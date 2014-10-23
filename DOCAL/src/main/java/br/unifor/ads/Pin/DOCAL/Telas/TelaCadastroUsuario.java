package br.unifor.ads.Pin.DOCAL.Telas;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;






import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.border.EmptyBorder;




import javax.swing.text.MaskFormatter;

import br.unifor.ads.Pin.DOCAL.Manager.ManagerCadastroUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

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
	private JFormattedTextField textFieldAltura;

	/**
	 * Cria a tela.
	 * @param managerCadastroUsuario responsavel por esta tela.
	 */

	public TelaCadastroUsuario(ManagerCadastroUsuario manager) {
		setBackground(Color.WHITE);
		this.manager = manager;

		setPreferredSize(new Dimension(580, 479));

		setLayout(null);

		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		/*Criação da label do titulo da tela**/
		JLabel lblCadastroDeUsuario = new JLabel("Cadastro de Usuario");
		lblCadastroDeUsuario.setFont(new Font("Microsoft Sans Serif",Font.PLAIN, 22));
		lblCadastroDeUsuario.setBounds(187, 8, 207, 56);
		add(lblCadastroDeUsuario);

		/*Criação da label do nome e o textFild do nome**/
		JLabel lblNome = new JLabel("<html><B>Nome:</B></html>");
		lblNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblNome.setBounds(61, 122, 49, 14);
		add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldNome.setBounds(120, 115, 214, 28);
		textFieldNome.setColumns(10);
		add(textFieldNome);
		
		/*Criação da label do login e o textFild do Login**/
		JLabel lblLogin = new JLabel("<html><B>Login:</B></html>");
		lblLogin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblLogin.setBounds(61, 179, 39, 17);
		add(lblLogin);

		textFieldLogin = new JTextField();
		textFieldLogin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldLogin.setBounds(120, 173, 214, 28);
		textFieldLogin.setColumns(10);
		add(textFieldLogin);
		
		/*Criação da label do senha e o passwordFild do Senha**/
		JLabel lblSenha = new JLabel("<html><B>Senha:</B></html>");
		lblSenha.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblSenha.setBounds(51, 229, 49, 14);
		add(lblSenha);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setFont(new Font("SansSerif", Font.PLAIN, 14));
		passwordFieldSenha.setBounds(120, 222, 214, 28);
		add(passwordFieldSenha);
		
		/*Criação da label do confirmaSenha e o passwordFild do ConfimaSenha**/
		JLabel lblConfirmeSenha = new JLabel("<html><B>Confirme<br/> senha:</B></html>");
		lblConfirmeSenha.setFont(new Font("Microsoft Sans Serif", Font.PLAIN,14));
		lblConfirmeSenha.setBounds(19, 283, 81, 28);
		add(lblConfirmeSenha);
		
		passwordFieldConfSenha = new JPasswordField();
		passwordFieldConfSenha.setFont(new Font("SansSerif", Font.PLAIN, 14));
		passwordFieldConfSenha.setBounds(120, 275, 214, 28);
		add(passwordFieldConfSenha);
		
		/*Criação da label do peso e o textFild do Peso**/
		JLabel lblPeso = new JLabel("<html><B>Peso:</B></html>");
		lblPeso.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblPeso.setBounds(472, 121, 39, 17);
		add(lblPeso);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldPeso.setBounds(521, 115, 49, 28);
		textFieldPeso.setColumns(10);
		add(textFieldPeso);
		
		/*Criação da label do altura e o textFild do Altura**/
		JLabel lblAltura = new JLabel("<html><B>Altura:</B></html>");
		lblAltura.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblAltura.setBounds(344, 121, 50, 17);
		add(lblAltura);
		
		try {
			MaskFormatter altura = new MaskFormatter("#.###");
			textFieldAltura = new JFormattedTextField(altura);
			textFieldAltura.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
			textFieldAltura.setColumns(10);
			textFieldAltura.setBounds(410, 115, 52, 28);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Altura invalida!");
		}
		add(textFieldAltura);
		
		/*Criação button de Cadastrar**/
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarPressionado();
			}
		});
		btnCadastrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCadastrar.setBounds(51, 365, 114, 38);
		add(btnCadastrar);
		
		/*Criação button de Limpa**/
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLimparPressionado();
			}
		});
		btnLimpar.setBounds(224, 365, 114, 38);
		add(btnLimpar);
		
		/*Criação button de Cancela**/
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarPressionado();
			}
		});
		btnCancelar.setBounds(392, 365, 114, 38);
		add(btnCancelar);
		
		JLabel foto = new JLabel("");
		foto.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagens = new ImageIcon(TelaAdicionarRefeicao.class.getResource("/br/unifor/ads/Pin/DOCAL/Imagem/plano de fundo.png"));
		Image imagem = imagens.getImage().getScaledInstance(540, 470, Image.SCALE_SMOOTH);
		foto.setIcon(new ImageIcon(imagem));
		foto.setBounds(0, 0, 540, 470);
		add(foto);
		
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
	
	/**
	 * Delega a operacao adequada do botao Limpar ao manager.
	 */
	public void btnLimparPressionado() {
		manager.btnLimparPressionado();
	}
	
	/**
	 * Limpa texto dos formularios.
	 */
	public void limparFormularios() {
		textFieldAltura.setText("");
		textFieldPeso.setText("");
		textFieldNome.setText("");
		textFieldLogin.setText("");
		passwordFieldConfSenha.setText("");
		passwordFieldSenha.setText("");
	}
	
}
