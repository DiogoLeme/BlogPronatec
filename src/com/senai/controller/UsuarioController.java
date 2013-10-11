package com.senai.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senai.model.bean.Usuario;
import com.senai.model.dao.UsuarioDAO;

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		salvar(request, response);
	}

	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		
		usuario.setNome(request.getParameter("nome"));
		usuario.setSobrenome(request.getParameter("sobrenome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setStatus(0);
		
		String confirmasenha = request.getParameter("confirmasenha");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		RequestDispatcher rd;
		
		if (usuario.getSenha().isEmpty() || !usuario.getSenha().equals(confirmasenha)) {
			request.setAttribute("mensagem", "Confirmação de senha não é compatível com a senha");
			request.setAttribute("usuario", usuario);
			rd = request.getRequestDispatcher("/usuario.jsp");
		} else if (usuarioDAO.emailEncontrado(usuario.getEmail())) {
			request.setAttribute("mensagem", "E-mail já cadastrado no sistema");
			request.setAttribute("usuario", usuario);
			rd = request.getRequestDispatcher("/usuario.jsp");
		} else {
			usuarioDAO.adiciona(usuario);
			request.setAttribute("mensagem", "Usuário cadastrado com sucesso");
			rd = request.getRequestDispatcher("/home");
		}
		rd.forward(request, response);
	}
}
