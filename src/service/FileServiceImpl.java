package service;

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
import dto.NationDto;

public class FileServiceImpl implements FileService {

	NationDao nationDao = new NationDaoImpl();
	ClimateDao climateDao = new ClimateDaoImpl();
	CityDao cityDao = new CityDaoImpl();
	MediaDao mediaDao = new MediaDaoImpl();
	LanguageDao languageDao = new LanguageDaoImpl();
	
	public static void main(String[] args) {
		FileService service = new FileServiceImpl();
		System.out.println(service.upload("C:\\Users\\mjk49\\Downloads\\외교부_국가·지역별_일반정보_20201231.csv"));

	}
	
	@Override
	public int upload(String path) {
		/*
		 * Nation을 중심으로 City, Climate, Language, Media, Race, Religion 등록 
		 * Nation: 국가, 국가코드, 수도, 위치, 면적, 면적 출처, 면적 설명, 기준연도: 여러개X, 추가파싱X 
		 * Climate: 여러개O, 추가파싱X
		 * Language: 여러개O, 추가파싱X
		 * City: 여러개O, 추가파싱X 
		 * Religion: 여러개O, 추가파싱O 			수동업로드
		 * Race: 여러개O, 추가파싱O 				수동업로드
		 * Media: 여러개O, 추가파싱X
		 * 만약 Nation이 없으면 전부 새로 올리고 있으면 갱신(삭제하고 덮어쓰기)
		 */
		try{
			int count = 0;
			List<NationDto> list = CSVParsingService.readFile(path);
			
			for(NationDto nationDto: list) {
				//국가이름 기준으로 없는 경우 Nation을 업로드한다.
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
				}
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
				
				count++;
			}
			
			return count;
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int download(String path) {
		return -1;
	}

}
