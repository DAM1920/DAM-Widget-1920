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
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(botones);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static BotonSampler[][] cargarSampler(BotonSampler[][] botones, JFrame actual) {
		JFrame ventana=actual;
		BotonSampler[][] devolver=botones;
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
				botones=(BotonSampler[][])ois.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return botones;
	}
}
