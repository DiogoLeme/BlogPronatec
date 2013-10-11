package com.senai.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senai.model.bean.Post;
import com.senai.model.dao.PostDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if ("exibir".equals(acao)) {
			exibir(request, response);
		} else {
			showIndex(request, response);
		}
	}
	
	private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PostDAO postDAO = new PostDAO();
		List<Post> lista = postDAO.getLista(Boolean.TRUE);

		request.setAttribute("lista", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	private void exibir(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		String stringId = request.getParameter("id");
		Integer id = Integer.parseInt(stringId);
		PostDAO postDAO = new PostDAO();
		Post post = postDAO.getPost(id);

		request.setAttribute("post", post);
		RequestDispatcher rd = request.getRequestDispatcher("/post.jsp");
		rd.forward(request, response);
	}
}





