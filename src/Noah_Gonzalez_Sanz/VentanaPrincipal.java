package Noah_Gonzalez_Sanz;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaPrincipal {
	JFrame marco;
	PixelPaint paint;

	public VentanaPrincipal() {
		marco = new JFrame("Pixel Paint");
		paint = new PixelPaint();
		marco.setBounds(0, 0, 900, 600);
		marco.setLayout(new GridLayout(0,1));
		marco.add(paint);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * Hacemos visible el JFrame
	 */
	public void visible() {
		marco.setVisible(true);
	}

	

}
