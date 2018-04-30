package com.bmpl.ims.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface CommonDAO {

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String dburl = "jdbc:mysql://localhost:3306/imsdb?useSSL=false";
		//Driver load
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(dburl,"root","ast3398");
		return conn;
	}
	
}
