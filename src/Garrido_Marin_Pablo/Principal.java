package Garrido_Marin_Pablo;

import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					VentanaPrincipal v = new VentanaPrincipal();
					v.inicializar();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
	}

}
