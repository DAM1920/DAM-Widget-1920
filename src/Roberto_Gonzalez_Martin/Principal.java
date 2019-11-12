package Roberto_Gonzalez_Martin;

import java.awt.EventQueue;

import Redondo_Garcia_Jesus.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
					ventanaPrincipal.inicializar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

}
