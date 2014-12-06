package br.unifor.ads.DOCAL_core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.unifor.ads.DOCAL_core.entity.Refeicao;

public class RefeicaoDAO {

	private UsuarioDAO userDAO;

	public RefeicaoDAO() {
		userDAO = new UsuarioDAO();
	}

	private EntityManager<Refeicao> em = new EntityManager<Refeicao>() {
		@Override
		public Refeicao trataResultSet(ResultSet result) throws SQLException {
			Refeicao refeicao = new Refeicao();
			refeicao.setId(result.getInt("id"));
			refeicao.setNome(result.getString("nome"));
			refeicao.setCarboidratos(result.getFloat("carboidratos"));
			refeicao.setProteinas(result.getFloat("proteinas"));
			refeicao.setGorduras(result.getFloat("gorduras"));
			refeicao.setUsuario_id(userDAO.findById(result.getInt("usuario_id")));
			return refeicao;
		}
	};

	public void inserir(Refeicao refeicao) {
		String sql = "insert into refeicao (usuario_id, nome, carboidratos, proteinas, gorduras) values (?, ?, ?, ?, ?)";
		em.execute(sql, refeicao.getUsuario_id().getId(), refeicao.getNome(),
				refeicao.getCarboidratos(), refeicao.getProteinas(),
				refeicao.getGorduras());
	}

	public Refeicao buscarPorNome(String nome) {
		String sql = "select id, nome, usuario_id, carboidratos, proteinas, gorduras from refeicao where nome = ?";
		return (Refeicao) em.getSingleResult(sql, nome);
	}

	public List<Refeicao> findByUserId(Integer usuario_id) {
		String sql = "select id, nome, usuario_id, carboidratos, proteinas, gorduras from refeicao where usuario_id = ?";
		return em.resultList(sql, usuario_id);
	}

	public List<Refeicao> buscarTodos() {
		String sql = "select id, nome, usuario_id, carboidratos, proteinas, gorduras from refeicao";
		return em.resultList(sql);
	}

	public void excluir(Refeicao refeicao) {
		String sql = "delete from refeicao where id = ?";
		em.execute(sql, refeicao.getId());
	}
}
