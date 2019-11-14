package Daniel_Simon_Mateo;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.InternalFrameListener;

public class VentanaPrincipal {
	Icon panelBlanco;
	JFrame marco;
	JLabel casillas[][];
	JPanel panelMovimientos;
	JPanel panelEstado;
	JPanel panelJuego;
	JLabel labelMovimientos;
	JLabel labelEstado;

	public VentanaPrincipal() {
		marco = new JFrame();
		marco.setBounds(100, 100, 450, 500);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InputStream is;
		try {
			is = new BufferedInputStream(new FileInputStream("img\\W.jpg"));
			Image aux = ImageIO.read(is);
			panelBlanco=(new ImageIcon(aux));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void inicializarComponentes() {
		int aleatorio,y,x;
		GridBagConstraints settings = new GridBagConstraints();
		ArrayList<Image> imagenes = devolverListaImagenes();
		marco.getContentPane().setLayout(new GridBagLayout());
		
		//Se inicializa el panel de movimientos
		settings = new GridBagConstraints();
		panelMovimientos = new JPanel();
		settings.gridy=0;
		settings.gridx =0;
		settings.gridwidth=2;
		settings.ipadx = 150;
		panelMovimientos.setBorder(BorderFactory.createTitledBorder("MOVIMIENTOS"));
		panelMovimientos.setBackground(Color.white);
		marco.add(panelMovimientos,settings);
		
		//Se inicializa la etiqueta con la puntuaci�n
		settings = new GridBagConstraints();
		labelMovimientos = new JLabel();
		labelMovimientos.setText("0");
		panelMovimientos.add(labelMovimientos,settings);
		
		//Se inicializa el panel de estado
		settings = new GridBagConstraints();
		panelEstado = new JPanel();
		settings.gridy=0;
		settings.gridx =2;
		settings.ipadx = 150;
		panelEstado.setBorder(BorderFactory.createTitledBorder("ESTADO DE LA PARTIDA"));
		panelEstado.setBackground(Color.white);
		marco.add(panelEstado,settings);
		
		//Se inicializa la etiqueta de estado de la partida
		settings = new GridBagConstraints();
		labelEstado = new JLabel();
		labelEstado.setText("EN PROCESO");
		panelEstado.add(labelEstado,settings);
		
		//Se inicializa el panel de juego
		settings = new GridBagConstraints();
		panelJuego = new JPanel();
		panelJuego.setLayout(new GridLayout(3,3));
		settings.gridy=1;
		settings.gridwidth=3;
		settings.gridheight=3;
		marco.add(panelJuego,settings);
		
		//Se inicializan los botones
		casillas = new JLabel[3][3];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new MiBotonPuzle(this, j, i);
				casillas[i][j].setBorder(BorderFactory.createLineBorder(Color.darkGray));
			}
		}
		
		//Se le da una imagen al azar a todos los botones
		while(imagenes.size()>0) {
			y=(int)(Math.random()*3);
			x=(int)(Math.random()*3);
			aleatorio = (int) (Math.random()*imagenes.size());
			if(casillas[y][x].getIcon()==null) {
				casillas[y][x].setIcon(new ImageIcon(imagenes.get(aleatorio)));
				imagenes.remove(aleatorio);
			}
		}
		
		//Se a�aden las casillas al panel de juego
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				settings = new GridBagConstraints();
				settings.gridx = i;
				settings.gridy = j;
				panelJuego.add(casillas[i][j],settings);
			}
		}

	}
	
	public void convertirBlanco(int columnasX,int filasY) {
		//casillas[filasY][columnasX].setIcon(new ImageIcon(panelBlanco));
	}
	
	
	
	/**
	 * Comprueba las posiciones norte, sur, este y oeste en busca de la casilla blanca (W.jpg)
	 */
	public void comprobarCasillasAdyacentes(int posX,int posY) {
		//[posX][posY-1] ARRIBA
		if((posX>0)&&(posX<3)&&(posY-1>0)&&(posY-1<3)) {
			if((casillas[posX][posY-1].getIcon() == panelBlanco)) {
				ImageIcon auxiliar = (ImageIcon) casillas[posX][posY-1].getIcon();
				casillas[posX][posY-1].setIcon((ImageIcon)casillas[posX][posY].getIcon());
				casillas[posX][posY].setIcon((ImageIcon)auxiliar);
				aumentarMovimientos();
			}
		}
		
		//[posX-1][posY] IZQUIERDA
		if((posX-1>0)&&(posX-1<3)&&(posY>0)&&(posY<3)) {
			if(casillas[posX-1][posY].getIcon() == panelBlanco) {
				ImageIcon auxiliar = (ImageIcon) casillas[posX-1][posY].getIcon();
				casillas[posX-1][posY].setIcon((ImageIcon)casillas[posX][posY].getIcon());
				casillas[posX][posY].setIcon((ImageIcon)auxiliar);
				aumentarMovimientos();
			}
		}
		
		//[posX+1][posY] DERECHA
		if((posX+1>0)&&(posX+1<3)&&(posY>0)&&(posY<3)) {
			if(casillas[posX+1][posY].getIcon() == panelBlanco) {
				ImageIcon auxiliar = (ImageIcon) casillas[posX+1][posY].getIcon();
				casillas[posX+1][posY].setIcon((ImageIcon)casillas[posX][posY].getIcon());
				casillas[posX][posY].setIcon((ImageIcon)auxiliar);
				aumentarMovimientos();
			}
		}
		
		//[posX][posY+1] ABAJO
		if((posX>0)&&(posX<3)&&(posY+1>0)&&(posY+1<3)) {
			if(casillas[posX][posY+1].getIcon() == panelBlanco) {
				ImageIcon auxiliar = (ImageIcon) casillas[posX][posY+1].getIcon();
				casillas[posX][posY+1].setIcon((ImageIcon)casillas[posX][posY].getIcon());
				casillas[posX][posY].setIcon((ImageIcon)auxiliar);
				aumentarMovimientos();
			}
		}
	}
	
	public void aumentarMovimientos() {
		String texto = labelMovimientos.getText();
		int punt = Integer.valueOf(texto);
		texto = Integer.toString(punt++);
		labelMovimientos.setText(Integer.toString(punt++));
	}

	/**
	 * Lee la carpeta de im�genes y retorna una lista con todas las im�genes que encuentra
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
	

	public void inicializar() {
		marco.setVisible(true);
		inicializarComponentes();
	}
}
