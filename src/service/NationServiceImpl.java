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
import dao.RaceDao;
import dao.RaceDaoImpl;
import dao.ReligionDao;
import dao.ReligionDaoImpl;
import dto.NationDto;
import entity.City;
import entity.Climate;
import entity.Language;
import entity.Media;
import entity.Nation;
import entity.NationForGame;
import entity.Race;
import entity.Religion;

//nation service 구현체
public class NationServiceImpl implements NationService{

	private NationDao nationDao = new NationDaoImpl();
	private CityDao cityDao = new CityDaoImpl();
	private ClimateDao climateDao = new ClimateDaoImpl();
	private LanguageDao languageDao = new LanguageDaoImpl();
	private MediaDao mediaDao = new MediaDaoImpl();
	private RaceDao raceDao = new RaceDaoImpl();
	private ReligionDao religionDao = new ReligionDaoImpl();
	
	//모든 국가 조회
	@Override
	public List<Nation> retrieveAllNation() {
		return nationDao.retrieveAllNation();
	}
	
	//게임을 위한 국가 조회
	@Override
	public List<NationForGame> retrieveAllNationForGame() {
		return nationDao.retrieveAllNationForGame();
	}

	//검색값으로 국가 조회
	@Override
	public List<Nation> retrieveBySearchValue(String searchValue, String columnName) {
		return nationDao.retrieveNationsBySearchValue(searchValue, columnName);
	}

	//이름으로 국가 상세 조회
	@Override
	public NationDto retrieveNationByName(String nationName) {
		
		NationDto nation = nationDao.retrieveNationByName(nationName);
		List<City> cityList = cityDao.retrieveCityListByNationId(nation.getId());
		List<Climate> climateList = climateDao.retrieveClimateListByNationId(nation.getId());
		List<Language> languageList = languageDao.retrieveLanguageListByNationId(nation.getId());
		List<Media> mediaList = mediaDao.retrieveMediaListByNationId(nation.getId());
		List<Race> raceList = raceDao.retrieveRaceListByNationId(nation.getId());
		List<Religion> religionList = religionDao.retrieveReligionListByNationId(nation.getId());
		
		nation.setCityList(cityList);
		nation.setClimateList(climateList);
		nation.setLanguageList(languageList);
		nation.setMediaList(mediaList);
		nation.setRaceList(raceList);
		nation.setReligionList(religionList);
		
		return nation;
	}

	//검색값과 테이블로 국가 조회
	@Override
	public List<Nation> retrieveBySearchValueAndTable(String searchValue, String tableName) {
		return nationDao.retrieveBySearchValueAndTable(searchValue, tableName);
	}

	//국가 등록
	@Override
	public void registerNation(Nation nation) {
		nationDao.createNation(nation);
	}


}
