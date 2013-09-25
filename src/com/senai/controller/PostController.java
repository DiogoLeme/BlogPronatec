package com.senai.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senai.model.bean.Post;
import com.senai.model.dao.PostDAO;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Post post = new Post();
		post.setTitulo(request.getParameter("titulo"));
		post.setTexto(request.getParameter("texto"));
		post.setResumo(request.getParameter("resumo"));
		post.setAutor(request.getParameter("autor"));
		post.setData(Calendar.getInstance());
		
		String acao = request.getParameter("acao");
		if ("salvar".equals(acao)) {
			// Salva como rascunho
			post.setStatus(0);
		}else if ("publicar".equals(acao)) {
			// Salva como rascunho
			post.setStatus(1);
		}
		
		PostDAO postDAO = new PostDAO();
		postDAO.adiciona(post);
		
	}

}
