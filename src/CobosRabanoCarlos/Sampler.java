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

public class Sampler {
	JFrame ventana;
	
	JLabel titulo;
	
	//panel de los botones y los botones
	JPanel panelBotones;
	BotonSampler[][] botones;
	
	//Array con las direcciones de los sonidos para asignarlos a los botones
	String[] txtSonidos;
	
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
		settings.ipadx=60;
		settings.ipady=5;
		settings.fill=GridBagConstraints.BOTH;
		titulo=new JLabel("SAMPLER");
		titulo.setOpaque(true);
		titulo.setBackground(Color.BLACK);
		titulo.setForeground(new Color(137, 143, 156));
		titulo.setFont(new Font("Tahoma", Font.BOLD, 42));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ventana.add(titulo, settings);
		
		//Añadimos un panel con los 16 botones
		settings=new GridBagConstraints();
		settings.gridx=0;
		settings.gridy=1;
		settings.weightx=1;
		settings.weighty=4;
		settings.fill=GridBagConstraints.BOTH;
		panelBotones=new JPanel();
		panelBotones.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ventana.add(panelBotones, settings);
		panelBotones.setLayout(new GridBagLayout());
		botones=new BotonSampler[4][4];
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j]=new BotonSampler();
				botones[i][j].setFocusPainted(false);
				botones[i][j].setBackground(new Color(59, 89, 182));
				botones[i][j].setFont(new Font("Tahoma", Font.BOLD, 12));
				botones[i][j].setForeground(Color.WHITE);
				botones[i][j].setFichero(new File("./sonidos/ringtones-super-mario-bros.mp3"));
				botones[i][j].setSonido(new ReproduccionSonido(botones[i][j].getFichero(), botones[i][j]));
				botones[i][j].setDescripcion("mario");
				settings=new GridBagConstraints();
				settings.gridx=i;
				settings.gridy=j;
				settings.insets=new Insets(20, 20, 20, 20);
				settings.fill=GridBagConstraints.BOTH;
				settings.weightx=1;
				settings.weighty=1;
				panelBotones.add(botones[i][j], settings);
			}
		}
		
		//Colocamos la barra de menï¿½
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

	public BotonSampler[][] getBotones() {
		return botones;
	}

	public void setBotones(BotonSampler[][] botones) {
		this.botones = botones;
	}
}
