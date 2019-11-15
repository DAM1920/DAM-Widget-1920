package Vega_Calzado_Alba;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
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
 * 
 * @author Alba Vega Calzado
 *
 */
public class JGaleria extends JPanel{
	ArrayList<String> rutasImagenes;
	ArrayList<ImageIcon> vImagenes;
	JLabel contenedor;
	int contador=0;
	
	public JGaleria() {
		super(new GridLayout(1,1));
		contenedor= new JLabel();
		add(contenedor);
		rutasImagenes = new ArrayList<>();
		vImagenes = new ArrayList<>();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}


	public void iniciarGaleria() {
		String ruta = "img\\imgGaleria";
		
		guardarRutasImagenes(ruta);
		mostrarPrimeraImagen(rutasImagenes);
		crearArrayImagenes(rutasImagenes);
	}
	
	public void guardarRutasImagenes(String ruta) {
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
					rutasImagenes.add(ruta+"\\"+nombreImg);
				}
			}
		}
	}
	
	public void mostrarPrimeraImagen(ArrayList<String> rutasImagenes) {
		ImageIcon[] vImagenes;
		
		try {
			BufferedImage imagen = ImageIO.read(new File(rutasImagenes.get(0)));
			ImageIcon icon = new ImageIcon(imagen.getScaledInstance(800,500, imagen.SCALE_SMOOTH));
			
			contenedor.setIcon(icon);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void crearArrayImagenes(ArrayList<String> imagenes) {
		
		
		try{
			for(int i=0;i<imagenes.size();i++) {
				BufferedImage imagen = ImageIO.read(new File(rutasImagenes.get(i)));
				vImagenes.add(new ImageIcon(imagen.getScaledInstance(800,500, imagen.SCALE_SMOOTH)));
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void avanzar() {
		//Si llegamos a la última imagen de la presentación, reseteamos el contador
		if(contador==(vImagenes.size()-1)) {
			contador=0;
			contenedor.setIcon(vImagenes.get(contador));
		}
		else {
			contador++;
			contenedor.setIcon(vImagenes.get(contador));
		}
	}
	
	public void retroceder() {
		//Si llegamos a la primera imagen, volvemos a la última del arraylist
		if(contador==0) {
			contador=vImagenes.size()-1;
			
			contenedor.setIcon(vImagenes.get(contador));
		}
		else {
			contador--;
			
			contenedor.setIcon(vImagenes.get(contador));
		}
	}
	
	public void presentacion() {
		Timer timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contenedor.setIcon(vImagenes.get(contador));
				contador++;
				
				if(contador==vImagenes.size()) {
					contador=0;
				}
			}
		});
		timer.start();
	}
}
