package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionManager;
import entity.City;

public class CityDaoImpl implements CityDao{

	private Connection con = ConnectionManager.getConnection();
	
	@Override
	public List<City> retrieveCityListByNationId(int nationId) {
		
		String query = "SELECT * FROM LANGUAGE WHERE NATION_ID = ?";
		City city = null;
		List<City> cityList = new ArrayList<City>();
		
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setLong(1, nationId);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				city = new City(id, nationId, name);
				cityList.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cityList;
	}

}
