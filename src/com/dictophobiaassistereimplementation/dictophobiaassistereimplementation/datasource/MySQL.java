package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL implements DataSource {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/dai?serverTimezone=GMT";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static Connection conn;

	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		MySQL.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return MySQL.conn;
	}

	public static void close() throws SQLException {
		try {
			MySQL.conn.close();
		} catch (SQLException e) {
			throw e;
		}
	}
}
