package service;

import java.sql.Connection;
import java.util.List;

import config.ConnectionManager;
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
	private final Connection con = ConnectionManager.getConnection();

	NationDao nationDao = new NationDaoImpl();
	ClimateDao climateDao = new ClimateDaoImpl();
	CityDao cityDao = new CityDaoImpl();
	MediaDao mediaDao = new MediaDaoImpl();
	LanguageDao userDao = new LanguageDaoImpl();
	
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
			List<NationDto> list = CSVParsingService.readFile(path);
			for(NationDto nation: list) {
				//국가이름 기준으로 없는 경우 Nation, Climate, Language, City, Media를 업로드한다.
				if(nationDao.retrieveNationByName(nation.getName()) == null) {
					
				}
				else {
					
				}
			}
			
			return 0;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
