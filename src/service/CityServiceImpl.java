package service;

import dao.CityDao;
import dao.CityDaoImpl;
import entity.City;

public class CityServiceImpl implements CityService{

	private CityDao cityDao = new CityDaoImpl();
	
	@Override
	public void registerCity(City city) {
		cityDao.insertByCity(city);
	}

}
