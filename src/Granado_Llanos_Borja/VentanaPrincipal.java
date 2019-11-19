package Granado_Llanos_Borja;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class VentanaPrincipal {

	JFrame f;
	Font fuenteFinal;
	JTextPane panelWrite;
	JBotonFont miboton1, miboton2, miboton3;

	
	public VentanaPrincipal () {
		f= new JFrame();
		f.setLayout(new GridLayout(2,1));
		f.setBounds(100, 100, 350, 250);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void inicializar() {
		f.setVisible(true);
		inicializaComp();
	}
	private void inicializaComp() {
		
		miboton1= new JBotonFont();
		miboton2= new JBotonFont();
		miboton3= new JBotonFont();
		JPanel panel1 = new JPanel();
		panel1.add(miboton1);
		panel1.add(miboton2);
		panel1.add(miboton3);
		f.add(panel1);
		panelWrite= new JTextPane();
		
		f.add(panelWrite);
		
		miboton1.setTextArea(panelWrite);
		miboton2.setTextArea(panelWrite);
		miboton3.setTextArea(panelWrite);
		
		 
		
		
		
	}
} 