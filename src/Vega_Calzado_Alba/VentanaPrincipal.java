package Vega_Calzado_Alba;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VentanaPrincipal {
	JFrame ventana;
	JTextField buscadorRuta;
	JButton botonBuscar;
	Galeria galeria;
	
	public VentanaPrincipal() {
		ventana=new JFrame();
		ventana.setBounds(100, 100, 350, 250);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
	
	public void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());
		
		//Inicialización del JTextField
		buscadorRuta = new JTextField();
		
		
	}
	
	public void inicializarListeners() {
		
	}
}
