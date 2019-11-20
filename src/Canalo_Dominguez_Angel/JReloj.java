package Canalo_Dominguez_Angel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JReloj extends JPanel implements Runnable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	JLabel horaLabel;//JLabel que muestra la hora
	double tiempo;//Variable de tiempo
	Thread hilo = null;//Hilo del programa
	boolean contando = false, formato24 = false;//Booleanos que controlan la cuenta del tiempo y del formato
	Calendar calendario;//Variable Calendar de tiempo

	public JReloj() {
		super();
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		setLayout(new GridBagLayout());
		horaLabel = new JLabel();
		horaLabel.setFont(new Font("Impact", Font.PLAIN, 70));
		horaLabel.setForeground(Color.GREEN);
		add(horaLabel);
		hilo = new Thread(this);
		hilo.start();
	}

	public boolean parar() {
		return contando = false;
	}
	
	public void cambioColor(Color colorHora, Color colorFondo) {
		this.setBackground(colorFondo);
		horaLabel.setForeground(colorHora);
	}

	@Override
	public void run() {
		contando = true;
		while (contando) {
			calendario = Calendar.getInstance();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			actualizarPantalla(obtenerHora());
		}
	}

	private String obtenerHora() {
		int hora = 0, minuto, segundo;
		String tipoHora = "", sMinuto, sSegundo;
		if (!formato24) {
			hora = calendario.get(Calendar.HOUR);
			if (calendario.get(Calendar.HOUR_OF_DAY) <= 12) {
				tipoHora = " AM";
			} else {
				tipoHora = " PM";
			}
		} else {
			hora = calendario.get(Calendar.HOUR_OF_DAY);
		}
		minuto = calendario.get(Calendar.MINUTE);
		segundo = calendario.get(Calendar.SECOND);
		sMinuto = minuto >= 10 ? minuto + "" : "0" + minuto;
		sSegundo = segundo >= 10 ? segundo + "" : "0" + segundo;
		String tiempo = hora + ":" + sMinuto + ":" + sSegundo + "" + tipoHora;
		return tiempo;
	}

	private void actualizarPantalla(String tiempo) {
		horaLabel.setText(tiempo);
	}

}
