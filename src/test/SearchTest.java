package test;
import java.sql.SQLException;

import config.*;
import entity.Nation;
public class SearchTest {

    public static void main(String[] args) throws SQLException {
        Nation[] nations = SearchManager.GetAllNation();
        for(int i = 0; i < nations.length; i++)
            System.out.println(nations[i].getName());



    }

}
