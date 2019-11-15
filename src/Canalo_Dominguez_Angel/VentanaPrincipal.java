package Canalo_Dominguez_Angel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VentanaPrincipal {

	JFrame frame;//Frame donde se muestran los paneles y el reloj
	JPanel panelColores, panelFormato;//Paneles que muestran las opciones de color y de formato
	JReloj panelReloj;//Panel que muestra el reloj
	JRadioButton form1, form2, form3, horaForm1, horaForm2;//Opciones de color y de formato
	
	public VentanaPrincipal() {
		frame = new JFrame("RELOJ");
		frame.setBounds(600, 300, 900, 250);
		frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void inicializar() {
		frame.setVisible(true);
		inicializarComponentes();
		iniciarListeners();
	}
	
	public void inicializarComponentes() {
		frame.setLayout(new GridBagLayout());
		panelReloj=new JReloj();
		GridBagConstraints settingsObjeto = new GridBagConstraints();
		settingsObjeto.weightx=10;
		settingsObjeto.weighty=10;
		settingsObjeto.gridx=0;
		settingsObjeto.gridy=0;
		settingsObjeto.gridheight=2;
		settingsObjeto.fill=GridBagConstraints.BOTH;
		frame.add(panelReloj, settingsObjeto);
		
		panelColores=new JPanel(new GridLayout(3,1));
		panelColores.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		ButtonGroup botonesColor=new ButtonGroup();
		form1=new JRadioButton("Formato 1 (Números verdes sobre fondo negro)",true);
		form2=new JRadioButton("Formato 2 (Números rojos sobre fondo negro)");
		form3=new JRadioButton("Formato 3 (Números negros sobre fondo cian)");
		botonesColor.add(form1);
		botonesColor.add(form2);
		botonesColor.add(form3);
		panelColores.add(form1);
		panelColores.add(form2);
		panelColores.add(form3);
		settingsObjeto = new GridBagConstraints();
		settingsObjeto.ipadx=45;
		settingsObjeto.weighty=10;
		settingsObjeto.gridx=1;
		settingsObjeto.gridy=0;
		settingsObjeto.gridheight=1;
		settingsObjeto.fill=GridBagConstraints.BOTH;
		frame.add(panelColores, settingsObjeto);
		
		
		panelFormato=new JPanel(new GridBagLayout());
		panelFormato.setBorder(BorderFactory.createLineBorder(Color.RED,3));
		ButtonGroup botonesFormato=new ButtonGroup();
		horaForm1=new JRadioButton("Formato 12 Horas",true);
		horaForm2=new JRadioButton("Formato 24 Horas");
		botonesFormato.add(horaForm1);
		botonesFormato.add(horaForm2);
		panelFormato.add(horaForm1);
		panelFormato.add(horaForm2);
		settingsObjeto = new GridBagConstraints();
		settingsObjeto.ipadx=45;
		settingsObjeto.weighty=5;
		settingsObjeto.gridx=1;
		settingsObjeto.gridy=1;
		settingsObjeto.gridheight=1;
		settingsObjeto.fill=GridBagConstraints.BOTH;
		frame.add(panelFormato, settingsObjeto);
		
	}

	private void iniciarListeners() {
		frame.addWindowListener(new WindowListener() {
			
			public void windowOpened(WindowEvent e) {
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
			}
			
			@Override
			public void windowClosing(WindowEvent e) {//frame.dispose() cierra el frame
				panelReloj.parar();
				frame.dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {//frame.dispose() cierra el frame
				panelReloj.parar();
				frame.dispose();
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		form1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelReloj.setBackground(Color.BLACK);
				panelReloj.horaLabel.setForeground(Color.GREEN);
			}
		});
		form2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelReloj.setBackground(Color.BLACK);
				panelReloj.horaLabel.setForeground(Color.RED);
			}
		});
		form3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelReloj.setBackground(Color.CYAN);
				panelReloj.horaLabel.setForeground(Color.BLACK);
			}
		});
		horaForm1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelReloj.formato24=false;
			}
		});
		horaForm2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelReloj.formato24=true;
			}
		});
	}
}