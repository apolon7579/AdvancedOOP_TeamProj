package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionManager;
import entity.Climate;

//climate dao 구현체
public class ClimateDaoImpl implements ClimateDao {

	private Connection con = ConnectionManager.getConnection();
	
	//국가 번호로 기후 조회
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

	//기후 추가
	@Override
	public boolean insertByClimate(Climate climate) {
		String query = "INSERT INTO climate (nation_id, name) VALUES (?, ?)";

		try (PreparedStatement psmt = con.prepareStatement(query)){
			psmt.setInt(1, climate.getNationId());
			psmt.setString(2, climate.getName());
			
			int count = psmt.executeUpdate();
			return count == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	//국가 번호로 기후 삭제
	@Override
	public int deleteByNationId(int nationId) {
		String query = "DELETE FROM climate WHERE nation_id=?";

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
