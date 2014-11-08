package br.unifor.ads.Pin.DOCAL.Telas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Esta classe tem como responsabilidade mostrar as telas da aplicacao.
 */
public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 3577900688565338673L;

	public FramePrincipal(JPanel startingScreen) {
		setTitle("DietOC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeelToNimbus();
		setContentPane(startingScreen);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public void setLookAndFeelToNimbus() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showScreen(JPanel screen) {
		setContentPane(screen);
		pack();
	}
}
