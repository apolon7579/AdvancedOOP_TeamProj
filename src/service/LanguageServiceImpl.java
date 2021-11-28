package service;

import dao.LanguageDao;
import dao.LanguageDaoImpl;
import entity.Language;

//language service 구현체
public class LanguageServiceImpl implements LanguageService{

	private LanguageDao languageDao = new LanguageDaoImpl();
	
	//언어 등록
	@Override
	public void registerLanguage(Language language) {
		languageDao.insertByLanguage(language);
	}

}
