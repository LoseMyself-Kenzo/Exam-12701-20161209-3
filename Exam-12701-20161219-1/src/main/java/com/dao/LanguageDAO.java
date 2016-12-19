package com.dao;

public interface LanguageDAO {
	//查找Language_id对应的Language
	public String findLanguage(int Language_id);
	
	//查找name对应的Language_id
	public int findLanguage_id(String Language);
}
