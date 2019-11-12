package PedroLuis_Rodriguez_Perez;

import javax.swing.JFrame;

public class VentanaPrincipal {
	JFrame marco;
	Formulario form;
	
	public VentanaPrincipal() {
		marco = new JFrame();		
		form = new Formulario();
		marco.add(form);
		marco.setBounds(0, 0, 1000, 1000);
		marco.setVisible(true);
	}
}
