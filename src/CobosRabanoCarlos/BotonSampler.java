package CobosRabanoCarlos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class BotonSampler extends JButton implements MouseListener, Serializable {
	private ReproduccionSonido sonido;
	private File fichero;
	private String descripcion;

	public BotonSampler() {
		super();
		addMouseListener(this);
	}
	
	private void ejegirFichero() {
		int select;
		JFileChooser chooser=new JFileChooser("./sonidos");
		chooser.setFileFilter(new FiltroExt(".mp3"));
		select=chooser.showOpenDialog(this);
		if(select==JFileChooser.APPROVE_OPTION) {
			fichero=chooser.getSelectedFile();
			descripcion=JOptionPane.showInputDialog(this,"Escribe una descripci�n del sonido");
			setText(descripcion);
			sonido=new ReproduccionSonido(fichero, this);
		}
	}
	
	private void sonar() {
		sonido.start();
		setBackground(Color.GREEN);
	}
	
	public void parar() {
		sonido.parar();
		setBackground(Color.BLUE);
		sonido=new ReproduccionSonido(fichero, this);
	}

	public File getFichero() {
		return fichero;
	}

	public void setFichero(File fichero) {
		this.fichero = fichero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	

	public ReproduccionSonido getSonido() {
		return sonido;
	}

	public void setSonido(ReproduccionSonido sonido) {
		this.sonido = sonido;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			ejegirFichero();
		}else {
			if (sonido.isPausado()){
				sonar();
			}else {
				parar();
			}
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
}
