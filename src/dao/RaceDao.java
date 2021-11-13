package dao;

import java.util.List;

import entity.Race;

public interface RaceDao {

	List<Race> retrieveRaceListByNationId(int id);

}
