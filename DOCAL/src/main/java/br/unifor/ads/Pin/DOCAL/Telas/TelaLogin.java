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
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import br.unifor.ads.Pin.DOCAL.Manager.ManagerLogin;
import java.awt.Color;

/**
 * Esta classe e responsavel por manter os componentes relativos ao login do
 * usuario.
 */
public class TelaLogin extends JPanel {

	private static final long serialVersionUID = -3409430088264915369L;

	private ManagerLogin manager;

	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblLogin;
	private JLabel lblCadastro;
	private JLabel background;
	private JTextField textFieldUsuario;
	private JPasswordField passwordFieldSenha;
	private JButton btnEntrar;
	private JButton btnSair;

	public TelaLogin(ManagerLogin manager) {
		this.manager = manager;
		initializeLayout();
		initializeLabels();
		initalizeFields();
		initalizeButtons();
		initalizeBackground();
	}

	public void initializeLayout() {
		setLookAndFeelToNimbus();
		setPreferredSize(new Dimension(486, 406));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	public void setLookAndFeelToNimbus() {
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

	public void initializeLabels() {
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblUsuario.setBounds(192, 86, 89, 41);
		add(lblUsuario);

		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblSenha.setBounds(193, 171, 75, 41);
		add(lblSenha);

		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
		lblLogin.setBounds(180, 11, 102, 64);
		add(lblLogin);

		lblCadastro = new JLabel("Cadastre-se aqui!");
		lblCadastro.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		lblCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblCadastrarPressionado();
			}
		});
		lblCadastro.setBounds(101, 256, 131, 22);
		lblCadastro.setForeground(Color.BLUE);
		add(lblCadastro);

	}

	public void initalizeFields() {
		textFieldUsuario = new JTextField();
		textFieldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsuario.setFont(new Font("Microsoft Sans Serif", Font.PLAIN,
				16));
		textFieldUsuario.setBounds(101, 125, 273, 35);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldSenha.setFont(new Font("Microsoft Sans Serif", Font.PLAIN,
				16));
		passwordFieldSenha.setBounds(101, 209, 273, 35);
		add(passwordFieldSenha);
	}

	public void initalizeButtons() {
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(java.awt.Color.LIGHT_GRAY);
		btnEntrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEntrarPressionado();
			}

		});
		btnEntrar.setBounds(247, 305, 120, 48);
		add(btnEntrar);

		btnSair = new JButton("Sair");
		btnSair.setBackground(java.awt.Color.LIGHT_GRAY);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSairPressionado();
			}
		});
		btnSair.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnSair.setBounds(100, 305, 120, 48);
		add(btnSair);
	}

	public void initalizeBackground() {
		setBackground(java.awt.Color.WHITE);
		background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagens = new ImageIcon(
				TelaAdicionarRefeicao.class
						.getResource("/br/unifor/ads/Pin/DOCAL/Imagem/plano de fundo.png"));
		Image imagem = imagens.getImage().getScaledInstance(486, 406,
				Image.SCALE_SMOOTH);
		background.setIcon(new ImageIcon(imagem));
		background.setBounds(0, 0, 486, 406);
		add(background);
	}

	public void btnEntrarPressionado() {
		String login = textFieldUsuario.getText();
		String senha = new String(passwordFieldSenha.getPassword());
		manager.btnEntrarPressionado(login, senha);
	}

	public void lblCadastrarPressionado() {
		manager.lblCadastrarPressionado();
	}

	public void btnSairPressionado() {
		manager.btnSairPressionado();
	}

	public void clearFields() {
		textFieldUsuario.setText("");
		passwordFieldSenha.setText("");
	}

}
