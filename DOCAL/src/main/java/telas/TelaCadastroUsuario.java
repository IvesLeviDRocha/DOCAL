package telas;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;



import java.awt.Dimension;

import javax.swing.border.EmptyBorder;



import managers.ManagerCadastroUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Esta classe e responsavel por manter os componentes relativos ao cadastro do
 * usuario.
 */
public class TelaCadastroUsuario extends JPanel {

	private static final long serialVersionUID = -5136790803161914286L;

	private ManagerCadastroUsuario manager;

	private JTextField textFieldNome;
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldSenha;
	private JPasswordField passwordFieldConfSenha;
	private JTextField textFieldPeso;
	private JTextField textFieldAltura;

	/**
	 * Cria a tela.
	 * @param managerCadastroUsuario responsavel por esta tela.
	 */

	public TelaCadastroUsuario(ManagerCadastroUsuario manager) {

		this.manager = manager;

		setPreferredSize(new Dimension(320, 480));

		setLayout(null);

		
		
		setBorder(new EmptyBorder(5, 5, 5, 5));


		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblNome.setBounds(20, 80, 49, 14);
		add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldNome.setBounds(64, 75, 227, 28);
		textFieldNome.setColumns(10);
		add(textFieldNome);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblLogin.setBounds(41, 150, 39, 17);
		add(lblLogin);

		textFieldLogin = new JTextField();
		textFieldLogin
				.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldLogin.setBounds(83, 144, 165, 28);
		add(textFieldLogin);
		textFieldLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblSenha.setBounds(31, 193, 49, 14);
		add(lblSenha);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setFont(new Font("SansSerif", Font.PLAIN, 14));
		passwordFieldSenha.setBounds(83, 185, 165, 28);
		add(passwordFieldSenha);

		passwordFieldConfSenha = new JPasswordField();
		passwordFieldConfSenha.setFont(new Font("SansSerif", Font.PLAIN, 14));
		passwordFieldConfSenha.setBounds(83, 225, 165, 28);
		add(passwordFieldConfSenha);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarPressionado();
			}
		});
		btnCadastrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCadastrar.setBounds(111, 279, 114, 38);
		add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLimpar.setBounds(111, 342, 114, 38);
		add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarPressionado();
			}
		});
		btnCancelar.setBounds(111, 403, 114, 38);
		add(btnCancelar);

		JLabel lblConfirmeSenha = new JLabel("<html>Confirme<br/> senha:</html>");
		lblConfirmeSenha.setFont(new Font("Microsoft Sans Serif", Font.PLAIN,
				14));
		lblConfirmeSenha.setBounds(19, 225, 61, 28);
		add(lblConfirmeSenha);

		JLabel lblCadastroDeUsuario = new JLabel("Cadastro de Usuario");
		lblCadastroDeUsuario.setFont(new Font("Microsoft Sans Serif",
				Font.PLAIN, 22));
		lblCadastroDeUsuario.setBounds(69, 0, 207, 56);
		add(lblCadastroDeUsuario);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblPeso.setBounds(160, 115, 39, 17);
		add(lblPeso);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldPeso.setBounds(199, 108, 49, 28);
		add(textFieldPeso);
		textFieldPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblAltura.setBounds(41, 115, 50, 17);
		add(lblAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(83, 109, 52, 28);
		add(textFieldAltura);

	}

	/**
	 * Delega a operacao adequada do botao Cancelar ao manager.
	 */
	public void btnCancelarPressionado() {
		manager.btnCancelarPressionado();
	}
	
	/**
	 * Delega a operacao adequada do botao Cadastrar ao manager.
	 */
	public void btnCadastrarPressionado() {
		manager.btnCadastrarPressionado();
	}
}
