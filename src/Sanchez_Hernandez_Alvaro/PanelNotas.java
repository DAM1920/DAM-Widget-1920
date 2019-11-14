package Sanchez_Hernandez_Alvaro;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;


public class PanelNotas extends JDialog {

	private static final long serialVersionUID = 5266212298815899686L;
	private GridBagLayout layout;
	private JButton guardar;
	private JButton cerrar;
	private JButton limpiar;
	private JTextArea texto;
	private GridBagConstraints settings;
	
	
	//Constructor
	public PanelNotas() {
		super();
		this.setBounds(0, 0, 500, 600);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		inicializarComponentes();
		inicializarListeners();
	}
	
	/**
	 * Inicializa Layout(GridBagLayout).
	 * Inicializa el cuadro de texto con sus Constraints.
	 * Inicializa los botones con sus Constraints.
	 */
	public void inicializarComponentes() {
		
		//Inicializamos el layout
		layout = new GridBagLayout();
		this.setLayout(layout);
		
		//Inicializamos JTextArea con sus settings.
		settings = new GridBagConstraints();
		settings.gridy=0;
		settings.gridwidth=3;
		settings.weighty=8;
		settings.fill = GridBagConstraints.BOTH;
		texto = new JTextArea();
		texto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(texto, settings);
		
		//Inicializamos boton guardar.
		settings = new GridBagConstraints();
		settings.gridy=1;
		settings.gridx=0;
		settings.weighty=1;
		settings.weightx=1;
		settings.fill=GridBagConstraints.BOTH;
		
		guardar = new JButton("Guardar");
		guardar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(guardar, settings);
		
		//Inicializamos Boton Limpiar.
		settings = new GridBagConstraints();
		settings.gridy=1;
		settings.gridx=1;
		settings.weightx=1;
		settings.weighty=1;
		settings.fill=GridBagConstraints.BOTH;
		
		limpiar = new JButton("Limpiar");
		limpiar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(limpiar, settings);
		
		//Inicializamos Boton cerrar
		settings = new GridBagConstraints();
		settings.gridy=1;
		settings.gridx=2;
		settings.weighty=1;
		settings.weightx=1;
		settings.fill=GridBagConstraints.BOTH;
		
		cerrar = new JButton("Cerrar");
		cerrar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(cerrar, settings);
	}
	
	
	/**
	 * Si el usuario quiere guardar el fichero llamara a guardarFichero().
	 * Esté método siempre cierra el JDialog.
	 * En caso de que el usuario no haya escrito nada,no se preguntará si quiere guardar el fichero.
	 */
	public void cerrarVentana() {
		if(!texto.getText().isEmpty()) {
			int guardar = eleccion();
			if(guardar!=1) {
			guardarFichero();
			}
		}
		this.dispose();
	}
	
	/**
	 * Pregunta al usuario si desea guardar el texto en el fichero antes de borrarlo o cerrar el panel.
	 * @return: devuelve la elección del usuario. 0 si quiere guardar el fichero,1 si no quiere.
	 */
	public int eleccion() {
		return JOptionPane.showConfirmDialog(this, "¿Desea guardar la información del fichero antes de borrar?", "Guardar  fichero", 0);
	}
	
	/**
	 * Si el usuario pulsa que si en el metodo eleccion() guarda el fichero y quita el texto al TextArea.
	 * En caso de que el usuario no quiera guardar los datos simplemente cambia el fichero de texto.
	 * Comprueba que el campo de texto esta vacio para no preguntar.
	 */
	public void limpiarVentana() {
		if(!texto.getText().isEmpty()) {
			int guarda = eleccion();
			if(guarda!=1) {
				guardarFichero();
				texto.setText("");
			}else {
				texto.setText("");
			}
		}
	}
	/**
	 * 
	 * @param pw Objeto PrintWriter para escribir en el fichero.
	 * Obtiene el texto del JTextField pasandolo a una variable y el printWriter lo escribe en el fichero.
	 */
	public void escribirFichero(PrintWriter pw) {
		String text = texto.getText();
		pw.write(text);
	}
	/**
	 * Este método pide el nombre del archivo y creara un directorio en la ruta de nuestro programa.
	 * Declara los writer para escribir en el fichero.
	 */
	public void guardarFichero() {
		//Pedimos nombre del fichero.
		String nombre  = JOptionPane.showInputDialog("Introduce el nombre del fichero")+".txt";
		//Declaramos el lugar donde se va a guardar
		File directorio = new File("Notas");
		File archivo = new File(directorio,nombre);
		if(!directorio.exists()) {
			directorio.mkdir();
		}
		
		try {
			//Declaramos los writer.
			FileWriter fw = new FileWriter(archivo);
			PrintWriter pw = new PrintWriter(fw);
			
			escribirFichero(pw);//Escribimos en el fichero
			pw.close(); //Cerramos flujo.
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
		
	}
	/**
	 * Inicializa los listeners para cada uno de los botones.
	 */
	public void inicializarListeners() {
		
		//Listener de boton cerrar.
		cerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVentana();
			}
		});
		
		//Listener de boton Limpiar.
		limpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarVentana();
			}
		});
		
		//Listener de Boton Guardar.
		guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardarFichero();	
			}
		});
		
	}

	
}
