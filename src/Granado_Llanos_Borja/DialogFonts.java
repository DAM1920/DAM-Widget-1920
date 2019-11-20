package Granado_Llanos_Borja;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DialogFonts extends JDialog implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7727027973223151786L;

	
	// Array con todos los tipos de letras disponibles
	String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
	Font fontAux;

	JComboBox<String> tipoLetra; // Contenedor para los tipos de letra
	String tipoElegido;

	JSlider tamayoLetra; // Slider para selecionar el tamaño
	int tamayoElegido;

	JCheckBox negrita, italica;
	int opcionElegida;
	

	JLabel prevLetra; // Labels para previsualizar tipo de letra y tamaño

	JPanel panelTipo, panelTamayo, panelOpciones, panelAceptar; // Paneles contenedores

	JBotonFont botonFuente;

	JButton aceptar;

	public DialogFonts(JBotonFont botonFuente, int tamayoInicial, String tipoLetraIni, boolean checkN, boolean checkC) {
		super();
		setModal(true);
		setBounds(0, 0, 400, 600);
		addElementos();
		this.tamayoLetra.setValue(tamayoInicial);
		this.tipoLetra.setSelectedItem(tipoLetraIni);
		this.negrita.setSelected(checkN);
		this.italica.setSelected(checkC);
		addListeners();
		this.botonFuente = botonFuente;
	}

	private void addListeners() {
		tamayoLetra.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				
				tamayoElegido = tamayoLetra.getValue();
				
				prevLetra.setText(tipoElegido);
				prevLetra.setFont(new Font(tipoElegido, opcionElegida, tamayoElegido));

			}
		});
		tipoLetra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tipoElegido = tipoLetra.getSelectedItem().toString();
				prevLetra.setText(tipoElegido);
				prevLetra.setFont(new Font(tipoElegido, opcionElegida, tamayoElegido));

			}
		});
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				botonFuente.fuenteActual = new Font(tipoElegido, opcionElegida, tamayoElegido);
				
				
				dispose();

			}
		});

		negrita.addChangeListener(this);
		italica.addChangeListener(this);

	}
	
	@Override
	public void stateChanged(ChangeEvent e) {

		if (negrita.isSelected() == true && italica.isSelected() == true) {
			opcionElegida = Font.BOLD | Font.ITALIC;
			prevLetra.setFont(new Font(tipoElegido, opcionElegida, tamayoElegido));
		} else if (italica.isSelected() == true) {
			opcionElegida = Font.ITALIC;
			prevLetra.setFont(new Font(tipoElegido, opcionElegida, tamayoElegido));
			// atributos.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
		} else if (negrita.isSelected() == true) {
			opcionElegida = Font.BOLD;
			prevLetra.setFont(new Font(tipoElegido, opcionElegida, tamayoElegido));
		} else {
			opcionElegida = Font.PLAIN;
			prevLetra.setFont(new Font(tipoElegido, opcionElegida, tamayoElegido));
		}

	}

	private void addElementos() {
		this.setLayout(new GridLayout(4, 1)); // Layout del dialogo

		// Tipo de letra
		panelTipo = new JPanel(); // Panel contenedor
		panelTipo.setLayout(new GridLayout(3, 1));
		panelTipo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		this.add(panelTipo);
		panelTipo.add(new JPanel());
		tipoLetra = new JComboBox();
		tipoLetra.setModel(new DefaultComboBoxModel(fontNames));
		panelTipo.add(tipoLetra);
		panelTipo.add(new JPanel());

		// Tamaño de letra
		panelTamayo = new JPanel(); // Panel contenedor
		panelTamayo.setLayout(new GridLayout(1, 1));
		panelTamayo.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		this.add(panelTamayo);

		tamayoLetra = new JSlider(0, 150, 20);
		tamayoLetra.setMajorTickSpacing(50);
		tamayoLetra.setMinorTickSpacing(1);
		tamayoLetra.setPaintTicks(true);
		tamayoLetra.setPaintLabels(true);
		panelTamayo.add(tamayoLetra); // Añadimos el slider para el tamaño

		// Opciones de estilo
		panelOpciones = new JPanel(); // Panel contenedor
		panelOpciones.setLayout(new GridLayout(3, 1));
		panelOpciones.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
		this.add(panelOpciones);

		negrita = new JCheckBox("Negrita");
		panelOpciones.add(negrita);

		italica = new JCheckBox("Cursiva");
		panelOpciones.add(italica);

		// Boton para finalizar
		panelAceptar = new JPanel(); // Panel contenedor
		prevLetra = new JLabel("");
		panelAceptar.setLayout(new GridLayout(2, 1));
		this.add(panelAceptar);
		aceptar = new JButton("Aceptar");
		aceptar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panelAceptar.add(prevLetra);
		panelAceptar.add(aceptar);

	}

	

}
