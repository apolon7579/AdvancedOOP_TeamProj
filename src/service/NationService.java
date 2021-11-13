package service;

import java.util.List;

import dto.NationDto;
import entity.Nation;

public interface NationService {
	List<Nation> retrieveAllNation();

	List<Nation> retrieveBySearchValue(String string, String columnName);

	NationDto retrieveNationByName(String nationName);
}
