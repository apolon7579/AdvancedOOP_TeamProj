package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConnectionManager;
import entity.User;

public class UserServiceImpl implements UserService {
	private static final Connection con = ConnectionManager.getConnection();

	// 유저 테스트용 메인 메소드
	public static void main(String[] args) {
		System.out.println("aaa");
		UserService user = new UserServiceImpl();
		System.out.println(user.userResist(new User(0, "aaa", "test", "test", 0)));
	}

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
		try {
			PreparedStatement psmt = con.prepareStatement("SELECT * FROM user WHERE user_id = ? AND password = ? ");
			psmt.setString(1, userId);
			psmt.setString(2, password);

			ResultSet user = psmt.executeQuery();
			user.next();

			if (user.getRow() != 1) {
				throw new Exception("중복된 아이디와 비밀번호를 가진 유저가 " + user.getRow() + "입니다.");
			}

			boolean flag = false;
			if (userId.equals(user.getString("user_id")) && password.equals(user.getString("password"))) {
				flag = true;
			}
			psmt.close();

			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
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
