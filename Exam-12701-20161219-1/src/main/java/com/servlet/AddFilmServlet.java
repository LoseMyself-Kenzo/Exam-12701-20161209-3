package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.FilmDAOImpl;
import com.service.loginService;

/**
 * Servlet implementation class AddFilmServlet
 */
public class AddFilmServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String language = req.getParameter("language");
		Boolean flag = false;
		String message = null;
		if (title.equals("") || title.equals(null)) {
			message = "不可为空";
			req.setAttribute("message", message);
			req.getRequestDispatcher("add.jsp").forward(req, res);
		} else if (description.equals("") || description.equals(null)) {
			message = "不可为空";
			req.setAttribute("message", message);
			req.getRequestDispatcher("add.jsp").forward(req, res);
		} else if (language.equals("") || language.equals(null)) {
			message = "不可为空";
			req.setAttribute("message", message);
			req.getRequestDispatcher("add.jsp").forward(req, res);
		} else {
			FilmDAOImpl fimpl = new FilmDAOImpl();
			flag = fimpl.addFilm(title, description, language);
			if (flag == false) {
				message = "新增失败";
			} else {
				message = "新增成功";
			}
			req.setAttribute("message", message);
			req.getRequestDispatcher("add.jsp").forward(req, res);
		}

	}
}
