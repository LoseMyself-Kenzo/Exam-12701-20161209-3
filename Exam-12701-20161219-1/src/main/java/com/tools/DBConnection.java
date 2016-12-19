package com.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class DBConnection {

	private static DBConnection conn = null;
	private static BasicDataSource bds = null;

	private DBConnection() throws Exception {
		this.init();
	}

	// 加载驱动类
	private void init() throws Exception {
		bds = new BasicDataSource();
		bds.setUrl(DBConfig.getInstance().getProperty("url"));
		bds.setDriverClassName(DBConfig.getInstance().getProperty("driverName"));
		bds.setUsername(DBConfig.getInstance().getProperty("userName"));
		bds.setPassword(DBConfig.getInstance().getProperty("password"));
	}

	public static DBConnection getInstance() throws Exception {

		if (conn == null) {
			conn = new DBConnection();
		}
		return conn;
	}

	public Connection getConnection() throws Exception {
		Connection con = null;
		con = bds.getConnection();

		return con;
	}

	public void colse(Connection con, Statement st, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
