package service;

import dao.RaceDao;
import dao.RaceDaoImpl;
import entity.Race;

//race service 구현체
public class RaceServiceImpl implements RaceService{

	private RaceDao raceDao = new RaceDaoImpl();
	
	//인종 등록
	@Override
	public void registerRace(Race race) {
		raceDao.createRace(race);
	}

}
