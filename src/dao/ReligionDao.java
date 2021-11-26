package dao;

import java.util.List;

import entity.Religion;

public interface ReligionDao {

	List<Religion> retrieveReligionListByNationId(int id);
	public boolean insertByReligion(Religion religion);
	public int deleteByNationId(int id);

	void createReligion(Religion religion);

}
