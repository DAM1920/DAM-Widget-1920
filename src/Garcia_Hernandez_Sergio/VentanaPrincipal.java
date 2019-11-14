package Garcia_Hernandez_Sergio;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaPrincipal {
	// La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;
	
	JLectorTweets lectorTweets;

	// Constructor, marca el tamaño y el cierre del frame
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 500, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {
		ventana.setLayout(new GridLayout(1, 1));		
		
		lectorTweets = new JLectorTweets();
		ventana.getContentPane().add(lectorTweets);
		
		ventana.setVisible(true);
	}

	public void inicializarListeners() {

	}

	public void inicializar() {
		inicializarComponentes();
		inicializarListeners();
	}
}
