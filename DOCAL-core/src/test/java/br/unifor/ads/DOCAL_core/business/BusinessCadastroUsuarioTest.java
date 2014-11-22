package br.unifor.ads.DOCAL_core.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unifor.ads.DOCAL_core.dao.UsuarioDAO;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class BusinessCadastroUsuarioTest {
	
	private static Usuario testUser;
	private static BusinessCadastroUsuario business; 
	private static UsuarioDAO userDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		business = new BusinessCadastroUsuario();
		testUser = new Usuario("testUserJoao", "joao123", "joao321", 1.70f, 53f);
		userDao = new UsuarioDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDao = null;
		testUser = null;
		business = null;
	}

	@Test
	public void testRegisterUsuario() {
		assertTrue(business.registerUsuario(testUser));
		testUser = userDao.findByLogin(testUser.getLogin());
		userDao.excluir(testUser);
	}
	
	@Test
	public void testRegisterAlreadyExistingUsuario() {
		userDao.inserir(testUser);
		testUser = userDao.findByLogin(testUser.getLogin());
		assertFalse(business.registerUsuario(testUser));
		userDao.excluir(testUser);
	}

}
