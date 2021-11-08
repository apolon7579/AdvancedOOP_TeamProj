package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionManager;
import entity.Climate;
import entity.Language;
import entity.Nation;
import entity.Race;
import entity.Religion;

public class SearchDao {
    Connection con = ConnectionManager.getConnection();
    public List<Nation> GetAllNation()
    {
        String sql = "SELECT * FROM NATION";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
        
            List<Nation> resultNations = new ArrayList<Nation>();
        
            while(rs.next()) {
                resultNations.add(new Nation(
                    Integer.parseInt(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getString("capital"),
                    rs.getString("location"),
                    Integer.parseInt(rs.getString("area")),
                    rs.getString("area_source"),
                    rs.getString("area_description"),
                    Integer.parseInt(rs.getString("base_year").split("-")[0])
                    ));
            }
        
            rs.close();
            st.close();
            return resultNations;

        }
        catch(SQLException e)
        {
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        return null;
    }

    public Nation GetNationForID(int id)
    {
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
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        return null;
    }

    public Nation GetNationForName(String name)
    {
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
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        return null;
    }

    public List<Nation> getNationForLanguageName(String name)
    {
        String sql = "select * from nation where nation.id in (select language.nation_id from language where language.name = \"" + name + "\")";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            List<Nation> result = new ArrayList<Nation>();
        
            while(rs.next()) {
                result.add(new Nation(
                    Integer.parseInt(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getString("capital"),
                    rs.getString("location"),
                    Integer.parseInt(rs.getString("area")),
                    rs.getString("area_source"),
                    rs.getString("area_description"),
                    Integer.parseInt(rs.getString("base_year").split("-")[0])
                    ));
            }
        
            rs.close();
            st.close();
            return result;

        }
        catch(SQLException e)
        {
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        return null;
    }
    
    public List<Nation> getNationForReligionName(String name)
    {
        String sql = "select * from nation where nation.id in (select religion.nation_id from religion where religion.name = \"" + name+ "\")";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            List<Nation> result = new ArrayList<Nation>();
        
            while(rs.next()) {
                result.add(new Nation(
                    Integer.parseInt(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getString("capital"),
                    rs.getString("location"),
                    Integer.parseInt(rs.getString("area")),
                    rs.getString("area_source"),
                    rs.getString("area_description"),
                    Integer.parseInt(rs.getString("base_year").split("-")[0])
                    ));
            }
        
            rs.close();
            st.close();
            return result;

        }
        catch(SQLException e)
        {
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        return null;
    }

    public List<Nation> getNationForClimateName(String name)
    {
        String sql = "select * from nation where nation.id in (select climate.nation_id from climate where climate.name = \"" + name + "\")";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            List<Nation> result = new ArrayList<Nation>();
        
            while(rs.next()) {
                result.add(new Nation(
                    Integer.parseInt(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getString("capital"),
                    rs.getString("location"),
                    Integer.parseInt(rs.getString("area")),
                    rs.getString("area_source"),
                    rs.getString("area_description"),
                    Integer.parseInt(rs.getString("base_year").split("-")[0])
                    ));
            }
        
            rs.close();
            st.close();
            return result;

        }
        catch(SQLException e)
        {
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        return null;
    }

    public List<Nation> getNationForRaceName(String name)
    {
        String sql = "select * from nation where nation.id in (select race.nation_id from race where race.name = \"" + name + "\")";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            List<Nation> result = new ArrayList<Nation>();
        
            while(rs.next()) {
                result.add(new Nation(
                    Integer.parseInt(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getString("capital"),
                    rs.getString("location"),
                    Integer.parseInt(rs.getString("area")),
                    rs.getString("area_source"),
                    rs.getString("area_description"),
                    Integer.parseInt(rs.getString("base_year").split("-")[0])
                    ));
            }
        
            rs.close();
            st.close();
            return result;

        }
        catch(SQLException e)
        {
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        return null;
    }
    
    public List<Language> GetLanguageForNationID(int nationId)
    {
        String sql = "SELECT * FROM LANGUAGE WHERE nation_id = " + nationId;

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            List<Language> result = new ArrayList<Language>();
        
            while(rs.next()) {
                result.add(new Language(
                    Integer.parseInt(rs.getString("id")),
                    Integer.parseInt(rs.getString("nation_id")),
                    rs.getString("name")
                    ));
            }
        
            rs.close();
            st.close();
            return result;

        }
        catch(SQLException e)
        {
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        return null;
    }
    
    public List<Climate> GetClimateForNationID(int nationId)
    {
        String sql = "SELECT * FROM CLIMATE WHERE nation_id = " + nationId;

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            List<Climate> result = new ArrayList<Climate>();
        
            while(rs.next()) {
                result.add(new Climate(
                    Integer.parseInt(rs.getString("id")),
                    Integer.parseInt(rs.getString("nation_id")),
                    rs.getString("name")
                    ));
            }
        
            rs.close();
            st.close();
            return result;

        }
        catch(SQLException e)
        {
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        return null;
    }
    
    public List<Religion> GetReligionForNationID(int nationId)
    {
        String sql = "SELECT * FROM Religion WHERE nation_id = " + nationId;

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            List<Religion> result = new ArrayList<Religion>();
        
            while(rs.next()) {
                result.add(new Religion(
                    Integer.parseInt(rs.getString("id")),
                    Integer.parseInt(rs.getString("nation_id")),
                    rs.getString("name"),
                    rs.getString("percentage") == null ? -1 : Double.parseDouble(rs.getString("percentage"))
                    ));
            }
        
            rs.close();
            st.close();
            return result;

        }
        catch(SQLException e)
        {
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        return null;
    }
    
    public List<Race> GetRaceForNationID(int nationId)
    {
        String sql = "SELECT * FROM Religion WHERE nation_id = " + nationId;

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            List<Race> result = new ArrayList<Race>();
        
            while(rs.next()) {
                result.add(new Race(
                    Integer.parseInt(rs.getString("id")),
                    Integer.parseInt(rs.getString("nation_id")),
                    rs.getString("name"),
                    rs.getString("percentage") == null ? -1 : Double.parseDouble(rs.getString("percentage"))
                    ));
            }
        
            rs.close();
            st.close();
            return result;

        }
        catch(SQLException e)
        {
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        return null;
    }
}
