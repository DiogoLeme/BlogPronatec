package com.senai.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.senai.model.bean.Usuario;


public class UsuarioDAO {

	// Conexão com o banco de dados
	private Connection connection;

	// Construtor que obtem a conexão da fábrica de conexões com banco de dados;
	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Usuario usuario) {
		String sql = "insert into usuario ( nome, sobrenome, email, senha, status ) values ( ?, ?, ?, ?, ? )";
		try {
			
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			stmt.setInt(5,usuario.getStatus());
			
			// executa
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Boolean emailEncontrado(String email) {
		try {
			PreparedStatement stmt = this.connection .prepareStatement("select * from usuario where LOWER(email) like LOWER(?)");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				rs.close();
				stmt.close();
				return Boolean.TRUE;
			}
			
			rs.close();
			stmt.close();
			return Boolean.FALSE;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario getUser(String email) {
		try {
			PreparedStatement stmt = this.connection .prepareStatement("select * from usuario where LOWER(email) like LOWER(?)");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			Usuario usuario = new Usuario();
			while (rs.next()) {
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setStatus(rs.getInt("status"));
			}
			
			rs.close();
			stmt.close();
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}	
