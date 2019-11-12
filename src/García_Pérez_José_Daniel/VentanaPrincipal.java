package García_Pérez_José_Daniel;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class VentanaPrincipal {
	JFrame ventana;

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
		// TODO Auto-generated method stub

	}
}
