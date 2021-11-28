package dao;

import java.util.List;

import dto.NationDto;
import entity.Nation;
import entity.NationForGame;

public interface NationDao {
	//모든 국가 조회
	List<Nation> retrieveAllNation();

	//게임을 위한 국가 조회
	List<NationForGame> retrieveAllNationForGame();
	
	//검색값에 의한 국가 조회
	List<Nation> retrieveNationsBySearchValue(String searchValue, String field);

	//이름으로 상세조회
	NationDto retrieveNationByName(String nationName);
	
	//직렬화를 위한 국가 조회
	List<String> retrieveSerializableStringAllNation();

	//검색값과 테이블로 조회
	List<Nation> retrieveBySearchValueAndTable(String searchValue, String tableName);
	
	//국가 삽입
	public boolean insertByNation(Nation nation);
	
	//국가 갱신
	public boolean updateByNation(Nation nation);

	//국가 생성
	void createNation(Nation nation);
}
