package com.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig extends Properties {

	private static DBConfig jdbcConfig = null;

	public static DBConfig getInstance() throws IOException {
		if (jdbcConfig == null) {
			jdbcConfig = new DBConfig();
		}
		return jdbcConfig;
	}

	private DBConfig() throws IOException {
		this.init();
	}

	private void init() throws IOException {

		InputStream inputStream = DBConfig.class.getClassLoader().getResourceAsStream("db.properties");

		this.load(inputStream);
	}

}