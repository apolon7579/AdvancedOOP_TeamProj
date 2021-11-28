package service;

import dao.ReligionDao;
import dao.ReligionDaoImpl;
import entity.Religion;

//religion service 구현체
public class ReligionServiceImpl implements ReligionService{

	private ReligionDao religionDao = new ReligionDaoImpl();
	
	//종교 등록
	@Override
	public void registerReligion(Religion religion) {
		religionDao.createReligion(religion);
	}

}
