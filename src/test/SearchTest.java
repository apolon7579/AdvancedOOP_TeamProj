package test;
import java.sql.SQLException;

import config.*;
import entity.Nation;
public class SearchTest {

    public static void main(String[] args) throws SQLException {
        Nation[] nations = SearchManager.GetAllNation();
        for(int i = 0; i < nations.length; i++)
            System.out.println(nations[i]);


        System.out.println(SearchManager.GetNationForID(8));
        System.out.println(SearchManager.GetNationForID(80));
        System.out.println(SearchManager.GetNationForName("가나"));
        System.out.println(SearchManager.GetNationForName("없는나라"));
    }

}
