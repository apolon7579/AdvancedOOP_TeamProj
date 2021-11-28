package dao;

import java.util.List;

import entity.City;
import entity.Climate;

public interface CityDao {

	//국가번호로 도시 조회
	List<City> retrieveCityListByNationId(int id);
	
	//city 추가
	public boolean insertByCity(City city);
	
	//국가번호로 city 삭제
	public int deleteByNationId(int nationId);
}
