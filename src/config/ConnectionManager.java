package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static ConnectionManager connectionManager = new ConnectionManager();
	private Connection conn;
	
	private ConnectionManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://182.230.134.78/advanceddb?useUnicode=true&serverTimezone=Asia/Seoul";
			String id = "joonmyung";
			String password = "1234";
			conn = DriverManager.getConnection(url, id, password);
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connectionManager.conn;
	}
}
