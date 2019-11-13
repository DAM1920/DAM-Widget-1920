package PedroLuis_Rodriguez_Perez;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class Formulario extends JPanel {	
	JPanel formulario;
	JPanel visor;
	
	JTabbedPane panelTabbed;
	
	JLabel[] etiquetas;
	JTextField[] cuadrosDeTexto;
		
	JTable tabla;
	DefaultTableModel model = new DefaultTableModel(); 

	JButton almacenar;
	JButton cambiarVista;
	
	String [] atributos;

	public Formulario(String[] atributos) {
		this.setLayout(new GridLayout());
		this.atributos = atributos;
		formulario = new JPanel();
		formulario.setLayout(new GridBagLayout());		
		visor = new JPanel();
		visor.setLayout(new GridLayout(1,1));
		
		tabla = new JTable(model);
		for (int i = 0; i < atributos.length; i++) {
			model.addColumn(atributos[i]);
		}
		
				
		almacenar= new JButton("Almacenar");
		cambiarVista= new JButton("Cambiar vista-->");
		
		etiquetas = new JLabel[atributos.length];
		cuadrosDeTexto = new JTextField[atributos.length];
		
		for (int i = 0; i < atributos.length; i++) {
			etiquetas[i] = new JLabel(atributos[i]);
			cuadrosDeTexto[i] = new JTextField();
		}
		
		panelTabbed = new JTabbedPane();
		
		inicializarComponentes();
	}
	private void refrescarPantalla() {
		this.revalidate(); 
		this.repaint();
		
	}
	private void inicializarComponentes() {
		GridBagConstraints settings = new GridBagConstraints();
		
		
		
		// Formulario		
		formulario.setBorder(BorderFactory.createTitledBorder("Formulario"));
		formulario.setBackground(new Color(223,235,192));
		
		panelTabbed.addTab("Formulario",new JScrollPane(formulario));

		// Visor		
		visor.setBorder(BorderFactory.createTitledBorder("Visor"));
		visor.setBackground(new Color(216,229,237));
		tabla.setBackground(new Color(216,229,237));
		
		visor.add(new JScrollPane(tabla));
		
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		panelTabbed.addTab("Visor del Fichero",new JScrollPane(visor));
		
		
		this.add(panelTabbed);
		//Añado las etiquetas y los cuadros de Texto
		
		settings = new GridBagConstraints();		
		settings.insets = new Insets(0, 0, 40, 0);
		settings.fill = GridBagConstraints.BOTH;
		
		for (int i = 0; i < atributos.length; i++) {
			settings.gridx=0;
			settings.gridy=i;
			settings.weightx = 1;
			etiquetas[i].setForeground(new Color(136,61,29));
			etiquetas[i].setFont(etiquetas[i].getFont().deriveFont(Font.BOLD, 14f));
			formulario.add(etiquetas[i],settings);
			
			settings.gridx=1;
			settings.gridy=i;
			settings.weightx = 1;		
			formulario.add(cuadrosDeTexto[i],settings);
		}
		
		
		//Boton cambiar vista
		
		settings =new GridBagConstraints();
		settings.gridx =0;
		settings.gridy =0;
		settings.gridwidth=2;
		settings.weighty=2;
		settings.fill=GridBagConstraints.BOTH;
		
//		this.add(cambiarVista,settings);
		
		
		//Boton almacenar
		
		settings =new GridBagConstraints();
		
		settings.gridy = atributos.length;
		settings.insets = new Insets(50, 0, 0, 0);
		settings.gridwidth = 2;
		settings.fill = GridBagConstraints.HORIZONTAL;
		formulario.add(almacenar,settings);
		
		almacenar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				
				String values [] = new String[cuadrosDeTexto.length];
				boolean compCamposVacios = false;
				for (int j = 0; j < values.length; j++) {
					values[j] = cuadrosDeTexto[j].getText();
					if(cuadrosDeTexto[j].getText().equals("")) {
						compCamposVacios = true;
					}
				}
				
				if(compCamposVacios) {
					JOptionPane.showMessageDialog(null, "Todos los campos deben estar rellenos");
				}else {
					model.addRow(values);
				}
													
				refrescarPantalla();
			}			
		});
		
		/*cambiarVista.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(visor.isVisible()) {
					visor.setVisible(false);
					formulario.setVisible(true);
				}
				else {
					visor.setVisible(true);
					formulario.setVisible(false);
				}				
			}
		});*/
		

	}
}
