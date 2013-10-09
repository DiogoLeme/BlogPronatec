package com.senai.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns = { "/home" })
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String usuario = request.getParameter("usuario");
		if ("1".equals(usuario)) {
			request.setAttribute("mensagem", "Você deve fazer login para acessar essa página.");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}
	
	public LoginFilter() { }
	
	public void destroy() { }

	public void init(FilterConfig fConfig) throws ServletException { }

}
