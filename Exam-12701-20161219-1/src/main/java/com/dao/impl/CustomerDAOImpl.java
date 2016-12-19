package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.CustomerDAO;
import com.entity.Customer;

import com.tools.DBConnection;

public class CustomerDAOImpl implements CustomerDAO {
	
	//实现查找顾客是否存在
	@Override
	public Boolean findUserByUserName(String userName) {
		Customer cs = null;
		DBConnection dbConn = null;
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean flag = false;
		try {
			
			dbConn = DBConnection.getInstance();
			conn = dbConn.getConnection();
			String sql = "select first_name from customer where first_name = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();	
			
			if(rs.next()){
				cs = new Customer();
				if(rs.getString("first_name").equals(userName)){
					return flag = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.colse(conn, pstmt, rs);
		}
		return flag;
	}

}
