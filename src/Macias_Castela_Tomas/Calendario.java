package Macias_Castela_Tomas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Calendario extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8869075441821100033L;
	JComboBox<String> mes;
	JComboBox<String> year = new JComboBox<String>();
	String[] month = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Septiembre", "Octube",
			"Noviembre", "Diciembre" };
	String[] dia = { "Lun", "Mar", "Mie", "Jue", "Vie", "Sab", "Dom" };
	JButton[] botonDia = new JButton[42];
	JPanel[] panelNumDia = new JPanel[42];
	JPanel panelEncabezado, panelDia;
	JLabel[] textoDias = new JLabel[7];
	JLabel mesYearActual;
	
	int yearPrincipio = 60, yearFinal = 60;
	int yearActual, mesSelec, numDia, maxDia, diaPrincipal;
	
	GregorianCalendar cal = new GregorianCalendar();
	GridBagConstraints gbc = new GridBagConstraints();
	Font texto = new Font("Arial", Font.BOLD, 11);
	
	Calendar calendario = Calendar.getInstance();
	int diaActual = calendario.get(Calendar.DAY_OF_MONTH);
	int mesReal;
	
	public Calendario() {
		setModal(true);
		setBounds(0, 0, 450, 350);
		this.setLayout(new GridBagLayout());
		iniciarComboBox();
		insertarEncabezado();
		insertarPanelBoton();
		insertarDias(mesSelec, yearActual);
		cambiarMes();
		cambiarYear();
		insertarNotas();
	}

	/**
	 * Metodo para iniciarlizar el JComboBox.
	 */
	public void iniciarComboBox() {
		//Sacamos el año actual
		yearActual = cal.get(GregorianCalendar.YEAR);
		//Sacamos el mes actual.
		mesReal = cal.get(GregorianCalendar.MONTH);
		//Seleccionamos el mes. 
		mesSelec = mesReal-1;
		mes = new JComboBox<String>(month);
		//El mes seleccionado por defecto.
		mes.setSelectedIndex(mesSelec);
		//Añadimos la lista de los años.
		for (int i = yearActual - yearPrincipio; i < yearActual + yearFinal; i++) {
			year.addItem(String.valueOf(i));
		}
		//El año seleccionado por defecto.
		year.setSelectedIndex(yearPrincipio);
	}

	/**
	 * Metodo para inicializarEncabezado.
	 */
	public void insertarEncabezado() {
		panelEncabezado = new JPanel();
		panelEncabezado.setLayout(new GridBagLayout());
		// JComboBox mes.
		panelEncabezado.add(mes);
		// Mes y año seleccionado.
		gbc = new GridBagConstraints();
		mesYearActual = new JLabel(mes.getItemAt(mesSelec) + " " + yearActual);
		mesYearActual.setHorizontalAlignment(SwingUtilities.CENTER);
		gbc.ipadx = 30;
		panelEncabezado.add(mesYearActual, gbc);
		// JComboBox año.
		panelEncabezado.add(year);
		gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(panelEncabezado, gbc);
	}

	/**
	 * Metodo para crear los botones e insertarlos.
	 */
	public void insertarPanelBoton() {
		gbc = new GridBagConstraints();
		panelDia = new JPanel();
		panelDia.setLayout(new GridLayout(7, 7));
		// Insertar el encabezado.
		for (int i = 0; i < textoDias.length; i++) {
			textoDias[i] = new JLabel();
			textoDias[i].setText(dia[i]);
			textoDias[i].setHorizontalAlignment(SwingUtilities.CENTER);
			panelDia.add(textoDias[i]);
		}
		// Insertar los botones dentro del panel.
		for (int j = 0; j < panelNumDia.length; j++) {
			panelNumDia[j] = new JPanel();
			botonDia[j] = new JButton();
			botonDia[j].setMinimumSize(new Dimension(50, 25));
			botonDia[j].setMaximumSize(new Dimension(50, 25));
			botonDia[j].setPreferredSize(new Dimension(50, 25));
			botonDia[j].setEnabled(false);
			panelNumDia[j].add(botonDia[j]);
			panelDia.add(panelNumDia[j]);
		}
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(panelDia, gbc);
	}

	/**
	 * Iniciar los botones con dias.
	 */
	public void insertarDias(int mesSelec, int yearActual) {
		cal = new GregorianCalendar(yearActual, mesSelec + 1, 1);
		// Maximos de dias del mes.
		maxDia = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		// El dia 1 que dia de la semana cae.
		diaPrincipal = cambiarDiaPrincipal(cal.get(GregorianCalendar.DAY_OF_WEEK));
		
		// Ponemos todo a 0 si hay algo escrito.
		for (int j = 0; j < botonDia.length; j++) {
			botonDia[j].setText("");
			botonDia[j].setEnabled(false);
			botonDia[j].setBackground(null);
		}

		// Insertamos los digitos en sus respectivos dias.
		for (int i = 1; i <= maxDia; i++) {
			botonDia[diaPrincipal].setText(String.valueOf(i));
			botonDia[diaPrincipal].setEnabled(true);
			if(diaPrincipal==diaActual && mesReal==mesSelec+1) {
				botonDia[diaPrincipal].setBackground(Color.LIGHT_GRAY);
			}else {
				botonDia[diaPrincipal].setBackground(Color.WHITE);
			}			
			diaPrincipal++;
		}
	}

	/**
	 * Metodo para cambiar la posicion de dias.
	 * 
	 * @param diaPrincipal Pasamos por parametro el día en el que estamos.
	 * @return retornamos la nueva posicion.
	 */
	public int cambiarDiaPrincipal(int diaPrincipal) {
		if (diaPrincipal == 1) {
			diaPrincipal = 6; // Domingo.
		} else if (diaPrincipal == 2) {
			diaPrincipal = 0; // Lunes.
		} else if (diaPrincipal == 3) {
			diaPrincipal = 1; // Martes.
		} else if (diaPrincipal == 4) {
			diaPrincipal = 2; // Miercoles.
		} else if (diaPrincipal == 5) {
			diaPrincipal = 3; // Jueves.
		} else if (diaPrincipal == 6) {
			diaPrincipal = 4; // Viernes.
		} else if (diaPrincipal == 7) {
			diaPrincipal = 5; // Sabado.
		}
		return diaPrincipal;
	}

	/**
	 * Accion si pulsamos para cambiar el mes.
	 */
	public void cambiarMes() {
		mes.addActionListener(e -> {
			if (mes.getSelectedItem() != null) {
				mesSelec = mes.getSelectedIndex();
				mesYearActual.setText(mes.getItemAt(mesSelec) + " " + yearActual);
				insertarDias(mesSelec, yearActual);
			}
		});
	}
	/**
	 * Accion si pulsamos para cambiar el año.
	 */
	public void cambiarYear() {
		year.addActionListener(e -> {
			if (year.getSelectedItem() != null) {
				String y = year.getSelectedItem().toString();
				yearActual = Integer.parseInt(y);
				mesYearActual.setText(mes.getItemAt(mesSelec) + " " + yearActual);
				insertarDias(mesSelec, yearActual);
			}
		});
	}
	
	/**
	 * Acciones para añadir ficheros.
	 */
	public void insertarNotas() {
		diaPrincipal = cambiarDiaPrincipal(cal.get(GregorianCalendar.DAY_OF_WEEK));
		System.out.println(maxDia);
		for (int i = 1; i <= maxDia; i++) {
			System.out.println(diaPrincipal);
			diaPrincipal = i;
			botonDia[diaPrincipal].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Hola "+botonDia[diaPrincipal].getText());
					
				}
			});
			diaPrincipal++;
		}
	}

}
