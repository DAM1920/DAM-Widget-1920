package PedroLuis_Rodriguez_Perez;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 * Clase formulario, donde tendremos un tabbedPane donde lo dividiremos en un panel formulario y un panel visor de ficheros CSV.
 * @author Pedro Luis
 *
 */
public class Formulario extends JPanel {	
	JPanel formulario; //Panel formulario.
	JLabel[] etiquetas; //JLabels del formulario.
	JTextField[] cuadrosDeTexto;//JText del formulario.
	JButton almacenar;
	
	JPanel visor; //Panel visor de fichero.
	JTable tabla; //Tabla donde guardo los datos.
	DefaultTableModel model = new DefaultTableModel();
	
	JTabbedPane panelTabbed; //Contenedor donde meto el formulario y el visor
	
	File ficheroCSV; //Fichero CSV con el que trabajo.
	ArrayList<String> atributos;//Atributos del formulario

	public Formulario(File ficheroCSV) {		
		atributos = new ArrayList<String>();
		this.setLayout(new GridLayout());
		formulario = new JPanel();
		visor = new JPanel();
		formulario.setLayout(new GridBagLayout());
		tabla = new JTable(model);
		almacenar = new JButton("Almacenar");		
		this.ficheroCSV = ficheroCSV;		
		visor.setLayout(new GridLayout(1, 1));						
		volcarAtributos();
		aniadirColumas();
		aniadirValores();
		etiquetas = new JLabel[atributos.size()];
		cuadrosDeTexto = new JTextField[atributos.size()];
		for (int i = 0; i < atributos.size(); i++) {
			etiquetas[i]=new JLabel(atributos.get(i));
			cuadrosDeTexto[i]=new JTextField();
		}
		panelTabbed = new JTabbedPane();
		inicializarComponentes();
	}
	

	private void inicializarComponentes() {
		GridBagConstraints settings = new GridBagConstraints();

		// Formulario
		//formulario.setBorder(BorderFactory.createTitledBorder("Formulario"));
		formulario.setBorder(BorderFactory.createMatteBorder(20, 5, 5, 5, new Color(51, 102, 153)));
		formulario.setBackground(new Color(236, 242, 249));

		panelTabbed.addTab("Formulario", new JScrollPane(formulario));

		// Visor
		visor.setBorder(BorderFactory.createTitledBorder("Visor"));
		visor.setBackground(new Color(216, 229, 237));
		tabla.setBackground(new Color(216, 229, 237));

		visor.add(new JScrollPane(tabla));
		
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		panelTabbed.addTab("Visor del Fichero", new JScrollPane(visor));

		this.add(panelTabbed);
		
		
		
		//Etiquetas y los cuadros de Texto

		settings = new GridBagConstraints();
		settings.insets = new Insets(0, 0, 40, 0);
		//settings.fill = GridBagConstraints.BOTH;

		for (int i = 0; i < atributos.size(); i++) {
			settings.gridx = 0;
			settings.gridy = i;
			settings.weightx = 1;
			settings.ipadx = 100;
			etiquetas[i].setForeground(new Color(136, 61, 29));
			etiquetas[i].setFont(etiquetas[i].getFont().deriveFont(Font.BOLD, 14f));
			formulario.add(etiquetas[i], settings);

			settings.gridx = 1;
			settings.gridy = i;
			settings.weightx = 1;
			formulario.add(cuadrosDeTexto[i], settings);
		}

		// Boton almacenar

		settings = new GridBagConstraints();

		settings.gridy = atributos.size();
		settings.insets = new Insets(50, 0, 0, 0);
		settings.gridwidth = 2;
		formulario.add(almacenar, settings);

		almacenar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String values[] = new String[cuadrosDeTexto.length];
				boolean compCamposVacios = false;
				String cadena = "";
				
				for (int j = 0; j < values.length; j++) { // Almaceno los valorees y compruebo, que no esten vacios
					values[j] = cuadrosDeTexto[j].getText();
					cadena += values[j] + ",";
					if (cuadrosDeTexto[j].getText().equals("")) {
						compCamposVacios = true;
					}
				}
				

				if (compCamposVacios) { //Si esta vacio muestro un mensaje de error.
					JOptionPane.showMessageDialog(panelTabbed, "Todos los campos deben estar rellenos");
				} 
				else { // Si todos los campos estan rellenos
					escribirEnfichero(cadena);
					System.out.println(cadena);
					model.addRow(values);
				}

				refrescarPantalla();
			}

		});
	}

	private void escribirEnfichero(String cadena) {

		try {
			FileWriter fw = new FileWriter(ficheroCSV, true);
			PrintWriter pw = new PrintWriter(fw);

			pw.println(cadena);
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	private void aniadirColumas() {
		for (int i = 0; i < atributos.size(); i++) {
			model.addColumn(atributos.get(i));
		}		
		
	}
	private void aniadirValores() {
		FileReader fr = null;
		BufferedReader br = null;
		String linea;
		String[] aux;
		try {
			fr = new FileReader(ficheroCSV);
			br = new BufferedReader(fr);

			aux = br.readLine().split(",");
			while ((linea = br.readLine()) != null) {
				aux = linea.split(",");
				model.addRow(aux);
			}

			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void volcarAtributos() {
		FileReader fr = null;
		BufferedReader br = null;
		String linea;
		String[] aux;
		try {
			fr = new FileReader(ficheroCSV);
			br = new BufferedReader(fr);

			aux = br.readLine().split(",");

			for (int i = 0; i < aux.length; i++) {
				atributos.add(aux[i]);
			}

			br.close();
		} catch (Exception e) {
			System.out.println("error");
		}

	}

	private void refrescarPantalla() {
		this.revalidate();
		this.repaint();

	}
}
