package br.unifor.ads.DOCAL_core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.unifor.ads.DOCAL_core.entity.Refeicao;

public class RefeicaoDAO {

	public void insert(Refeicao refeicao) {
		Connection connection = null;
		try {
			connection = ConnectionPool.getConnection();
			String sql = "insert into refeicao "
					+ "(usuario_id, nome, carboidratos, proteinas, gorduras, calorias) "
					+ "values (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, refeicao.getUsuario_id().getId());
			statement.setString(2, refeicao.getNome());
			statement.setFloat(3, refeicao.getCarboidratos());
			statement.setFloat(4, refeicao.getProteinas());
			statement.setFloat(5, refeicao.getGorduras());
			statement.setFloat(6, refeicao.getCalorias());
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
}
