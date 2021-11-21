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

	@Override
	public boolean insertByCity(City city) {
		String query = "INSERT INTO city (nation_id, name) VALUES (?, ?)";

		try (PreparedStatement psmt = con.prepareStatement(query)){
			psmt.setInt(1, city.getNationId());
			psmt.setString(2, city.getName());
			
			int count = psmt.executeUpdate();
			return count == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int deleteByNationId(int nationId) {
		String query = "DELETE FROM city WHERE nation_id=?";

		try (PreparedStatement psmt = con.prepareStatement(query)){
			psmt.setInt(1, nationId);
			
			int count = psmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
