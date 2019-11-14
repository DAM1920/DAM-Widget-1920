package Daniel_Simon_Mateo;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MiBotonPuzle extends JLabel implements MouseListener {
	private VentanaPrincipal ventana;
	private int filaY;
	private int columnaX;
	
	public MiBotonPuzle(VentanaPrincipal ventana,int columnaX,int filaY) {
		super();
		this.addMouseListener(this);
		this.ventana = ventana;
		this.filaY = filaY;
		this.columnaX = columnaX;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		it = imagenesOriginales.iterator();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		ventana.buscarBlanca(columnaX, filaY);
		//ventana.buscarBlanca();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

	

}
