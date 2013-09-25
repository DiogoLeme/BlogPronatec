package com.senai.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.senai.model.bean.Post;


public class PostDAO {

	// Conexão com o banco de dados
	private Connection connection;

	// Construtor que obtem a conexão da fábrica de conexões com banco de dados;
	public PostDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Post post) {
		String sql = "insert into post (titulo,resumo,texto,autor,status,data) values (?,?,?,?,?,?)";
		try {
			
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1,post.getTitulo());
			stmt.setString(2,post.getResumo());
			stmt.setString(3,post.getTexto());
			stmt.setString(4,post.getAutor());
			stmt.setInt(5,post.getStatus());
			stmt.setDate(6, new Date(post.getData().getTimeInMillis()));
			
			// executa
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}	
