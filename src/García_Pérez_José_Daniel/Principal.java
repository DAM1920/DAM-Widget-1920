package García_Pérez_José_Daniel;

import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				VentanaPrincipal vp = new VentanaPrincipal();

				vp.inicializar();

			}
		});

	}

}
