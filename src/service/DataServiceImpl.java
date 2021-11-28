package service;

import java.util.ArrayList;
import java.util.List;

import entity.Nation;
import entity.NationForGame;

//data service 구현체 
public class DataServiceImpl implements DataService{

	//모든 국가 조회
	@Override
	public List<Nation> getAllNationList() {
		// TODO Auto-generated method stub
		return null;
	}

	//게임을 위한 국가 조회(nation servvice에 구현되어 여기에선 미구현)
	@Override
	public ArrayList<NationForGame> getAllNationForGameArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

}
