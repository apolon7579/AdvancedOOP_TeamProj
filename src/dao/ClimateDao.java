package dao;

import java.util.List;

import entity.Climate;

public interface ClimateDao {

	List<Climate> retrieveClimateListByNationId(int id);
	public boolean insertByClimate(Climate climate);
	public int deleteByNationId(int nationId);

}
