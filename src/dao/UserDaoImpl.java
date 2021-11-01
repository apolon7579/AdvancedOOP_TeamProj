package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConnectionManager;
import entity.User;

public class UserDaoImpl implements UserDao{

	private Connection con = ConnectionManager.getConnection();
	
	@Override
	public User retrieveByUserIdAndPassword(String id, String password) {
		
		User user = null;
		
		try {
			PreparedStatement psmt = con.prepareStatement("SELECT * FROM user WHERE user_id = ? AND password = ? ");
			psmt.setString(1, id);
			psmt.setString(2, password);
			ResultSet resultSet = psmt.executeQuery();
			

			if(resultSet != null) {
				resultSet.next();
				int primaryId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String user_id = resultSet.getString("user_id");
				String password2 = resultSet.getString("password");
				int level = resultSet.getInt("level");
				user = new User(primaryId, name, user_id, password2, level);
			}
			
			resultSet.close();
			psmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
