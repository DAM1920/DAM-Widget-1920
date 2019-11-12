package García_Pérez_José_Daniel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaPrincipal implements ActionListener, ChangeListener {
	JFrame ventana;
	private JMenuBar mb;
	private JMenu menu1;
	private JMenuItem mi1, mi2;
	private JPanel opciones;
	private JTextPane editor;
	private JCheckBox checkNegrita, checkItalica, checkSub;

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

		checkNegrita.addChangeListener(this);

		checkItalica = new JCheckBox("Italica");

		checkItalica.addChangeListener(this);
		checkSub = new JCheckBox("Subrayado");

		checkSub.addChangeListener(this);

		opciones = new JPanel();
		opciones.setLayout(gbl);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.anchor = GridBagConstraints.WEST;
		opciones.add(checkNegrita, settings);
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.anchor = GridBagConstraints.WEST;
		opciones.add(checkItalica, settings);
		settings = new GridBagConstraints();
		settings.gridx = 2;
		settings.gridy = 0;
		settings.anchor = GridBagConstraints.WEST;
		opciones.add(checkSub, settings);
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

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub

	}
}
