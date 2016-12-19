package com.dao;

import com.entity.Film;

public interface FilmDAO {
	
	//显示所有File
	public Film findFilm();
	
	//增加Film
	public boolean addFilm(String title,String description,String language);
	
	//删除Film
	public boolean deleteFilm(int film_id);
	
	//编辑Film
	public boolean updateFilm(int film_id,String title,String description,String language );

}
