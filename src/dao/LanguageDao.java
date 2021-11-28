package dao;

import java.util.List;

import entity.Language;

public interface LanguageDao {

	//국가 번호로 언어 조회
	List<Language> retrieveLanguageListByNationId(int id);
	
	//언어 삽입
	public boolean insertByLanguage(Language language);
	
	//국가 번호로 언어 삭제
	public int deleteByNationId(int nationId);
}
