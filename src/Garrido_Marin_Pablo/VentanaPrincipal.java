package Garrido_Marin_Pablo;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaPrincipal {

	JFrame ventana;
	Buscador buscador;
	JButton boton;

	public VentanaPrincipal() {
		this.ventana = new JFrame();
		this.ventana.setBounds(0, 0, 600, 100);
		this.ventana.setLocationRelativeTo(null);
		this.ventana.setUndecorated(true);

	}

	public void inicializar() {
		this.ventana.setVisible(true);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		this.ventana.setLayout(new GridLayout(1, 2));
		buscador = new Buscador(this);
		ventana.add(buscador);
		
	}

}
