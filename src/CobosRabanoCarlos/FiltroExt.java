package CobosRabanoCarlos;

import java.io.File;

import javax.swing.filechooser.FileFilter;

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
