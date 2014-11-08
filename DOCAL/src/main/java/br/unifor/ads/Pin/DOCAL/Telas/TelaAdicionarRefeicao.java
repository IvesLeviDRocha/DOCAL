package br.unifor.ads.Pin.DOCAL.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private TableRowSorter sorter;
	private DefaultTableModel model;

	public TelaAdicionarRefeicao(ManagerAdicionarRefeicao manager) {
		setBackground(new Color(255, 255, 255));

		this.manager = manager;

		// Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(540, 470));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblAddRef = new JLabel("Adicionar Refeição");
		lblAddRef.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblAddRef.setBounds(176, 65, 183, 32);
		add(lblAddRef);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(Color.LIGHT_GRAY);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdicionarPressionado();
			}
		});
		btnAdicionar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnAdicionar.setBounds(29, 317, 104, 32);
		add(btnAdicionar);

		JButton btnCadastrarNova = new JButton(
				"<html>Cadastra<br/> nova</html>");
		btnCadastrarNova.setBackground(Color.LIGHT_GRAY);
		btnCadastrarNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarNovaPressionado();
			}
		});
		btnCadastrarNova.setFont(new Font("Microsoft Sans Serif", Font.PLAIN,
				12));
		btnCadastrarNova.setBounds(277, 317, 104, 32);
		add(btnCadastrarNova);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarPressionado();
			}
		});
		btnCancelar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCancelar.setBounds(404, 317, 99, 31);
		add(btnCancelar);

		JLabel lblSelecione = new JLabel(
				"<html><B>Refeições já cadastradas</B></html>",
				SwingConstants.CENTER);
		lblSelecione.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblSelecione.setBounds(29, 175, 183, 23);
		add(lblSelecione);

		JButton btnRemover = new JButton("<html>Remover<br/> da lista</html>");
		btnRemover.setBackground(Color.LIGHT_GRAY);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemoverPressionado();
			}
		});
		btnRemover.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnRemover.setBounds(155, 317, 99, 32);
		add(btnRemover);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 211, 497, 76);

		String[] colunas = { "Nome", "Carboidratos", "Proteinas", "Gorduras" };
		Object[][] dados = { { "Arroz com bife", "300g", "25g", "50g" },
				{ "Macarronada", "100g", "40g", "60g" },
				{ "Baião com frango e puré", "80g", "75g", "80g" } };

		table = new JTable();
		model = new DefaultTableModel(dados, colunas);
		table.setModel(model);
		scrollPane.setViewportView(table);
		sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		add(scrollPane);

		JLabel lblPesquisa = new JLabel("<html><B>Pesquisa</B></html>",
				SwingConstants.CENTER);
		lblPesquisa.setBounds(305, 179, 54, 14);
		add(lblPesquisa);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				pesquisa();
			}
		});
		textField.setBounds(369, 176, 150, 23);
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
		manager.btnAdicionarPressionado();
	}

	public void btnCadastrarNovaPressionado() {
		manager.btnCadastrarNovaPressionado();
	}

	public void btnCancelarPressionado() {
		manager.btnCancelarPressionado();
	}

	public void btnRemoverPressionado() {
		manager.btnRemoverPressionado();
	}

	private void pesquisa() {
		String text = textField.getText().substring(0, 1).toUpperCase()
				.concat(textField.getText().substring(1));

		if (text.length() == 0) {
			sorter.setRowFilter(null);

		} else {
			sorter.setRowFilter(RowFilter.regexFilter(text));

		}
	}
}
