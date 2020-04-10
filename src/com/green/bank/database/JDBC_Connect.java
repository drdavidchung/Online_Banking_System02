package com.green.bank.database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connect {
	private Connection connection = null;

	public Connection getConnection() throws SQLException {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //oracle.jdbc.driver.OracleDriver
		
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?useSSL=false&serverTimezone=CST","root","2xjuxaru"); 
			//"jdbc:mysql://localhost:3306/lmonkeyshop?useSSL=false&serverTimezone=CST","root","2xjuxaru"
					//"jdbc:oracle:thin:@localhost:1521:xe", "bank", "2xjuxaru"

		} catch (SQLException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();

		}

		return connection;

	}

}
