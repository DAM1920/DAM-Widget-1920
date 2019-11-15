package García_Pérez_José_Daniel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleContext;

public class VentanaPrincipal implements ActionListener, ItemListener {
	JFrame ventana;
	private JMenuBar mb;
	private JMenu menu1;
	private JMenuItem mi1, mi2, mi3;
	private JPanel opciones, espacio;
	private JTextPane editor;
	private JCheckBox checkNegrita, checkItalica;
	private JComboBox<String> tamanio;
	private JComboBox<String> letra;
	private JButton colores;
	SimpleAttributeSet attrs;
	StyleContext st;
	Color color;
	Escrituras escritura;
	String fuente;
	Color colorActual;
	boolean negrita;
	boolean italica;
	int tamanioActual;
	int indice;
	int indiceTamanio;

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
		mi3 = new JMenuItem("Abrir");
		mi3.addActionListener(this);
		menu1.add(mi3);

		checkNegrita = new JCheckBox("Negrita");

		checkNegrita.addItemListener(this);

		checkItalica = new JCheckBox("Italica");

		checkItalica.addItemListener(this);

		tamanio = new JComboBox<String>();

		tamanio.addActionListener(this);
		tamanio.setModel(new DefaultComboBoxModel<>(new String[] { "8", "10", "12", "14", "16", "20" }));

		letra = new JComboBox<String>();
		letra.addActionListener(this);
		letra.setModel(new DefaultComboBoxModel<>(fontNames));

		colores = new JButton();
		colores.setIcon(new ImageIcon(".//img//colores.png"));
		colores.addActionListener(this);
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

		settings.ipadx = 60;
		settings.insets = new Insets(0, 5, 0, 0);
		opciones.add(tamanio, settings);

		settings = new GridBagConstraints();
		settings.gridx = 3;
		settings.gridy = 0;
		settings.insets = new Insets(0, 5, 0, 0);
		opciones.add(letra, settings);

		settings = new GridBagConstraints();

		settings.gridx = 4;
		settings.gridy = 0;
		settings.insets = new Insets(0, 5, 0, 0);

		opciones.add(colores, settings);
		espacio = new JPanel();
		espacio.setBackground(Color.GRAY);

		settings = new GridBagConstraints();
		settings.gridx = 5;
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

		escritura = new Escrituras(this, ventana, editor);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Container f = ventana.getContentPane();
		if (arg0.getSource() == mi3) {

			escritura.open();
		}

		if (arg0.getSource() == mi2) {

			escritura.save();
		}
		if (arg0.getSource() == mi1) {
			editor.setText("");
		}
		if (arg0.getSource() == tamanio) {
			tamanioActual = Integer.parseInt(tamanio.getSelectedItem().toString());
			fuente = letra.getSelectedItem().toString();
			if (negrita == true && italica == true) {
				editor.setFont(new Font(letra.getSelectedItem().toString(), Font.BOLD | Font.ITALIC,
						Integer.parseInt(tamanio.getSelectedItem().toString())));
			} else {
				if (negrita == true) {
					editor.setFont(new Font(letra.getSelectedItem().toString(), Font.BOLD,
							Integer.parseInt(tamanio.getSelectedItem().toString())));
				} else {
					if (italica == true) {
						editor.setFont(new Font(letra.getSelectedItem().toString(), Font.ITALIC,
								Integer.parseInt(tamanio.getSelectedItem().toString())));
					} else {
						editor.setFont(new Font(letra.getSelectedItem().toString(), Font.PLAIN,
								Integer.parseInt(tamanio.getSelectedItem().toString())));
					}
				}
			}
			indiceTamanio = tamanio.getSelectedIndex();
		}
		if (arg0.getSource() == letra) {
			tamanioActual = Integer.parseInt(tamanio.getSelectedItem().toString());
			fuente = letra.getSelectedItem().toString();
			if (negrita == true && italica == true) {
				editor.setFont(new Font(letra.getSelectedItem().toString(), Font.BOLD | Font.ITALIC,
						Integer.parseInt(tamanio.getSelectedItem().toString())));
			} else {
				if (negrita == true) {
					editor.setFont(new Font(letra.getSelectedItem().toString(), Font.BOLD,
							Integer.parseInt(tamanio.getSelectedItem().toString())));
				} else {
					if (italica == true) {
						editor.setFont(new Font(letra.getSelectedItem().toString(), Font.ITALIC,
								Integer.parseInt(tamanio.getSelectedItem().toString())));
					} else {
						editor.setFont(new Font(letra.getSelectedItem().toString(), Font.PLAIN,
								Integer.parseInt(tamanio.getSelectedItem().toString())));
					}
				}
			}
			indice = letra.getSelectedIndex();
		}
		if (arg0.getSource() == colores) {
			Color aux = color;
			color = JColorChooser.showDialog(null, "Seleccione un color", this.color);
			System.out.println(color);
			if (color == null) {
				color = aux;
			}
			editor.setForeground(color);
			colorActual = color;
		}

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		negrita = true;
		italica = true;
		if (checkItalica.isSelected() && checkNegrita.isSelected()) {
			editor.setFont(new Font(letra.getSelectedItem().toString(), Font.ITALIC | Font.BOLD,
					Integer.parseInt(tamanio.getSelectedItem().toString())));

		} else {
			italica = true;
			negrita = false;
			if (checkItalica.isSelected()) {
				editor.setFont(new Font(letra.getSelectedItem().toString(), Font.ITALIC,
						Integer.parseInt(tamanio.getSelectedItem().toString())));
			} else {
				italica = false;
				negrita = true;
				if (checkNegrita.isSelected()) {
					editor.setFont(new Font(letra.getSelectedItem().toString(), Font.BOLD,
							Integer.parseInt(tamanio.getSelectedItem().toString())));
				} else {
					italica = false;
					negrita = false;
					editor.setFont(new Font(letra.getSelectedItem().toString(), Font.PLAIN,
							Integer.parseInt(tamanio.getSelectedItem().toString())));
				}
			}
		}

	}

	public void actualizarFuentes() {
		System.out.println(negrita);
		System.out.println(italica);
		System.out.println(tamanioActual);
		if (negrita == true && italica == true) {
			checkNegrita.setSelected(true);
			checkItalica.setSelected(true);

			editor.setFont(new Font(fuente, Font.BOLD | Font.ITALIC, tamanioActual));
		} else {
			if (negrita == true) {
				checkNegrita.setSelected(true);
				checkItalica.setSelected(false);
				editor.setFont(new Font(fuente, Font.BOLD, tamanioActual));
			} else {

				if (italica == true) {
					checkItalica.setSelected(true);
					checkNegrita.setSelected(false);
					editor.setFont(new Font(fuente, Font.ITALIC, tamanioActual));
				} else {
					checkItalica.setSelected(false);
					checkNegrita.setSelected(false);
					editor.setFont(new Font(fuente, Font.PLAIN, tamanioActual));
				}
			}
		}
		letra.setSelectedIndex(indice);
		tamanio.setSelectedIndex(indiceTamanio);

	}

}
