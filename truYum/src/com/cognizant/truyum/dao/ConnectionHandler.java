package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ConnectionHandler {

		public static Connection con = null;
		private static Properties prop = new Properties();

		public static Connection getConnection() throws SQLException, ClassNotFoundException {

			try {
				FileInputStream fs = new FileInputStream("C:\\Users\\Anusha\\eclipse-workspace\\truYum\\src\\connection.properties");
				prop.load(fs);

				Class.forName(prop.getProperty("driver"));

				con = DriverManager.getConnection(prop.getProperty("connection-url"), prop.getProperty("user"),
						prop.getProperty("password"));
			} catch (IOException e) {
				e.printStackTrace();
			}

			return con;
		
	}

}
