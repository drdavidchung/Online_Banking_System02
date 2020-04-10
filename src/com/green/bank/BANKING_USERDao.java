package com.green.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.green.bank.model.AccountModel;
//import com.green.bank.model.Basedao;


public class BANKING_USERDao {
	public static int insert(AccountModel u) {
			String sql = "insert into account values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";			
			Object[] params = {
						u.getAccount_no(), 
						u.getFirst_name(), 
						u.getLast_name(),
						u.getAddress(),
						u.getCity(),
						u.getBranch(),
						u.getZip(),
						u.getUsername(),
						u.getPassword(),
						u.getPhone_number(),
						u.getEmail(),
						u.getAccount_type(),
						u.getReg_date(),
						u.getUser_status()};
			
			return Basedao.exectuIUD(sql, params);
	}
	
	
	public static int del(String id) {
		
		String sql = "delete from LMONKEY_USER where USER_ID=? and USER_STATUS!=2";
		
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	public static int update(AccountModel u) {
		String sql = "update LMONKEY_USER set USER_NAME=?, USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?, '%y-%m-%d'),USER_IDENITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID = ?";
		
		Object[] params = {
				u.getAccount_no(), 
				u.getFirst_name(), 
				u.getLast_name(),
				u.getAddress(),
				u.getCity(),
				u.getBranch(),
				u.getZip(),
				u.getUsername(),
				u.getPassword(),
				u.getPhone_number(),
				u.getEmail(),
				u.getAccount_type(),
				u.getReg_date(),
				u.getUser_status()};
		
		return Basedao.exectuIUD(sql, params);
}

	public static int selectByName(String id) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "select count(*) from LMONKEY_USER where USER_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
		    rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 count = rs.getInt(1);
			 }
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return count;
	}
	
	
	public static int[] totalPage(int count, String keyword) {
		// 0 总记录数， 1， 页数
		int arr[] = {0, 1};
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select count(*) from LMONKEY_USER where USER_NAME like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
			}else{
				sql = "select count(*) from LMONKEY_USER";
				
				ps = conn.prepareStatement(sql);
				
			}
			
	
			
			
			
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 arr[0]= rs.getInt(1);
				 
				 if(arr[0]%count==0){
					 arr[1] = arr[0]/count;
				 }else{
					 arr[1] = arr[0]/count+1;
				 }
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return arr;
	}
	
	
	public static ArrayList<AccountModel> selectAll(int cpage, int count,String keyword) {
		ArrayList<AccountModel> list = new ArrayList<AccountModel>();
		
		ResultSet rs = null;
		
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select * from ACCOUNT where USERNAME like ? order by REG_DATE desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, "%"+keyword+"%");
				 ps.setInt(2, (cpage-1)*count);
				 ps.setInt(3, count);
			}else{
			
				sql = "select * from ACCOUNT order by REG_DATE desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 
				 ps.setInt(1, (cpage-1)*count);
				 ps.setInt(2, count);
			}
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 AccountModel u = new AccountModel(
						 	rs.getString("ID"),
						 	rs.getString("F_NAME"),
						 	rs.getString("L_NAME"),
						 	rs.getString("ADDRESS"),
						 	rs.getString("CITY"),
						 	rs.getString("BRANCH"),
						 	rs.getString("ZIP"),
						 	rs.getString("USERNAME"),
						 	rs.getString("PASSWORD"),
						 	rs.getString("PHONE"),
						 	rs.getString("EMAIL"),
						 	rs.getString("ACCOUNT_TYPE"),
						 	rs.getString("REG_DATE"),
						 	rs.getInt("USER_STATUS")
						 
						 );		 
				 
				 list.add(u);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	/**
	 * 通过ID查找用户
	 * @param cpage
	 * @param count
	 * @param keyword
	 * @return
	 */
	public static AccountModel selectByID(String id) {

		AccountModel u = null;
		
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday  from LMONKEY_USER m where USER_ID=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, id);
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 u = new AccountModel(
						 	rs.getString("ID"),
						 	rs.getString("F_NAME"),
						 	rs.getString("L_NAME"),
						 	rs.getString("ADDRESS"),
						 	rs.getString("CITY"),
						 	rs.getString("BRANCH"),
						 	rs.getString("ZIP"),
						 	rs.getString("USERNAME"),
						 	rs.getString("PASSWORD"),
						 	rs.getString("PHONE"),
						 	rs.getString("EMAIL"),
						 	rs.getString("ACCOUNT_TYPE"),
						 	rs.getString("REG_DATE"),
						 	rs.getInt("USER_STATUS")
			
						 );
				 
				 
				
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return u;
	}
	
	public static int selectByNM(String name, String pwd){
		int count =0; 
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "select count(*) from ACCOUNT where USERNAME=? and PASSWORD=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
		    rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 count = rs.getInt(1);
			 }
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return count;
		
	}
	/**
	 * 通过用户名和密码查询用户信息
	 * @param name
	 * @param pwd
	 * @return
	 */
	
	public static AccountModel selectAdmin(String name, String pwd) {
		AccountModel u = null;
		
		ResultSet rs = null;
		//
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from ACCOUNT where USERNAME=? and PASSWORD=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, name);
			 ps.setString(2, pwd);
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 u = new AccountModel(
						 	rs.getString("ID"),
						 	rs.getString("F_NAME"),
						 	rs.getString("L_NAME"),
						 	rs.getString("ADDRESS"),
						 	rs.getString("CITY"),
						 	rs.getString("BRANCH"),
						 	rs.getString("ZIP"),
						 	rs.getString("USERNAME"),
						 	rs.getString("PASSWORD"),
						 	rs.getString("PHONE"),
						 	rs.getString("EMAIL"),
						 	rs.getString("ACCOUNT_TYPE"),
						 	rs.getString("REG_DATE"),
						 	rs.getInt("USER_STATUS")
			
						 ); 				 			 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return u;
		
		
	}
	
	
	
}
