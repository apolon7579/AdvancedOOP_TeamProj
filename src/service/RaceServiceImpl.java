package service;

import dao.RaceDao;
import dao.RaceDaoImpl;
import entity.Race;

public class RaceServiceImpl implements RaceService{

	private RaceDao raceDao = new RaceDaoImpl();
	
	@Override
	public void registerRace(Race race) {
		raceDao.createRace(race);
	}

}
