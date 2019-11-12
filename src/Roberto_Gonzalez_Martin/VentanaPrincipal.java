package Roberto_Gonzalez_Martin;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaPrincipal {
	// La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;
	JButton widget;

	// Constructor, marca el tamaÃ±o y el cierre del frame
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes() {
		ventana.setLayout(new GridLayout(1,1));
		widget = new JButton("Abrir reproductor de música");
		ventana.getContentPane().add(widget);
	}

	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners() {
		widget.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReproductorMusica reproductorMusica = new ReproductorMusica();
				reproductorMusica.setVisible(true);
			}
		});
	}

	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana
	 * correctamente.
	 */
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
}
