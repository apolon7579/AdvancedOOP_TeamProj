package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionManager;
import entity.Climate;
import entity.Race;

public class RaceDaoImpl implements RaceDao{
	
	private Connection con = ConnectionManager.getConnection();

	@Override
	public List<Race> retrieveRaceListByNationId(int nationId) {

		String query = "SELECT * FROM RACE WHERE NATION_ID = ?";
		Race race = null;
		List<Race> raceList = new ArrayList<Race>();
		
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setLong(1, nationId);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double percentage = rs.getDouble("percentage");
				
				race = new Race(id, nationId, name, percentage);
				raceList.add(race);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return raceList;
	}

	@Override
	public void createRace(Race race) {
		String query = "INSERT INTO race (nation_id, name, percentage) VALUES (?, ?, ?)";

		try (PreparedStatement psmt = con.prepareStatement(query)){
			psmt.setInt(1, race.getNationId());
			psmt.setString(2, race.getName());
			psmt.setDouble(3, race.getPercentage());
			psmt.setObject(3, race.getPercentage(), Types.DOUBLE);
			
			psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
