package br.unifor.ads.Pin.DOCAL.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.unifor.ads.Pin.DOCAL.Manager.ManagerHome;

/**
 * Esta classe e responsavel por manter os componentes relativos a a pagina
 *  principal do usuario.
 */
public class TelaHome extends JPanel {
	
	private static final long serialVersionUID = 2857670324681532711L;
	
	private ManagerHome manager;
	private JTable table;
	
	/**
	 * Cria a tela.
	 * @param o ManagerHome responsavel pela tela.
	 */
	public TelaHome(ManagerHome manager) {
		setBackground(Color.WHITE);
		
		this.manager = manager;
		
		//Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(540, 470));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		JLabel lblDieta = new JLabel("Dieta: [Dieta]",SwingConstants.CENTER);
		lblDieta.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		lblDieta.setBounds(206, 73, 138, 37);
		add(lblDieta);
		
		JButton btnAddRefeicao = new JButton("Adicionar Refeição");
		btnAddRefeicao.setBackground(Color.LIGHT_GRAY);
		btnAddRefeicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddRefeicaoPressionado();
			}
		});
		btnAddRefeicao.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnAddRefeicao.setBounds(332, 339, 178, 32);
		add(btnAddRefeicao);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetPressionado();
			}
		});
		btnReset.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnReset.setBounds(192, 342, 103, 27);
		add(btnReset);
		
		JButton btnNovaDieta = new JButton("Nova Dieta");
		btnNovaDieta.setBackground(Color.LIGHT_GRAY);
		btnNovaDieta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNovaDietaPressionado();
			}
		});
		btnNovaDieta.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnNovaDieta.setBounds(31, 342, 127, 27);
		add(btnNovaDieta);
		
		
		
		String colunas [] = {"","Hoje","Total"};
		String dados [][] = {{"Caboidratos","Valor","Valor"},{"Proteinas","Valor","Valor"},
							 {"Gorduras","Valor","Valor"},{"Calorias Totais","Valor","Valor"}};
		
		table = new JTable();
		
		DefaultTableCellRenderer letras = 
		new DefaultTableCellRenderer() {
			
			private static final long serialVersionUID = -5834457900837802725L;

			public void setValue(Object value) {
				setBackground(new Color(215,215,215));
				setForeground(Color.RED);
				setHorizontalAlignment(JLabel.CENTER);
				
				super.setValue(value);
			}
		};
		
		DefaultTableModel model = new DefaultTableModel(dados, colunas);
		table.setModel(model);
		javax.swing.table.TableColumn tc = table.getColumn("");
		tc.setCellRenderer(letras);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 150, 401, 91);
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(424, 11, 97, 21);
		
		JMenu mnOlusurio = new JMenu("<html><B>Olá [Usuário]</B></html>");
		mnOlusurio.setBounds(483, 11, 107, 22);
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		mntmEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnItemAtualizarDadosPressionado();
			}
		});
		mntmEditar.setBounds(510, 10, 129, 22);
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnItemSairPressionado();
			}
		});
		mntmSair.setBounds(95, 21, 129, 22);

		mnOlusurio.add(mntmEditar);
		mnOlusurio.add(mntmSair);
		menuBar.add(mnOlusurio);
		add(menuBar);
		
		JLabel foto = new JLabel("");
		foto.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagens = new ImageIcon(TelaAdicionarRefeicao.class.getResource("/br/unifor/ads/Pin/DietOC/Imagem/plano de fundo.png"));
		Image imagem = imagens.getImage().getScaledInstance(540, 470, Image.SCALE_SMOOTH);
		foto.setIcon(new ImageIcon(imagem));
		foto.setBounds(0, 0, 540, 470);
		add(foto);
		
		
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
	public void mnItemSairPressionado() {
		manager.btnSairPressionado();
	}
	
	/**
	 * Delega a operacao adequada do botao AtualizarDados ao manager.
	 */
	public void mnItemAtualizarDadosPressionado() {
		manager.btnAtualizarDadosPressionado();
	}
}
