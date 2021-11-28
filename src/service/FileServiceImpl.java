package service;

import java.nio.file.Path;
import java.util.List;

import dao.CityDao;
import dao.CityDaoImpl;
import dao.ClimateDao;
import dao.ClimateDaoImpl;
import dao.LanguageDao;
import dao.LanguageDaoImpl;
import dao.MediaDao;
import dao.MediaDaoImpl;
import dao.NationDao;
import dao.NationDaoImpl;
import dao.RaceDao;
import dao.RaceDaoImpl;
import dao.ReligionDao;
import dao.ReligionDaoImpl;
import dto.NationDto;

//csv 업로드 및 다운로드 담당 service 구현체
public class FileServiceImpl implements FileService {

	NationDao nationDao = new NationDaoImpl();
	ClimateDao climateDao = new ClimateDaoImpl();
	CityDao cityDao = new CityDaoImpl();
	MediaDao mediaDao = new MediaDaoImpl();
	LanguageDao languageDao = new LanguageDaoImpl();
	RaceDao raceDao = new RaceDaoImpl();
	ReligionDao religionDao = new ReligionDaoImpl();
	
	//csv 업로드
	@Override
	public int upload(Path path) throws Exception{
		/*
		 * Nation을 중심으로 City, Climate, Language, Media, Race, Religion 등록 
		 * Nation: 국가, 국가코드, 수도, 위치, 면적, 면적 출처, 면적 설명, 기준연도: 여러개X, 추가파싱X 
		 * Climate: 여러개O, 추가파싱X
		 * Language: 여러개O, 추가파싱X
		 * City: 여러개O, 추가파싱X 
		 * Religion: 여러개O, 추가파싱O
		 * Race: 여러개O, 추가파싱O
		 * Media: 여러개O, 추가파싱X
		 * 만약 Nation이 없으면 전부 새로 올리고 있으면 갱신(기타 테이블은 삭제하고 덮어쓰기)
		 */

		int count = 0;
		List<NationDto> list = CSVParsingService.readFile(path);
		
		for(NationDto nationDto: list) {
			//국가이름 기준으로 없는 경우에는 Nation을 업로드한다.
			int newNationId = -1;
			if(nationDao.retrieveNationByName(nationDto.getName()) == null) {
				nationDao.insertByNation(nationDto.getNation());
				newNationId = nationDao.retrieveNationByName(nationDto.getName()).getId();
			}
			//국가이름 기준으로 있는 경우 Nation을 갱신하고 Climate, Language, City, Media를 제거한다.
			else {
				nationDao.updateByNation(nationDto.getNation());
				newNationId = nationDao.retrieveNationByName(nationDto.getName()).getId();
				climateDao.deleteByNationId(newNationId);
				languageDao.deleteByNationId(newNationId);
				cityDao.deleteByNationId(newNationId);
				mediaDao.deleteByNationId(newNationId);
				raceDao.deleteByNationId(newNationId);
				religionDao.deleteByNationId(newNationId);
			}
			// Climate, Language, City, Media를 다시 올린다.
			final int finalNewNAtionId = newNationId;
			if(nationDto.getClimateList() != null) {
				nationDto.getClimateList().forEach(c->{c.setNationId(finalNewNAtionId); climateDao.insertByClimate(c);});
			}
			if(nationDto.getLanguageList()!=null) {
				nationDto.getLanguageList().forEach(c->{c.setNationId(finalNewNAtionId); languageDao.insertByLanguage(c);});
			}
			if(nationDto.getCityList()!= null) {
				nationDto.getCityList().forEach(c->{c.setNationId(finalNewNAtionId); cityDao.insertByCity(c);});
			}
			if(nationDto.getMediaList()!= null) {
				nationDto.getMediaList().forEach(c->{c.setNationId(finalNewNAtionId); mediaDao.insertByMedia(c);});
			}
			if(nationDto.getRaceList()!= null) {
				nationDto.getRaceList().forEach(c->{c.setNationId(finalNewNAtionId); raceDao.insertByRace(c);});
			}
			if(nationDto.getReligionList()!= null) {
				nationDto.getReligionList().forEach(c->{c.setNationId(finalNewNAtionId); religionDao.insertByReligion(c);});
			}
			
			count++;
		}
		
		return count;
	}

	//csv 다운로드
	@Override
	public int download(Path path) throws Exception {
		List<String> list = nationDao.retrieveSerializableStringAllNation();
		CSVSerializeService.writeFile(path, list);
		return list.size();
	}

}
