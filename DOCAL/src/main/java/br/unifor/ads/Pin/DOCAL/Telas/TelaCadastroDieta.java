package br.unifor.ads.Pin.DOCAL.Telas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
 * Esta classe e responsavel por manter os componentes relativos ao cadastro da
 * dieta.
 */
public class TelaCadastroDieta extends JPanel {

	private static final long serialVersionUID = 3919730245101788170L;

	private ManagerCadastroDieta manager;

	private JTextField textFieldNome;
	private JFormattedTextField formattedTextFieldCarb;
	private JFormattedTextField formattedTextFieldProt;
	private JFormattedTextField formattedTextFieldGord;

	public TelaCadastroDieta(ManagerCadastroDieta manager) {
		setBackground(Color.WHITE);

		this.manager = manager;

		// Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(540, 470));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblCadastroDeDieta = new JLabel("Cadastro de Dieta",
				SwingConstants.CENTER);
		lblCadastroDeDieta.setFont(new Font("Microsoft Sans Serif", Font.PLAIN,
				22));
		lblCadastroDeDieta.setBounds(164, 39, 199, 33);
		add(lblCadastroDeDieta);
		ImageIcon imagens = new ImageIcon(
				TelaAdicionarRefeicao.class
						.getResource("/br/unifor/ads/Pin/DOCAL/Imagem/plano de fundo.png"));
		Image imagem = imagens.getImage().getScaledInstance(540, 470,
				Image.SCALE_SMOOTH);

		JLabel lblNome = new JLabel("Nome da dieta:",
				SwingConstants.CENTER);
		lblNome.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNome.setBounds(200, 100, 148, 33);
		add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textFieldNome.setBounds(132, 143, 268, 33);
		add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblQuantidadeDeCarboidratos = new JLabel(
				"Carboidratos:");
		lblQuantidadeDeCarboidratos.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblQuantidadeDeCarboidratos.setBounds(142, 196, 101, 20);
		add(lblQuantidadeDeCarboidratos);

		formattedTextFieldCarb = new JFormattedTextField();
		formattedTextFieldCarb.setFont(new Font("Microsoft Sans Serif",
				Font.PLAIN, 14));
		formattedTextFieldCarb.setBounds(253, 193, 60, 28);
		add(formattedTextFieldCarb);

		JLabel lblQuantidadeDeProteinas = new JLabel(
				"Proteinas:");
		lblQuantidadeDeProteinas.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblQuantidadeDeProteinas.setBounds(168, 238, 75, 14);
		add(lblQuantidadeDeProteinas);

		formattedTextFieldProt = new JFormattedTextField();
		formattedTextFieldProt.setFont(new Font("Microsoft Sans Serif",
				Font.PLAIN, 14));
		formattedTextFieldProt.setBounds(253, 232, 60, 28);
		add(formattedTextFieldProt);

		JLabel lblQuantidadeDeGorduras = new JLabel(
				"Gorduras:");
		lblQuantidadeDeGorduras.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblQuantidadeDeGorduras.setBounds(168, 278, 75, 14);
		add(lblQuantidadeDeGorduras);

		formattedTextFieldGord = new JFormattedTextField();
		formattedTextFieldGord.setFont(new Font("Microsoft Sans Serif",
				Font.PLAIN, 14));
		formattedTextFieldGord.setBounds(253, 271, 60, 28);
		add(formattedTextFieldGord);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarPressionado();
			}
		});
		btnCadastrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCadastrar.setBounds(280, 340, 120, 42);
		add(btnCadastrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarPressionado();
			}
		});
		btnCancelar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCancelar.setBounds(130, 340, 120, 42);
		add(btnCancelar);

		JLabel foto = new JLabel("");
		foto.setHorizontalAlignment(SwingConstants.CENTER);
		foto.setIcon(new ImageIcon(imagem));
		foto.setBounds(0, 0, 540, 470);
		add(foto);

	}

	public void btnCadastrarPressionado() {
		if (checkFieldsNotEmpty()) {
			String nome = textFieldNome.getText();
			String carb = formattedTextFieldCarb.getText();
			String prot = formattedTextFieldProt.getText();
			String gord = formattedTextFieldGord.getText();
			manager.btnCadastrarPressionado(nome, carb, prot, gord);
		} else {
			JOptionPane.showMessageDialog(this, "Campos em branco!");
		}
	}

	public void btnCancelarPressionado() {
		manager.btnCancelarPressionado();
	}

	public void limparFormularios() {
		textFieldNome.setText("");
		formattedTextFieldCarb.setText("");
		formattedTextFieldProt.setText("");
		formattedTextFieldGord.setText("");
	}

	public boolean checkFieldsNotEmpty() {
		if (textFieldNome.getText().equals("")
				|| formattedTextFieldCarb.getText().equals("")
				|| formattedTextFieldProt.getText().equals("")
				|| formattedTextFieldGord.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}

}
