package config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Nation;

public class SearchManager {

    static public Nation[] GetAllNation()
    {
        Connection con = ConnectionManager.getConnection();
        String sql = "SELECT * FROM NATION";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
        
            Nation[] resultNations = new Nation[rowcount];
        
            while(rs.next()) {
                resultNations[rs.getRow() - 1] = new Nation(
                    Integer.parseInt(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getString("capital"),
                    rs.getString("location"),
                    Integer.parseInt(rs.getString("area")),
                    rs.getString("area_source"),
                    rs.getString("area_description"),
                    Integer.parseInt(rs.getString("base_year").split("-")[0])
                    );
            }
        
            rs.close();
            st.close();
            return resultNations;

        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return null;
    }

    static public Nation GetNationForID(int id)
    {
        Connection con = ConnectionManager.getConnection();
        String sql = "SELECT * FROM NATION WHERE ID = " + id;

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            if(rs.next())
                return new Nation(
                    Integer.parseInt(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getString("capital"),
                    rs.getString("location"),
                    Integer.parseInt(rs.getString("area")),
                    rs.getString("area_source"),
                    rs.getString("area_description"),
                    Integer.parseInt(rs.getString("base_year").split("-")[0])
                    );
        
            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return null;
    }

    static public Nation GetNationForName(String name)
    {
        Connection con = ConnectionManager.getConnection();
        String sql = "SELECT * FROM NATION WHERE NAME = \"" + name + "\"";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            if(rs.next()) {
                return new Nation(
                    Integer.parseInt(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getString("capital"),
                    rs.getString("location"),
                    Integer.parseInt(rs.getString("area")),
                    rs.getString("area_source"),
                    rs.getString("area_description"),
                    Integer.parseInt(rs.getString("base_year").split("-")[0])
                    );
            }
        
            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return null;
    }
}
