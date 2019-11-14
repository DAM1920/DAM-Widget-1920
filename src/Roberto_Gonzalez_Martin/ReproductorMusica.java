package Roberto_Gonzalez_Martin;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


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
	File cancion;
	AudioInputStream ais;
	Clip clip;
	
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
		avanceCancion = new JSlider(JSlider.HORIZONTAL,0,100,0);
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
		volumen = new JSlider(JSlider.HORIZONTAL,0,100,50);
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
		carpeta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(fileChooser);
				cancion = fileChooser.getSelectedFile();
				nombreCancion.setText(cancion.getName());
				try {
					ais = AudioSystem.getAudioInputStream(cancion.getAbsoluteFile());
					clip = AudioSystem.getClip();
					clip.open(ais);
				} catch (UnsupportedAudioFileException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				}
			}
		});
		reproduccion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float duracion = clip.getMicrosecondLength();
				float avance = clip.getMicrosecondPosition();
				float posicion = (100*avance)/duracion;
				if(clip.isRunning()) {
					clip.stop();
				} else {
					clip.start();
				}
				while(clip.isRunning()) {
					avanceCancion.setValue((int)posicion);
				}
			}
		});
		detener.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clip.stop();
			}
		});
		retroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		avanzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		volumen.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				
			}
		});
	}
}
