package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.ConnectionManager;

public class ConnectionTest {
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		String sql = "SELECT * FROM NATION";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			String name = rs.getString("NAME");
			System.out.println(name);
		}
		
		rs.close();
		st.close();
		con.close();
	}
}
