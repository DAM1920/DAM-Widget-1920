package CobosRabanoCarlos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Utilidades {

	public Utilidades() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void guardarSampler(BotonSampler[][] botones) {
		File f=new File("./sampler.sam");
		String descripciones[][]=new String[4][4];
		String [][] direcciones=new String[4][4];
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				descripciones[i][j]=botones[i][j].getDescripcion();
				direcciones[i][j]=botones[i][j].getFichero().getPath();
			}
		}
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(descripciones);
			oos.writeObject(direcciones);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void cargarSampler(BotonSampler[][] botones, JFrame actual) {
		JFrame ventana=actual;
		String[][] descripciones;
		String[][] direcciones;
 		JFileChooser chooser=new JFileChooser(".");
		chooser.setFileFilter(new FiltroExt(".sam"));
		int select;
		File f;
		select=chooser.showOpenDialog(actual);
		if(select==JFileChooser.APPROVE_OPTION) {
			f=chooser.getSelectedFile();
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(new FileInputStream(f));
				descripciones=(String[][])ois.readObject();
				direcciones=(String[][])ois.readObject();
				for (int i = 0; i < botones.length; i++) {
					for (int j = 0; j < botones[i].length; j++) {
						botones[i][j].setDescripcion(descripciones[i][j]);
						botones[i][j].setText(descripciones[i][j]);
						botones[i][j].setFichero(new File( direcciones[i][j]));
						botones[i][j].setSonido(new ReproduccionSonido(new File( direcciones[i][j]), botones[i][j]));
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
					}
		
	}
}
