package Vega_Calzado_Alba;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VentanaPrincipal {
	JFrame ventana;
	JTextField buscadorRuta;
	JButton botonBuscar, botonPlay, botonPause, botonAvanzar, botonRetroceder;
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
		
		//Inicialización de la Galería
		galeria = new Galeria();
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx=0;
		settings.gridy=0;
		settings.gridwidth=4;
		settings.weightx=1;
		settings.weighty=1;
		settings.fill=GridBagConstraints.BOTH;
		
		
		
		//Inicialización del JTextField
		buscadorRuta = new JTextField();
		
		//Inicializamos boton de busqueda de ka ruta
		botonBuscar = new JButton("Buscar");
		
	}
	
	public void inicializarListeners() {
		
	}
}
