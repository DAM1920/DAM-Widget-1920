
package Garrido_Marin_Pablo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author pgarridom01
 *
 */
public class Buscador extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Variable donde introduzco el texto que quiero buscar
	JTextField texto;
	// Boton para ir a la busqueda
	JButton boton;
	// Lista de ultimas busquedas
	JComboBox<String> opciones;
	// Color de fondo del widget
	Color colorFondo = Color.DARK_GRAY;
	// Color de la letra
	Color colorLetra = Color.WHITE;
	// Fuente del widget
	Font fuente = new Font("Arial", Font.BOLD, 16);
	// URL inicial del buscador
	String url = "https://www.google.com/search?q=";

	/**
	 * Constructor Establezco el tama�o, el layaout, el color de fondo e inicializo
	 * los componentes y los listenners
	 */
	public Buscador() {
		this.setSize(600, 40);
		this.setLayout(new GridBagLayout());
		this.setBackground(colorFondo);
		inicializarComponentes();
		addActionListenners();
	}

	/**
	 * Metodo donde inicializo los componentes
	 */
	public void inicializarComponentes() {
		// Creo el boton con el icono y lo a�ado al panel
		ImageIcon icono = new ImageIcon("img/google.png");
		boton = new JButton(icono);
		boton.setBorder(null);
		boton.setBackground(this.getBackground());
		this.add(boton);
		// Creo el JTextField y lo a�ado al panel
		texto = new JTextField();
		texto.setBackground(colorFondo);
		texto.setBorder(null);
		texto.setFont(fuente);
		texto.setForeground(colorLetra);
		GridBagConstraints settings = new GridBagConstraints();
		settings.weightx = 1;
		settings.fill = GridBagConstraints.BOTH;
		this.add(texto, settings);
		// Llamo al metodo para inicializar el ComboBox
		iniciliazarComboBox();

	}

	/**
	 * Metodo para inicializar el ComboBox con las ultimas busquedas
	 */
	public void iniciliazarComboBox() {
		opciones = new JComboBox<String>();
		opciones.setFont(fuente);
		opciones.setForeground(colorLetra);
		opciones.setBackground(Color.GRAY);
		// Creo un arrayList leyendo el fichero donde guardo las busquedas
		ArrayList<String> busquedas = leerFichero();
		
		// Elimino las busquedas que se repiten despues y dejo la ultima vez que fueron buscadas
		for (int i = 0; i < busquedas.size(); i++) {
			for (int j = i+1; j < busquedas.size(); j++) {
				if (busquedas.get(i).equalsIgnoreCase(busquedas.get(j))) {
					busquedas.remove(i);
				}
			}
		}		
		
		// Recorro el arrayList al reves para a�adir primero las ultimas busquedas
		for (int i = busquedas.size() - 1; i >= busquedas.size()-5; i--) {
			opciones.addItem(busquedas.get(i));
		}
		// Pongo el indice -1 como seleccionado para que no me muestre ninguna opcion al
		// iniciarlo
		opciones.setSelectedIndex(-1);
		this.add(opciones);
	}

	/**
	 * Metodo donde a�ado la busqueda al fichero
	 * 
	 * @param texto String con la busqueda que voy a realizar
	 */
	public void crearFichero(String texto) {
		File fich = new File("txt/busqueda.txt");
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fich, true));
			pw.println(texto);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo donde leo el fichero de busquedas
	 * 
	 * @return ArrayList con todas las busquedas que he realizado
	 */
	public ArrayList<String> leerFichero() {
		File fich = new File("txt/busqueda.txt");
		ArrayList<String> busquedas = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fich));
			String linea;
			while ((linea = br.readLine()) != null) {
				busquedas.add(linea);
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return busquedas;
	}

	/**
	 * Metodo para implementar los listener del boton y del ComboBox
	 */
	public void addActionListenners() {
		// Listener del texto para al pulsar ENTER ir a la busqueda
		texto.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					crearFichero(texto.getText());
					irURL(url + texto.getText().replaceAll("\\s", "+"));
					texto.setText("");
				}

			}
		});
		// Listener del ComboBox
		opciones.addActionListener(e -> {
			texto.setText(opciones.getSelectedItem().toString());
			irURL(url + texto.getText().replaceAll("\\s", "+"));
			texto.setText("");
		});
		// Listener para cuando pulso el boton
		boton.addActionListener(e -> {
			crearFichero(texto.getText());
			irURL(url + texto.getText().replaceAll("\\s", "+"));
			texto.setText("");
		});
	}

	/**
	 * Metodo para ir a la URL de la busqueda en una nueva ventana
	 * 
	 * @param URL url del buscador de google mas lo que quiero buscar
	 */
	public void irURL(String url) {
		JFrameWindow window = new JFrameWindow(url);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}

}

