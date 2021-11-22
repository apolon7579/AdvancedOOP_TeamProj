package service;

import dao.ReligionDao;
import dao.ReligionDaoImpl;
import entity.Religion;

public class ReligionServiceImpl implements ReligionService{

	private ReligionDao religionDao = new ReligionDaoImpl();
	
	@Override
	public void registerReligion(Religion religion) {
		religionDao.createReligion(religion);
	}

}
