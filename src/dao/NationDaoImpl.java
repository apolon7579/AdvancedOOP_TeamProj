package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import config.ConnectionManager;
import dto.NationDto;
import entity.Nation;
import entity.NationForGame;

//nation dao 구현체
public class NationDaoImpl implements NationDao {

	private Connection con = ConnectionManager.getConnection();

	//모든 국가 조회
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

	//검색값에 의한 국가 조회
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

	//이름으로 국가 상세 조회
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
	
	//직렬화를 위한 국가 조회
	@Override
	public List<String> retrieveSerializableStringAllNation() {
		String query = "select n.name, n.code,  n.capital, GROUP_CONCAT(DISTINCT cl.name SEPARATOR ', ') climate, n.location, GROUP_CONCAT(DISTINCT c.name SEPARATOR ', ') city, GROUP_CONCAT(DISTINCT re.name SEPARATOR ', ') religion, GROUP_CONCAT(DISTINCT r.name SEPARATOR ', ') race, GROUP_CONCAT(DISTINCT m.name SEPARATOR ', ') media, n.area, n.area_source, n.area_description, GROUP_CONCAT(DISTINCT l.name SEPARATOR ', ') language, n.base_year\n"
				+ "from nation n\n" 
				+ "left join city c on n.id = c.nation_id\n"
				+ "left join climate cl on n.id = cl.nation_id\n"
				+ "left join language l  on n.id = l.nation_id\n"
				+ "left join race r on n.id = r.nation_id\n"
				+ "left join media m on n.id = m.nation_id\n"
				+ "left join religion re on n.id = re.nation_id\n"
				+ "group by n.name\n"
				+ "order by n.name";
		
		List<String> list = new LinkedList<>();

		try (PreparedStatement psmt = con.prepareStatement(query)) {
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				StringBuilder builder = new StringBuilder();
				if (rs.getString("name") != null)
					if(rs.getString("name").contains(","))
						builder.append("\"").append(rs.getString("name")).append("\"");
					else 
						builder.append(rs.getString("name"));
				builder.append(",");
				
				if (rs.getString("code") != null)
					if(rs.getString("code").contains(","))
						builder.append("\"").append(rs.getString("code")).append("\"");
					else 
						builder.append(rs.getString("code"));
				builder.append(",");
				
				if (rs.getString("capital") != null)
					if(rs.getString("capital").contains(","))
						builder.append("\"").append(rs.getString("capital")).append("\"");
					else 
						builder.append(rs.getString("capital"));
				builder.append(",");
				
				if (rs.getString("climate") != null)
					if(rs.getString("climate").contains(","))
						builder.append("\"").append(rs.getString("climate")).append("\"");
					else 
						builder.append(rs.getString("climate"));
				builder.append(",");
				
				if (rs.getString("location") != null)
					if(rs.getString("location").contains(","))
						builder.append("\"").append(rs.getString("location")).append("\"");
					else 
						builder.append(rs.getString("location"));
				builder.append(",");
				
				if (rs.getString("city") != null)
					if(rs.getString("city").contains(","))
						builder.append("\"").append(rs.getString("city")).append("\"");
					else 
						builder.append(rs.getString("city"));
				builder.append(",");
				
				if (rs.getString("religion") != null)
					if(rs.getString("religion").contains(","))
						builder.append("\"").append(rs.getString("religion")).append("\"");
					else 
						builder.append(rs.getString("religion"));
				builder.append(",");
				
				if (rs.getString("race") != null)
					if(rs.getString("race").contains(","))
						builder.append("\"").append(rs.getString("race")).append("\"");
					else 
						builder.append(rs.getString("race"));
				builder.append(",");
				
				if (rs.getString("media") != null)
					if(rs.getString("media").contains(","))
						builder.append("\"").append(rs.getString("media")).append("\"");
					else 
						builder.append(rs.getString("media"));
				builder.append(",");
				
				if (rs.getObject("area", Double.class) != null)
					builder.append(rs.getObject("area", Double.class));
				builder.append(",");
				
				if (rs.getString("area_source") != null)
					if(rs.getString("area_source").contains(","))
						builder.append("\"").append(rs.getString("area_source")).append("\"");
					else 
						builder.append(rs.getString("area_source"));
				builder.append(",");
				
				if (rs.getString("area_description") != null)
					if(rs.getString("area_description").contains(","))
						builder.append("\"").append(rs.getString("area_description")).append("\"");
					else 
						builder.append(rs.getString("area_description"));
				builder.append(",");
				
				if (rs.getString("language") != null)
					if(rs.getString("language").contains(","))
						builder.append("\"").append(rs.getString("language")).append("\"");
					else 
						builder.append(rs.getString("language"));
				builder.append(",");
				
				if (rs.getObject("base_year", Integer.class) != null)
					builder.append(rs.getObject("base_year", Integer.class));
				builder.append("\n");
				
				list.add(builder.toString());
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	//게임을 위한 국가 조회
	@Override
	public List<NationForGame> retrieveAllNationForGame() {

		String query = "select n.name, n.code, n.area, n.capital, n.location, GROUP_CONCAT(DISTINCT c.name SEPARATOR ', ') city, GROUP_CONCAT(DISTINCT l.name SEPARATOR ', ') language, GROUP_CONCAT(DISTINCT cl.name SEPARATOR ', ') climate, GROUP_CONCAT(DISTINCT re.name SEPARATOR ', ') religion, GROUP_CONCAT(DISTINCT r.name SEPARATOR ', ') race\r\n"
				+ "	from nation n\r\n" + "    left outer join city c on n.id = c.nation_id\r\n"
				+ "    left outer join climate cl on n.id = cl.nation_id\r\n"
				+ "    left outer join language l  on n.id = l.nation_id\r\n"
				+ "    left outer join race r on n.id = r.nation_id\r\n"
				+ "    left outer join religion re on n.id = re.nation_id\r\n" + "    GROUP BY n.name";

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

	//검색값과 테이블로 국가 조회
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

	//국가 삽입
	@Override
	public boolean insertByNation(Nation nation) {
		String query = "INSERT INTO nation (name, code, capital, location, area, area_source, area_description, base_year) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement psmt = con.prepareStatement(query)) {

			psmt.setString(1, nation.getName());
			psmt.setString(2, nation.getCode());
			psmt.setString(3, nation.getCapital());
			psmt.setString(4, nation.getLocation());
			psmt.setObject(5, nation.getArea(), Types.DOUBLE);
			psmt.setString(6, nation.getAreaSource());
			psmt.setString(7, nation.getAreaDescription());
			psmt.setObject(8, nation.getBaseYear(), Types.INTEGER);

			int count = psmt.executeUpdate();
			return count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	//국가 갱신
	@Override
	public boolean updateByNation(Nation nation) {
		String query = "UPDATE nation SET code = ?, capital = ?, location=?, area=?, area_source=?, area_description=?, base_year=? WHERE name=?";

		try (PreparedStatement psmt = con.prepareStatement(query)) {

			psmt.setString(1, nation.getCode());
			psmt.setString(2, nation.getCapital());
			psmt.setString(3, nation.getLocation());
			psmt.setObject(4, nation.getArea(), Types.DOUBLE);
			psmt.setString(5, nation.getAreaSource());
			psmt.setString(6, nation.getAreaDescription());
			psmt.setObject(7, nation.getBaseYear(), Types.INTEGER);
			psmt.setString(8, nation.getName());

			int count = psmt.executeUpdate();
			return count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	//국가 생성
	@Override
	public void createNation(Nation nation) {
		String query = "INSERT INTO NATION (NAME, CODE, CAPITAL, LOCATION, AREA, AREA_SOURCE, AREA_DESCRIPTION, BASE_YEAR) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, nation.getName());
			psmt.setString(2, nation.getCode());
			psmt.setString(3, nation.getCapital());
			psmt.setString(4, nation.getLocation());
			psmt.setObject(5, nation.getArea(), Types.DOUBLE);
			psmt.setString(6, nation.getAreaSource());
			psmt.setString(7, nation.getAreaDescription());
			psmt.setObject(8, nation.getBaseYear(), Types.INTEGER);

			psmt.executeUpdate();

			psmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
