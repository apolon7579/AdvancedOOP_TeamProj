package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import config.ConnectionManager;
import entity.User;

public class UserDaoImpl implements UserDao {

	private Connection con = ConnectionManager.getConnection();

	@Override
	public boolean createByNameAndUserIdAndPassword(String name, String id, String password) {
		try {
			PreparedStatement psmt = con
					.prepareStatement("INSERT INTO user(name, user_id, password, level) VALUES(?, ?, ?, ?)");
			psmt.setString(1, name);
			psmt.setString(2, id);
			psmt.setString(3, password);
			psmt.setInt(4, 0);

			int flag = psmt.executeUpdate();
			psmt.close();

			return (flag == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User retrieveByUserIdAndPassword(String id, String password) {

		User user = null;

		try {
			PreparedStatement psmt = con.prepareStatement("SELECT * FROM user WHERE user_id = ? AND password = ? ");
			psmt.setString(1, id);
			psmt.setString(2, password);
			ResultSet resultSet = psmt.executeQuery();

			if (resultSet != null) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public boolean updateByUserIdAndUser(String id, User newUser) {
		return false;
	}

	@Override
	public boolean deleteByUserId(String id) {
		try {
			PreparedStatement psmt = con.prepareStatement("DELETE FROM user WHERE user_id = ?");
			psmt.setString(1, id);

			int flag = psmt.executeUpdate();
			psmt.close();

			return (flag == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Long retrieveLevelByUserId(String id) {
		Long level = null;
		try {
			PreparedStatement psmt = con.prepareStatement("SELECT * FROM user WHERE user_id = ?");
			psmt.setString(1, id);
			ResultSet resultSet = psmt.executeQuery();

			if (resultSet != null) {
				resultSet.next();
				level = resultSet.getLong("level");
			}

			resultSet.close();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return level;
	}

	@Override
	public Long retrieveTopLevel() {
		Long level = null;
		try {
			PreparedStatement psmt = con.prepareStatement("select max(user.level) level from user;");
			ResultSet resultSet = psmt.executeQuery();

			if (resultSet != null) {
				resultSet.next();
				level = resultSet.getLong("level");
			}

			resultSet.close();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return level;
	}

	@Override
	public boolean updateLevelByUserAndLevel(User user, Long newLevel) {
		String query = "UPDATE user SET level=? WHERE user_id=?";

		if (user.getLevel() < newLevel) {
			try (PreparedStatement psmt = con.prepareStatement(query)) {

				psmt.setLong(1, newLevel);
				psmt.setString(2, user.getUserId());

				int count = psmt.executeUpdate();
				return count == 1;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}
	
}
