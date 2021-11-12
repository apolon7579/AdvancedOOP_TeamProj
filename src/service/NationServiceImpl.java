package service;

import java.util.List;

import dao.NationDao;
import dao.NationDaoImpl;
import entity.Nation;

public class NationServiceImpl implements NationService{

	private NationDao nationDao = new NationDaoImpl();
	
	@Override
	public List<Nation> retrieveAllNation() {
		return nationDao.retrieveAllNation();
	}

}
