package Pascual_Clemente_Alejandro;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class VentanaPrincipal {
	private final static String[] IDIOMAS = {"Inglés", "Español", "Francés", "Aleman"};
	private JFrame ventana;
	private GridBagLayout layout;
	private GridBagConstraints settings;
	private JComboBox<String> selc1;
	private JComboBox<String> selc2;
	private JButton traducir;
	private JTextArea textoTraducir;
	private JTextArea textoTraducido;
	private DefaultComboBoxModel<String> idioma;
	
	public VentanaPrincipal() {
		super();
		ventana = new JFrame("Traductor");
		ventana.setBounds(100, 100, 500, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponetes();
		
	}
	
	public void inicializarComponetes() {
		
		layout = new GridBagLayout();
		ventana.setLayout(layout);
		
		//Colocar selector1
		selc1 = new JComboBox<String>();
		
		for(int i = 0; i < IDIOMAS.length; i++) {
			selc1.addItem(IDIOMAS[i]);
		}
		
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.ipadx = 3;
		settings.ipady = 3;
		ventana.add(selc1, settings);
		
		//Colocar selector2
		selc2 = new JComboBox<String>();
		
		for(int i = 0; i < IDIOMAS.length; i++) {
			selc2.addItem(IDIOMAS[i]);
		}
		
		settings = new GridBagConstraints();
		settings.gridx = 2;
		settings.gridy = 0;
		settings.ipadx = 3;
		settings.ipady = 3;
		ventana.add(selc2, settings);
		
		//Colocar texto a traducir
		textoTraducir = new JTextArea(5,10);
		textoTraducir.setBorder(BorderFactory.createLineBorder(Color.black));
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.ipadx = 3;
		settings.ipady = 3;
		ventana.add(textoTraducir, settings);
		
		//Colocar boton traducir
		traducir = new JButton();
		traducir.setText("Traducir");
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 1;
		settings.ipadx = 3;
		settings.ipady = 3;
		ventana.add(traducir, settings);
		
		//Colocar texto a traducido
		textoTraducido = new JTextArea(5,10);
		textoTraducido.setBorder(BorderFactory.createLineBorder(Color.black));
		textoTraducido.setEditable(false);
		settings = new GridBagConstraints();
		settings.gridx = 2;
		settings.gridy = 1;
		settings.ipadx = 3;
		settings.ipady = 3;
		ventana.add(textoTraducido, settings);
		
	}
	
	
	
}
