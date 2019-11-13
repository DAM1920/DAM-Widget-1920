package Noah_Gonzalez_Sanz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PixelPaint extends JPanel{
	JPanel panelSelectorColor;
	JPanel [][] lienzo;
	JPanel panelPixel;
	JButton botonNegro;
	JButton botonAzul;
	JButton botonVerde;
	JButton botonRojo;
	JLabel texto;
	
	/**
	 * Inicializamos los paneles
	 */
	public void añadirElementos() {
		this.setLayout(new GridBagLayout());
		//Panel SeleccionColor
		panelSelectorColor = new JPanel();
		panelSelectorColor.setLayout(new GridBagLayout());
		panelSelectorColor.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, Color.CYAN));
		añadirBotones();
		
		//Panel Pixel
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
		setting.weightx = 5;
		setting.weighty = 5;
		setting.fill = GridBagConstraints.BOTH;
		this.add(panelPixel, setting);
		
	}
	/**
	 * Añadimos al panelSelectorColor , los botones y el label
	 */
	public void añadirBotones() {
		GridBagConstraints setting = new GridBagConstraints();
		//Label
		Font font = new Font("Agency FB", Font.BOLD, 20);
		texto = new JLabel("Seleccion de Colores");
		texto.setFont(font);
		texto.setForeground(Color.DARK_GRAY);
		setting.gridx = 0;
		setting.gridy = 0;
		panelSelectorColor.add(texto,setting);
		
	//**Botones
		
		//Negro
		botonNegro = new JButton();
		botonNegro.setBackground(Color.BLACK);
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 2;
		setting.ipady = 25;
		setting.ipadx = 25;
		setting.insets = new Insets(20, 20, 20, 20);
		panelSelectorColor.add(botonNegro,setting);
		
		//Azul
		botonAzul = new JButton();
		botonAzul.setBackground(Color.BLUE);
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 3;
		setting.ipady = 25;
		setting.ipadx = 25;
		panelSelectorColor.add(botonAzul,setting);
		
		//Verde
		botonVerde = new JButton();
		botonVerde.setBackground(Color.GREEN);
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 4;
		setting.ipady = 25;
		setting.ipadx = 25;
		setting.insets = new Insets(20, 20, 20, 20);
		panelSelectorColor.add(botonVerde,setting);
		
		//Rojo
		botonRojo = new JButton();
		botonRojo.setBackground(Color.RED);
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 5;
		setting.ipady = 25;
		setting.ipadx = 25;
		panelSelectorColor.add(botonRojo,setting);
		
		//Añadir PanelSelectorColor
		setting = new GridBagConstraints();
		setting.weightx = 1;
		setting.weighty = 1;
		setting.fill = GridBagConstraints.BOTH;
		this.add(panelSelectorColor,setting);
			
	}
	
	public void iniciarlizarListener() {
		
		botonNegro.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				for (int i = 0; i < lienzo.length; i++) {
					for (int j = 0; j < lienzo[i].length; j++) {
						lienzo[i][j].setBackground(Color.red);
					}
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}

}
