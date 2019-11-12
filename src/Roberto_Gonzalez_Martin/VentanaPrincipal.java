package Roberto_Gonzalez_Martin;
import javax.swing.JFrame;

public class VentanaPrincipal {
	// La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;

	// Constructor, marca el tama√±o y el cierre del frame
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * MÈtodo que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes() {

	}

	/**
	 * MÈtodo que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners() {

	}

	/**
	 * MÈtodo que realiza todas las llamadas necesarias para inicializar la ventana
	 * correctamente.
	 */
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
}
