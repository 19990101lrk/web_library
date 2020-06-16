package cn.xh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil {
	static Connection conn = null;

	static {
		// ?????porperties???
//		ResourceBundle bundle = ResourceBundle.getBundle("jdbcConfig");
//		String dirver = bundle.getString("driverManager");
//		String url = bundle.getString("url");
//		String user = bundle.getString("user");
//		String password = bundle.getString("password");

		String dirver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/xinhua_library";
		String user = "root";
		String password = "123456";


		try {
			Class.forName(dirver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println('1');
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}
	
	public static void release(ResultSet set, Statement stmt, Connection connection) throws SQLException {
		if (set != null) {
			set.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
