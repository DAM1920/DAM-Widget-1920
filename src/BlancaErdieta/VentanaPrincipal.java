package BlancaErdieta;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VentanaPrincipal {
	JFrame ventana;
	JButton cambiar;
	JTextField cuadroTexto;
	String tipo;
	int estilo;
	int tamanio;
	
	
	public VentanaPrincipal() {

		ventana = new JFrame();
		ventana.setBounds(100, 100, 900, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());
		
		//inicializo los componentes y doy valores
		tipo = "Adobe Arabic";
		estilo = 0;
		tamanio =14;
		
		cambiar = new JButton("Cambiar letra");
		
		cuadroTexto = new JTextField();
		cuadroTexto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		cuadroTexto.setFont(new Font(tipo,estilo,tamanio));
		
		//introduzco componentes
		GridBagConstraints settingObject = new GridBagConstraints();
		
		settingObject.gridx=0;
		settingObject.gridy=0;
		settingObject.weighty=1;
		settingObject.weightx=1;
		settingObject.fill = GridBagConstraints.BOTH;
		ventana.add(cambiar,settingObject);
		
		settingObject.gridx=0;
		settingObject.gridy=1;
		settingObject.weighty=10;
		settingObject.weightx=1;
		settingObject.fill = GridBagConstraints.BOTH;
		ventana.add(cuadroTexto,settingObject);
		
		
		
	}
	/**
	 * Añado listener al botón de la ventana
	 **/
	public  void inicializarListeners() {
		
		cambiar.addActionListener(e->{
			DialogSelectorFuente selectorFuente = new DialogSelectorFuente(cambiar,tipo,estilo, tamanio);
			selectorFuente.setVisible(true);
			selectorFuente.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent arg0) {
					tipo=selectorFuente.getTipoElegido();
					estilo = selectorFuente.getEstiloElegido();
					tamanio = selectorFuente.getTamanio();
					cuadroTexto.setFont(new Font(tipo,estilo,tamanio));
				}
			});	
		});
		
	}
	
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}

}
