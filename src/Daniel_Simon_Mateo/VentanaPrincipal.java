package Daniel_Simon_Mateo;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.InternalFrameListener;

public class VentanaPrincipal {
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
		
		//Se inicializa la etiqueta con la puntuación
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
				casillas[i][j] = new JLabel();
				casillas[i][j].setBorder(BorderFactory.createLineBorder(Color.darkGray));
			}
		}
		
		//Se le da una imagen al azar a todos los botones salvo a uno
		while(imagenes.size()>0) {
			y=(int)(Math.random()*3);
			x=(int)(Math.random()*3);
			aleatorio = (int) (Math.random()*imagenes.size());
			if(casillas[y][x].getIcon()==null) {
				casillas[y][x].setIcon(new ImageIcon(imagenes.get(aleatorio)));
				imagenes.remove(aleatorio);
			}
		}
		
		//Se añaden los botones al panel de juego
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				settings = new GridBagConstraints();
				settings.gridx = i;
				settings.gridy = j;
				panelJuego.add(casillas[i][j],settings);
			}
		}

	}
	
	public void inicializarListeners() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j].addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						comprobarAdyacentes();
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		}
	}
	
	/**
	 * Comprueba las posiciones norte, sur, este y oeste en busca de la casilla blanca (W.jpg)
	 */
	public void comprobarAdyacentes() {
		
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

	public void inicializar() {
		marco.setVisible(true);
		inicializarComponentes();
	}
}
