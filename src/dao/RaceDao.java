package dao;

import java.util.List;

import entity.Race;

public interface RaceDao {

	List<Race> retrieveRaceListByNationId(int id);
	public boolean insertByRace(Race race);
	public int deleteByNationId(int nationId);

	void createRace(Race race);

}
