package dao;

import java.util.List;

import entity.Religion;

public interface ReligionDao {

	//국가 번호로 종교 조회
	List<Religion> retrieveReligionListByNationId(int id);
	
	//인종 삽입
	public boolean insertByReligion(Religion religion);
	
	//국가 번호로 인종 삭제
	public int deleteByNationId(int id);

	//인종 생성
	void createReligion(Religion religion);

}
