package br.unifor.ads.Pin.DOCAL.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import br.unifor.ads.DOCAL_core.dao.RefeicaoDAO;
import br.unifor.ads.DOCAL_core.entity.Refeicao;
import br.unifor.ads.DOCAL_core.entity.Usuario;
import br.unifor.ads.Pin.DOCAL.Manager.ManagerAdicionarRefeicao;

/**
 * Esta classe e responsavel por manter os componentes relativos a adicionar
 * refeicoes a a dieta atual do usuario.
 */
public class TelaAdicionarRefeicao extends JPanel {

	private static final long serialVersionUID = 3679713584612256623L;

	private ManagerAdicionarRefeicao manager;
	private JTable table;
	private JTextField textField;
	private TableRowSorter<TableModel> sorter;
	private DefaultTableModel model;

	private Vector<String> colunas;
	private Vector<Vector<String>> dados;
	private List<Refeicao> loadedRefeicoes;

	public TelaAdicionarRefeicao(ManagerAdicionarRefeicao manager) {

		colunas = new Vector<String>();
		colunas.add("Nome");
		colunas.add("Carboidratos");
		colunas.add("Proteinas");
		colunas.add("Gorduras");

		dados = new Vector<Vector<String>>();
		loadedRefeicoes = new ArrayList<Refeicao>();

		setBackground(new Color(255, 255, 255));

		this.manager = manager;

		// Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(540, 470));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblAddRef = new JLabel("Adicionar Refeição");
		lblAddRef.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblAddRef.setBounds(176, 11, 183, 32);
		add(lblAddRef);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(Color.LIGHT_GRAY);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdicionarPressionado();
			}
		});
		btnAdicionar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnAdicionar.setBounds(409, 370, 110, 52);
		add(btnAdicionar);

		JButton btnCadastrarNova = new JButton(
				"<html><center>Cadastrar<br/> nova</center></html>");
		btnCadastrarNova.setBackground(Color.LIGHT_GRAY);
		btnCadastrarNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarNovaPressionado();
			}
		});
		btnCadastrarNova.setFont(new Font("Microsoft Sans Serif", Font.PLAIN,
				16));
		btnCadastrarNova.setBounds(277, 370, 110, 52);
		add(btnCadastrarNova);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarPressionado();
			}
		});
		btnCancelar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCancelar.setBounds(22, 370, 110, 52);
		add(btnCancelar);

		JLabel lblSelecione = new JLabel("Refeições já cadastradas",
				SwingConstants.CENTER);
		lblSelecione.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblSelecione.setBounds(22, 65, 193, 33);
		add(lblSelecione);

		JButton btnRemover = new JButton(
				"<html><center>Remover<br/> da lista</center></html>");
		btnRemover.setBackground(Color.LIGHT_GRAY);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemoverPressionado();
			}
		});
		btnRemover.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnRemover.setBounds(155, 370, 110, 52);
		add(btnRemover);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 109, 497, 250);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 16));
		table.setRowHeight(22);
		table.setPreferredScrollableViewportSize(table.getSize());

		model = new DefaultTableModel(dados, colunas);
		table.setModel(model);
		scrollPane.setViewportView(table);
		sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		add(scrollPane);

		JLabel lblPesquisa = new JLabel("Pesquisa:", SwingConstants.CENTER);
		lblPesquisa.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblPesquisa.setBounds(278, 67, 81, 29);
		add(lblPesquisa);

		textField = new JTextField();
		textField.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 16));
		textField.setBackground(Color.WHITE);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				pesquisa();
			}
		});
		textField.setBounds(369, 66, 150, 32);
		textField.setColumns(10);
		add(textField);

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

	public void btnAdicionarPressionado() {
		int row = table.getSelectedRow();
		Refeicao ref = loadedRefeicoes.get(row);
		manager.btnAdicionarPressionado(ref);
	}

	public void btnCadastrarNovaPressionado() {
		manager.btnCadastrarNovaPressionado();
	}

	public void btnCancelarPressionado() {
		manager.btnCancelarPressionado();
	}

	public void btnRemoverPressionado() {
		int row = table.getSelectedRow();
		Refeicao ref = loadedRefeicoes.get(row);
		manager.btnRemoverPressionado(ref, row);
	}

	public void removeRefeicaoFromTable(int row) {
		loadedRefeicoes.remove(row);
		dados.remove(row);
		model.fireTableDataChanged();
	}

	public void pesquisa() {
		String text = textField.getText();
		sorter.setRowFilter(RowFilter.regexFilter(text, 0));
	}

	public void loadRefeicaoData(Usuario loggedUser) {
		clearRefeicaoData();
		List<Object> list = RefeicaoDAO.findByUserId(loggedUser.getId());
		for (Object obj : list) {
			Refeicao ref = (Refeicao) obj;
			loadedRefeicoes.add(ref);
			dados.add(ref.getRowData());
		}
	}

	private void clearRefeicaoData() {
		dados.clear();
		loadedRefeicoes.clear();
	}

	public void limparForms() {
		textField.setText("");
	}
}
