package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter {
	
	private String excludedPages;         

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.excludedPages = filterConfig.getInitParameter("excludedPages");     
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		
		//例外页面判断
		if(req.getServletPath().equals(excludedPages)){
			chain.doFilter(request, response);
			return;
		}
		
		//非例外页面
		
		HttpSession session=req.getSession();
		
		if(session.getAttribute("LOGIN_USER")==null){//表示没有登陆
			
			req.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}

