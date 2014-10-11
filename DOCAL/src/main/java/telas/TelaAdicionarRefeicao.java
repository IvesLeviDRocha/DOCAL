package telas;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import managers.ManagerAdicionarRefeicao;

/**
 * Esta classe e responsavel por manter os componentes relativos a adicionar
 * refeicoes a a dieta atual do usuario.
 */
public class TelaAdicionarRefeicao extends JPanel {

	private static final long serialVersionUID = 3679713584612256623L;
	
	private ManagerAdicionarRefeicao manager;

	/**
	 * Cria a tela.
	 * @param o ManagerAdicionarRefeicao responsavel pela tela.
	 */
	public TelaAdicionarRefeicao(ManagerAdicionarRefeicao manager) {
		
		this.manager = manager;
		
		//Setta tamanho, layout e borda.
		setPreferredSize(new Dimension(320, 480));
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblAddRef = new JLabel("Adicionar Refeição");
		lblAddRef.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblAddRef.setBounds(64, 11, 183, 32);
		add(lblAddRef);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdicionarPressionado();
			}
		});
		btnAdicionar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnAdicionar.setBounds(44, 160, 133, 38);
		add(btnAdicionar);
		
		JButton btnCadastrarNova = new JButton("Cadastrar Nova");
		btnCadastrarNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarNovaPressionado();
			}
		});
		btnCadastrarNova.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCadastrarNova.setBounds(76, 281, 181, 38);
		add(btnCadastrarNova);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarPressionado();
			}
		});
		btnCancelar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnCancelar.setBounds(106, 374, 119, 32);
		add(btnCancelar);
		
		JLabel lblSelecione = new JLabel("Selecione uma refeição já cadastrada:");
		lblSelecione.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblSelecione.setBounds(44, 90, 242, 23);
		add(lblSelecione);
		
		JLabel labelCadastrar = new JLabel("...Ou cadastre uma nova refeição:");
		labelCadastrar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		labelCadastrar.setBounds(56, 247, 215, 23);
		add(labelCadastrar);
		
		JComboBox comboBoxLista = new JComboBox();
		comboBoxLista.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		comboBoxLista.setBounds(44, 117, 242, 32);
		add(comboBoxLista);
		
		JButton btnRemover = new JButton("<html>Remover<br/> da lista</html>");
		btnRemover.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btnRemover.setBounds(187, 160, 99, 38);
		add(btnRemover);

	}
	
	/**
	 * Delega a operacao adequada do botao Adicionar ao manager.
	 */
	public void btnAdicionarPressionado() {
		manager.btnAdicionarPressionado();
	}
	
	/**
	 * Delega a operacao adequada do botao CadastrarNova ao manager.
	 */
	public void btnCadastrarNovaPressionado() {
		manager.btnCadastrarNovaPressionado();
	}
	
	/**
	 * Delega a operacao adequada do botao Cancelar ao manager.
	 */
	public void btnCancelarPressionado() {
		manager.btnCancelarPressionado();
	}
}
