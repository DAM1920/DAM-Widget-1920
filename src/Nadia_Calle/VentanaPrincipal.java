package Nadia_Calle;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaPrincipal  {
	
	JFrame ventana;
	Cambio cambio;
	
    
    
    	
	// Constructor, marca el tamaño y el cierre del frame
	public VentanaPrincipal() {
		cambio = new Cambio();
		ventana = new JFrame();
		ventana.add(cambio);
		ventana.setBounds(0,0,900,500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

	public void inicializarComponentes() {
		
        
	}

}
