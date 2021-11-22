package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionManager;
import entity.Religion;

public class ReligionDaoImpl implements ReligionDao {

	private Connection con = ConnectionManager.getConnection();

	@Override
	public List<Religion> retrieveReligionListByNationId(int nationId) {

		String query = "SELECT * FROM RELIGION WHERE NATION_ID = ?";
		Religion religion = null;
		List<Religion> religionList = new ArrayList<Religion>();

		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setLong(1, nationId);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double percentage = rs.getDouble("percentage");

				religion = new Religion(id, nationId, name, percentage);
				religionList.add(religion);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return religionList;
	}

	@Override
	public void createReligion(Religion religion) {
		String query = "INSERT INTO religion (nation_id, name, percentage) VALUES (?, ?, ?)";

		try (PreparedStatement psmt = con.prepareStatement(query)) {
			psmt.setInt(1, religion.getNationId());
			psmt.setString(2, religion.getName());
			psmt.setDouble(3, religion.getPercentage());

			psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
