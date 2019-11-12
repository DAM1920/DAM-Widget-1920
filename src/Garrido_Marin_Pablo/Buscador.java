package Garrido_Marin_Pablo;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Buscador extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JTextField texto;
	JButton boton;
	Color colorFondo = Color.WHITE;
	VentanaPrincipal vp;
	public Buscador(VentanaPrincipal vp) {
		this.vp = vp;
		this.setBounds(0, 0, 600, vp.ventana.getBounds().height-40);
		this.setLayout(new GridBagLayout());
		this.setBackground(colorFondo);
		texto = new JTextField();
		GridBagConstraints settings = new GridBagConstraints();
		settings.weightx = 10;
		settings.fill = GridBagConstraints.BOTH;
		this.add(texto, settings);
		ImageIcon icono = new ImageIcon("google.png");
		boton = new JButton(icono);
		boton.setBorder(null);
		boton.setBackground(this.getBackground());
		this.add(boton);
		addActionListenners();
	}
	
	public void addActionListenners() {
		texto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boton.requestFocusInWindow();
				
			}
		});
		
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goToURL("https://www.google.com/search?q="+texto.getText().replaceAll("\\s", "+"));
				
			}
		});
		
		boton.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					goToURL("https://www.google.com/search?q="+texto.getText().replaceAll("\\s", "+"));
					
				}
				
			}
		});
	}
	
	public void goToURL(String URL) {
		if (java.awt.Desktop.isDesktopSupported()) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
				try {
					java.net.URI uri = new java.net.URI(URL);
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex) {
					
				}
			}
		}
	}

}
