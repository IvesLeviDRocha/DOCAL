package telas;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import managers.ManagerCadastroRefeicao;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Esta classe e responsavel por manter os componentes relativos ao cadastro da
 * refeicao.
 */
public class TelaCadastroRefeicao extends JPanel {

	private static final long serialVersionUID = -214369656604544646L;

	private ManagerCadastroRefeicao manager;
	
	/**
	 * Cria a tela.
	 * @param managerCadastroRefeicao responsavel por esta tela.
	 */
	public TelaCadastroRefeicao(ManagerCadastroRefeicao manager) {
		
		this.manager = manager;
		
		//Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(320, 480));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblCadastroRefeicao = new JLabel("Cadastro de Refeição");
		lblCadastroRefeicao.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblCadastroRefeicao.setBounds(54, 11, 225, 26);
		add(lblCadastroRefeicao);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblNome.setBounds(8, 85, 44, 20);
		add(lblNome);
		
		JFormattedTextField formattedTextFieldNome = new JFormattedTextField();
		formattedTextFieldNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		formattedTextFieldNome.setBounds(54, 79, 248, 33);
		add(formattedTextFieldNome);
		
		JLabel lblQuantidadeDeCarboidratos = new JLabel("Carboidratos:");
		lblQuantidadeDeCarboidratos.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblQuantidadeDeCarboidratos.setBounds(54, 135, 85, 20);
		add(lblQuantidadeDeCarboidratos);
		
		JFormattedTextField formattedTextFieldCarb = new JFormattedTextField();
		formattedTextFieldCarb.setBounds(141, 131, 55, 28);
		add(formattedTextFieldCarb);
		
		JLabel lblQuantidadeDeProteinas = new JLabel("Proteinas:");
		lblQuantidadeDeProteinas.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblQuantidadeDeProteinas.setBounds(75, 184, 64, 14);
		add(lblQuantidadeDeProteinas);
		
		JFormattedTextField formattedTextFieldProt = new JFormattedTextField();
		formattedTextFieldProt.setBounds(141, 177, 55, 28);
		add(formattedTextFieldProt);
		
		JLabel lblQuantidadeDeGoduras = new JLabel("Gorduras:");
		lblQuantidadeDeGoduras.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblQuantidadeDeGoduras.setBounds(75, 232, 64, 14);
		add(lblQuantidadeDeGoduras);
		
		JFormattedTextField formattedTextFieldGord = new JFormattedTextField();
		formattedTextFieldGord.setBounds(141, 225, 55, 28);
		add(formattedTextFieldGord);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarPressionado();
			}
		});
		btnCadastrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCadastrar.setBounds(96, 288, 119, 40);
		add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarPressionado();
			}
		});
		btnCancelar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCancelar.setBounds(96, 362, 119, 40);
		add(btnCancelar);

	}
	
	/**
	 * Delega a operacao adequada do botao Cadastrar ao manager.
	 */
	public void btnCadastrarPressionado() {
		manager.btnCadastrarPressionado();
	}
	
	/**
	 * Delega a operacao adequada do botao Cadastrar ao manager.
	 */
	public void btnCancelarPressionado() {
		manager.btnCancelarPressionado();
	}

}
