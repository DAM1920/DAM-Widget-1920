package García_Pérez_José_Daniel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
				guardado.println(vp.colorActual);
				guardado.println(vp.fuente);
				guardado.println(Boolean.toString(vp.italica));
				guardado.println(Boolean.toString(vp.negrita));
				guardado.println(vp.tamanioActual);
				guardado.println(vp.indice);
				guardado.println(vp.indiceTamanio);
				JOptionPane.showMessageDialog(archivo, "El archivo fue guardado con éxito en la ruta establecida");
				guardado.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	void open() {
		String linea = "";
		String texto = "";
		String atributos = "";
		ArrayList<String> fuentes = new ArrayList<String>();

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

					fuentes.add(linea);

				}
				lector.close();
				try {
					vp.fuente = fuentes.get(1);
					vp.italica = Boolean.parseBoolean(fuentes.get(2));
					vp.negrita = Boolean.parseBoolean(fuentes.get(3));
					vp.tamanioActual = Integer.parseInt(fuentes.get(4));
					vp.indice = Integer.parseInt(fuentes.get(5));
					vp.indiceTamanio = Integer.parseInt(fuentes.get(6));
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(archivo, "No se ha insertado un archivo de fuentes correcto");
				}
				vp.actualizarFuentes();

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
