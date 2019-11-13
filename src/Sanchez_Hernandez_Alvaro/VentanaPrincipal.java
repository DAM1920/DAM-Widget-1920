package Sanchez_Hernandez_Alvaro;



import javax.swing.JFrame;

public class VentanaPrincipal {
	
	private JFrame marco;
	private PanelNotas panel;
	
	public VentanaPrincipal() {
		marco = new JFrame("Panel Notas");
		marco.setBounds(100, 100, 400, 500);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void inicializar() {
		marco.setVisible(true);
		panel = new PanelNotas();
	}
	
}
