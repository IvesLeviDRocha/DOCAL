package br.unifor.ads.DOCAL_core.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unifor.ads.DOCAL_core.entity.Usuario;

public class UsuarioDAOTest {
	
	private static Usuario testUser;
	private static UsuarioDAO userDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testUser = new Usuario("testUserJoao", "joao123", "joao321", 1.70f, 53f);
		userDao = new UsuarioDAO();
		userDao.inserir(testUser);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDao.excluir(testUser);
		testUser = null;
		userDao = null;
	}
	
	@Before
	public void setUp() throws Exception {
		testUser = userDao.findByLogin(testUser.getLogin());
	}
	
	@Test
	public void testInserir() {
		userDao.excluir(testUser);
		userDao.inserir(testUser);
		testUser = userDao.findByLogin(testUser.getLogin());
		assertNotNull(testUser);
	}

	@Test
	public void testBuscarPorNome() {
		assertNotNull(userDao.buscarPorNome(testUser.getNome()));
	}

	@Test
	public void testFindById() {
		assertNotNull(userDao.findById(testUser.getId()));
	}

	@Test
	public void testFindByLogin() {
		assertNotNull(userDao.findByLogin(testUser.getLogin()));
	}

	@Test
	public void testBuscarTodos() {
		Usuario testUser2 = new Usuario("testUserJose", "jose123", "jose321", 1.70f, 53f);
		userDao.inserir(testUser2);
		testUser2 = userDao.findByLogin(testUser2.getLogin());
		List<Object> list = userDao.buscarTodos();
		int expectedMinimumSize = 2;
		int actualSize = list.size();
		assertTrue("Not enough registered users!", actualSize >= expectedMinimumSize);
		userDao.excluir(testUser2);
	}

	@Test
	public void testExcluir() {
		userDao.excluir(testUser);
		Usuario expectedNullUser = userDao.findByLogin(testUser.getLogin());
		assertNull("User was not deleted!", expectedNullUser);
		userDao.inserir(testUser);
	}

	@Test
	public void testUpdateAlturaAndPeso() {
		Float newAltura = 1.71f;
		Float newPeso = 54f;
		userDao.updateAlturaAndPeso(testUser, newAltura, newPeso);
		testUser = userDao.findByLogin(testUser.getLogin());
		assertEquals("New altura did not match!", newAltura, testUser.getAltura());
		assertEquals("New peso did not match!", newPeso, testUser.getPeso());
	}

}
