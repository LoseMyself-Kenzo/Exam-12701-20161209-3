package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Film;
import com.service.loginService;
import com.service.showService;

/**
 * Servlet implementation class ShowFilm
 */
public class ShowFilm extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Film> list = new showService().show();
		req.getSession().setAttribute("list", list);
		req.getRequestDispatcher("show.jsp").forward(req, res);	
	}
}
