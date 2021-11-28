package dao;

import java.util.List;

import entity.Race;

public interface RaceDao {

	//국가 번호로 인종 조회
	List<Race> retrieveRaceListByNationId(int id);
	
	//인종 삽입
	public boolean insertByRace(Race race);
	
	//국가 번호로 인종 삭제
	public int deleteByNationId(int nationId);

	//인종 생성
	void createRace(Race race);

}
