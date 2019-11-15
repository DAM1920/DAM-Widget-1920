package Vega_Calzado_Alba;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 * @author Alba Vega Calzado
 *
 */

public class VentanaPrincipal {
	JFrame ventana;
	JButton presentacion, siguiente, anterior;
	JGaleria galeria;
	
	/**
	 * Constructor de la ventana
	 */
	public VentanaPrincipal() {
		ventana=new JFrame();
		ventana.setBounds(100, 100, 800, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JGaleria getJGaleria() {
		return galeria;
	}
	
	/**
	 * Método para inicializar la ventana y sus componentes.
	 */
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
	
	/**
	 * Método para inicializar los componentes
	 */
	public void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());
		
		//Inicialización de la galería
		galeria = new JGaleria();
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx=0;
		settings.gridy=0;
		settings.gridwidth=4;
		settings.weightx=1;
		settings.weighty=1;
		settings.fill=GridBagConstraints.BOTH;
		
		ventana.add(galeria, settings);
		
		//Inicialización del botón Anterior
		anterior = new JButton("Anterior");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.weightx = 1;
		settings.fill = GridBagConstraints.BOTH;
		
		ventana.add(anterior,settings);
		
		//Inicialización del botón Presentación
		presentacion = new JButton("Presentación");
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 1;
		settings.weightx = 1;
		settings.fill = GridBagConstraints.BOTH;
		
		ventana.add(presentacion, settings);
		
		//Inicialización del botón Siguiente
		siguiente = new JButton("Siguiente");
		settings = new GridBagConstraints();
		settings.gridx = 2;
		settings.gridy = 1;
		settings.weightx = 1;
		settings.fill = GridBagConstraints.BOTH;
				
		ventana.add(siguiente,settings);
		
		//Inicialización de la presentación de la galería
		getJGaleria().iniciarGaleria();
	}
	
	public void inicializarListeners() {
		siguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				galeria.avanzar();
			}
		});
		
		anterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				galeria.retroceder();
			}
		});
		
		presentacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				galeria.presentacion();
			}
		});
	}
}
