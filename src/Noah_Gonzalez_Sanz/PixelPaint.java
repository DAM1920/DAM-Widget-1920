package Noah_Gonzalez_Sanz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class PixelPaint extends JPanel {
	
	JPanel panelSelectorColor;
	JPanel [][] lienzo;
	JPanel panelPixel;
	JButton botonNegro;
	JButton botonAzul;
	JButton botonVerde;
	JButton botonRojo;
	JButton botonAmarillo;
	JButton botonNuevoColor;
	JButton reset;
	JButton rellenar;
	JLabel texto;
	JLabel opc;
	Color colorPaint = Color.BLACK;
	MiMouse listener;
	
	public PixelPaint() {
		añadirElementos();
		inicializarListener();
	}
	/**
	 * Inicializamos los paneles
	 */
	public void añadirElementos() {
		
		this.setLayout(new GridBagLayout());
		
		// Panel SeleccionColor
		panelSelectorColor = new JPanel();
		panelSelectorColor.setLayout(new GridBagLayout());
		panelSelectorColor.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, Color.CYAN));
		añadirBotones();

		// Panel Pixel
		panelPixel = new JPanel();
		panelPixel.setLayout(new GridLayout(20, 20));
		añadirLienzo();

	}

	/**
	 * Añadimos al panelPixel la matriz de paneles
	 */
	public void añadirLienzo() {
		GridBagConstraints setting = new GridBagConstraints();
		lienzo = new JPanel[20][20];
		for (int i = 0; i < lienzo.length; i++) {
			for (int j = 0; j < lienzo[i].length; j++) {
				lienzo[i][j] = new JPanel();
				setting.gridx = i;
				setting.gridy = j;
				setting.ipadx = 45;
				setting.ipady = 45;
				setting.fill = GridBagConstraints.BOTH;
				lienzo[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panelPixel.add(lienzo[i][j], setting);
			}
		}
		setting = new GridBagConstraints();
		setting.weightx = 1;
		setting.weighty = 1;
		setting.fill = GridBagConstraints.BOTH;
		this.add(panelPixel, setting);

	}

	/**
	 * Añadimos al panelSelectorColor , los botones y el label
	 */
	public void añadirBotones() {
		GridBagConstraints setting = new GridBagConstraints();
		Font font = new Font("Agency FB", Font.BOLD, 20);
		
		// Label
		texto = new JLabel("Seleccion de Colores");
		texto.setFont(font);
		texto.setForeground(Color.DARK_GRAY);
		setting.gridx = 0;
		setting.gridy = 2;
		panelSelectorColor.add(texto, setting);

		// **Botones

		// Negro
		botonNegro = new JButton();
		botonNegro.setBackground(Color.BLACK);
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 4;
		setting.ipady = 25;
		setting.ipadx = 25;
		setting.insets = new Insets(20, 20, 20, 20);
		panelSelectorColor.add(botonNegro, setting);

		// Azul
		botonAzul = new JButton();
		botonAzul.setBackground(Color.BLUE);
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 5;
		setting.ipady = 25;
		setting.ipadx = 25;
		panelSelectorColor.add(botonAzul, setting);

		// Verde
		botonVerde = new JButton();
		botonVerde.setBackground(Color.GREEN);
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 6;
		setting.ipady = 25;
		setting.ipadx = 25;
		setting.insets = new Insets(20, 20, 20, 20);
		panelSelectorColor.add(botonVerde, setting);

		// Rojo
		botonRojo = new JButton();
		botonRojo.setBackground(Color.RED);
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 7;
		setting.ipady = 25;
		setting.ipadx = 25;
		panelSelectorColor.add(botonRojo, setting);

		// Amarillo
		botonAmarillo = new JButton();
		botonAmarillo.setBackground(Color.YELLOW);
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 8;
		setting.ipady = 25;
		setting.ipadx = 25;
		setting.insets = new Insets(20, 20, 20, 20);
		panelSelectorColor.add(botonAmarillo, setting);

		// BotonNuevoColor
		botonNuevoColor = new JButton("Elije otro Color");
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 9;
		panelSelectorColor.add(botonNuevoColor, setting);
		
		// **Opciones
		
		// Label
		opc = new JLabel("Opciones");
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 0;
		opc.setFont(font);
		panelSelectorColor.add(opc,setting);
		
		// Resetear Lienzo
		reset = new JButton("Reset");
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 1;
		setting.insets = new Insets(30, 30, 30, 30);
		setting.anchor = GridBagConstraints.WEST;
		reset.setFont(font);
		panelSelectorColor.add(reset,setting);
		
		// Rellenar Lienzos
		rellenar = new JButton("Rellenar");
		setting = new GridBagConstraints();
		setting.gridx = 1;
		setting.gridy = 1;
		rellenar.setFont(font);
		panelSelectorColor.add(rellenar,setting);
		
		// Añadir PanelSelectorColor
		setting = new GridBagConstraints();
		setting.weightx = 1;
		setting.weighty = 1;
		setting.fill = GridBagConstraints.BOTH;
		this.add((new JScrollPane(panelSelectorColor)), setting);
	}
	/**
	 * Inicializamos los listeners de los botones.
	 */
	public void inicializarListener() {

		for (int i = 0; i < lienzo.length; i++) {
			for (int j = 0; j < lienzo[i].length; j++) {
				lienzo[i][j].addMouseListener(new MiMouse(this, i, j));
			}
		}

		botonNuevoColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(null, "Selecciona un color", colorPaint);
				if (c != null) {
					colorPaint = c;
				}
			}
		});

		botonAmarillo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				colorPaint = ((Component) e.getSource()).getBackground();
			}
		});

		botonNegro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				colorPaint = ((Component) e.getSource()).getBackground();

			}
		});
		
		botonVerde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorPaint = ((Component) e.getSource()).getBackground();
			}
		});
		
		botonRojo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorPaint = ((Component) e.getSource()).getBackground();
			}
		});
		
		botonAzul.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorPaint = ((Component) e.getSource()).getBackground();
			}
		});
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < lienzo.length; i++) {
					for (int j = 0; j < lienzo[i].length; j++) {
						lienzo[i][j].setBackground(Color.WHITE);
						lienzo[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
				}
			}
		});
		
		rellenar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < lienzo.length; i++) {
					for (int j = 0; j < lienzo[i].length; j++) {
						lienzo[i][j].setBackground(colorPaint);
						lienzo[i][j].setBorder(BorderFactory.createLineBorder(colorPaint));
					}
				}
			}
		});
	}
}
