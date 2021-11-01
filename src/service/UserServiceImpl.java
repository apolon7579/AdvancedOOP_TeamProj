package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConnectionManager;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class UserServiceImpl implements UserService {
	private final Connection con = ConnectionManager.getConnection();

	UserDao userDao = new UserDaoImpl();

	// 유저 등록
	@Override
	public boolean userResist(User user) {
		try {
			PreparedStatement psmt = con
					.prepareStatement("INSERT INTO user(name, user_id, password, level) VALUES(?, ?, ?, ?)");
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getUserId());
			psmt.setString(3, user.getPassword());
			psmt.setInt(4, 0);

			int flag = psmt.executeUpdate();
			psmt.close();

			return (flag == 1) ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// 유저 조회(로그인)
	@Override
	public boolean userLogin(String userId, String password) {
		
		User user = userDao.retrieveByUserIdAndPassword(userId, password);
		
		if(user == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean userUpdate(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userDelete(User user) {
		try {
			PreparedStatement psmt = con.prepareStatement("DELETE FROM user WHERE user_id = ? AND password = ? ");
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getPassword());

			int flag = psmt.executeUpdate();
			psmt.close();

			return (flag == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
