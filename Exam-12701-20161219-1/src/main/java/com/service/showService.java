package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Film;
import com.tools.DBConnection;

public class showService {
	public List<Film> show() {
		List<Film> list = new ArrayList<Film>();
		Film film = null;
		DBConnection dbConn = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			dbConn = DBConnection.getInstance();
			conn = dbConn.getConnection();
			String sql = "select * from film";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				film = new Film();
				film.setDescription(rs.getString("description"));
				film.setFilm_id(rs.getInt("film_id"));
				film.setLanguage_id(rs.getInt("language_id"));
				film.setTitle(rs.getString("title"));
				list.add(film);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.colse(conn, pstmt, rs);
		}
		return list;

	}

}
