package Garcia_Hernandez_Sergio;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class JLectorTweets extends JPanel {

	private JTextField textFieldNombreUsuario;
	private JButton botonMostrarTweets;
	private JTextArea[] panelTweets;

	public JLectorTweets() {
		super(); // Creación del panel
		// Color de fondo
		setBackground(new Color(43, 196, 255));

		// Borde azul oscuro, ancho 3 y sin redondear
		setBorder(BorderFactory.createLineBorder(new Color(25, 25, 25), 3, false));

		// Inicializamos el JLabel y cambiamos el estilo de letra
		setLayout(new GridLayout(8, 1));

		// Metemos el JLabel
		add(new JLabel("Nombre del usuario (sin @)"));

		// Metemos el textFieldNombreUsuario
		textFieldNombreUsuario = new JTextField();
		add(textFieldNombreUsuario);

		// Añadimos el botón
		botonMostrarTweets = new JButton("Mostrar Tweets");
		add(botonMostrarTweets);
		
		panelTweets = new JTextArea[5];
		
		for (int i=0; i<5; i++) {
			panelTweets[i] = new JTextArea();
			panelTweets[i].setEditable(false);
			panelTweets[i].setLineWrap(true);
			panelTweets[i].setBackground(new Color(204, 246, 255));
			panelTweets[i].setBorder(BorderFactory.createLineBorder(new Color(0, 255, 255)));
			add(panelTweets[i]);
		}

		
		
		// Inicializamos los listeners
		inicializarListeners();
	}

	public void inicializarListeners() {
		botonMostrarTweets.addActionListener((e) -> {
			Twitter twitter = getObjetoTwitter();
			Status tweet;
			
			try {				
				String user = textFieldNombreUsuario.getText();
				
				List<Status> listaTweets = twitter.getUserTimeline(user); 
				
				int tamano = Math.min(listaTweets.size(), 5);
				
				// Añadimos el panel donde se mostrarán los tweets
				//panelTweets = new JTextArea[tamano];
				
				for (int i=0; i<tamano; i++) {					
					// Almacenamos toda la info relativa al tweet
					tweet = listaTweets.get(i);	
					
					//panelTweets[i].add(new JLabel(listaTweets.get(i).getText()));
					panelTweets[i].setText(tweet.getText());
					
					
//					tweet = "@" + listaTweets.get(i).getUser().getScreenName() + " - "
//							+ listaTweets.get(i).getText() + "\n";
//					cadenaTweets += tweet + "\n";
				}
				
			} catch (TwitterException te) {
				te.printStackTrace();
				//cadenaTweets = ("No se pudo obtener timeline: " + te.getMessage());
			} finally {
				//panelTweets.setText(cadenaTweets);
			}
			
			
		}); // FIN LISTENER BOTÓN
	}

	/**
	 * Obtiene un objeto de la clase Twitter.
	 * @return Objeto de la clase Twitter
	 */
	private Twitter getObjetoTwitter() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("bnOzzlRNvqx7a2fTcJZX7pH07")
				.setOAuthConsumerSecret("qlj9bOXxXcYY8LbGvX4qKNTlKcTQQRCy9NtPlp7ejB6au3Y99A")
				.setOAuthAccessToken("378087758-EVDCoy1FIOqr0ca1VFvjGXj0s9uIA9A7Mql45MBo")
				.setOAuthAccessTokenSecret("FzePaRdHx7tZ1aTXAptiGwoJg4akyqd3ijPcm9u4hG9GI");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		return twitter;
	}
		
	/**
	 * Refresca los componentes de la pantalla
	 */
	private void refrescarPantalla() {
		revalidate();
		repaint();
	}
}
