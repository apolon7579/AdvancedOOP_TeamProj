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

}
