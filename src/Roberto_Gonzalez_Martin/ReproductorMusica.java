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
		setBounds(0,0, 700, 300);
		anadirElementos();
		anadirListeners();
	}

	/**
	 * Método que añade todos los elementos al Dialog. Se codifica como un JFrame
	 */
	private void anadirElementos(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints settingObjeto = new GridBagConstraints();
	}
	
	/**
	 * Método que añade todos los listeners al Dialog
	 */
	private void anadirListeners(){
		
	}
}
