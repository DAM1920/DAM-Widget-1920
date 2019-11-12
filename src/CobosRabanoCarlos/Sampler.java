package CobosRabanoCarlos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Sampler {
	JFrame ventana;
	
	//panel de los botones y los botones
	JPanel panelBotones;
	BotonSampler[][] botones;
	
	//Array con las direcciones de los sonidos para asignarlos a los botones
	String[] txtSonidos;
	
	JMenuBar barraMenu;
	JMenu menuArchivo;
	JMenuItem itemGuardar;
	JMenuItem itemAbrir;
	
	
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
				botones=Utilidades.cargarSampler(botones, ventana);
				ventana.revalidate();
				ventana.repaint();
				
			}
		});
	}

	public void inicializar() {
		//Añadimos un panel con los 16 botones
		panelBotones=new JPanel();
		ventana.add(panelBotones);
		panelBotones.setLayout(new GridBagLayout());
		GridBagConstraints settings;
		botones=new BotonSampler[4][4];
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j]=new BotonSampler();
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
		
		//Colocamos la barra de menú
		barraMenu=new JMenuBar();
		ventana.setJMenuBar(barraMenu);
		menuArchivo=new JMenu("Archivo");
		itemGuardar=new JMenuItem("Guardar sampler");
		itemAbrir=new JMenuItem("Abrir fichero");		
		barraMenu.add(menuArchivo);
		menuArchivo.add(itemGuardar);
		menuArchivo.add(itemAbrir);
		
		
		ventana.setVisible(true);
		
	}
}
