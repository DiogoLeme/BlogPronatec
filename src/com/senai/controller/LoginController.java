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

/**
 * Servlet implementation class LoginController
 */
@WebServlet({"/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario user = dao.getUser(email);
		
		RequestDispatcher rd;
		
		if (request.getParameter("sair") != null) {
			request.getSession().invalidate();
	        rd = request.getRequestDispatcher("/home");
		} else if (user.getEmail() == null || user.getSenha() == null) {
			request.setAttribute("mensagem", "Usuário ou senha inválido");
			rd = request.getRequestDispatcher("/login.jsp");
		}else if (!user.getSenha().equals(senha)) {
			request.setAttribute("mensagem", "Usuário ou senha inválido");
			rd = request.getRequestDispatcher("/login.jsp");
		}else if (user.getStatus() == 0) {
			request.setAttribute("mensagem", "Usuário ainda não foi autorizado");
			rd = request.getRequestDispatcher("/login.jsp");
		} else {
			request.setAttribute("mensagem", "Login realizado com sucesso");
			request.getSession().setAttribute("user", user);
			rd = request.getRequestDispatcher("/home");
		}
		rd.forward(request, response);
	}
}
