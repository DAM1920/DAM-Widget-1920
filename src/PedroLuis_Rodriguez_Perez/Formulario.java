package PedroLuis_Rodriguez_Perez;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulario extends JPanel {
	JPanel formulario;
	JPanel visor;

	JLabel[] etiquetas;
	JTextField[] cuadrosDeTexto;
	
	JButton almacenar;
	String [] atributos = {"Nombre","Apellido","DNI","Ciudad","Edad"};

	public Formulario() {
		this.setLayout(new GridBagLayout());

		formulario = new JPanel();
		formulario.setLayout(new GridBagLayout());		
		visor = new JPanel();
		visor.setLayout(new GridBagLayout());
		
		
		
		almacenar= new JButton("Almacenar");
		
		etiquetas = new JLabel[atributos.length];
		cuadrosDeTexto = new JTextField[atributos.length];
		
		for (int i = 0; i < atributos.length; i++) {
			etiquetas[i] = new JLabel(atributos[i]);
			cuadrosDeTexto[i] = new JTextField();
		}

		inicializarComponentes();
	}
	private void refrescarPantalla() {
		this.revalidate(); 
		this.repaint();
		
	}
	private void inicializarComponentes() {
		GridBagConstraints settings = new GridBagConstraints();
		settings.fill = GridBagConstraints.BOTH;
		
		
		// Formulario
		formulario.setBorder(BorderFactory.createTitledBorder("Formulario"));
		formulario.setBackground(new Color(223,235,192));
		
		settings.weightx=1;
		settings.weighty=1;			
		this.add(formulario,settings);

		// Visor
		visor.setBorder(BorderFactory.createTitledBorder("Visor"));
		visor.setBackground(new Color(216,229,237));
		
		settings.weightx=3;
		settings.weighty=3;
		this.add(visor,settings);
		
		settings = new GridBagConstraints();		
		settings.insets = new Insets(0, 0, 40, 0);
		settings.fill = GridBagConstraints.BOTH;
		
		for (int i = 0; i < atributos.length; i++) {
			settings.gridx=0;
			settings.gridy=i;
			settings.weightx = 1;
			etiquetas[i].setForeground(new Color(136,61,29));
			etiquetas[i].setFont(etiquetas[i].getFont().deriveFont(Font.BOLD, 14f));
			formulario.add(etiquetas[i],settings);
			
			settings.gridx=1;
			settings.gridy=i;
			settings.weightx = 1;		
			formulario.add(cuadrosDeTexto[i],settings);
		}
		
		
		//Boton almacenar
		
		settings =new GridBagConstraints();
		
		settings.gridy = atributos.length;
		settings.insets = new Insets(50, 0, 0, 0);
		settings.gridwidth = 2;
		settings.fill = GridBagConstraints.HORIZONTAL;
		formulario.add(almacenar,settings);
		
		almacenar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				String cadena="";
				
				for (int i = 0; i < atributos.length; i++) {
					cadena+="  -"+atributos[i]+":  ";
					cadena+=cuadrosDeTexto[i].getText();
					
				}
				System.out.println(cadena);
				visor.removeAll();
				visor.add(new JLabel(cadena));
				refrescarPantalla();
			}			
		});
		

	}
}
