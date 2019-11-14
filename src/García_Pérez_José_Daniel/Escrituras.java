package García_Pérez_José_Daniel;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class Escrituras {
	VentanaPrincipal vp;
	JFrame ventana;
	JTextPane editor;

	public Escrituras(VentanaPrincipal vp, JFrame ventana, JTextPane editor) {
		this.vp = vp;
		this.ventana = ventana;
		this.editor = editor;
	}

	void save() {
		int i;
		Font fuente = editor.getFont();
		System.out.println(fuente);
		String font = editor.getFont().toString();
		JFileChooser archivo = new JFileChooser(System.getProperty("user.dir"));
		JFileChooser archivoBinario = new JFileChooser(System.getProperty("user.dir"));
		archivo.showSaveDialog(ventana);
		if (archivo.getSelectedFile() != null) {
			try {
				PrintWriter guardado = new PrintWriter(new File(archivo.getSelectedFile().toString()));
				guardado.write(editor.getText());
				JOptionPane.showMessageDialog(archivo, "El archivo fue guardado con éxito en la ruta establecida");
				guardado.close();

				archivoBinario.showSaveDialog(ventana);
				guardado = new PrintWriter(new File(archivoBinario.getSelectedFile().toString()));
				guardado.write(font);
				JOptionPane.showMessageDialog(archivo, "El archivo fue guardado con éxito en la ruta establecida");
				guardado.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	void open() {
		int i;
		String linea = "";
		String texto = "";
		String atributos = "";
		String fuente[];

		JFileChooser archivo = new JFileChooser(System.getProperty("user.dir"));
		JFileChooser archivoBinario = new JFileChooser(System.getProperty("user.dir"));
		archivo.showOpenDialog(ventana);
		if (archivo.getSelectedFile() != null) {
			try {
				BufferedReader lector = new BufferedReader(new FileReader(archivo.getSelectedFile().toString()));
				while ((linea = lector.readLine()) != null) {

					texto += linea;

				}
				editor.setText(texto);

				lector.close();

				archivoBinario.showOpenDialog(ventana);
				lector = new BufferedReader(new FileReader(archivoBinario.getSelectedFile().toString()));
				while ((linea = lector.readLine()) != null) {

					atributos += linea;

				}
				lector.close();
				fuente = atributos.split(",");
				for (int j = 0; j < fuente.length; j++) {
					System.out.println(fuente[j]);
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
