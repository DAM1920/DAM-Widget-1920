package Sanchez_Hernandez_Alvaro;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class VentanaPrincipal implements KeyListener{
	
	private JFrame marco;
	private PanelNotas panel;
	
	//Constructor
	public VentanaPrincipal() {
		marco = new JFrame("Panel Notas");
		marco.setBounds(100, 100, 0, 0);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.addKeyListener(this);
	}
	//Muestra la ventana.
	public void inicializar() {
		marco.setVisible(true);
		panel = new PanelNotas();
		panel.setVisible(false);
	}
	
	
	//Establece el Listener para que se habra el panel al pulsar el control.
	//Controla que el panel no este ya desplegado.
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(!panel.isVisible()) {
			if(key == KeyEvent.VK_CONTROL) {
				panel = new PanelNotas();
				panel.setVisible(true);
				panel.revalidate();
				panel.repaint();
				}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
