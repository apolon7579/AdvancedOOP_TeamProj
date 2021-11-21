package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionManager;
import entity.Language;

public class LanguageDaoImpl implements LanguageDao{

	private Connection con = ConnectionManager.getConnection();
	
	@Override
	public List<Language> retrieveLanguageListByNationId(int nationId) {
		
		String query = "SELECT * FROM LANGUAGE WHERE NATION_ID = ?";
		Language language = null;
		List<Language> languageList = new ArrayList<Language>();
		
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setLong(1, nationId);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				language = new Language(id, nationId, name);
				languageList.add(language);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean insertByLanguage(Language language) {
		String query = "INSERT INTO language (nation_id, name) VALUES (?, ?)";

		try (PreparedStatement psmt = con.prepareStatement(query)){
			psmt.setInt(1, language.getNationId());
			psmt.setString(2, language.getName());
			
			int count = psmt.executeUpdate();
			return count == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int deleteByNationId(int nationId) {
		String query = "DELETE FROM language WHERE nation_id=?";

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
