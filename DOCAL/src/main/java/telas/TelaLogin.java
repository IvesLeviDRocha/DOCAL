package telas;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import managers.ManagerLogin;

/**
 * Esta classe e responsavel por manter os componentes relativos ao login do
 * usuario.
 */
public class TelaLogin extends JPanel {

	private static final long serialVersionUID = -3409430088264915369L;

	private ManagerLogin manager;

	private JTextField textFieldUsuario;
	private JPasswordField passwordFieldSenha;

	/**
	 * Cria a tela.
	 * @param o ManagerLogin responsavel por gerenciar a tela.
	 */
	public TelaLogin(ManagerLogin manager) {

		// Designa o manager recebido como proprio.
		this.manager = manager;
		
		//Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(320, 480));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		// Label de usuário
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		lblUsuario.setBounds(31, 103, 89, 41);
		add(lblUsuario);

		// text field de usuário
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Microsoft Sans Serif", Font.PLAIN,
				16));
		textFieldUsuario.setBounds(130, 109, 149, 35);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		// label de senha
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		lblSenha.setBounds(41, 174, 75, 41);
		add(lblSenha);

		// textfield de senha
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setFont(new Font("Microsoft Sans Serif", Font.PLAIN,
				16));
		passwordFieldSenha.setBounds(130, 180, 149, 35);
		add(passwordFieldSenha);

		// botao entrar
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEntrarPressionado();
			}

		});
		btnEntrar.setBounds(100, 259, 127, 48);
		add(btnEntrar);

		// Label login (titulo da tela)
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 32));
		lblLogin.setBounds(112, 11, 102, 64);
		add(lblLogin);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarPressionado();
			}
		});
		btnCadastrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		btnCadastrar.setBounds(84, 355, 157, 48);
		add(btnCadastrar);
	}

	/**
	 * Delega a operacao adequada do botao Entrar ao manager.
	 */
	public void btnEntrarPressionado() {
		manager.btnEntrarPressionado();
	}
	
	/**
	 * Delega a operacao adequada do botao Cadastrar ao manager.
	 */
	public void btnCadastrarPressionado() {
		manager.btnCadastrarPressionado();
	}

}
