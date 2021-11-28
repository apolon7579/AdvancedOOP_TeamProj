package service;

import java.util.List;

import dto.NationDto;
import entity.Nation;
import entity.NationForGame;

public interface NationService {
	//모든 국가 조회
	List<Nation> retrieveAllNation();
	
	//게임을 위한 국가 조회
	List<NationForGame> retrieveAllNationForGame();

	//검색값으로 국가 조회
	List<Nation> retrieveBySearchValue(String string, String columnName);

	//이름으로 상세조회
	NationDto retrieveNationByName(String nationName);
	
	//검색값과 테이블로 조회
	List<Nation> retrieveBySearchValueAndTable(String searchValue, String tableName);

	//국가 등록
	void registerNation(Nation nation);
}
