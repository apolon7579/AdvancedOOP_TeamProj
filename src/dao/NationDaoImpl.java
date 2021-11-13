package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionManager;
import dto.NationDto;
import entity.Nation;

public class NationDaoImpl implements NationDao{

	private Connection con = ConnectionManager.getConnection();
	
	@Override
	public List<Nation> retrieveAllNation() {
		
		String query = "SELECT * FROM NATION";
		Nation nation;
		List<Nation> nationList = new ArrayList<Nation>();
		
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				//id, name, code, capital, location, area, area_source, area_description, base_year
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String code = rs.getString("code");
				String capital = rs.getString("capital");
				String location = rs.getString("location");
				int area = rs.getInt("area");
				String area_source = rs.getString("area_source");
				String area_location = rs.getString("area_description");
				int base_year = rs.getInt("base_year");
				
				nation = new Nation(id, name, code, capital, location, area, area_source, area_location, base_year);
				nationList.add(nation);
				
			}
			
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nationList;
	}

	@Override
	public List<Nation> retrieveNationsBySearchValue(String searchValue, String field) {
		
		String query = "SELECT * FROM NATION WHERE "+field+" LIKE ?";
		Nation nation;
		List<Nation> nationList = new ArrayList<Nation>();
		
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, "%"+searchValue+"%");
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				//id, name, code, capital, location, area, area_source, area_description, base_year
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String code = rs.getString("code");
				String capital = rs.getString("capital");
				String location = rs.getString("location");
				int area = rs.getInt("area");
				String area_source = rs.getString("area_source");
				String area_location = rs.getString("area_description");
				int base_year = rs.getInt("base_year");
				
				nation = new Nation(id, name, code, capital, location, area, area_source, area_location, base_year);
				nationList.add(nation);
				
			}
			
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nationList;
	}

	@Override
	public NationDto retrieveNationByName(String nationName) {
		
		String query = "SELECT * FROM NATION WHERE NAME = ?";
		NationDto nation = null;
		
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, nationName);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				//id, name, code, capital, location, area, area_source, area_description, base_year
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String code = rs.getString("code");
				String capital = rs.getString("capital");
				String location = rs.getString("location");
				int area = rs.getInt("area");
				String area_source = rs.getString("area_source");
				String area_location = rs.getString("area_description");
				int base_year = rs.getInt("base_year");
				
				nation = new NationDto();
				nation.setId(id);
				nation.setName(name);
				nation.setCode(code);
				nation.setCapital(capital);
				nation.setLocation(location);
				nation.setArea(area);
				nation.setAreaSource(area_source);
				nation.setAreaLocation(area_location);
				nation.setBaseYear(base_year);
			}
			
			rs.close();
			psmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nation;
	}

}
