package dao;

import java.util.List;

import entity.Language;

public interface LanguageDao {

	List<Language> retrieveLanguageListByNationId(int id);
	public boolean insertByLanguage(Language language);
	public int deleteByNationId(int nationId);
}
