package BlancaErdieta;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DialogSelectorFuente extends JDialog implements ActionListener {
	/**
	 * Clase que representa un dialogo que nos permite: Cambiar el tipo de letra de
	 * un texto Cambiar es estilo(negrita y/o cursiva) de un texto Cambiar el tamaño
	 * de la letra de un texto
	 * 
	 * Mostrar los tipos de letra de java:
	 * String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	 * System.out.println(Arrays.toString(fontNames));
	 * 
	 * 
	 * @author Blanca Erdieta
	 **/

	private static final long serialVersionUID = 1L;

	JTextField seleccion;

	// valores para crear la fuente
	String tipo;
	int estilo;
	int tamanio;
	int negr;
	int curs;

	// menu
	JMenuBar menu;
	JMenu menuTipo;
	JMenuItem[] opciones;
	String[] StringMenu = { "Adobe Arabic", "Arial", "Britannic Bold", "Calibri", "DejaVu Math TeX Gyre",
			"Gentium Basic", "Segoe Print", "Source Code Pro", "Tahoma" };
	JCheckBox negrita;
	JCheckBox cursiva;

	// tamaño
	JTextField textTamanio;
	JSlider sTamanio;
	JButton aceptar;

	public DialogSelectorFuente(JComponent componente, String tipo, int estilo, int tamanio) {

		this.tipo = tipo;
		this.estilo = estilo;
		this.tamanio = tamanio;
		setModal(true);
		setBounds((int) componente.getLocationOnScreen().getX(), (int) componente.getLocationOnScreen().getY(), 300,
				400);
		anadirElementos();
		anadirListeners();
	}

	/**
	 * Método que introduce todos los componentes en el JDialog
	 **/
	public void anadirElementos() {

		seleccion = new JTextField("Seleccione una fuente:");
		seleccion.setEditable(false);
		aceptar = new JButton("Aceptar");

		// establecer tipo
		menuTipo = new JMenu("Tipo");
		menu = new JMenuBar();
		menu.add(menuTipo);
		this.setJMenuBar(menu);

		opciones = new JMenuItem[StringMenu.length];
		for (int i = 0; i < StringMenu.length; i++) {
			opciones[i] = new JMenuItem();
			opciones[i].setText(StringMenu[i]);
			menuTipo.add(opciones[i]);
			menuTipo.addSeparator();

		}

		// establecer estilo
		negrita = new JCheckBox("Negrita");
		cursiva = new JCheckBox("Cursiva");
		switch (estilo) {
			case 1: {
				negrita.setSelected(true);
				negr = 1;
				break;
			}
			case 2: {
				cursiva.setSelected(true);
				curs = 2;
				break;
			}
			case 3: {
				negrita.setSelected(true);
				cursiva.setSelected(true);
				negr = 1;
				curs = 2;
				break;
			}
			default: {
				negrita.setSelected(false);
				cursiva.setSelected(false);
				negr = 0;
				curs = 0;
				break;
			}
		}

		// establecer tamaño
		textTamanio = new JTextField("Cambiar tamaño:");
		textTamanio.setEditable(false);
		sTamanio = new JSlider(1, 30, tamanio);
		sTamanio.setMinorTickSpacing(5);
		sTamanio.setMajorTickSpacing(29);
		sTamanio.setPaintTicks(true);
		sTamanio.setPaintLabels(true);

		// introducir componentes
		this.setLayout(new GridBagLayout());

		GridBagConstraints settingObject = new GridBagConstraints();
		// texto de título
		settingObject.gridx = 0;
		settingObject.gridy = 0;
		settingObject.insets = new Insets(20, 0, 0, 0);
		settingObject.gridwidth = 2;
		settingObject.fill = GridBagConstraints.CENTER;
		this.add(seleccion, settingObject);
		// menu
		settingObject.gridx = 0;
		settingObject.gridy = 1;
		settingObject.gridwidth = 2;
		settingObject.insets = new Insets(20, 0, 0, 0);
		settingObject.fill = GridBagConstraints.CENTER;
		this.add(menu, settingObject);
		// JCheckBox negrita
		settingObject.gridx = 0;
		settingObject.gridy = 2;
		settingObject.gridwidth = 1;
		settingObject.insets = new Insets(20, 20, 0, 0);
		settingObject.fill = GridBagConstraints.CENTER;
		this.add(negrita, settingObject);
		// JCheckBox cursiva
		settingObject.gridx = 1;
		settingObject.gridy = 2;
		settingObject.insets = new Insets(20, 20, 0, 0);
		settingObject.gridwidth = 1;
		settingObject.fill = GridBagConstraints.CENTER;
		this.add(cursiva, settingObject);
		// texto de tamaño
		settingObject.gridx = 0;
		settingObject.gridy = 3;
		settingObject.gridwidth = 2;
		settingObject.insets = new Insets(20, 20, 0, 0);
		settingObject.fill = GridBagConstraints.CENTER;
		this.add(textTamanio, settingObject);
		// Slider de tamaño
		settingObject.gridx = 0;
		settingObject.gridy = 4;
		settingObject.insets = new Insets(20, 20, 0, 0);
		settingObject.gridwidth = 2;
		settingObject.fill = GridBagConstraints.CENTER;
		this.add(sTamanio, settingObject);
		// botón aceptar
		settingObject.gridx = 0;
		settingObject.gridy = 5;
		settingObject.insets = new Insets(20, 0, 20, 0);
		settingObject.gridwidth = 2;
		settingObject.fill = GridBagConstraints.CENTER;
		this.add(aceptar, settingObject);

	}

	/**
	 * Método que añade los listener al JDialog
	 */
	public void anadirListeners() {
		// listener del menu
		for (int i = 0; i < StringMenu.length; i++) {
			int iInterna = i;
			opciones[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					tipo = opciones[iInterna].getText();

				}
			});
		}
		// listener del JCeckBox negrita
		negrita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				negr = (negrita.isSelected()) ? 1 : 0;
				estilo = negr + curs;
			}

		});
		// listener del JCeckBox cursiva
		cursiva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				curs = (cursiva.isSelected()) ? 2 : 0;
				estilo = negr + curs;
			}
		});

		// listener del JSlider del tamaño
		ChangeListener listenerSliders = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				tamanio = sTamanio.getValue();
			}
		};

		sTamanio.addChangeListener(listenerSliders);

		// boton aceptar
		aceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();

	}

	public String getTipoElegido() {
		return tipo;
	}

	public void setTipoElegido(String tipoElegido) {
		this.tipo = tipoElegido;
	}

	public int getEstiloElegido() {

		return estilo;
	}

	public void setEstiloElegido(int estiloElegido) {
		this.estilo = estiloElegido;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

}
