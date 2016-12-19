package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.LanguageDAO;
import com.entity.Film;
import com.tools.DBConnection;

public class LanguageDAOImpl implements LanguageDAO {
	
	//实现查找Language_id对应的Language
	@Override
	public String findLanguage(int Language_id) {
		String l = "English";
		DBConnection dbConn = null;
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			dbConn = DBConnection.getInstance();
			conn = dbConn.getConnection();
			String sql = "select name from Language where Language_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Language_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				l = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.colse(conn, pstmt, rs);
		}
		return l;
	}
	
	//查找name对应的Language_id
	@Override
	public int findLanguage_id(String Language) {
		int l = 1;
		DBConnection dbConn = null;
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			dbConn = DBConnection.getInstance();
			conn = dbConn.getConnection();
			String sql = "select Language_id from Language where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Language);
			rs = pstmt.executeQuery();
			if(rs.next()){
				l = rs.getInt("language_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.colse(conn, pstmt, rs);
		}
		return l;
	}

}
