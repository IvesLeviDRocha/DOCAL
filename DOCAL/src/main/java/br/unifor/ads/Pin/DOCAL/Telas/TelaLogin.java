package br.unifor.ads.Pin.DOCAL.Telas;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.unifor.ads.Pin.DOCAL.Manager.ManagerLogin;

/**
 * Esta classe e responsavel por manter os componentes relativos ao login do
 * usuario.
 */
public class TelaLogin extends JPanel {

	private static final long serialVersionUID = -3409430088264915369L;

	private ManagerLogin manager;

	private JTextField textFieldUsuario;
	private JPasswordField passwordFieldSenha;

	public TelaLogin(ManagerLogin manager) {
		setBackground(java.awt.Color.WHITE);

		// Designa o manager recebido como proprio.
		this.manager = manager;

		// Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(486, 406));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		// Label de usuário
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblUsuario.setBounds(192, 86, 89, 41);
		add(lblUsuario);

		// text field de usuário
		textFieldUsuario = new JTextField();
		textFieldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsuario.setFont(new Font("Microsoft Sans Serif", Font.PLAIN,
				16));
		textFieldUsuario.setBounds(101, 125, 273, 35);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		// label de senha
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblSenha.setBounds(193, 171, 75, 41);
		add(lblSenha);

		// textfield de senha
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldSenha.setFont(new Font("Microsoft Sans Serif", Font.PLAIN,
				16));
		passwordFieldSenha.setBounds(101, 209, 273, 35);
		add(passwordFieldSenha);

		// botao entrar
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(java.awt.Color.LIGHT_GRAY);
		btnEntrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEntrarPressionado();
			}

		});
		btnEntrar.setBounds(101, 305, 127, 48);
		add(btnEntrar);

		// Label login (titulo da tela)
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
		lblLogin.setBounds(180, 11, 102, 64);
		add(lblLogin);

		JLabel lblCadastreseAqui = new JLabel(
				"<html><B>Cadastre-se aqui!</B></html>");
		lblCadastreseAqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblCadastrarPressionado();
			}
		});
		lblCadastreseAqui.setBounds(101, 256, 114, 14);
		lblCadastreseAqui.setForeground(java.awt.Color.RED);
		add(lblCadastreseAqui);

		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(java.awt.Color.LIGHT_GRAY);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSairPressionado();
			}
		});
		btnSair.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnSair.setBounds(260, 305, 114, 48);
		add(btnSair);

		JLabel foto = new JLabel("");
		foto.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagens = new ImageIcon(
				TelaAdicionarRefeicao.class
						.getResource("/br/unifor/ads/Pin/DOCAL/Imagem/plano de fundo.png"));
		Image imagem = imagens.getImage().getScaledInstance(486, 406,
				Image.SCALE_SMOOTH);
		foto.setIcon(new ImageIcon(imagem));
		foto.setBounds(0, 0, 486, 406);
		add(foto);
	}

	public void btnEntrarPressionado() {
		manager.btnEntrarPressionado();
	}

	public void lblCadastrarPressionado() {
		manager.lblCadastrarPressionado();
	}

	public void btnSairPressionado() {
		manager.btnSairPressionado();
	}

	public void limparFormularios() {
		textFieldUsuario.setText("");
		passwordFieldSenha.setText("");
	}
}
