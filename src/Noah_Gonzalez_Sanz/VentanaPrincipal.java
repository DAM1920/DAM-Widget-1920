package Noah_Gonzalez_Sanz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPrincipal {
	JFrame marco;
	JPanel panelSelectorColor;
	JPanel [][] lienzo;
	JPanel panelPixel;
	JButton botonNegro;
	JButton botonAzul;
	JButton botonVerde;
	JButton botonRojo;
	JLabel texto;
	
	public VentanaPrincipal() {
		marco = new JFrame("Pixel Paint");
		marco.setBounds(0,0,900,600);
		marco.setLayout(new GridLayout(0,2));
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void añadirElementos() {
		// Añadir panel de seleccion de colores
		panelSelectorColor = new JPanel();
		panelSelectorColor.setBackground(Color.RED);
		marco.add(panelSelectorColor);
		
		//Añadir el panelPixel que encierra la matriz de paneles(lienzo)
		GridBagConstraints setting = new GridBagConstraints();
		panelPixel = new JPanel();
		panelPixel.setLayout(new GridBagLayout());
		lienzo = new JPanel[7][7];
		for(int i=0;i<lienzo.length;i++) {
			for(int j=0;j<lienzo[i].length;i++) {
				lienzo[i][j] = new JPanel();
				setting.gridx = i;
				setting.gridy = j;
				setting.fill = GridBagConstraints.BOTH;
				lienzo[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panelPixel.add(lienzo[i][j],setting);
			}
		}
		marco.add(panelPixel);
	}
	
	public void visible() {
		marco.setVisible(true);
	}

}
