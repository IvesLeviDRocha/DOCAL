package br.unifor.ads.DOCAL_core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unifor.ads.DOCAL_core.entity.Usuario;

public class UsuarioDAO {
	
	public void insert(Usuario usuario) {
		Connection connection = null;
		try {
			connection = ConnectionPool.getConnection();
			String sql = "insert into usuario (login, nome, senha, altura, peso) "
					+ "values (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getNome());
			statement.setString(3, usuario.getSenha());
			statement.setFloat(4, usuario.getAltura());
			statement.setFloat(5, usuario.getPeso());
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel inserir o usuario!");
		} finally {
			tryCloseConnection(connection);
		}
	}

	private void tryCloseConnection(Connection connection) {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			} 
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel fechar a conexao?");
		}
	}
	
	public Usuario findByNome(String nome) {
		Connection connection = null;
		Usuario usuario = null;
		try {
			connection = ConnectionPool.getConnection();
			String sql = "select id, login, nome, senha, altura, peso from usuario "
					+ "where nome = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nome);
			
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				usuario = new Usuario();
				usuario.setId(result.getInt("id"));
				usuario.setLogin(result.getString("login"));
				usuario.setNome(result.getString("nome"));
				usuario.setSenha(result.getString("senha"));
				usuario.setAltura(result.getFloat("altura"));
				usuario.setPeso(result.getFloat("peso"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel inserir o usuario!");
		} finally {
			tryCloseConnection(connection);
		}
		return usuario;
	}

}
