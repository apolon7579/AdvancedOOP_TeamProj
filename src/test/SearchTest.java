package test;
import java.sql.SQLException;
import java.util.List;

import config.*;
import dao.SearchDao;
import entity.*;
public class SearchTest {

    public static void main(String[] args) throws SQLException {
        SearchDao searchDao = new SearchDao();
        List<Language> results = searchDao.GetLanguageForNationID(2);
        for(int i = 0; i < results.size(); i++)
            System.out.println(results.get(i).getName());



    }

}
