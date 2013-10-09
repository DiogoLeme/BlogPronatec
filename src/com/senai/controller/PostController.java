package com.senai.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
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
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if ("salvar".equals(acao) || "publicar".equals(acao)) {
			salvar(request, response);
		} else if ("exibir".equals(acao)) {
			exibir(request, response);
		} else if ("editar".equals(acao)) {
			editar(request, response);
		} else if ("deletar".equals(acao)) {
			deletar(request, response);
		} else if ("editar".equals(acao)) {
			editar(request, response);
		}
	}

	private void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String stringId = request.getParameter("id");
		Integer id = Integer.parseInt(stringId);
		PostDAO postDAO = new PostDAO();
		postDAO.deletar(id);

		request.setAttribute("mensagem", "Post excluído com sucesso!");
		RequestDispatcher rd = request.getRequestDispatcher("/home");
		rd.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String stringId = request.getParameter("id");
		Integer id = Integer.parseInt(stringId);
		PostDAO postDAO = new PostDAO();
		Post post = postDAO.getPost(id);

		request.setAttribute("post", post);
		RequestDispatcher rd = request.getRequestDispatcher("/cadastrar.jsp");
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

	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post post = new Post();
		
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			post.setId(Integer.parseInt(id));
		}
		
		post.setTitulo(request.getParameter("titulo"));
		post.setTexto(request.getParameter("texto"));
		post.setResumo(request.getParameter("resumo"));
		post.setAutor(request.getParameter("autor"));
		post.setData(Calendar.getInstance().getTime());

		String acao = request.getParameter("acao");
		if ("salvar".equals(acao)) {
			post.setStatus(0);
		} else if ("publicar".equals(acao)) {
			post.setStatus(1);
		}

		PostDAO postDAO = new PostDAO();
		if (post.getId() == null) {
			postDAO.adiciona(post);
		} else {
			postDAO.atualiza(post);
		}

		request.setAttribute("mensagem", "Post salvo com sucesso!");
		RequestDispatcher rd = request.getRequestDispatcher("/cadastrar.jsp");
		rd.forward(request, response);
	}

}
