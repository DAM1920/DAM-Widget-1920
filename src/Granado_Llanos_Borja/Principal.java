package Granado_Llanos_Borja;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Principal {

	public static void main(String[] args) {
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {

					new VentanaPrincipal().inicializar();
				}
			});

		}

	}