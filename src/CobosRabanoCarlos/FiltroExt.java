package CobosRabanoCarlos;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Es una clase hija de FileFilter que nos permite filtrar los objetos de un JFileChooser según la extensión que le pasemos por parámetros
 * @author ccobosr02
 *
 */
public class FiltroExt extends FileFilter{

	private String ext;	
		
	public FiltroExt(String ext) {
		this.ext = ext;
	}

	@Override
	public boolean accept(File fich) {
		// TODO Auto-generated method stub
		return extension(fich);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean extension(File f) {
		return f.getName().endsWith(ext);
	}
}
