package service;

import java.util.List;

import dto.NationDto;
import entity.Nation;
import entity.NationForGame;

public interface NationService {
	List<Nation> retrieveAllNation();
	
	List<NationForGame> retrieveAllNationForGame();

	List<Nation> retrieveBySearchValue(String string, String columnName);

	NationDto retrieveNationByName(String nationName);
	
	List<Nation> retrieveBySearchValueAndTable(String searchValue, String tableName);
}
