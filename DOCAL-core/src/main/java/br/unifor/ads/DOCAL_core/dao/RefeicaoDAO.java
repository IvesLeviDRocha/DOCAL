package br.unifor.ads.DOCAL_core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.unifor.ads.DOCAL_core.dao.EntityManager;
import br.unifor.ads.DOCAL_core.entity.Refeicao;

public class RefeicaoDAO {

	private EntityManager em = new EntityManager() {
		@Override
		public Object trataResultSet(ResultSet result) throws SQLException {
			Refeicao refeicao = null;
			if (result.next()) {
				refeicao = new Refeicao();
				refeicao.setId(result.getInt("id"));
				refeicao.setNome(result.getString("nome"));
				refeicao.setCarboidratos(result.getFloat("carboidratos"));
				refeicao.setProteinas(result.getFloat("proteinas"));
				refeicao.setGorduras(result.getFloat("gorduras"));
				refeicao.setCalorias(result.getFloat("calorias"));

			}
			return refeicao;
		}
	};

	public void inserir(Refeicao refeicao) {

		String sql = "insert into refeicao (nome, carboidratos, proteinas, gorduras, calorias) values (?, ?, ?, ?, ?)";
		em.execute(sql, refeicao.getNome(), refeicao.getCarboidratos(),
				refeicao.getProteinas(), refeicao.getGorduras(),
				refeicao.getCalorias());

	}

	public Refeicao buscarPorNome(String nome) {

		String sql = "select id, nome, carboidratos, proteinas, gorduras, calorias from refeicao where nome = ?";
		return (Refeicao) em.getSingleResult(sql, nome);

	}

	public List<Object> buscarTodos() {
		String sql = "select id, nome, carboidratos, proteinas, gorduras, calorias from refeicao";
		return em.resultList(sql);

	}

	public void excluir(Refeicao refeicao) {

		String sql = "delete from refeicao where id = ?";
		em.execute(sql, refeicao.getNome());
	}
}
