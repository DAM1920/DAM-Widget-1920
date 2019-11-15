package Nadia_Calle;

import java.awt.EventQueue;

public class Principal {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});	
	}
}
