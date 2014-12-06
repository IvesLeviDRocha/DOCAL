package br.unifor.ads.DOCAL_core.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class DietaDAOTest {
	
	private static Dieta testDiet;
	private static Usuario testUser;
	private static DietaDAO dietDao;
	private static UsuarioDAO userDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testUser = new Usuario("testUserJoao", "joao123", "joao321", 1.70f, 53f);
		userDao = new UsuarioDAO();
		userDao.inserir(testUser);
		testUser = userDao.findByLogin(testUser.getLogin());
		testDiet = new Dieta(testUser, "testDiet", 100f, 50f, 10f);
		dietDao = new DietaDAO();
		dietDao.inserir(testDiet);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dietDao.excluir(testDiet);
		userDao.excluir(testUser);
		testDiet = null;
		testUser = null;
		dietDao = null;
		userDao = null;
	}

	@Before
	public void setUp() throws Exception {
		testDiet = dietDao.findByUsuarioId(testUser.getId());
	}

	@Test
	public void testInserir() {
		dietDao.excluir(testDiet);
		dietDao.inserir(testDiet);
		testDiet = dietDao.findByUsuarioId(testUser.getId());
		assertNotNull(testDiet);
	}

	@Test
	public void testBuscarPorNome() {
		assertNotNull(dietDao.buscarPorNome(testDiet.getNome()));
	}

	@Test
	public void testFindByUsuarioId() {
		assertNotNull(dietDao.findByUsuarioId(testUser.getId()));
	}

	@Test
	public void testBuscarTodos() {
		Dieta testDiet2 = new Dieta(testUser, "testDiet2", 200f, 120f, 33f);
		dietDao.inserir(testDiet2);
		testDiet2 = dietDao.buscarPorNome("testDiet2");
		List<Dieta> list = dietDao.buscarTodos();
		int expectedMinimumSize = 2;
		int actualSize = list.size();
		assertTrue("Not enough registered diets!", actualSize >= expectedMinimumSize);
		dietDao.excluir(testDiet2);
	}

	@Test
	public void testExcluir() {
		dietDao.excluir(testDiet);
		Dieta expectedNullDiet = dietDao.findByUsuarioId(testUser.getId());
		assertNull(expectedNullDiet);
		dietDao.inserir(testDiet);
	}

}
