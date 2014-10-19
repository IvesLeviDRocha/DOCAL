package br.unifor.ads.DOCAL_core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.unifor.ads.DOCAL_core.entity.Dieta;

public class DietaDAO {

	public void insert(Dieta dieta) {
		Connection connection = null;
		try {
			connection = ConnectionPool.getConnection();
			String sql = "insert into dieta "
					+ "(usuario_id, nome, carboidratos, proteinas, gorduras, calorias) "
					+ "values (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dieta.getUsuario_id().getId());
			statement.setString(2, dieta.getNome());
			statement.setFloat(3, dieta.getCarboidratos());
			statement.setFloat(4, dieta.getProteinas());
			statement.setFloat(5, dieta.getGorduras());
			statement.setFloat(6, dieta.getCalorias());
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
