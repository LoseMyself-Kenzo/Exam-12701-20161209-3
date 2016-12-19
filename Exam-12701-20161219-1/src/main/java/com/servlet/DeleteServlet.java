package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.FilmDAOImpl;
import com.entity.Film;
import com.service.showService;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));

		Boolean flag = false;
		String message = null;
		FilmDAOImpl fimpl = new FilmDAOImpl();
		flag = fimpl.deleteFilm(id);

		if (flag == false) {
			message = "删除失败";
		} else {
			message = "删除成功";
		}
		
		List<Film> list = new showService().show();
		req.getSession().setAttribute("list", list);
		req.setAttribute("message", message);
		req.getRequestDispatcher("show.jsp").forward(req, res);
	}
}
