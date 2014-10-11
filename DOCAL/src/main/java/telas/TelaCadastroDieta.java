package telas;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import managers.ManagerCadastroDieta;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Esta classe e responsavel por manter os componentes relativos ao cadastro
 * da dieta.
 */
public class TelaCadastroDieta extends JPanel {

	private static final long serialVersionUID = 3919730245101788170L;
	
	private ManagerCadastroDieta manager;
	
	private JTextField textFieldNome;

	/**
	 * Cria a tela.
	 * @param managerCadastroDieta responsavel por esta tela.
	 */
	public TelaCadastroDieta(ManagerCadastroDieta manager) {
		
		this.manager = manager;
		
		//Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(320, 480));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblCadastroDeDieta = new JLabel("Cadastro de Dieta");
		lblCadastroDeDieta.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblCadastroDeDieta.setBounds(66, 11, 199, 33);
		add(lblCadastroDeDieta);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblNome.setBounds(12, 87, 48, 14);
		add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldNome.setBounds(59, 78, 244, 33);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblQuantidadeDeCarboidratos = new JLabel("Carboidratos:");
		lblQuantidadeDeCarboidratos.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblQuantidadeDeCarboidratos.setBounds(34, 144, 88, 14);
		add(lblQuantidadeDeCarboidratos);
		
		JFormattedTextField formattedTextFieldCarb = new JFormattedTextField();
		formattedTextFieldCarb.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		formattedTextFieldCarb.setBounds(134, 137, 60, 29);
		add(formattedTextFieldCarb);
		
		JLabel lblQuantidadeDeProteinas = new JLabel("Proteinas:");
		lblQuantidadeDeProteinas.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblQuantidadeDeProteinas.setBounds(52, 186, 70, 14);
		add(lblQuantidadeDeProteinas);
		
		JFormattedTextField formattedTextFieldProt = new JFormattedTextField();
		formattedTextFieldProt.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		formattedTextFieldProt.setBounds(134, 179, 60, 29);
		add(formattedTextFieldProt);
		
		JLabel lblQuantidadeDeGorduras = new JLabel("Gorduras:");
		lblQuantidadeDeGorduras.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblQuantidadeDeGorduras.setBounds(52, 228, 70, 14);
		add(lblQuantidadeDeGorduras);
		
		JFormattedTextField formattedTextFieldGord = new JFormattedTextField();
		formattedTextFieldGord.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		formattedTextFieldGord.setBounds(134, 221, 60, 29);
		add(formattedTextFieldGord);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarPressionado();
			}
		});
		btnCadastrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCadastrar.setBounds(106, 292, 111, 39);
		add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarPressionado();
			}
		});
		btnCancelar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCancelar.setBounds(106, 369, 111, 39);
		add(btnCancelar);

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
	
}
