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
import entity.NationForGame;

public class NationDaoImpl implements NationDao {

	private Connection con = ConnectionManager.getConnection();

	@Override
	public List<Nation> retrieveAllNation() {

		String query = "SELECT * FROM NATION";
		Nation nation;
		List<Nation> nationList = new ArrayList<Nation>();

		try {
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				// id, name, code, capital, location, area, area_source, area_description,
				// base_year
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String code = rs.getString("code");
				String capital = rs.getString("capital");
				String location = rs.getString("location");
				Double area = rs.getDouble("area");
				String area_source = rs.getString("area_source");
				String area_location = rs.getString("area_description");
				Integer base_year = rs.getInt("base_year");

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

		String query = "SELECT * FROM NATION WHERE " + field + " LIKE ?";
		Nation nation;
		List<Nation> nationList = new ArrayList<Nation>();

		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, "%" + searchValue + "%");
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				// id, name, code, capital, location, area, area_source, area_description,
				// base_year
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String code = rs.getString("code");
				String capital = rs.getString("capital");
				String location = rs.getString("location");
				Double area = rs.getDouble("area");
				String area_source = rs.getString("area_source");
				String area_location = rs.getString("area_description");
				Integer base_year = rs.getInt("base_year");

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

			while (rs.next()) {
				// id, name, code, capital, location, area, area_source, area_description,
				// base_year
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String code = rs.getString("code");
				String capital = rs.getString("capital");
				String location = rs.getString("location");
				Double area = rs.getDouble("area");
				String area_source = rs.getString("area_source");
				String area_location = rs.getString("area_description");
				Integer base_year = rs.getInt("base_year");

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

	@Override
	public List<NationForGame> retrieveAllNationForGame() {

		String query = "select n.name, n.code, n.area, n.capital, n.location, c.name city, l.name language, cl.name climate, re.name religion, r.name race\n"
				+ "from nation n\n" + "left outer join city c on n.id = c.id\n"
				+ "left outer join climate cl on n.id = cl.id\n" + "left outer join language l  on n.id = l.id\n"
				+ "left outer join race r on n.id = r.id\n" + "left outer join religion re on n.id = re.id";

		List<NationForGame> nationList = new ArrayList<NationForGame>();

		try {
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				nationList.add(new NationForGame(rs.getString("name"), rs.getString("code"), rs.getDouble("area"),
						rs.getString("capital"), rs.getString("location"), rs.getString("city"),
						rs.getString("language"), rs.getString("climate"), rs.getString("religion"),
						rs.getString("race")));
			}

			rs.close();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nationList;
	}

	@Override
	public List<Nation> retrieveBySearchValueAndTable(String searchValue, String tableName) {
		
		String query = "SELECT * FROM NATION WHERE ID IN (SELECT NATION_ID FROM " + tableName + " WHERE NAME LIKE ?)";
		List<Nation> nationList = new ArrayList<Nation>();
		Nation nation;
		
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, "%" + searchValue + "%");
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				// id, name, code, capital, location, area, area_source, area_description,
				// base_year
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String code = rs.getString("code");
				String capital = rs.getString("capital");
				String location = rs.getString("location");
				Double area = rs.getDouble("area");
				String area_source = rs.getString("area_source");
				String area_location = rs.getString("area_description");
				Integer base_year = rs.getInt("base_year");

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
	public boolean insertByNation(Nation nation) {
		String query = "INSERT INTO nation (name, code, capital, location, area, area_source, area_description, base_year) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement psmt = con.prepareStatement(query)){
			
			psmt.setString(1, nation.getName());
			psmt.setString(2, nation.getCode());
			psmt.setString(3, nation.getCapital());
			psmt.setString(4, nation.getLocation());
			psmt.setDouble(5, nation.getArea());
			psmt.setString(6, nation.getAreaSource());
			psmt.setString(7, nation.getAreaDescription());
			psmt.setInt(8, nation.getBaseYear());
			
			int count = psmt.executeUpdate();
			psmt.close();
			return count == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateByNation(Nation nation) {
		String query = "UPDATE nation SET name = ?, code = ?, capital = ?, location=?, area=?, area_source=?, area_description=?, base_year=? WHERE id=?";

		try (PreparedStatement psmt = con.prepareStatement(query)){
			
			psmt.setString(1, nation.getName());
			psmt.setString(2, nation.getCode());
			psmt.setString(3, nation.getCapital());
			psmt.setString(4, nation.getLocation());
			psmt.setDouble(5, nation.getArea());
			psmt.setString(6, nation.getAreaSource());
			psmt.setString(7, nation.getAreaDescription());
			psmt.setInt(8, nation.getBaseYear());
			psmt.setInt(9, nation.getId());
			
			int count = psmt.executeUpdate();
			return count == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void createNation(Nation nation) {
		String query = "INSERT INTO NATION (NAME, CODE, CAPITAL, LOCATION, AREA, AREA_SOURCE, AREA_DESCRIPTION, BASE_YEAR) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, nation.getName());
			psmt.setString(2, nation.getCode());
			psmt.setString(3, nation.getCapital());
			psmt.setString(4, nation.getLocation());
			psmt.setDouble(5, nation.getArea());
			psmt.setString(6, nation.getAreaSource());
			psmt.setString(7, nation.getAreaDescription());
			psmt.setInt(8, nation.getBaseYear());
			
			psmt.executeUpdate();
			
			psmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
