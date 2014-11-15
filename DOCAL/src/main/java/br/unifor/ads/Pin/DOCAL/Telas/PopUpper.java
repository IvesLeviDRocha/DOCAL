package br.unifor.ads.Pin.DOCAL.Telas;

import javax.swing.JOptionPane;

public class PopUpper {

	private static FramePrincipal frame;

	public static void setFrame(FramePrincipal framePrincipal) {
		frame = framePrincipal;
	}

	public void show(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}

	public boolean confirm(String question) {
		int op = JOptionPane.showConfirmDialog(frame, question, "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (op == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String receiveInput(String message) throws InputException {
		String input = JOptionPane.showInputDialog(frame, message);
		if (input == null) {
			throw new InputException();
		}
		return input;
	}

}
