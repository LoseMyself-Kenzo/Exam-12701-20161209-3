package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.loginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		loginService ls = new loginService();
		String message = null;
		String str = null;
		try {
			str = ls.verifyUser(userName);

			if (userName.equals("") || userName.equals(null)) {
				message = "用户名不能为空,请重新输入.";
			} else if (str == null) {
				message = "用户不存在,请重新输入.";
			}

		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}

		if (message == null) {
			req.setAttribute("LOGIN_USER", userName);
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} else {
			req.setAttribute("message", message);
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}
}
