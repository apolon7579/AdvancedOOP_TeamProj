package service;

import java.util.List;

import dto.NationDto;
import entity.Nation;
import entity.NationForGame;

public interface NationService {
	List<Nation> retrieveAllNation();
	
	List<NationForGame> retrieveAllNationForGmae();

	List<Nation> retrieveBySearchValue(String string, String columnName);

	NationDto retrieveNationByName(String nationName);
}
