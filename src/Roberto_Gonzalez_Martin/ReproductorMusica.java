package Roberto_Gonzalez_Martin;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ReproductorMusica extends JDialog{
	private static final long serialVersionUID = 1L;
	JTextField nombreCancion;
	JButton carpeta;
	JButton reproduccion;
	JButton avanzar;
	JButton retroceder;
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
		this.setLayout(new GridBagLayout());
		GridBagConstraints settingObjeto = new GridBagConstraints();
		
		nombreCancion = new JTextField("Seleccione la canción que desea escuchar:");
		nombreCancion.setEditable(false);
		settingObjeto.gridx = 0;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 10;
		settingObjeto.fill = GridBagConstraints.HORIZONTAL;
		this.add(nombreCancion,settingObjeto);
		
		settingObjeto = new GridBagConstraints();
		carpeta = new JButton("Canción");
		settingObjeto.gridx = 1;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.fill = GridBagConstraints.HORIZONTAL;
		this.add(carpeta,settingObjeto);
		
		settingObjeto = new GridBagConstraints();
		avanceCancion = new JSlider(0,100);
		settingObjeto.gridx = 0;
		settingObjeto.gridy = 1;
		settingObjeto.weightx = 10;
		settingObjeto.fill = GridBagConstraints.HORIZONTAL;
		this.add(avanceCancion,settingObjeto);
		
		settingObjeto = new GridBagConstraints();
		retroceder = new JButton("<<");
		settingObjeto.gridx = 0;
		settingObjeto.gridy = 2;
		settingObjeto.weightx = 1;
		this.add(retroceder,settingObjeto);
		
		settingObjeto = new GridBagConstraints();
		reproduccion = new JButton("Play");
		settingObjeto.gridx = 1;
		settingObjeto.gridy = 2;
		settingObjeto.weightx = 1;
		this.add(reproduccion,settingObjeto);
		
		settingObjeto = new GridBagConstraints();
		avanzar = new JButton(">>");
		settingObjeto.gridx = 2;
		settingObjeto.gridy = 2;
		settingObjeto.weightx = 1;
		this.add(avanzar,settingObjeto);
	}
	
	/**
	 * Método que añade todos los listeners al Dialog
	 */
	private void anadirListeners(){
		
	}
}
