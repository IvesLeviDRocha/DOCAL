package br.unifor.ads.Pin.DOCAL.Telas;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Esta classe tem como responsabilidade mostrar as telas da aplicacao.
 */
public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 3577900688565338673L;

	public FramePrincipal(JPanel startingScreen) {
		setTitle("DOCAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(startingScreen);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public void showScreen(JPanel screen) {
		setContentPane(screen);
		pack();
	}
}
