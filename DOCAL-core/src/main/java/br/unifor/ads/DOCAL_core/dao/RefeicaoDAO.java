package br.unifor.ads.DOCAL_core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.unifor.ads.DOCAL_core.dao.EntityManager;
import br.unifor.ads.DOCAL_core.entity.Refeicao;

public class RefeicaoDAO {

	private static EntityManager em = new EntityManager() {
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
				refeicao.setUsuario_id(UsuarioDAO.findById(result.getInt("id")));
			}
			return refeicao;
		}
	};

	public static void inserir(Refeicao refeicao) {
		String sql = "insert into refeicao (usuario_id, nome, carboidratos, proteinas, gorduras) values (?, ?, ?, ?, ?)";
		em.execute(sql, refeicao.getUsuario_id().getId(), refeicao.getNome(),
				refeicao.getCarboidratos(), refeicao.getProteinas(),
				refeicao.getGorduras());
	}

	public static Refeicao buscarPorNome(String nome) {
		String sql = "select id, nome, usuario_id, carboidratos, proteinas, gorduras from refeicao where nome = ?";
		return (Refeicao) em.getSingleResult(sql, nome);
	}

	public static List<Object> buscarTodos() {
		String sql = "select id, nome, usuario_id, carboidratos, proteinas, gorduras from refeicao";
		return em.resultList(sql);
	}

	public static void excluir(Refeicao refeicao) {
		String sql = "delete from refeicao where id = ?";
		em.execute(sql, refeicao.getId());
	}
}
