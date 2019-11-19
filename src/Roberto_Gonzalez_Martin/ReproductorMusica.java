package Roberto_Gonzalez_Martin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReproductorMusica extends JDialog {
	private static final long serialVersionUID = 1L;
	private static final int MAX_ANCHO_IMAGEN = 15;
	private static final int MAX_ALTO_IMAGEN = 15;
	JPanel panelSuperior;
	JPanel panelCentral;
	JPanel panelInferior;
	JTextField nombreCancion;
	JButton carpeta;
	JButton reproducir;
	JButton pausar;
	JButton avanzar;
	JButton retroceder;
	JButton detener;
	JSlider volumen;
	JSlider avanceCancion;
	File cancion;
	boolean reproduciendo;
	Long currentFrame;
	Long maxFrames;
	AudioInputStream ais;
	Clip clip;
	ImageIcon avanzarIcono = new ImageIcon("img/Roberto_Gonzalez_Martin/avanzaricono.png");
	ImageIcon carpetaIcono = new ImageIcon("img/Roberto_Gonzalez_Martin/carpetaicono.png");
	ImageIcon detenerIcono = new ImageIcon("img/Roberto_Gonzalez_Martin/detenericono.png");
	ImageIcon pausarIcono = new ImageIcon("img/Roberto_Gonzalez_Martin/pausaricono.png");
	ImageIcon reproducirIcono = new ImageIcon("img/Roberto_Gonzalez_Martin/reproduciricono.png");
	ImageIcon retrocederIcono = new ImageIcon("img/Roberto_Gonzalez_Martin/retrocedericono.png");
	Image imagen;
	ImageIcon icono;

	public ReproductorMusica() {
		super();
		setModal(true);
		setBounds(0, 0, 500, 300);
		anadirElementos();
		anadirListeners();
	}

	/**
	 * Método que añade todos los elementos al Dialog. Se codifica como un JFrame
	 */
	private void anadirElementos() {
		this.setLayout(new GridLayout(3, 1));
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
		panelSuperior.add(nombreCancion, settingObjeto);

		settingObjeto = new GridBagConstraints();
		carpeta = new JButton();
		imagen = carpetaIcono.getImage();
		icono = new ImageIcon(imagen.getScaledInstance(MAX_ANCHO_IMAGEN, MAX_ALTO_IMAGEN, Image.SCALE_SMOOTH));
		carpeta.setIcon(icono);
		settingObjeto.gridx = 1;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.fill = GridBagConstraints.HORIZONTAL;
		settingObjeto.anchor = GridBagConstraints.NORTH;
		panelSuperior.add(carpeta, settingObjeto);
		this.add(panelSuperior);

		panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(1, 1));
		panelCentral.setBorder(BorderFactory.createTitledBorder("Progreso de la canción"));
		avanceCancion = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		panelCentral.add(avanceCancion);
		this.add(panelCentral);

		panelInferior = new JPanel();
		panelInferior.setLayout(new GridBagLayout());
		panelInferior.setBorder(BorderFactory.createTitledBorder("Controles de la canción"));
		settingObjeto = new GridBagConstraints();
		retroceder = new JButton();
		imagen = retrocederIcono.getImage();
		icono = new ImageIcon(imagen.getScaledInstance(MAX_ANCHO_IMAGEN, MAX_ALTO_IMAGEN, Image.SCALE_SMOOTH));
		retroceder.setIcon(icono);
		settingObjeto.gridx = 0;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.gridwidth = 1;
		panelInferior.add(retroceder, settingObjeto);

		settingObjeto = new GridBagConstraints();
		reproducir = new JButton();
		imagen = reproducirIcono.getImage();
		icono = new ImageIcon(imagen.getScaledInstance(MAX_ANCHO_IMAGEN, MAX_ALTO_IMAGEN, Image.SCALE_SMOOTH));
		reproducir.setIcon(icono);
		settingObjeto.gridx = 1;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.gridwidth = 1;
		panelInferior.add(reproducir, settingObjeto);

		settingObjeto = new GridBagConstraints();
		pausar = new JButton();
		imagen = pausarIcono.getImage();
		icono = new ImageIcon(imagen.getScaledInstance(MAX_ANCHO_IMAGEN, MAX_ALTO_IMAGEN, Image.SCALE_SMOOTH));
		pausar.setIcon(icono);
		settingObjeto.gridx = 2;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.gridwidth = 1;
		panelInferior.add(pausar, settingObjeto);

		settingObjeto = new GridBagConstraints();
		detener = new JButton();
		imagen = detenerIcono.getImage();
		icono = new ImageIcon(imagen.getScaledInstance(MAX_ANCHO_IMAGEN, MAX_ALTO_IMAGEN, Image.SCALE_SMOOTH));
		detener.setIcon(icono);
		settingObjeto.gridx = 3;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.gridwidth = 1;
		panelInferior.add(detener, settingObjeto);

		settingObjeto = new GridBagConstraints();
		avanzar = new JButton();
		imagen = avanzarIcono.getImage();
		icono = new ImageIcon(imagen.getScaledInstance(MAX_ANCHO_IMAGEN, MAX_ALTO_IMAGEN, Image.SCALE_SMOOTH));
		avanzar.setIcon(icono);
		settingObjeto.gridx = 4;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 1;
		settingObjeto.gridwidth = 1;
		panelInferior.add(avanzar, settingObjeto);

		settingObjeto = new GridBagConstraints();
		volumen = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
		volumen.setBorder(BorderFactory.createTitledBorder("Volumen"));
		settingObjeto.gridx = 5;
		settingObjeto.gridy = 0;
		settingObjeto.weightx = 4;
		settingObjeto.gridwidth = 4;
		settingObjeto.fill = GridBagConstraints.HORIZONTAL;
		panelInferior.add(volumen, settingObjeto);
		this.add(panelInferior);
	}

	/**
	 * Método que añade todos los listeners al Dialog
	 */
	private void anadirListeners() {
		carpeta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Archivos de audio", "wav");
				fileChooser.setFileFilter(fileFilter);
				fileChooser.showOpenDialog(fileChooser);
				cancion = fileChooser.getSelectedFile();
				nombreCancion.setText(cancion.getName());
				try {
					ais = AudioSystem.getAudioInputStream(cancion.getAbsoluteFile());
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
					reproduciendo = true;
					currentFrame = 0l;
					maxFrames = clip.getMicrosecondLength();
					avanceCancion.setMinimum(0);
					avanceCancion.setMaximum((int) (long) maxFrames);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
			}
		});
		retroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saltoCancion(clip.getMicrosecondPosition()-10000000);
				avanceCancion.setValue((int)(long)currentFrame);
			}
		});
		reproducir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!reproduciendo) {
					clip.close();
					resetAudioStream();
					clip.setMicrosecondPosition(currentFrame);
					clip.start();
				}
			}
		});
		pausar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentFrame = clip.getMicrosecondPosition();
				avanceCancion.setValue((int)(long)currentFrame);
				clip.stop();
				reproduciendo = false;
			}
		});
		detener.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentFrame = 0l;
				avanceCancion.setValue((int)(long)currentFrame);
				clip.stop();
				reproduciendo = false;
			}
		});
		avanzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saltoCancion(clip.getMicrosecondPosition()+10000000);
				avanceCancion.setValue((int)(long)currentFrame);
			}
		});
		avanceCancion.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				saltoCancion((int) (long) avanceCancion.getValue());
			}
		});
		volumen.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				FloatControl controlVolumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				volumen.setMinimum((int) controlVolumen.getMinimum());
				volumen.setMaximum((int) controlVolumen.getMaximum());
				controlVolumen.setValue((float) volumen.getValue());
			}
		});
	}

	public void saltoCancion(long saltoCancion) {
		if (saltoCancion > 0 && saltoCancion < clip.getMicrosecondLength()) {
			clip.stop();
			clip.close();
			resetAudioStream();
			currentFrame = saltoCancion;
			clip.setMicrosecondPosition(saltoCancion);
			clip.start();
		}
	}

	public void resetAudioStream() {
		try {
			ais = AudioSystem.getAudioInputStream(cancion.getAbsoluteFile());
			clip.open(ais);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
	}
}
