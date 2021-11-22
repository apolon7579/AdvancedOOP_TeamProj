package dao;

import java.util.List;

import dto.NationDto;
import entity.Nation;
import entity.NationForGame;

public interface NationDao {
	List<Nation> retrieveAllNation();

	List<NationForGame> retrieveAllNationForGame();
	
	List<Nation> retrieveNationsBySearchValue(String searchValue, String field);

	NationDto retrieveNationByName(String nationName);

	List<Nation> retrieveBySearchValueAndTable(String searchValue, String tableName);
	
	public boolean insertByNation(Nation nation);
	public boolean updateByNation(Nation nation);

	void createNation(Nation nation);
}
