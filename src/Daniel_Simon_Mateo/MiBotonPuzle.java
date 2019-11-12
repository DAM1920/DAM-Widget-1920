package Daniel_Simon_Mateo;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MiBotonPuzle extends JLabel {
	private JLabel cuadroAsociado;
	private JPanel panelJuego;
	
	public MiBotonPuzle(JPanel asociado,int columna,int fila) {
		
	}
	
	/**
	 * Lee la carpeta de imágenes y retorna una lista con todas las imágenes que encuentra
	 * @return
	 */
	public ArrayList<Image> devolverListaImagenes() {
		Iterator it;
		Image aux;
		File fichero = new File("img");
		String[] lista = fichero.list();
		ArrayList<Image> imagenesOriginales = new ArrayList<>();
		ArrayList<Image> imagenes = new ArrayList<>();
		
		try {
			for (int i = 0; i < lista.length; i++) {
				String auxPalabra = "img\\" + lista[i];
				if(!auxPalabra.endsWith("txt")){
					InputStream is = new BufferedInputStream(new FileInputStream("img\\" + lista[i]));
					imagenesOriginales.add(ImageIO.read(is));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		it = imagenesOriginales.iterator();
		
		while(it.hasNext()) {
			aux = (Image) it.next();
			aux = aux.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
			imagenes.add(aux);
		}
		
		return imagenes;
	}

}
