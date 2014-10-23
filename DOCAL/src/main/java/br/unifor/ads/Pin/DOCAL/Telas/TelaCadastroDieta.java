package br.unifor.ads.Pin.DOCAL.Telas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.unifor.ads.Pin.DOCAL.Manager.ManagerCadastroDieta;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * Esta classe e responsavel por manter os componentes relativos ao cadastro
 * da dieta.
 */
public class TelaCadastroDieta extends JPanel {

	private static final long serialVersionUID = 3919730245101788170L;
	
	private ManagerCadastroDieta manager;
	
	private JTextField textFieldNome;
	private JFormattedTextField formattedTextFieldCarb;
	private JFormattedTextField formattedTextFieldProt;
	private JFormattedTextField formattedTextFieldGord;

	/**
	 * Cria a tela.
	 * @param managerCadastroDieta responsavel por esta tela.
	 */
	public TelaCadastroDieta(ManagerCadastroDieta manager) {
		setBackground(Color.WHITE);
		
		this.manager = manager;
		
		//Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(540, 470));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblCadastroDeDieta = new JLabel("Cadastro de Dieta",SwingConstants.CENTER);
		lblCadastroDeDieta.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblCadastroDeDieta.setBounds(165, 22, 199, 33);
		add(lblCadastroDeDieta);
		ImageIcon imagens = new ImageIcon(TelaAdicionarRefeicao.class.getResource("/br/unifor/ads/Pin/DietOC/Imagem/plano de fundo.png"));
		Image imagem = imagens.getImage().getScaledInstance(540, 470, Image.SCALE_SMOOTH);
		
		JLabel lblNome = new JLabel("<html><B>Nome da dieta</B></html>",SwingConstants.CENTER);
		lblNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblNome.setBounds(201, 94, 118, 14);
		add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldNome.setBounds(143, 126, 244, 33);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblQuantidadeDeCarboidratos = new JLabel("<html><B>Carboidratos:</B></html>");
		lblQuantidadeDeCarboidratos.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblQuantidadeDeCarboidratos.setBounds(0, 235, 107, 14);
		add(lblQuantidadeDeCarboidratos);
		
		formattedTextFieldCarb = new JFormattedTextField();
		formattedTextFieldCarb.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		formattedTextFieldCarb.setBounds(117, 228, 60, 29);
		add(formattedTextFieldCarb);
		
		JLabel lblQuantidadeDeProteinas = new JLabel("<html><B>Proteinas:</B></html>");
		lblQuantidadeDeProteinas.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblQuantidadeDeProteinas.setBounds(189, 235, 82, 14);
		add(lblQuantidadeDeProteinas);
		
		formattedTextFieldProt = new JFormattedTextField();
		formattedTextFieldProt.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		formattedTextFieldProt.setBounds(281, 228, 60, 29);
		add(formattedTextFieldProt);
		
		JLabel lblQuantidadeDeGorduras = new JLabel("<html><B>Gorduras:</B></html>");
		lblQuantidadeDeGorduras.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblQuantidadeDeGorduras.setBounds(356, 235, 82, 14);
		add(lblQuantidadeDeGorduras);
		
		formattedTextFieldGord = new JFormattedTextField();
		formattedTextFieldGord.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		formattedTextFieldGord.setBounds(442, 228, 60, 29);
		add(formattedTextFieldGord);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarPressionado();
			}
		});
		btnCadastrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCadastrar.setBounds(84, 378, 111, 39);
		add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarPressionado();
			}
		});
		btnCancelar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCancelar.setBounds(343, 378, 111, 39);
		add(btnCancelar);
		
		JLabel foto = new JLabel("");
		foto.setHorizontalAlignment(SwingConstants.CENTER);
		foto.setIcon(new ImageIcon(imagem));
		foto.setBounds(0, 0, 540, 470);
		add(foto);

	}
	
	/**
	 * Delega a operacao adequada do botao Cadastrar ao manager.
	 */
	public void btnCadastrarPressionado() {
		manager.btnCadastrarPressionado();
	}
	
	/**
	 * Delega a operacao adequada do botao Cancelar ao manager.
	 */
	public void btnCancelarPressionado() {
		manager.btnCancelarPressionado();
	}
	
	/**
	 * Limpa texto dos formularios.
	 */
	public void limparFormularios() {
		textFieldNome.setText("");
		formattedTextFieldCarb.setText("");
		formattedTextFieldProt.setText("");
		formattedTextFieldGord.setText("");
	}
	
}
