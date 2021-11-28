package service;

import dao.CityDao;
import dao.CityDaoImpl;
import entity.City;

//city service 구현체
public class CityServiceImpl implements CityService{

	private CityDao cityDao = new CityDaoImpl();
	
	//도시 등록
	@Override
	public void registerCity(City city) {
		cityDao.insertByCity(city);
	}

}
