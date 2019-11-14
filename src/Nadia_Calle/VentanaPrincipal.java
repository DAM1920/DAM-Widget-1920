package Nadia_Calle;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaPrincipal implements ChangeListener, ActionListener{
	// La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;
	JPanel panelIzq;
	JPanel panelDer;
	
	JSlider sliderRojo;
    JSlider sliderVerde;
    JSlider sliderAzul;
    JLabel labelRojo, labelVerde, labelAzul;   
    JButton botonAceptar;
    JPanel panelColor;
	Color colorSeleccionado;
	
    JTextArea texto;

    
	// Constructor, marca el tama√±o y el cierre del frame
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(0,0,900,500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {
		
		panelIzq = new JPanel();
		panelDer = new JPanel();
		panelIzq.setLayout(new GridBagLayout());
		panelDer.setLayout(new GridBagLayout());
		ventana.setLayout(new GridBagLayout());
		
		GridBagConstraints settings = new GridBagConstraints();

		// --- PANEL IZQUIERDO ---
		settings = new GridBagConstraints();
		panelIzq.setBackground(Color.WHITE);
		panelIzq.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 5;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelIzq, settings);
		
        GridBagConstraints setting = new GridBagConstraints();
		// ---- ROJO ----
        //Niveles de Rojo
        labelRojo = new JLabel("Niveles de rojo.");
        
        setting = new GridBagConstraints();
        setting.gridy = 3;
        setting.fill = GridBagConstraints.HORIZONTAL;
        panelIzq.add(labelRojo, setting);
        
        //Inicializo slider Rojo
      	sliderRojo = new JSlider(JSlider.HORIZONTAL,0,255,0);
      	sliderRojo.setMajorTickSpacing(255);
      	sliderRojo.setMinorTickSpacing(0);
      	sliderRojo.setPaintTicks(true);
      	sliderRojo.setPaintLabels(true);
      	
      	setting = new GridBagConstraints();
        setting.gridy = 4;
        setting.fill = GridBagConstraints.HORIZONTAL;
        panelIzq.add(sliderRojo, setting);

      	// ---- VERDE ----
      	
        //Niveles de Verde
        labelVerde = new JLabel("Niveles de verde.");
        
        setting = new GridBagConstraints();
        setting.gridy = 5;
        setting.fill = GridBagConstraints.HORIZONTAL;
        panelIzq.add(labelVerde, setting);

        //Inicializo slider Verde
      	sliderVerde = new JSlider(JSlider.HORIZONTAL,0,255,0);
      	sliderVerde.setMajorTickSpacing(255);
      	sliderVerde.setMinorTickSpacing(0);
      	sliderVerde.setPaintTicks(true);
      	sliderVerde.setPaintLabels(true);
      	
      	setting = new GridBagConstraints();
        setting.gridy = 6;
        setting.fill = GridBagConstraints.HORIZONTAL;
        panelIzq.add(sliderVerde, setting);

      	// ---- AZUL ----
      	
        //Niveles de Azul
        labelAzul = new JLabel("Niveles de azul.");
        
        setting = new GridBagConstraints();
        setting.gridy = 7;
        setting.fill = GridBagConstraints.HORIZONTAL;
        panelIzq.add(labelAzul, setting);
        
        //Inicializo slider Azul
      	sliderAzul = new JSlider(JSlider.HORIZONTAL,0,255,0);
      	sliderAzul.setMajorTickSpacing(255);
      	sliderAzul.setMinorTickSpacing(0);
      	sliderAzul.setPaintTicks(true);
      	sliderAzul.setPaintLabels(true);
      	
      	setting = new GridBagConstraints();
        setting.gridy = 8;
        setting.fill = GridBagConstraints.HORIZONTAL;
        panelIzq.add(sliderAzul, setting);
        
        //Panel
        panelColor = new JPanel();
        
        setting = new GridBagConstraints();
        panelColor.setBackground(Color.GRAY);
        panelColor.setBorder(new LineBorder(Color.BLACK));
        setting.gridy = 9;
        setting.ipady = 20;
        setting.fill = GridBagConstraints.HORIZONTAL;
        panelIzq.add(panelColor, setting);
        
        //Boton
        botonAceptar = new JButton("Aceptar");
        
        setting = new GridBagConstraints();
        setting.gridy = 10;
        setting.ipady = 20;
        setting.fill = GridBagConstraints.HORIZONTAL;
        panelIzq.add(botonAceptar, setting);
       
        // --- PANEL DERECHO ---
        
        settings = new GridBagConstraints();
		panelDer.setBackground(Color.WHITE);
		panelDer.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		settings.gridx = 1;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelDer, settings);
		
		texto = new JTextArea("Lorem Ipsum is simply dummy text of "
				+ "\nthe printing and typesetting industry. "
				+ "\nLorem Ipsum has been the industry's standard "
				+ "\ndummy text ever since the 1500s, "
				+ "\nwhen an unknown printer took a galley "
				+ "\nof type and scrambled it to make a type specimen book. "
				+ "\nLorem Ipsum is simply dummy text of "
				+ "\nthe printing and typesetting industry. "
				+ "\nLorem Ipsum has been the industry's standard "
				+ "\ndummy text ever since the 1500s, "
				+ "\nwhen an unknown printer took a galley "
				+ "\nof type and scrambled it to make a type specimen book. "
				+ "\nLorem Ipsum is simply dummy text of "
				+ "\nthe printing and typesetting industry. "
				+ "\nLorem Ipsum has been the industry's standard "
				+ "\ndummy text ever since the 1500s, "
				+ "\nwhen an unknown printer took a galley "
				+ "\nof type and scrambled it to make a type specimen book. ");
		settings.ipadx = 20;
		settings.ipady = 20;
		settings.weightx = 5;
		texto.setEditable(false);
		panelDer.add(texto, settings);
		
		botonAceptar.addActionListener(this);
        sliderRojo.addChangeListener(this);
        sliderVerde.addChangeListener(this);
        sliderAzul.addChangeListener(this);
		
		
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		int red = sliderRojo.getValue();
        int green = sliderVerde.getValue();
        int blue = sliderAzul.getValue();
        colorSeleccionado = new Color(red, green, blue);
        panelColor.setBackground(colorSeleccionado);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Color colorFondo() {
		Color color;
		color = panelColor.getBackground();
		return color;
	}
	
	public void inicializarListeners() {
		
			botonAceptar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					texto.setForeground(colorFondo());
				}
			});
		
	}

	/**
	 * MÈtodo que realiza todas las llamadas necesarias para inicializar la ventana
	 * correctamente.
	 */
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}



}
