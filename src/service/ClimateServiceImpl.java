package service;

import dao.ClimateDao;
import dao.ClimateDaoImpl;
import entity.Climate;

public class ClimateServiceImpl implements ClimateService{

	private ClimateDao climateDao = new ClimateDaoImpl();
	
	@Override
	public void registerClimate(Climate climate) {
		climateDao.insertByClimate(climate);
	}

}
