package service;

import dao.ClimateDao;
import dao.ClimateDaoImpl;
import entity.Climate;

//climate service 구현체
public class ClimateServiceImpl implements ClimateService{

	private ClimateDao climateDao = new ClimateDaoImpl();
	
	//기후 등록
	@Override
	public void registerClimate(Climate climate) {
		climateDao.insertByClimate(climate);
	}

}
