package dao;

import java.util.List;

import entity.Religion;

public interface ReligionDao {

	List<Religion> retrieveReligionListByNationId(int id);

}
