 package br.unifor.ads.Pin.DOCAL.Telas;

import java.awt.EventQueue;

/**
 * Testa a visualizacao de todas as telas e as transicoes entre estas.
 */
public class Aplicacao03102014 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
