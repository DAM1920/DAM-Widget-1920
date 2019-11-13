package García_Pérez_José_Daniel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class VentanaPrincipal implements ActionListener, ItemListener {
	JFrame ventana;
	private JMenuBar mb;
	private JMenu menu1;
	private JMenuItem mi1, mi2;
	private JPanel opciones, espacio;
	private JTextPane editor;
	private JCheckBox checkNegrita, checkItalica, checkSub;
	private JComboBox<String> tamanio;
	private JComboBox<String> letra;
	private JComboBox<String> colores;

	public VentanaPrincipal() {
		ventana = new JFrame("Bloc de notas");
		Toolkit theKit = ventana.getToolkit();
		Dimension wndSize = theKit.getScreenSize();
		ventana.setBounds(wndSize.width / 4, wndSize.height / 4, wndSize.width / 2, wndSize.height / 2);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints settings = new GridBagConstraints();
		GridLayout gl = new GridLayout(1, 3);
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		System.out.println(Arrays.toString(fontNames));
		ventana.setLayout(gbl);
//menu	
		mb = new JMenuBar();
		ventana.setJMenuBar(mb);
		menu1 = new JMenu("Archivo");
		mb.add(menu1);
		mi1 = new JMenuItem("Nuevo");
		mi1.addActionListener(this);
		menu1.add(mi1);
		mi2 = new JMenuItem("Guardar");
		mi2.addActionListener(this);
		menu1.add(mi2);

		checkNegrita = new JCheckBox("Negrita");

		checkNegrita.addItemListener(this);

		checkItalica = new JCheckBox("Italica");

		checkItalica.addItemListener(this);
		checkSub = new JCheckBox("Subrayado");

		checkSub.addItemListener(this);

		tamanio = new JComboBox<String>();

		tamanio.addActionListener(this);
		tamanio.setModel(new DefaultComboBoxModel<>(new String[] { "8", "10", "12", "14", "16", "20" }));

		letra = new JComboBox<String>();
		letra.addActionListener(this);
		letra.setModel(new DefaultComboBoxModel<>(fontNames));

		colores = new JComboBox<String>();
		colores.addActionListener(this);
		colores.setModel(new DefaultComboBoxModel<>(
				new String[] { "Negro", "Blanco", "Rojo", "Amarillo", "Verde", "Azul", "Morado", "Gris" }));
		colores.setBackground(Color.DARK_GRAY);
		colores.setForeground(Color.BLACK);
		opciones = new JPanel();
		opciones.setLayout(gbl);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;

		opciones.add(checkNegrita, settings);
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;

		opciones.add(checkItalica, settings);
		settings = new GridBagConstraints();
		settings.gridx = 2;
		settings.gridy = 0;

		opciones.add(checkSub, settings);

		settings = new GridBagConstraints();
		settings.gridx = 3;
		settings.gridy = 0;
		settings.ipadx = 60;
		settings.insets = new Insets(0, 5, 0, 0);
		opciones.add(tamanio, settings);

		settings = new GridBagConstraints();
		settings.gridx = 4;
		settings.gridy = 0;
		settings.insets = new Insets(0, 5, 0, 0);
		opciones.add(letra, settings);

		settings = new GridBagConstraints();
		settings.gridx = 5;
		settings.gridy = 0;
		settings.insets = new Insets(0, 5, 0, 0);
		opciones.add(colores, settings);
		espacio = new JPanel();
		espacio.setBackground(Color.GRAY);

		settings = new GridBagConstraints();
		settings.gridx = 6;
		settings.gridy = 0;
		settings.fill = GridBagConstraints.BOTH;
		settings.weightx = 1;
		opciones.add(espacio, settings);
		opciones.setBackground(Color.GRAY);
		settings.gridx = 0;
		settings.gridy = 0;
		settings.fill = GridBagConstraints.BOTH;
		settings.weightx = 1;
		settings.weighty = 1;
		ventana.add(opciones, settings);

		settings = new GridBagConstraints();
		editor = new BlocDeTexto();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.fill = GridBagConstraints.BOTH;
		settings.weightx = 1;
		settings.weighty = 16;
		ventana.add(editor, settings);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Container f = ventana.getContentPane();
		if (arg0.getSource() == mi1) {
			System.out.println("Nuevo");
		}

		if (arg0.getSource() == mi2) {
			System.out.println("Guardar");
		}
		if (arg0.getSource() == tamanio) {
			String item_Seleccionado = tamanio.getSelectedItem().toString();
			System.out.println(item_Seleccionado);
		}
		if (arg0.getSource() == letra) {
			String item_Seleccionado = letra.getSelectedItem().toString();
			System.out.println(item_Seleccionado);
		}
		if (arg0.getSource() == colores) {
			String item_Seleccionado = colores.getSelectedItem().toString();
			System.out.println(item_Seleccionado);
			switch (item_Seleccionado) {
			case "Blanco":
				colores.setForeground(Color.WHITE);
				break;
			case "Negro":
				colores.setForeground(Color.BLACK);
				break;
			case "Rojo":
				colores.setForeground(Color.RED);
				break;
			case "Verde":
				colores.setForeground(Color.GREEN);
				break;
			case "Amarillo":
				colores.setForeground(Color.YELLOW);
				break;
			case "Gris":
				colores.setForeground(Color.GRAY);
				break;
			case "Azul":
				colores.setForeground(Color.BLUE);
				break;
			case "Morado":
				colores.setForeground(Color.MAGENTA);
				break;
			}

		}

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getStateChange() == ItemEvent.SELECTED) {
			SimpleAttributeSet attrs = new SimpleAttributeSet();
			StyleConstants.setBold(attrs, true);
			try {
				editor.getStyledDocument().insertString(editor.getStyledDocument().getLength(), null, attrs);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			SimpleAttributeSet attrs = new SimpleAttributeSet();
			StyleConstants.setBold(attrs, false);
			try {
				editor.getStyledDocument().insertString(editor.getStyledDocument().getLength(), null, attrs);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
