package García_Pérez_José_Daniel;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class BlocDeTexto extends JTextPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlocDeTexto() {
		SimpleAttributeSet attrs = new SimpleAttributeSet();
		StyleConstants.setBold(attrs, true);

	}
}
