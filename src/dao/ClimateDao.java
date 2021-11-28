package dao;

import java.util.List;

import entity.Climate;

public interface ClimateDao {

	//국가번호로 기후 조회
	List<Climate> retrieveClimateListByNationId(int id);
	
	//기후 추가
	public boolean insertByClimate(Climate climate);
	
	//국가 번호로 기후 삭제
	public int deleteByNationId(int nationId);

}
