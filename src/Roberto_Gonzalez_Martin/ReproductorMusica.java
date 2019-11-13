package Roberto_Gonzalez_Martin;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ReproductorMusica extends JDialog{
	private static final long serialVersionUID = 1L;
	JPanel panelSuperior;
	JPanel panelCentral;
	JPanel panelInferior;
	JTextField nombreCancion;
	JButton carpeta;
	JButton reproduccion;
	JButton avanzar;
	JButton retroceder;
	JButton detener;
	JSlider volumen;
	JSlider avanceCancion;
	
	public ReproductorMusica() {
		super();
		setModal(true);
		setBounds(0,0, 500, 300);
		anadirElementos();
		anadirListeners();
	}

	/**
	 * Método que añade todos los elementos al Dialog. Se codifica como un JFrame
	 */
	private void anadirElementos(){
		this.setLayout(new GridLayout(3,1));
		GridBagConstraints settingObjeto = new GridBagConstraints();
		
		panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridBagLayout());
		panelSuperior.setBorder(BorderFactory.createTitledBorder("Explorador de archivos"));
		nombreCancion = new JTextField("Seleccione la canción que desea escuchar:");
		nombreCancion.setEditable(false);
		settingObjeto.gridx = 0;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 9;
		settingObjeto.fill = GridBagConstraints.HORIZONTAL;
		settingObjeto.anchor = GridBagConstraints.NORTH;
		panelSuperior.add(nombreCancion,settingObjeto);
		
		
		settingObjeto = new GridBagConstraints();
		carpeta = new JButton("Canción");
		settingObjeto.gridx = 1;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.fill = GridBagConstraints.HORIZONTAL;
		settingObjeto.anchor = GridBagConstraints.NORTH;
		panelSuperior.add(carpeta,settingObjeto);
		this.add(panelSuperior);
		
		panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(1,1));
		panelCentral.setBorder(BorderFactory.createTitledBorder("Progreso de la canción"));
		avanceCancion = new JSlider(0,100);
		panelCentral.add(avanceCancion);
		this.add(panelCentral);
		
		panelInferior = new JPanel();
		panelInferior.setLayout(new GridBagLayout());
		panelInferior.setBorder(BorderFactory.createTitledBorder("Controles de la canción"));
		settingObjeto = new GridBagConstraints();
		retroceder = new JButton("<<");
		settingObjeto.gridx = 0;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.gridwidth = 1;
		panelInferior.add(retroceder,settingObjeto);
		
		settingObjeto = new GridBagConstraints();
		reproduccion = new JButton("Play");
		settingObjeto.gridx = 1;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.gridwidth = 1;
		panelInferior.add(reproduccion,settingObjeto);
		
		settingObjeto = new GridBagConstraints();
		detener = new JButton("Stop");
		settingObjeto.gridx = 2;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.gridwidth = 1;
		panelInferior.add(detener,settingObjeto);
		
		settingObjeto = new GridBagConstraints();
		avanzar = new JButton(">>");
		settingObjeto.gridx = 3;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.gridwidth = 1;
		panelInferior.add(avanzar,settingObjeto);
		
		settingObjeto = new GridBagConstraints();
		volumen = new JSlider(0,100);
		volumen.setBorder(BorderFactory.createTitledBorder("Volumen"));
		settingObjeto.gridx = 4;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 4;
		settingObjeto.gridwidth = 4;
		settingObjeto.fill = GridBagConstraints.HORIZONTAL;
		panelInferior.add(volumen,settingObjeto);
		this.add(panelInferior);
	}
	
	/**
	 * Método que añade todos los listeners al Dialog
	 */
	private void anadirListeners(){
		
	}
}
