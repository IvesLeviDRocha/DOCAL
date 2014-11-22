package br.unifor.ads.DOCAL_core.business;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unifor.ads.DOCAL_core.dao.RefeicaoDAO;
import br.unifor.ads.DOCAL_core.dao.UsuarioDAO;
import br.unifor.ads.DOCAL_core.entity.Refeicao;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class BusinessCadastroRefeicaoTest {
	
	private static BusinessCadastroRefeicao business;
	private static Refeicao testRef;
	private static RefeicaoDAO refDao;
	private static Usuario testUser;
	private static UsuarioDAO userDao;
	private static LoggedUserManager userManager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		business = new BusinessCadastroRefeicao();
		refDao = new RefeicaoDAO();
		userDao = new UsuarioDAO();
		userManager = new LoggedUserManager();
		testUser = new Usuario("testUserJoao", "joao123", "joao321", 1.70f, 53f);
		userDao.inserir(testUser);
		testUser = userDao.findByLogin(testUser.getLogin());
		testRef = new Refeicao(testUser, "testRef", 100f, 50f, 10f);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDao.excluir(testUser);
		refDao = null;
		userDao = null;
		testRef = null;
		testUser = null;
		userManager = null;
		business = null;
	}

	@Test
	public void testGetLoggedUser() {
		userManager.logUser(testUser.getLogin(), testUser.getSenha());
		assertNotNull(business.getLoggedUser());
		userManager.logOut();
	}

	@Test
	public void testRegisterRefeicao() {
		business.registerRefeicao(testRef);
		testRef = refDao.buscarPorNome(testRef.getNome());
		assertNotNull(testRef);
		refDao.excluir(testRef);
	}

}
