package service;

import dao.LanguageDao;
import dao.LanguageDaoImpl;
import entity.Language;

public class LanguageServiceImpl implements LanguageService{

	private LanguageDao languageDao = new LanguageDaoImpl();
	
	@Override
	public void registerLanguage(Language language) {
		languageDao.insertByLanguage(language);
	}

}
