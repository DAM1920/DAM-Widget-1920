package Vega_Calzado_Alba;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VentanaPrincipal {
	JFrame ventana;
	JTextField buscadorRuta;
	JButton botonBuscar;
	
	public VentanaPrincipal() {
		ventana=new JFrame();
		ventana.setBounds();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
	
	public void inicializarComponentes() {
		ventana.setLayout();
		
		//Inicialización del JTextField
		buscadorRuta = new JTextField();
		
		
	}
	
	public void inicializarListeners() {
		
	}
}
