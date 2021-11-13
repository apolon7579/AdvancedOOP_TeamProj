package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionManager;
import entity.Climate;

public class ClimateDaoImpl implements ClimateDao
{

	private Connection con = ConnectionManager.getConnection();
	
	@Override
	public List<Climate> retrieveClimateListByNationId(int nationId) {
		
		String query = "SELECT * FROM CLIMATE WHERE NATION_ID = ?";
		Climate climate = null;
		List<Climate> climateList = new ArrayList<Climate>();
		
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setLong(1, nationId);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				climate = new Climate(id, nationId, name);
				climateList.add(climate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return climateList;
	}

}
