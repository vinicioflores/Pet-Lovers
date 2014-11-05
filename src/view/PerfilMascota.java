package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;

import java.awt.Dimension;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import model.Mascota;
import model.Razas;
import model.PetColor;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import control.Control;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;

public class PerfilMascota extends JFrame {

	private JPanel contentPane;
	private JLabel photoLabel;
	private JLabel nombreLabel;
	private JTextField nombreTextField;
	private JTextField chipTextField;
	private JTextField lugarTextField;
	private JTextField recompensaTextField;
	private Control controller;
	private JCheckBox chckbxHayRecompensa;
	private JComboBox monedaComboBox;
	private JSpinner dateSpinner;
	private JComboBox estadoComboBox;
	private JComboBox colorComboBox;
	private JComboBox tipoComboBox;
	private JTextArea descripcionTextArea;
	private JButton albumButton;
	private JComboBox razasComboBox;

	/**
	 * Create the frame.
	 */
	public PerfilMascota(Control c, Mascota m) {
		this.controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 584);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		horizontalBox.setBounds(10, 11, 342, 295);
		contentPane.add(horizontalBox);
		
		photoLabel = new JLabel("");
		photoLabel.setIcon(new ImageIcon(ReporteMascota.class.getResource(m.getFoto())));
		horizontalBox.add(photoLabel);
		
		nombreLabel = new JLabel("Nombre");
		nombreLabel.setForeground(Color.BLUE);
		nombreLabel.setBounds(362, 11, 46, 14);
		contentPane.add(nombreLabel);
		
		nombreTextField = new JTextField();
		nombreTextField.setBounds(430, 8, 196, 20);
		contentPane.add(nombreTextField);
		nombreTextField.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.BLUE);
		lblTipo.setBounds(362, 47, 46, 14);
		contentPane.add(lblTipo);
		
		tipoComboBox = new JComboBox();
		tipoComboBox.setForeground(Color.BLUE);
		tipoComboBox.setModel(new DefaultComboBoxModel(Razas.values()));
		tipoComboBox.setBounds(430, 44, 60, 20);
		contentPane.add(tipoComboBox);
		
		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setForeground(Color.BLUE);
		lblRaza.setBounds(494, 47, 46, 14);
		contentPane.add(lblRaza);
		
		JLabel lblChipId = new JLabel("Chip ID");
		lblChipId.setForeground(Color.BLUE);
		lblChipId.setBounds(362, 79, 46, 14);
		contentPane.add(lblChipId);
		
		chipTextField = new JTextField();
		chipTextField.setBounds(430, 76, 196, 20);
		contentPane.add(chipTextField);
		chipTextField.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setForeground(Color.BLUE);
		lblColor.setBounds(362, 118, 46, 14);
		contentPane.add(lblColor);
		
		colorComboBox = new JComboBox();
		colorComboBox.setForeground(Color.BLUE);
		colorComboBox.setModel(new DefaultComboBoxModel(PetColor.values()));
		colorComboBox.setBounds(430, 115, 86, 20);
		contentPane.add(colorComboBox);
		
		JLabel lblEstado = new JLabel("Estado ");
		lblEstado.setForeground(Color.BLUE);
		lblEstado.setBounds(362, 143, 46, 14);
		contentPane.add(lblEstado);
		
		estadoComboBox = new JComboBox();
		estadoComboBox.setForeground(Color.BLUE);
		estadoComboBox.setEnabled(false);
		estadoComboBox.setBounds(430, 140, 86, 20);
		contentPane.add(estadoComboBox);
		
		JLabel lblLugarDeEncuentroextravo = new JLabel("Lugar de encuentro/extrav\u00EDo");
		lblLugarDeEncuentroextravo.setForeground(Color.BLUE);
		lblLugarDeEncuentroextravo.setBounds(362, 175, 264, 14);
		contentPane.add(lblLugarDeEncuentroextravo);
		
		lugarTextField = new JTextField();
		lugarTextField.setBounds(362, 200, 264, 20);
		contentPane.add(lugarTextField);
		lugarTextField.setColumns(10);
		
		JLabel lblFechaDeEncuentroextravo = new JLabel("Fecha de encuentro/extrav\u00EDo");
		lblFechaDeEncuentroextravo.setForeground(Color.BLUE);
		lblFechaDeEncuentroextravo.setBounds(362, 231, 264, 14);
		contentPane.add(lblFechaDeEncuentroextravo);
		
		chckbxHayRecompensa = new JCheckBox("Hay recompensa?");
		chckbxHayRecompensa.setBackground(Color.WHITE);
		chckbxHayRecompensa.setForeground(Color.BLUE);
		chckbxHayRecompensa.setBounds(10, 313, 141, 23);
		contentPane.add(chckbxHayRecompensa);
		
		recompensaTextField = new JTextField();
		recompensaTextField.setBounds(160, 314, 158, 20);
		contentPane.add(recompensaTextField);
		recompensaTextField.setColumns(10);
		
		monedaComboBox = new JComboBox();
		monedaComboBox.setModel(new DefaultComboBoxModel(new String[] {"$ - D\u00F3lares", "\u20AC - Euros", "\u20A1 - Colones"}));
		monedaComboBox.setForeground(Color.BLUE);
		monedaComboBox.setBounds(328, 314, 91, 20);
		contentPane.add(monedaComboBox);
		
		descripcionTextArea = new JTextArea();
		descripcionTextArea.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		descripcionTextArea.setBackground(Color.LIGHT_GRAY);
		descripcionTextArea.setBounds(10, 349, 409, 186);
		contentPane.add(descripcionTextArea);
		
		dateSpinner = new JSpinner();
		dateSpinner.setModel(new SpinnerDateModel(new Date(1414994400000L), null, null, Calendar.DAY_OF_YEAR));
		dateSpinner.setBounds(362, 252, 141, 20);
		contentPane.add(dateSpinner);
		
		albumButton = new JButton("");
		albumButton.setFocusable(false);
		albumButton.setIcon(new ImageIcon(PerfilMascota.class.getResource("/resources/album119x49.png")));
		albumButton.setRolloverIcon(new ImageIcon(PerfilMascota.class.getResource("/resources/album119x49_pressed.png")));
		albumButton.setForeground(Color.BLUE);
		albumButton.setBounds(507, 486, 119, 49);
		contentPane.add(albumButton);
		
		razasComboBox = new JComboBox();
		razasComboBox.setForeground(Color.BLUE);
		razasComboBox.setBounds(531, 45, 95, 20);
		contentPane.add(razasComboBox);
		
		configurarValidezEdicion(m);
	}
	
	private void configurarValidezEdicion(Mascota m)
	{
		if(!controller.getUsuarioLogeado().equals(m.getContacto().getUsuarioAsociado()))
		{
			nombreTextField.setEnabled(false);
			chipTextField.setEnabled(false);
			razasComboBox.setEnabled(false);
			lugarTextField.setEnabled(false);
			recompensaTextField.setEnabled(false);
			chckbxHayRecompensa.setEnabled(false);
			dateSpinner.setEnabled(false);
			monedaComboBox.setEnabled(false);
			descripcionTextArea.setEnabled(false);
			estadoComboBox.setEnabled(false);
			tipoComboBox.setEnabled(false);
			colorComboBox.setEnabled(false);
		}
	}
}
