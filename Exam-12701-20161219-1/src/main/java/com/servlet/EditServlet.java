package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.FilmDAOImpl;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

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
			flag = fimpl.updateFilm(id, title, description, language);

			if (flag == false) {
				message = "编辑失败";
			} else {
				message = "编辑成功";
			}
			req.setAttribute("id", id);
			req.setAttribute("message", message);
			req.getRequestDispatcher("edit.jsp").forward(req, res);
		}

		req.setAttribute("id", id);
		req.getRequestDispatcher("edit.jsp").forward(req, res);

	}

}
