package Granado_Llanos_Borja;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextPane;

public class JBotonFont extends JButton implements MouseListener {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -5896261506958808309L;

	private static String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

	Font fuenteActual;
	static int numBoton=1;
	DialogFonts dialogFonts;

	// TextPane auxiliar para este caso
	JTextPane textArea;

	//metodo para asignar el textPane
	public void setTextArea(JTextPane textArea) {
		this.textArea = textArea;
	}

	public JBotonFont() {
		super("B"+numBoton++);
		// Fuente por defecto al inicia
		this.fuenteActual = new Font("Arial", Font.PLAIN, 14);
		this.addMouseListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			
			textArea.setFont(fuenteActual);
			
		}
		if (e.getButton() == MouseEvent.BUTTON3) {

			dialogFonts = new DialogFonts(this, this.fuenteActual.getSize(), this.fuenteActual.getName(), this.fuenteActual.isBold(), this.fuenteActual.isItalic());
			dialogFonts.setVisible(true);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
