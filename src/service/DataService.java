package service;

import java.util.ArrayList;
import java.util.List;

import entity.Nation;
import entity.NationForGame;

public interface DataService {
	List<Nation> getAllNationList();

	ArrayList<NationForGame> getAllNationForGameArrayList();
}
