package Vega_Calzado_Alba;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author Alba Vega Calzado
 *
 */
public class JGaleria extends JPanel{
	ArrayList<String> imagenes;
	//
	
	JLabel contenedor;
	int contador=1;
	
	public JGaleria() {
		super();
		contenedor= new JLabel();
		ArrayList <String> imagenes = new ArrayList();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}


	public void iniciarGaleria() {
		String ruta = System.getProperty("/img/imgGaleria");
		
		guardarImagenes(ruta);
		mostrarPrimeraImagen(imagenes);
	}
	
	public void guardarImagenes(String ruta) {
		boolean cargado;
		String nombreImg;
		
		File fGaleria = new File(ruta);
		File[] listaDir = fGaleria.listFiles();
		
		//Bucle que recorre todos los archivos que contiene la carpeta
		for(int i=0; i<listaDir.length;i++) {
			if(listaDir[i].isFile()) {
				//Obtenemos el nombre del archivo
				nombreImg = listaDir[i].getName();
				
				//Comprobamos si su extensión es la correcta
				if(nombreImg.endsWith(".jpg") || nombreImg.endsWith(".JPG")) {
					imagenes.add(ruta+"/"+nombreImg);
					//new ImagenIcon(getClass().getResourve("img/imgGaleria/"+i+"jpg"))
				}
				
			}
		}
	}
	
	public void mostrarPrimeraImagen(ArrayList<String> imagenes) {
		try {
			BufferedImage imagen = ImageIO.read(new File(imagenes.get(0)));
			
			contenedor.setIcon(new ImageIcon(imagen));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void avanzar() {
		//Si llegamos a la última imagen de la presentación, reseteamos el contador
		if(contador==(imagenes.size()-1)) {
			contador=0;
		}
		contador++;
		contenedor.setIcon(new ImageIcon(imagenes.get(contador)));
	}
	
	public void retroceder() {
		//Si llegamos a la primera imagen, volvemos a la última del arraylist
		if(contador==1) {
			contador=4;
		}
		contador--;
		
		contenedor.setIcon(new ImageIcon(imagenes.get(contador)));
	}
	
	public void presentacion() {
		Timer timer = new Timer(600, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contenedor.setIcon(new ImageIcon(getClass().getResource(imagenes.get(contador))));
				contador++;
				
				if(contador==imagenes.size()) {
					contador=1;
				}
			}
		});
		timer.start();
	}
	//https://stackoverflow.com/questions/17383867/set-icon-image-in-java
	//https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
}
