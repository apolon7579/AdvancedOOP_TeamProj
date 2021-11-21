package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionManager;
import entity.Climate;
import entity.Media;

public class MediaDaoImpl implements MediaDao{

	private Connection con = ConnectionManager.getConnection();
	
	@Override
	public List<Media> retrieveMediaListByNationId(int nationId) {
		
		String query = "SELECT * FROM MEDIA WHERE NATION_ID = ?";
		Media media = null;
		List<Media> mediaList = new ArrayList<Media>();
		
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setLong(1, nationId);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				media = new Media(id, nationId, name);
				mediaList.add(media);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return mediaList;
	}

	@Override
	public boolean insertByMedia(Media media) {
		String query = "INSERT INTO media (nation_id, name) VALUES (?, ?)";

		try (PreparedStatement psmt = con.prepareStatement(query)){
			psmt.setInt(1, media.getNationId());
			psmt.setString(2, media.getName());
			
			int count = psmt.executeUpdate();
			return count == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int deleteByNationId(int nationId) {
		String query = "DELETE FROM media WHERE nation_id=?";

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
