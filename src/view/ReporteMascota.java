package view;


import control.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import model.Razas;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import model.Color;
import java.awt.Button;
import model.EstadoTipos;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ReporteMascota extends JFrame {

	private Control controller;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public ReporteMascota(Control controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Razas.values()));
		comboBox.setBounds(10, 36, 145, 30);
		contentPane.add(comboBox);
		
		JLabel lblTipoDeMascota = new JLabel("Tipo de Mascota");
		lblTipoDeMascota.setBounds(10, 11, 115, 14);
		contentPane.add(lblTipoDeMascota);
		
		JLabel lblRazas = new JLabel("Raza");
		lblRazas.setBounds(235, 11, 46, 14);
		contentPane.add(lblRazas);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(165, 36, 200, 30);
		contentPane.add(comboBox_1);
		
		JLabel lblNombreDeMascota = new JLabel("Nombre de Mascota");
		lblNombreDeMascota.setBounds(10, 110, 103, 14);
		contentPane.add(lblNombreDeMascota);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 85, 546, 8);
		contentPane.add(separator);
		
		textField = new JTextField();
		textField.setBounds(160, 107, 229, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblChipId = new JLabel("Chip ID");
		lblChipId.setBounds(10, 154, 46, 14);
		contentPane.add(lblChipId);
		
		passwordField = new JPasswordField();
		passwordField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		passwordField.setBounds(160, 151, 229, 20);
		contentPane.add(passwordField);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(440, 11, 46, 14);
		contentPane.add(lblColor);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(Color.values()));
		comboBox_2.setBounds(375, 36, 161, 30);
		contentPane.add(comboBox_2);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setBounds(10, 194, 46, 14);
		contentPane.add(lblFoto);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(160, 191, 229, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		Button button = new Button("Cargar foto");
		button.setBounds(433, 194, 70, 22);
		contentPane.add(button);
		
		JLabel lblDatosDeContacto = new JLabel("Datos de Contacto");
		lblDatosDeContacto.setBounds(235, 226, 115, 14);
		contentPane.add(lblDatosDeContacto);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 232, 215, 8);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(341, 232, 215, 8);
		contentPane.add(separator_2);
		
		JLabel lblTelfonoReportante = new JLabel("Tel\u00E9fono reportante");
		lblTelfonoReportante.setBounds(10, 251, 103, 14);
		contentPane.add(lblTelfonoReportante);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 251, 229, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmailReportante = new JLabel("E-Mail reportante");
		lblEmailReportante.setBounds(10, 296, 46, 14);
		contentPane.add(lblEmailReportante);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 293, 229, 20);
		contentPane.add(textField_3);
		
		JLabel lblTipoDeReporte = new JLabel("Tipo de Reporte");
		lblTipoDeReporte.setBounds(440, 251, 96, 14);
		contentPane.add(lblTipoDeReporte);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Extraviado", "Encontrado"}));
		comboBox_3.setBounds(434, 272, 102, 20);
		contentPane.add(comboBox_3);
		
		JLabel lblLugarDeEncuentroextravo = new JLabel("Lugar de encuentro/extrav\u00EDo");
		lblLugarDeEncuentroextravo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLugarDeEncuentroextravo.setBounds(10, 335, 145, 14);
		contentPane.add(lblLugarDeEncuentroextravo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 332, 229, 20);
		contentPane.add(textField_4);
		
		JLabel lblFechaDeEncuentroextravo = new JLabel("Fecha de encuentro/extrav\u00EDo");
		lblFechaDeEncuentroextravo.setBounds(10, 379, 145, 14);
		contentPane.add(lblFechaDeEncuentroextravo);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1414648800000L), new Date(-2208963684000L), new Date(4102466400000L), Calendar.DAY_OF_YEAR));
		spinner.setBounds(10, 404, 124, 20);
		contentPane.add(spinner);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(287, 404, 135, 20);
		contentPane.add(formattedTextField);
		
		JCheckBox chckbxHayRecompensa = new JCheckBox("Hay recompensa?");
		chckbxHayRecompensa.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(!chckbxHayRecompensa.isSelected()) 
					formattedTextField.setEnabled(false);
				else formattedTextField.setEnabled(true);
			}
		});
		chckbxHayRecompensa.setBounds(151, 401, 124, 23);
		contentPane.add(chckbxHayRecompensa);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(559, 11, 10, 442);
		contentPane.add(separator_3);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		editorPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		editorPane.setBounds(579, 52, 332, 401);
		contentPane.add(editorPane);
		
		JLabel lblDescripcinDeMascotas = new JLabel("Descripci\u00F3n de Mascotas");
		lblDescripcinDeMascotas.setBounds(688, 27, 200, 14);
		contentPane.add(lblDescripcinDeMascotas);
		
		JLabel lblMoneda = new JLabel("Moneda");
		lblMoneda.setBounds(453, 379, 46, 14);
		contentPane.add(lblMoneda);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"$ - D\u00F3lares", "\u20AC - Euros", "\u20A1 - Colones"}));
		comboBox_4.setBounds(434, 404, 102, 20);
		contentPane.add(comboBox_4);
	}
}
