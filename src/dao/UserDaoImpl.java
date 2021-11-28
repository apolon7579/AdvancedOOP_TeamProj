package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import config.ConnectionManager;
import entity.User;

//user dao 구현체
public class UserDaoImpl implements UserDao {

	private Connection con = ConnectionManager.getConnection();

	//유저 등록
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

	//아이디와 비밀번호로 유저 조회
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
	
	//아이디로 유저 조회
	@Override
	public User retrieveByUserId(String id) {
		User user = null;

		try {
			PreparedStatement psmt = con.prepareStatement("SELECT * FROM user WHERE user_id = ?");
			psmt.setString(1, id);
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

	//유저 갱신(미구현)
	@Override
	public boolean updateByUserIdAndUser(String id, User newUser) {
		return false;
	}

	//아이디로 유저 삭제
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

	//아이디로 점수 조회
	@Override
	public Integer retrieveLevelByUserId(String id) {
		Integer level = null;
		try {
			PreparedStatement psmt = con.prepareStatement("SELECT * FROM user WHERE user_id = ?");
			psmt.setString(1, id);
			ResultSet resultSet = psmt.executeQuery();

			if (resultSet != null) {
				resultSet.next();
				level = resultSet.getObject("level", Integer.class);
			}

			resultSet.close();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return level;
	}

	//최고점수조회
	@Override
	public Integer retrieveTopLevel() {
		Integer level = null;
		try {
			PreparedStatement psmt = con.prepareStatement("select max(user.level) level from user;");
			ResultSet resultSet = psmt.executeQuery();

			if (resultSet != null) {
				resultSet.next();
				level = resultSet.getObject("level", Integer.class);
			}

			resultSet.close();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return level;
	}

	//유저 점수 갱신
	@Override
	public boolean updateLevelByUserAndLevel(User user, Integer newLevel) {
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
