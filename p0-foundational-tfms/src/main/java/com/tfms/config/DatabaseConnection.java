package com.tfms.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {

	private static Connection connection = null;

	DatabaseConnection() {

	}

	public static Connection getConnection() {
		Connection connection = null;
		if (connection == null) {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("mysql");
			String dburl = resourceBundle.getString("dburl");
			String username = resourceBundle.getString("username");
			String password = resourceBundle.getString("password");
			try {
				Class.forName(resourceBundle.getString("driver"));
				connection = DriverManager.getConnection(dburl, username, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return connection;
	}
}