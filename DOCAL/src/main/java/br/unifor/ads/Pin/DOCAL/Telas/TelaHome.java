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

import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.DOCAL_core.entity.Usuario;
import br.unifor.ads.Pin.DOCAL.Manager.ManagerHome;

/**
 * Esta classe e responsavel por manter os componentes relativos a a pagina
 * principal do usuario.
 */
public class TelaHome extends JPanel {

	private static final long serialVersionUID = 2857670324681532711L;

	private ManagerHome manager;

	private JTable table;
	DefaultTableModel model;
	JMenu mnOlaUsuario;
	JLabel lblDieta;

	private String[] colunas = { "", "Hoje", "Total" };
	private String[][] dados = { { "Caboidratos", "Valor", "Valor" },
			{ "Proteinas", "Valor", "Valor" },
			{ "Gorduras", "Valor", "Valor" },
			{ "Calorias Totais", "Valor", "Valor" } };

	public TelaHome(ManagerHome manager) {
		setBackground(Color.WHITE);

		this.manager = manager;

		// Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(540, 470));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		lblDieta = new JLabel("Dieta: [Dieta]", SwingConstants.CENTER);
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
		btnAddRefeicao
				.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnAddRefeicao.setBounds(332, 339, 178, 45);
		add(btnAddRefeicao);

		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetPressionado();
			}
		});
		btnReset.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnReset.setBounds(192, 342, 103, 42);
		add(btnReset);

		JButton btnNovaDieta = new JButton("Nova Dieta");
		btnNovaDieta.setBackground(Color.LIGHT_GRAY);
		btnNovaDieta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNovaDietaPressionado();
			}
		});
		btnNovaDieta.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnNovaDieta.setBounds(31, 342, 127, 42);
		add(btnNovaDieta);

		table = new JTable();
		table.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 16));
		table.setRowHeight(22);
		table.setPreferredScrollableViewportSize(table.getSize());

		DefaultTableCellRenderer letras = new DefaultTableCellRenderer() {

			private static final long serialVersionUID = -5834457900837802725L;

			public void setValue(Object value) {
				setBackground(new Color(215, 215, 215));
				setForeground(Color.RED);
				setHorizontalAlignment(JLabel.CENTER);
				setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 16));
				super.setValue(value);
			}
		};

		model = new DefaultTableModel(dados, colunas);
		table.setModel(model);
		javax.swing.table.TableColumn tc = table.getColumn("");
		tc.setCellRenderer(letras);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 150, 401, 104);
		scrollPane.setViewportView(table);
		add(scrollPane);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(424, 11, 97, 21);

		mnOlaUsuario = new JMenu("<html><B>Olá [Usuário]</B></html>");
		mnOlaUsuario.setBounds(483, 11, 107, 22);

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

		mnOlaUsuario.add(mntmEditar);
		mnOlaUsuario.add(mntmSair);
		menuBar.add(mnOlaUsuario);
		add(menuBar);

		JLabel foto = new JLabel("");
		foto.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagens = new ImageIcon(
				TelaAdicionarRefeicao.class
						.getResource("/br/unifor/ads/Pin/DOCAL/Imagem/plano de fundo.png"));
		Image imagem = imagens.getImage().getScaledInstance(540, 470,
				Image.SCALE_SMOOTH);
		foto.setIcon(new ImageIcon(imagem));
		foto.setBounds(0, 0, 540, 470);
		add(foto);

	}

	public void btnAddRefeicaoPressionado() {
		manager.btnAddRefeicaoPressionado();
	}

	public void btnResetPressionado() {
		manager.btnResetPressionado();
	}

	public void btnNovaDietaPressionado() {
		manager.btnNovaDietaPressionado();
	}

	public void mnItemSairPressionado() {
		manager.btnSairPressionado();
	}

	public void mnItemAtualizarDadosPressionado() {
		manager.btnAtualizarDadosPressionado();
	}

	public JTable getTable() {
		return table;
	}

	public void updateUserData(String username, Dieta dieta) {
		updateUserName(username);
		updateTableDieta(dieta);
	}

	public void updateUserName(String username) {
		mnOlaUsuario.setText("<html><B>Olá " + username + " !</B></html>");
	}

	public void updateTableDieta(Dieta dieta) {
		lblDieta.setText("Dieta: " + dieta.getNome());
		lblDieta.setSize(new Dimension(lblDieta.getPreferredSize()));
		dados[0][2] = String.valueOf(dieta.getCarboidratos());
		dados[1][2] = String.valueOf(dieta.getProteinas());
		dados[2][2] = String.valueOf(dieta.getGorduras());
		dados[3][2] = String.valueOf(dieta.getCalorias());
		refreshTable();
	}

	public void refreshTable() {
		model.setDataVector(dados, colunas);
		model.fireTableDataChanged();
	}
}
