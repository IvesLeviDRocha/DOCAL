package telas;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import managers.ManagerHome;

/**
 * Esta classe e responsavel por manter os componentes relativos a a pagina
 *  principal do usuario.
 */
public class TelaHome extends JPanel {
	
	private static final long serialVersionUID = 2857670324681532711L;
	
	private ManagerHome manager;
	
	/**
	 * Cria a tela.
	 * @param o ManagerHome responsavel pela tela.
	 */
	public TelaHome(ManagerHome manager) {
		
		this.manager = manager;
		
		//Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(320, 480));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnAddRefeicao = new JButton("Adicionar Refeição");
		btnAddRefeicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddRefeicaoPressionado();
			}
		});
		btnAddRefeicao.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnAddRefeicao.setBounds(57, 275, 210, 56);
		add(btnAddRefeicao);
		
		JLabel lblOla = new JLabel("Olá, [Usuário]!");
		lblOla.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lblOla.setBounds(57, 10, 97, 26);
		add(lblOla);
		
		JLabel lblDieta = new JLabel("Dieta: [Dieta]");
		lblDieta.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		lblDieta.setBounds(96, 48, 138, 37);
		add(lblDieta);
		
		JLabel lblHoje = new JLabel("Hoje");
		lblHoje.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblHoje.setBounds(175, 103, 35, 23);
		add(lblHoje);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblTotal.setBounds(232, 103, 35, 23);
		add(lblTotal);
		
		JLabel lblCarboidratos = new JLabel("Carboidratos:");
		lblCarboidratos.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblCarboidratos.setBounds(57, 127, 97, 35);
		add(lblCarboidratos);
		
		JLabel lblProteinas = new JLabel("Proteinas:");
		lblProteinas.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblProteinas.setBounds(83, 162, 71, 34);
		add(lblProteinas);
		
		JLabel lblGorduras = new JLabel("Gorduras:");
		lblGorduras.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblGorduras.setBounds(83, 196, 71, 34);
		add(lblGorduras);
		
		JLabel lblCalorias = new JLabel("Calorias totais:");
		lblCalorias.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblCalorias.setBounds(50, 228, 104, 36);
		add(lblCalorias);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(220, 110, 2, 154);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 162, 217, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(50, 196, 217, 2);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(50, 228, 217, 2);
		add(separator_3);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(50, 127, 217, 2);
		add(separator_5);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetPressionado();
			}
		});
		btnReset.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnReset.setBounds(57, 342, 210, 35);
		add(btnReset);
		
		JButton btnNovaDieta = new JButton("Nova Dieta");
		btnNovaDieta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNovaDietaPressionado();
			}
		});
		btnNovaDieta.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnNovaDieta.setBounds(57, 388, 210, 35);
		add(btnNovaDieta);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSairPressionado();
			}
		});
		btnSair.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnSair.setBounds(57, 434, 210, 35);
		add(btnSair);
		
		JLabel lblCarbHoje = new JLabel("[Valor]");
		lblCarbHoje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarbHoje.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblCarbHoje.setBounds(164, 127, 52, 35);
		add(lblCarbHoje);
		
		JLabel lblCarbTotal = new JLabel("[Valor]");
		lblCarbTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarbTotal.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblCarbTotal.setBounds(220, 127, 52, 35);
		add(lblCarbTotal);
		
		JLabel lblProtHoje = new JLabel("[Valor]");
		lblProtHoje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProtHoje.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblProtHoje.setBounds(164, 162, 52, 35);
		add(lblProtHoje);
		
		JLabel lblGordHoje = new JLabel("[Valor]");
		lblGordHoje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGordHoje.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblGordHoje.setBounds(164, 196, 52, 35);
		add(lblGordHoje);
		
		JLabel lblCalHoje = new JLabel("[Valor]");
		lblCalHoje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalHoje.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblCalHoje.setBounds(164, 228, 52, 35);
		add(lblCalHoje);
		
		JLabel lblProtTotal = new JLabel("[Valor]");
		lblProtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProtTotal.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblProtTotal.setBounds(220, 162, 52, 35);
		add(lblProtTotal);
		
		JLabel lblGordTotal = new JLabel("[Valor]");
		lblGordTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGordTotal.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblGordTotal.setBounds(220, 196, 52, 35);
		add(lblGordTotal);
		
		JLabel lblCalTotal = new JLabel("[Valor]");
		lblCalTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalTotal.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblCalTotal.setBounds(220, 228, 52, 35);
		add(lblCalTotal);
		
		JButton btnAtualizarDados = new JButton("Atualizar dados");
		btnAtualizarDados.setBounds(173, 12, 112, 23);
		add(btnAtualizarDados);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(161, 109, 2, 154);
		add(separator_4);
		
	}
	
	/**
	 * Delega a operacao adequada do botao AdicionarRefeicao ao manager.
	 */
	public void btnAddRefeicaoPressionado() {
		manager.btnAddRefeicaoPressionado();
	}
	
	/**
	 * Delega a operacao adequada do botao Reset ao manager.
	 */
	public void btnResetPressionado() {
		manager.btnResetPressionado();
	}
	
	/**
	 * Delega a operacao adequada do botao NovaDieta ao manager.
	 */
	public void btnNovaDietaPressionado() {
		manager.btnNovaDietaPressionado();
	}
	
	/**
	 * Delega a operacao adequada do botao Sair ao manager.
	 */
	public void btnSairPressionado() {
		manager.btnSairPressionado();
	}
}
