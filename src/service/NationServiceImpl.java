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

	@Override
	public List<Nation> retrieveBySearchValue(String searchValue, String columnName) {
		// TODO Auto-generated method stub
		return nationDao.retrieveNationsBySearchValue(searchValue, columnName);
	}

}
