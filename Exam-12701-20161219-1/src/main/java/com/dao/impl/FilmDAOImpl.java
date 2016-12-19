package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.FilmDAO;
import com.entity.Film;
import com.tools.DBConnection;

public class FilmDAOImpl implements FilmDAO {

	// 实现Film表查找功能
	@Override
	public Film findFilm() {
		Film film = null;
		DBConnection dbConn = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			dbConn = DBConnection.getInstance();
			conn = dbConn.getConnection();
			String sql = "select film_id,title,description,language_AID from film";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				film = new Film();
				// int film_id,String title,String description,String language
				film.setFilm_id(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setLanguage_id(rs.getInt("language_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.colse(conn, pstmt, rs);
		}
		return film;
	}

	// 增加Film
	@Override
	public boolean addFilm(String title, String description, String language) {
		boolean bool = false;
		DBConnection dbConn = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LanguageDAOImpl ld = new LanguageDAOImpl();
		int language_id = ld.findLanguage_id(language);
		try {
			dbConn = DBConnection.getInstance();
			conn = dbConn.getConnection();
			String sql = "INSERT INTO film (title,description,language_id,last_update)" + " values(?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, description);
			pstmt.setInt(3, language_id);
			int count = pstmt.executeUpdate();
			bool = count > 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.colse(conn, pstmt, rs);
		}
		return bool;
	}

	// 删除Film
	@Override
	public boolean deleteFilm(int film_id) {
		boolean bool = false;
		DBConnection dbConn = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			dbConn = DBConnection.getInstance();
			conn = dbConn.getConnection();
			String sql = "delete from film where film_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, film_id);
			int count = pstmt.executeUpdate();
			bool = count > 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.colse(conn, pstmt, rs);
		}
		return bool;
	}

	// 编辑Film
	@Override
	public boolean updateFilm(int film_id, String title, String description, String language) {
		boolean bool = false;
		DBConnection dbConn = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LanguageDAOImpl ld = new LanguageDAOImpl();
		int language_id = ld.findLanguage_id(language);
		try {
			dbConn = DBConnection.getInstance();
			conn = dbConn.getConnection();
			String sql = "update film set title=?,description=?,language_id=? where film_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, description);
			pstmt.setInt(3, language_id);
			pstmt.setInt(4, film_id);
			int count = pstmt.executeUpdate();
			bool = count > 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.colse(conn, pstmt, rs);
		}
		return bool;
	}

}
