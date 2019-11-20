package CobosRabanoCarlos;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.sun.org.apache.xerces.internal.impl.RevalidationHandler;

/**
 * Es la clase a través de la que gestionaremos nuestro sampler
 * Contendrá una ventana con la interfaz
 * @author ccobosr02
 *
 */
public class Sampler {
	JFrame ventana;//Creamos una ventana
	
	JLabel titulo;//Un label para colocar un nombre al sampler
	
	//panel de los botones y los botones
	JPanel panelBotones;
	BotonSampler[][] botones;
	
	//Array con las direcciones de los sonidos para asignarlos a los botones
	String[] txtSonidos;
	
	//Una barra de menú donde ofreceremos varias opciones al usuario
	JMenuBar barraMenu;
	JMenu menuArchivo;
	JMenuItem itemGuardar;
	JMenuItem itemAbrir;
	JMenuItem itemSalir;
	
	
	public Sampler() {
		ventana = new JFrame();
		ventana.setBounds(100, 100, 700, 500);
		inicializar();
		inicializarListeners();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Colocamos un listener a los botones de la barra de menú
	 * Los botones del sampler ya implementan la interfaz MouseListener
	 */
	public void inicializarListeners() {
		itemGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				Utilidades.guardarSampler(botones);
				
			}
		});
		itemAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				Utilidades.cargarSampler(botones, ventana);	
				ventana.revalidate();
				ventana.repaint();
			}
		});
		itemSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				
			}
		});
	}

	public void inicializar() {
		GridBagConstraints settings;
		ventana.setLayout(new GridBagLayout());
		
		//Label de título
		settings=new GridBagConstraints();
		settings.gridx=0;
		settings.gridy=0;
		settings.weightx=1;
		settings.weighty=1;
		settings.insets=new Insets(10, 10, 10, 10);
		settings.fill=GridBagConstraints.BOTH;
		titulo=new JLabel("JSWING SAMPLER");
		titulo.setOpaque(true);
		titulo.setBackground(Color.BLACK);
		titulo.setForeground(new Color(137, 143, 156));
		titulo.setFont(new Font("Tahoma", Font.BOLD, 42));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		ventana.add(titulo, settings);
		
		//Añadimos un panel con los 16 botones
		settings=new GridBagConstraints();
		settings.gridx=0;
		settings.gridy=1;
		settings.weightx=1;
		settings.weighty=4;
		settings.insets=new Insets(10, 10, 10, 10);
		settings.fill=GridBagConstraints.BOTH;
		panelBotones=new JPanel();
		ventana.add(panelBotones, settings);
		panelBotones.setLayout(new GridLayout(4,4,5,5));
		botones=new BotonSampler[4][4];
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j]=new BotonSampler();
				botones[i][j].setFocusPainted(false);
				botones[i][j].setBackground(new Color(59, 89, 182));
				botones[i][j].setFont(new Font("Tahoma", Font.BOLD, 12));
				botones[i][j].setForeground(Color.WHITE);
				panelBotones.add(botones[i][j]);				
			}
		}
		
		//Colocamos la barra de menú
		barraMenu=new JMenuBar();
		ventana.setJMenuBar(barraMenu);
		menuArchivo=new JMenu("Archivo");
		itemGuardar=new JMenuItem("Guardar sampler");
		itemAbrir=new JMenuItem("Abrir sampler");
		itemSalir=new JMenuItem("Salir");
		barraMenu.add(menuArchivo);
		menuArchivo.add(itemAbrir);
		menuArchivo.add(itemGuardar);
		menuArchivo.add(itemSalir);
		
		
		ventana.setVisible(true);
		
	}

	/**
	 * Devuelve la matriz de botones
	 * @return
	 */
	public BotonSampler[][] getBotones() {
		return botones;
	}
}
