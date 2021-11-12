package service;

import java.util.List;

import entity.Nation;

public interface NationService {
	List<Nation> retrieveAllNation();

	List<Nation> retrieveBySearchValue(String string, String columnName);
}
