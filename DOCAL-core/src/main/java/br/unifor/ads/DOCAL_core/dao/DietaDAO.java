package br.unifor.ads.DOCAL_core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.unifor.ads.DOCAL_core.dao.EntityManager;
import br.unifor.ads.DOCAL_core.entity.Dieta;

public class DietaDAO {

	private EntityManager em = new EntityManager() {
		@Override
		public Object trataResultSet(ResultSet result) throws SQLException {
			Dieta dieta = null;
			if (result.next()) {
				dieta = new Dieta();
				dieta.setId(result.getInt("id"));
				dieta.setNome(result.getString("nome"));
				dieta.setCarboidratos(result.getFloat("carboidratos"));
				dieta.setProteinas(result.getFloat("proteinas"));
				dieta.setGorduras(result.getFloat("gorduras"));
				dieta.setCalorias(result.getFloat("calorias"));
			}
			return dieta;
		}
	};

	public void inserir(Dieta dieta) {

		String sql = "insert into dieta (nome, carboidratos, proteinas, gorduras, calorias) values (?, ?, ?, ?, ?)";
		em.execute(sql, dieta.getNome(), dieta.getCarboidratos(),
				dieta.getProteinas(), dieta.getGorduras(), dieta.getCalorias());

	}

	public Dieta buscarPorNome(String nome) {

		String sql = "select id, nome, carboidratos, proteinas, gorduras, calorias from dieta where nome = ?";
		return (Dieta) em.getSingleResult(sql, nome);

	}

	public List<Object> buscarTodos() {
		String sql = "select id, nome, carboidratos, proteinas, gorduras, calorias from dieta";
		return em.resultList(sql);

	}

	public void excluir(Dieta dieta) {

		String sql = "delete from dieta where id = ?";
		em.execute(sql, dieta.getNome());
	}
}
