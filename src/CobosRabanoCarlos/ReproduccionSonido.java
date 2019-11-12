package CobosRabanoCarlos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ReproduccionSonido extends Thread implements Serializable{
	File fich;
	boolean pausa;
	Player apl;

	public ReproduccionSonido(File fich) {
		this.fich = fich;
		pausa = true;
		try {
			apl=new Player(new FileInputStream(fich));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reproduce el sonido cuya ruta le hemos pasado por parámetros
	 */
	

	public void run() {
		pausa=false;
		try {
			while (true) {
				if (!pausa) {
					if (!apl.play(1)) {
						break;
					}
				}
			}
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
		pausa=true;

	}

	public boolean isPausado() {
		return pausa;
	}

	

	public void parar() {		
		pausa=true;
	}
}
