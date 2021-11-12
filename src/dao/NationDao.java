package dao;

import java.util.List;

import entity.Nation;

public interface NationDao {
	List<Nation> retrieveAllNation();

	List<Nation> retrieveNationsBySearchValue(String searchValue, String field);
}