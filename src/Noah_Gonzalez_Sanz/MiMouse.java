package Noah_Gonzalez_Sanz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MiMouse extends JPanel implements MouseListener, ActionListener {
	JPanel lienzo;
	JButton botonNegro, botonAzul, botonVerde, botonRojo, botonAmarillo, botonNuevoColor;
	boolean compBotonNegro=false, compBotonAzul=false, compBotonVerde=false, compBotonRojo=false, compBotonAmarillo=false;

	public MiMouse(JPanel lienzo, JButton botonNegro, JButton botonAzul, JButton botonVerde, JButton botonRojo,
			JButton botonAmarillo) {

		this.botonNegro = botonNegro;
		this.botonAzul = botonAzul;
		this.botonVerde = botonVerde;
		this.botonRojo = botonRojo;
		this.botonAmarillo = botonAmarillo;
		this.lienzo = lienzo;

		botonNegro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				compBotonNegro = true;
			}
		});

		botonAzul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				compBotonAzul = true;
			}
		});

		botonVerde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				compBotonVerde = true;
			}
		});

		botonRojo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				compBotonRojo = true;
			}
		});

		botonAmarillo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				compBotonAmarillo = true;
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (compBotonNegro) {
				lienzo.setBackground(Color.BLACK);
			}
			if (compBotonAzul) {
				lienzo.setBackground(Color.BLUE);
			}
			if (compBotonVerde) {
				lienzo.setBackground(Color.GREEN);
			}
			if (compBotonRojo) {
				lienzo.setBackground(Color.RED);
			}
			if (compBotonAmarillo) {
				lienzo.setBackground(Color.YELLOW);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (compBotonNegro) {
			lienzo.setBackground(Color.BLACK);
		}
		if (compBotonAzul) {
			lienzo.setBackground(Color.BLUE);
			compBotonNegro = false;
		}
		if (compBotonVerde) {
			lienzo.setBackground(Color.GREEN);
		}
		if (compBotonRojo) {
			lienzo.setBackground(Color.RED);
		}
		if (compBotonAmarillo) {
			lienzo.setBackground(Color.YELLOW);
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
