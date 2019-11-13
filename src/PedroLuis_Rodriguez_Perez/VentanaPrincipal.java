package PedroLuis_Rodriguez_Perez;

import javax.swing.JFrame;

public class VentanaPrincipal {
	JFrame marco;
	Formulario form;
	String [] atributos = {"Nombre","Apellido","DNI","Ciudad","Edad"};
	public VentanaPrincipal() {
		marco = new JFrame();		
		form = new Formulario(atributos);
		marco.add(form);
		marco.setBounds(0, 0, 1000, 1000);
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
