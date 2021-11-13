package dao;

import java.util.List;

import entity.City;
import entity.Climate;

public interface CityDao {

	List<City> retrieveCityListByNationId(int id);

}
