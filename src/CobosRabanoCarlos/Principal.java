package CobosRabanoCarlos;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Principal {
	public static void main(String[] args) {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//Colocamos una apariencia diferente en jswing
			// UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sampler sampler = new Sampler();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
