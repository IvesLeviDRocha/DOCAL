package br.unifor.ads.DOCAL_core.business;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unifor.ads.DOCAL_core.dao.RefeicaoDAO;
import br.unifor.ads.DOCAL_core.dao.UsuarioDAO;
import br.unifor.ads.DOCAL_core.entity.Refeicao;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class BusinessAdicionarRefeicaoTest {
	
	private static BusinessAdicionarRefeicao business;
	private static RefeicaoDAO refDao;
	private static UsuarioDAO userDao;
	private static Usuario testUser;
	private static Refeicao testRef1;
	private static Refeicao testRef2;
	private static Refeicao testRef3;
	private static LoggedUserManager userManager;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		business = new BusinessAdicionarRefeicao();
		refDao = new RefeicaoDAO();
		userDao = new UsuarioDAO();
		userManager = new LoggedUserManager();
		testUser = new Usuario("testUserJoao", "joao123", "joao321", 1.70f, 53f);
		userDao.inserir(testUser);
		testUser = userDao.findByLogin(testUser.getLogin());
		userManager.logUser(testUser.getLogin(), testUser.getSenha());
		testRef1 = new Refeicao(testUser, "testRef1", 111f, 11f, 1f);
		testRef2 = new Refeicao(testUser, "testRef2", 222f, 22f, 2f);
		testRef3 = new Refeicao(testUser, "testRef3", 333f, 33f, 3f);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDao.excluir(testUser);
		userManager.logOut();
		userManager = null;
		business = null;
		testUser = null;
		testRef1 = null;
		testRef2 = null;
		testRef3 = null;
		userDao = null;
		refDao = null;
	}

	@Test
	public void testGetRefeicaoData() {
		refDao.inserir(testRef1);
		testRef1 = refDao.buscarPorNome(testRef1.getNome());
		refDao.inserir(testRef2);
		testRef2 = refDao.buscarPorNome(testRef2.getNome());
		refDao.inserir(testRef3);
		testRef3 = refDao.buscarPorNome(testRef3.getNome());
		List<Refeicao> list = business.getRefeicaoData();
		assertTrue(list.size()>=3);
		refDao.excluir(testRef1);
		refDao.excluir(testRef2);
		refDao.excluir(testRef3);
	}

	@Test
	public void testRemoveRefeicao() {
		refDao.inserir(testRef1);
		testRef1 = refDao.buscarPorNome(testRef1.getNome());
		business.removeRefeicao(testRef1);
		Refeicao expectedNullRef = refDao.buscarPorNome(testRef1.getNome());
		assertNull(expectedNullRef);
	}

}
