package com.green.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Basedao {
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	
	public static  Connection getconn() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?useSSL=false&serverTimezone=CST","root","2xjuxaru");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static int exectuIUD(String sql, Object[] params) {
			int count = 0; 
			
			Connection conn = Basedao.getconn();
			
			PreparedStatement ps = null;
			
			try {
				
				ps = conn.prepareStatement(sql);
				
				for(int i=0; i<params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
				
				count = ps.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Basedao.closeall(null, ps, conn);
				
			}
		
			return count;
	}
	
	public static void closeall(ResultSet rs, PreparedStatement ps, Connection conn) {
		
		try {
			if(rs!=null)
			
				rs.close();
			if(ps!=null)
				ps.close();
			
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
