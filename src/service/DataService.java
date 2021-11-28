package service;

import java.util.ArrayList;
import java.util.List;

import entity.Nation;
import entity.NationForGame;

public interface DataService {
	//모든 국가 조회
	List<Nation> getAllNationList();

	//게임을 위한 국가 조회
	ArrayList<NationForGame> getAllNationForGameArrayList();
}
