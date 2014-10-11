package managers;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Esta classe tem como responsabilidade mostrar as telas da aplicacao.
 */
public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 3577900688565338673L;

	private ManagerLogin managerLogin;
	private ManagerHome managerHome;
	private ManagerCadastroUsuario managerCadUser;
	private ManagerCadastroDieta managerCadDieta;
	private ManagerCadastroRefeicao managerCadRef;
	private ManagerAdicionarRefeicao managerAddRef;

	/**
	 * Cria o frame.
	 */
	public FramePrincipal() {
		setTitle("DietOC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mudarLookAndFeel();
		inicializarManagers();
		setContentPane(managerLogin.getTela());
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	/**
	 * Instancia todos os managers.
	 */
	public void inicializarManagers() {
		managerLogin = new ManagerLogin(this);
		managerHome = new ManagerHome(this);
		managerCadUser = new ManagerCadastroUsuario(this);
		managerCadDieta = new ManagerCadastroDieta(this);
		managerCadRef = new ManagerCadastroRefeicao(this);
		managerAddRef = new ManagerAdicionarRefeicao(this);
	}

	/**
	 * Tenta mudar o look and feel para "Nimbus".
	 */
	public void mudarLookAndFeel() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exibe a tela TelaLogin no frame.
	 */
	public void mostrarLogin() {
		setContentPane(managerLogin.getTela());
		pack();
	}

	/**
	 * Exibe a tela TelaHome no frame.
	 */
	public void mostrarHome() {
		setContentPane(managerHome.getTela());
		pack();
	}

	/**
	 * Exibe a tela TelaCadastroUsuario no frame.
	 */
	public void mostrarCadastroUsuario() {
		setContentPane(managerCadUser.getTela());
		pack();
	}

	/**
	 * Exibe a tela TelaCadastroDieta no frame.
	 */
	public void mostrarCadastroDieta() {
		setContentPane(managerCadDieta.getTela());
		pack();
	}

	/**
	 * Exibe a tela TelaCadastroRefeicao no frame.
	 */
	public void mostrarCadastroRefeicao() {
		setContentPane(managerCadRef.getTela());
		pack();
	}

	/**
	 * Exibe a tela TelaAdicionarRefeicao no frame.
	 */
	public void mostrarAdicionarRefeicao() {
		setContentPane(managerAddRef.getTela());
		pack();
	}

}
