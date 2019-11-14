package Sanchez_Hernandez_Alvaro;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class VentanaPrincipal implements KeyListener{
	
	private JFrame marco;
	private PanelNotas panel;
	
	public VentanaPrincipal() {
		marco = new JFrame("Panel Notas");
		marco.setBounds(100, 100, 400, 500);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void inicializar() {
		marco.setVisible(true);
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_CONTROL) {
			panel = new PanelNotas();
			panel.setVisible(true);
			panel.revalidate();
			panel.repaint();
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
