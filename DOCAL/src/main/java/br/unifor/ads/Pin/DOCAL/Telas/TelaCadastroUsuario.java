package br.unifor.ads.Pin.DOCAL.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.unifor.ads.Pin.DOCAL.Manager.ManagerCadastroUsuario;

/**
 * Esta classe e responsavel por manter os componentes relativos ao cadastro do
 * usuario.
 */
public class TelaCadastroUsuario extends JPanel {

	private static final long serialVersionUID = -5136790803161914286L;

	private ManagerCadastroUsuario manager;
	private PopUpper popUp;

	private JLabel lblCadastroDeUsuario;
	private JLabel lblNome;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JLabel lblConfirmeSenha;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel background;
	private JTextField textFieldNome;
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldSenha;
	private JPasswordField passwordFieldConfSenha;
	private JTextField textFieldPeso;
	private JFormattedTextField textFieldAltura;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnCancelar;

	public TelaCadastroUsuario(ManagerCadastroUsuario manager) {
		this.manager = manager;
		popUp = new PopUpper();
		initializeLayout();
		initializeLabels();
		initializeFields();
		initializeButtons();
		initializeBackground();
	}

	private void initializeLayout() {
		setPreferredSize(new Dimension(580, 479));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	private void initializeLabels() {
		lblCadastroDeUsuario = new JLabel("Cadastro de Usuario");
		lblCadastroDeUsuario.setFont(new Font("Microsoft Sans Serif",
				Font.PLAIN, 22));
		lblCadastroDeUsuario.setBounds(187, 8, 207, 56);
		add(lblCadastroDeUsuario);

		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNome.setBounds(70, 122, 49, 14);
		add(lblNome);

		lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblAltura.setBounds(353, 121, 50, 17);
		add(lblAltura);

		lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblLogin.setBounds(70, 179, 49, 17);
		add(lblLogin);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblSenha.setBounds(67, 229, 52, 14);
		add(lblSenha);

		lblConfirmeSenha = new JLabel("Confirme senha:");
		lblConfirmeSenha
				.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblConfirmeSenha.setBounds(0, 275, 120, 28);
		add(lblConfirmeSenha);

		lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblPeso.setBounds(359, 179, 41, 17);
		add(lblPeso);
	}

	private void initializeFields() {
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldNome.setBounds(129, 115, 214, 28);
		textFieldNome.setColumns(10);
		add(textFieldNome);

		textFieldLogin = new JTextField();
		textFieldLogin
				.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldLogin.setBounds(129, 173, 214, 28);
		textFieldLogin.setColumns(10);
		add(textFieldLogin);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setFont(new Font("SansSerif", Font.PLAIN, 14));
		passwordFieldSenha.setBounds(129, 222, 214, 28);
		add(passwordFieldSenha);

		passwordFieldConfSenha = new JPasswordField();
		passwordFieldConfSenha.setFont(new Font("SansSerif", Font.PLAIN, 14));
		passwordFieldConfSenha.setBounds(129, 275, 214, 28);
		add(passwordFieldConfSenha);

		textFieldPeso = new JTextField();
		textFieldPeso.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldPeso.setBounds(410, 173, 52, 28);
		textFieldPeso.setColumns(10);
		add(textFieldPeso);

		try {
			MaskFormatter altura = new MaskFormatter("#.##");
			textFieldAltura = new JFormattedTextField(altura);
			textFieldAltura.setFont(new Font("Microsoft Sans Serif",
					Font.PLAIN, 14));
			textFieldAltura.setColumns(10);
			textFieldAltura.setBounds(410, 115, 52, 28);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Altura invalida!");
		}
		add(textFieldAltura);
	}

	private void initializeButtons() {
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarPressionado();
			}
		});
		btnCadastrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCadastrar.setBounds(342, 365, 120, 40);
		add(btnCadastrar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLimparPressionado();
			}
		});
		btnLimpar.setBounds(192, 365, 120, 40);
		add(btnLimpar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarPressionado();
			}
		});
		btnCancelar.setBounds(38, 365, 120, 40);
		add(btnCancelar);
	}

	private void initializeBackground() {
		setBackground(Color.WHITE);
		background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagens = new ImageIcon(
				TelaAdicionarRefeicao.class
						.getResource("/br/unifor/ads/Pin/DOCAL/Imagem/plano de fundo.png"));
		Image imagem = imagens.getImage().getScaledInstance(540, 470,
				Image.SCALE_SMOOTH);
		background.setIcon(new ImageIcon(imagem));
		background.setBounds(0, 0, 540, 470);
		add(background);
	}

	public void btnCancelarPressionado() {
		manager.btnCancelarPressionado();
	}

	public void btnCadastrarPressionado() {
		if (checkFieldsNotEmpty()) {
			if (checkPasswordsMatch()) {
				manager.btnCadastrarPressionado(textFieldNome.getText(),
						textFieldLogin.getText(),
						new String(passwordFieldSenha.getPassword()),
						textFieldAltura.getText(), textFieldPeso.getText());
			} else {
				popUp.show("Confirmação de senha incorreta");
			}
		} else {
			popUp.show("Campo(s) em branco!");
		}
	}

	public void btnLimparPressionado() {
		manager.btnLimparPressionado();
	}

	public void limparFormularios() {
		textFieldAltura.setText("");
		textFieldPeso.setText("");
		textFieldNome.setText("");
		textFieldLogin.setText("");
		passwordFieldConfSenha.setText("");
		passwordFieldSenha.setText("");
	}

	public boolean checkFieldsNotEmpty() {
		if (textFieldLogin.getText().equals("")
				|| textFieldNome.getText().equals("")
				|| textFieldAltura.getText().equals("")
				|| textFieldPeso.getText().equals("")
				|| passwordFieldConfSenha.getPassword().length == 0
				|| passwordFieldSenha.getPassword().length == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkPasswordsMatch() {
		String pass = new String(passwordFieldSenha.getPassword());
		String pass2 = new String(passwordFieldConfSenha.getPassword());
		if (pass.equals(pass2)) {
			return true;
		} else {
			return false;
		}
	}

}
