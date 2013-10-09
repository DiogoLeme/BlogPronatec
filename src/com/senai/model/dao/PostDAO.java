package com.senai.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
			stmt.setTimestamp(6, new Timestamp(post.getData().getTime()));
			
			// executa
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Post> getLista(Boolean showDrafts) {
		try {
			List<Post> posts = new ArrayList<Post>();
			PreparedStatement stmt = this.connection .prepareStatement("select * from post where status = 1 or status = ? order by data desc");

			if(showDrafts){
				stmt.setString(1, "0");
			} else {
				stmt.setString(1, "1");
			}
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setTitulo(rs.getString("titulo"));
				post.setResumo(rs.getString("resumo"));
				post.setAutor(rs.getString("autor"));
				post.setStatus(rs.getInt("status"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getTimestamp("data"));
				post.setData(data.getTime());
				
				// adicionando o objeto à lista
				posts.add(post);
			}
			
			rs.close();
			stmt.close();
			return posts;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Post getPost(Integer id) {
		try {
			Post post = new Post();
			PreparedStatement stmt = this.connection .prepareStatement("select * from post where id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				post = new Post();
				post.setId(rs.getInt("id"));
				post.setTitulo(rs.getString("titulo"));
				post.setTexto(rs.getString("texto"));
				post.setResumo(rs.getString("resumo"));
				post.setAutor(rs.getString("autor"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getTimestamp("data"));
				post.setData(data.getTime());
			}
			
			rs.close();
			stmt.close();
			return post;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Integer id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from post where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	 
	 
	public void atualiza(Post post) {
		String sql = "update post set titulo = ?, resumo = ?, texto = ?, autor = ?, status = ?, data = ? where id = ?";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, post.getTitulo());
			stmt.setString(2, post.getResumo());
			stmt.setString(3, post.getTexto());
			stmt.setString(4, post.getAutor());
			stmt.setInt(5, post.getStatus());
			stmt.setTimestamp(6, new Timestamp(post.getData().getTime()));
			stmt.setInt(7, post.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}	
