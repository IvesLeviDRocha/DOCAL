package br.unifor.ads.DOCAL_core.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unifor.ads.DOCAL_core.entity.Refeicao;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class RefeicaoDAOTest {
	
	private static Refeicao testRef;
	private static Usuario testUser;
	private static RefeicaoDAO refDao;
	private static UsuarioDAO userDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testUser = new Usuario("testUserJoao", "joao123", "joao321", 1.70f, 53f);
		userDao = new UsuarioDAO();
		userDao.inserir(testUser);
		testUser = userDao.findByLogin(testUser.getLogin());
		testRef = new Refeicao(testUser, "testRef", 100f, 50f, 10f);
		refDao = new RefeicaoDAO();
		refDao.inserir(testRef);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		refDao.excluir(testRef);
		userDao.excluir(testUser);
		testUser = null;
		testRef = null;
		userDao = null;
		refDao = null;
	}

	@Before
	public void setUp() throws Exception {
		testRef = refDao.buscarPorNome(testRef.getNome());
	}

	@Test
	public void testInserir() {
		refDao.excluir(testRef);
		refDao.inserir(testRef);
		testRef = refDao.buscarPorNome(testRef.getNome());
		assertNotNull(testRef);
	}

	@Test
	public void testBuscarPorNome() {
		assertNotNull(refDao.buscarPorNome(testRef.getNome()));
	}

	@Test
	public void testFindByUserId() {
		List<Refeicao> list = refDao.findByUserId(testUser.getId());
		assertTrue(list.size()>0);
	}

	@Test
	public void testBuscarTodos() {
		List<Refeicao> list = refDao.buscarTodos();
		assertTrue(list.size()>0);
	}

	@Test
	public void testExcluir() {
		refDao.excluir(testRef);
		Refeicao expectedNullRef = refDao.buscarPorNome(testRef.getNome());
		assertNull(expectedNullRef);
		refDao.inserir(testRef);
	}

}
