package Garcia_Hernandez_Sergio;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JLectorTweets extends JPanel{

	private JTextField textFieldNombreUsuario;
	private JButton botonMostrarTweets;
	private JLabel panelTweets;
	
	public JLectorTweets() {
		super();	// Creación del panel
		// Color de fondo
		setBackground(new Color(150, 250, 250));
		
		// Borde azul oscuro, ancho 3 y sin redondear
		setBorder(BorderFactory.createLineBorder(new Color(0, 180, 180), 3, false));
		
		// Inicializamos el JLabel y cambiamos el estilo de letra
		setLayout(new GridBagLayout());
		
		// Metemos el JLabel
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		add(new JLabel("Usuario:    @"), settings);
		
		// Metemos el textFieldNombreUsuario
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.fill = GridBagConstraints.HORIZONTAL;
		textFieldNombreUsuario = new JTextField();
		add(textFieldNombreUsuario, settings);
		
		// Añadimos el botón
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.gridwidth = 2;
		settings.fill = GridBagConstraints.NONE;
		botonMostrarTweets = new JButton("Mostrar Tweets");
		add(botonMostrarTweets, settings);
		
		// Añadimos el panel donde se mostrarán los tweets
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		settings.gridwidth = 2;
		panelTweets = new JLabel("PANEL QUE MUESTRA LOS TWEETS");
		add(panelTweets, settings);
	}
	
}
