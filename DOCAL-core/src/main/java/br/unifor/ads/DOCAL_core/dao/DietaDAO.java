package br.unifor.ads.DOCAL_core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.unifor.ads.DOCAL_core.entity.Dieta;

public class DietaDAO {

	private UsuarioDAO userDAO;

	public DietaDAO() {
		userDAO = new UsuarioDAO();
	}

	private EntityManager em = new EntityManager() {
		@Override
		public Object trataResultSet(ResultSet result) throws SQLException {
			Dieta dieta = new Dieta();
			dieta.setId(result.getInt("id"));
			dieta.setNome(result.getString("nome"));
			dieta.setCarboidratos(result.getFloat("carboidratos"));
			dieta.setProteinas(result.getFloat("proteinas"));
			dieta.setGorduras(result.getFloat("gorduras"));
			dieta.setUsuario_id(userDAO.findById(result.getInt("id")));
			return dieta;
		}
	};

	public void inserir(Dieta dieta) {
		String sql = "insert into dieta (usuario_id, nome, carboidratos, proteinas, gorduras) values (?, ?, ?, ?, ?)";
		em.execute(sql, dieta.getUsuario_id().getId(), dieta.getNome(),
				dieta.getCarboidratos(), dieta.getProteinas(),
				dieta.getGorduras());
	}

	public Dieta buscarPorNome(String nome) {
		String sql = "select id, nome, usuario_id, carboidratos, proteinas, gorduras from dieta where nome = ?";
		return (Dieta) em.getSingleResult(sql, nome);
	}

	public Dieta findByUsuarioId(Integer usuarioId) {
		String sql = "select id, nome, usuario_id, carboidratos, proteinas, gorduras from dieta where usuario_id = ?";
		return (Dieta) em.getSingleResult(sql, usuarioId);
	}

	public List<Object> buscarTodos() {
		String sql = "select id, nome, usuario_id, carboidratos, proteinas, gorduras from dieta";
		return em.resultList(sql);
	}

	public void excluir(Dieta dieta) {
		String sql = "delete from dieta where id = ?";
		em.execute(sql, dieta.getId());

	}
}
