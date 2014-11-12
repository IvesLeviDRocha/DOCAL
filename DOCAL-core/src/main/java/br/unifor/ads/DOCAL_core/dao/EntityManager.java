package br.unifor.ads.DOCAL_core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class EntityManager {

	public void execute(String sql, Object... params) {
		PreparedStatement pstm = null;
		try {
			pstm = logicaConexao(sql, params);
			pstm.execute();
		} catch (SQLException e) {
			System.out
					.println("Não foi possível inserir os dados, tente novamente!");
		} finally {
			close(pstm);
		}
	}

	public Object getSingleResult(String sql, Object... params) {
		Object retorno = null;
		PreparedStatement pstm = null;
		try {
			pstm = logicaConexao(sql, params);
			ResultSet result = pstm.executeQuery();
			while (result.next()) {
				retorno = trataResultSet(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("Não foi possível consultar os dados, tente novamente!");
		} finally {
			close(pstm);
		}
		return retorno;
	}

	public List<Object> resultList(String sql, Object... params) {
		List<Object> lista = new ArrayList<Object>();
		PreparedStatement pstm = null;
		ResultSet result = null;
		try {
			pstm = logicaConexao(sql, params);
			result = pstm.executeQuery();
			while (result.next()) {
				lista.add(trataResultSet(result));
			}
		} catch (SQLException e) {
			System.out
					.println("Não foi possível consultar os dados, tente novamente!");
		} finally {
			close(pstm, result);
		}
		return lista;
	}

	public PreparedStatement logicaConexao(String sql, Object... params)
			throws SQLException {
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement pstm = connection.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			pstm.setObject(i + 1, params[i]);
		}
		return pstm;
	}

	private void close(PreparedStatement pstm, ResultSet resultSet) {
		this.close(resultSet);
		this.close(pstm);
	}

	private void close(PreparedStatement pstm) {
		try {
			if (pstm != null && pstm.getConnection() != null
					&& !pstm.getConnection().isClosed()) {
				pstm.getConnection().close();
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível fechar a conexão");
		} finally {
			try {
				if (pstm != null && !pstm.isClosed()) {
					pstm.close();
				}
			} catch (SQLException e) {
				System.out
						.println("Não foi possível fechar o preparedStatement");
			}
		}
	}

	private void close(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível fechar o resultset");
		}

	}

	public abstract Object trataResultSet(ResultSet result) throws SQLException;

}
