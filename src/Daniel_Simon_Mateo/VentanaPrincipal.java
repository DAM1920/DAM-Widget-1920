package Daniel_Simon_Mateo;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JFrame marco;
	boolean victoria;
	JPuzzleLabel casillas[][];
	JPanel panelMovimientos;
	JPanel panelEstado;
	JPanel panelJuego;
	JLabel labelMovimientos;
	JLabel labelEstado;
	JButton reiniciar;

	public VentanaPrincipal() {
		marco = new JFrame();
		marco.setBounds(100, 100, 390, 460);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		victoria = false;
		marco.setResizable(false);
	}

	public void inicializarComponentes() {
		int indice,aleatorio,y,x;
		GridBagConstraints settings = new GridBagConstraints();
		ArrayList<Image> imagenes = devolverListaImagenes();
		marco.getContentPane().setLayout(new GridBagLayout());
		
		//Se inicializa el panel de movimientos
		settings = new GridBagConstraints();
		panelMovimientos = new JPanel();
		settings.gridy=0;
		settings.gridx =0;
		settings.ipadx = 100;
		panelMovimientos.setBorder(BorderFactory.createTitledBorder("MOVIMIENTOS"));
		panelMovimientos.setBackground(Color.lightGray);
		marco.add(panelMovimientos,settings);
		
		//Se inicializa la etiqueta con la puntuaciï¿½n
		settings = new GridBagConstraints();
		labelMovimientos = new JLabel();
		labelMovimientos.setText("0");
		panelMovimientos.add(labelMovimientos,settings);
		
		//Se inicializa el panel de estado
		settings = new GridBagConstraints();
		panelEstado = new JPanel();
		settings.gridy=0;
		settings.gridx =1;
		settings.ipadx = 75;
		panelEstado.setBorder(BorderFactory.createTitledBorder("ESTADO DE LA PARTIDA"));
		panelEstado.setBackground(Color.ORANGE);
		marco.add(panelEstado,settings);
		
		//Se inicializa la etiqueta de estado de la partida
		settings = new GridBagConstraints();
		labelEstado = new JLabel();
		labelEstado.setText("EN PROCESO");
		panelEstado.add(labelEstado,settings);
		
		//Se inicializa el botón de reinicio
		settings = new GridBagConstraints();
		reiniciar = new JButton();
		settings.gridy=0;
		settings.gridx =2;
		reiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciarPartida();
				
			}
		});
		settings.fill = GridBagConstraints.BOTH;
		reiniciar.setBackground(Color.DARK_GRAY);
		reiniciar.setText("REINICIAR");
		reiniciar.setForeground(Color.white);
		marco.add(reiniciar,settings);
		
		
		//Se inicializa el panel de juego
		settings = new GridBagConstraints();
		panelJuego = new JPanel();
		panelJuego.setLayout(new GridLayout(3,3));
		panelJuego.setBorder(BorderFactory.createLineBorder(Color.black, 10, false));
		settings.gridy=1;
		settings.gridx = 0;
		settings.gridwidth=3;
		settings.gridheight=3;
		marco.add(panelJuego,settings);
		
		//Se inicializan los botones
		casillas = new JPuzzleLabel[3][3];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new JPuzzleLabel(this, j, i);
				casillas[i][j].setBorder(BorderFactory.createLineBorder(Color.darkGray));
			}
		}
		
		//Se le da una imagen al azar a todos los botones
		indice = 0;
		while(imagenes.size()>0) {
			for (int i = 0; i < casillas.length; i++) {
				for (int j = 0; j < casillas[i].length; j++) {
					casillas[i][j].setIcon(new ImageIcon(imagenes.get(0)));
					casillas[i][j].setRuta(Integer.toString(indice));
					imagenes.remove(0);
					indice++;
				}
			}
		}
		
		//Se aï¿½aden las casillas al panel de juego
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				settings = new GridBagConstraints();
				settings.gridx = i;
				settings.gridy = j;
				panelJuego.add(casillas[i][j],settings);
			}
		}
		
		desordenarTablero();
	}
	
	/**
	 * Una vez asignados los paneles, los desordena
	 */
	public void desordenarTablero() {
		String rutaAux;
		Icon iconoAux;
		int randomX,randomY,randomX2,randomY2;
		for (int i = 0; i < (int)(Math.random()*100); i++) {
			randomX = (int)(Math.random()*3);
			randomY = (int)(Math.random()*3);
			randomX2 = (int)(Math.random()*3);
			randomY2 = (int)(Math.random()*3);
			rutaAux = casillas[randomX][randomY].getRuta();
			iconoAux = casillas[randomX][randomY].getIcon();
			casillas[randomX][randomY].setIcon(casillas[randomX2][randomY2].getIcon());
			casillas[randomX2][randomY2].setIcon(iconoAux);
			casillas[randomX][randomY].setRuta(casillas[randomX2][randomY2].getRuta());
			casillas[randomX2][randomY2].setRuta(rutaAux);
		}
	}
	
	/**
	 * Comprueba las posiciones norte, sur, este y oeste en busca de la casilla blanca (0.jpg)
	 */
	public void comprobarCasillasAdyacentes(int posX,int posY) {
		ImageIcon imAux;
		String stAux;
		//[posX][posY-1] ARRIBA
		if((posX>=0)&&(posX<3)&&(posY-1>=0)&&(posY-1<3)) {
			if((casillas[posX][posY-1].getRuta().equals("0"))) {
				imAux = (ImageIcon) casillas[posX][posY-1].getIcon();
				//stAux = casillas[posX][posY-1].getRuta();
				casillas[posX][posY-1].setIcon((ImageIcon)casillas[posX][posY].getIcon());
				casillas[posX][posY].setIcon(imAux);
				casillas[posX][posY-1].setRuta(casillas[posX][posY].getRuta());
				casillas[posX][posY].setRuta("0");
				aumentarMovimientos();
			}
		}
		
		//[posX-1][posY] IZQUIERDA
		if((posX-1>=0)&&(posX-1<3)&&(posY>=0)&&(posY<3)) {
			if(casillas[posX-1][posY].getRuta().equals("0")) {
				imAux = (ImageIcon) casillas[posX-1][posY].getIcon();
				//stAux = casillas[posX-1][posY].getRuta();
				casillas[posX-1][posY].setIcon((ImageIcon)casillas[posX][posY].getIcon());
				casillas[posX][posY].setIcon(imAux);
				casillas[posX-1][posY].setRuta(casillas[posX][posY].getRuta());
				casillas[posX][posY].setRuta("0");
				aumentarMovimientos();
			}
		}
		
		//[posX+1][posY] DERECHA
		if((posX+1>=0)&&(posX+1<3)&&(posY>=0)&&(posY<3)) {
			if(casillas[posX+1][posY].getRuta().equals("0")) {
				imAux = (ImageIcon) casillas[posX+1][posY].getIcon();
				//stAux = casillas[posX+1][posY].getRuta();
				casillas[posX+1][posY].setIcon((ImageIcon)casillas[posX][posY].getIcon());
				casillas[posX][posY].setIcon(imAux);
				casillas[posX+1][posY].setRuta(casillas[posX][posY].getRuta());
				casillas[posX][posY].setRuta("0");
				aumentarMovimientos();
			}
		}
		
		//[posX][posY+1] ABAJO
		if((posX>=0)&&(posX<3)&&(posY+1>=0)&&(posY+1<3)) {
			if(casillas[posX][posY+1].getRuta().equals("0")) {
				imAux = (ImageIcon) casillas[posX][posY+1].getIcon();
				//stAux = casillas[posX][posY+1].getRuta();
				casillas[posX][posY+1].setIcon((ImageIcon)casillas[posX][posY].getIcon());
				casillas[posX][posY].setIcon(imAux);
				casillas[posX][posY+1].setRuta(casillas[posX][posY].getRuta());
				casillas[posX][posY].setRuta("0");
				aumentarMovimientos();
			}
		}
		if(comprobarVictoria()) {
			mostrarFinJuego();
		}
	}
	
	/**
	 * Aumenta el número de movimientos
	 */
	public void aumentarMovimientos() {
		String texto = labelMovimientos.getText();
		int punt = Integer.valueOf(texto);
		texto = Integer.toString(punt++);
		labelMovimientos.setText(Integer.toString(punt++));
	}

	/**
	 * Lee la carpeta de imï¿½genes y retorna una lista con todas las imï¿½genes que encuentra
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
	
	/**
	 * Reinicia el tablero para jugar una nueva partida
	 */
	public void reiniciarPartida() {
		int indice = 0;
		labelEstado.setText("EN PROCESO");
		labelMovimientos.setText("0");
		victoria = false;
		ArrayList<Image> imagenes = devolverListaImagenes();
		while(imagenes.size()>0) {
			for (int i = 0; i < casillas.length; i++) {
				for (int j = 0; j < casillas[i].length; j++) {
					casillas[i][j].setIcon(new ImageIcon(imagenes.get(0)));
					casillas[i][j].setRuta(Integer.toString(indice));
					imagenes.remove(0);
					indice++;
				}
			}
		}
		desordenarTablero();
	}
	
	/**
	 * Si se ha cumplido la condición para ganar, muestra el fin del juego
	 */
	public void mostrarFinJuego() {
		victoria = true;
		labelEstado.setText("FINALIZADA");
		JOptionPane.showMessageDialog(panelJuego, "¡¡Has ganado!! Pulsa el botón REINICIAR para jugar de nuevo.", "¡¡Enhorabuena!!", 2);
	}
	
	/**
	 * Comprueba si se ha ganado
	 * @return
	 */
	public boolean comprobarVictoria() {
		return casillas[0][1].getRuta().equals("1")&&
			   casillas[0][2].getRuta().equals("2")&&
			   casillas[1][0].getRuta().equals("3")&&
			   casillas[1][1].getRuta().equals("4")&&
			   casillas[1][2].getRuta().equals("5")&&
			   casillas[2][0].getRuta().equals("6")&&
			   casillas[2][1].getRuta().equals("7")&&
			   casillas[2][2].getRuta().equals("8");
	}
	
	/**
	 * Inicializa la ventana y los componentes
	 */
	public void inicializar() {
		marco.setVisible(true);
		inicializarComponentes();
	}
}
