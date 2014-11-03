package view;

import control.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Color;
import model.Razas;
import model.RazasGatos;
import model.RazasPerros;
import model.Tamaño;


public class ReporteMascota extends JFrame {

	private Control controller;
	private JPanel contentPane;
	
	private JComboBox comboBox;      // Tipo de mascota
	private JComboBox comboBox_1;    // Raza de animal
	private JComboBox comboBox_2;    // Color de mascota
	private JComboBox comboBox_3;    // Tipo de reporte o estado inicial de reporte
	private JComboBox comboBox_4;    // Moneda de recompensa (si corresponde)
	private JComboBox comboBox_5;    // Lista de tamaños
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	
	private JPasswordField passwordField;
	private JCheckBox chckbxHayRecompensa;
	
	private JSpinner spinner;
	private JEditorPane editorPane;
	private JFormattedTextField formattedTextField;
	private ReporteMascota pVentanaReporte = this;
	
	
	/**
	 * Create the frame.
	 */
	public ReporteMascota(Control controller) {
		setResizable(false);
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 987, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int selectedIndex = comboBox.getSelectedIndex();
				if(selectedIndex == Razas.Perro.ordinal()){
					comboBox_1.setModel(new DefaultComboBoxModel(RazasPerros.values()));
					comboBox_1.repaint();
				}
				
				else if(selectedIndex == Razas.Gato.ordinal()){
					comboBox_1.setModel(new DefaultComboBoxModel(RazasGatos.values()));
					comboBox_1.repaint();
				}
				
				else {
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {""}));
					comboBox_1.repaint();
				}
					
			}
		});
		
		comboBox.setBounds(10, 36, 145, 30);
		comboBox.setModel(new DefaultComboBoxModel(Razas.values()));
		contentPane.add(comboBox);
		
		JLabel lblTipoDeMascota = new JLabel("Tipo de Mascota");
		lblTipoDeMascota.setBounds(10, 11, 115, 14);
		contentPane.add(lblTipoDeMascota);
		
		JLabel lblRazas = new JLabel("Raza");
		lblRazas.setBounds(219, 11, 46, 14);
		contentPane.add(lblRazas);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(165, 36, 154, 30);
		contentPane.add(comboBox_1);
		
		JLabel lblNombreDeMascota = new JLabel("Nombre de Mascota");
		lblNombreDeMascota.setBounds(10, 110, 103, 14);
		contentPane.add(lblNombreDeMascota);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 85, 589, 8);
		contentPane.add(separator);
		
		textField = new JTextField();
		textField.setBounds(160, 107, 229, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblChipId = new JLabel("Chip ID");
		lblChipId.setBounds(10, 154, 46, 14);
		contentPane.add(lblChipId);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 151, 229, 20);
		passwordField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		contentPane.add(passwordField);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(508, 11, 46, 14);
		contentPane.add(lblColor);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(465, 36, 136, 30);
		comboBox_2.setModel(new DefaultComboBoxModel(Color.values()));
		contentPane.add(comboBox_2);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setBounds(10, 194, 46, 14);
		contentPane.add(lblFoto);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 191, 229, 20);
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		Button button = new Button("Cargar foto");
		button.setBounds(395, 189, 70, 22);
		contentPane.add(button);
		
		JLabel lblTipoDeReporte = new JLabel("Tipo de Reporte");
		lblTipoDeReporte.setBounds(219, 280, 96, 14);
		contentPane.add(lblTipoDeReporte);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(213, 301, 102, 20);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Extraviado", "Encontrado"}));
		contentPane.add(comboBox_3);
		
		JLabel lblLugarDeEncuentroextravo = new JLabel("Lugar de encuentro/extrav\u00EDo");
		lblLugarDeEncuentroextravo.setBounds(10, 234, 145, 14);
		lblLugarDeEncuentroextravo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLugarDeEncuentroextravo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(160, 231, 229, 20);
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		JLabel lblFechaDeEncuentroextravo = new JLabel("Fecha de encuentro/extrav\u00EDo");
		lblFechaDeEncuentroextravo.setBounds(10, 275, 145, 14);
		contentPane.add(lblFechaDeEncuentroextravo);
		
		spinner = new JSpinner();
		spinner.setBounds(10, 301, 124, 20);
		spinner.setModel(new SpinnerDateModel(new Date(1414648800000L), new Date(-2208963684000L), new Date(4102466400000L), Calendar.DAY_OF_YEAR));
		contentPane.add(spinner);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(165, 339, 224, 20);
		contentPane.add(formattedTextField);
		
		chckbxHayRecompensa = new JCheckBox("Hay recompensa?");
		chckbxHayRecompensa.setBounds(10, 338, 145, 23);
		chckbxHayRecompensa.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(!chckbxHayRecompensa.isSelected()) 
					formattedTextField.setEnabled(false);
				else formattedTextField.setEnabled(true);
			}
		});
		contentPane.add(chckbxHayRecompensa);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(609, 24, 10, 442);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_3);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(629, 52, 332, 401);
		editorPane.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		editorPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		contentPane.add(editorPane);
		
		JLabel lblDescripcinDeMascotas = new JLabel("Descripci\u00F3n de Mascotas");
		lblDescripcinDeMascotas.setBounds(730, 27, 200, 14);
		contentPane.add(lblDescripcinDeMascotas);
		
		JLabel lblMoneda = new JLabel("Moneda");
		lblMoneda.setBounds(408, 342, 46, 14);
		contentPane.add(lblMoneda);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(452, 339, 102, 20);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"$ - D\u00F3lares", "\u20AC - Euros", "\u20A1 - Colones"}));
		contentPane.add(comboBox_4);
		
		JButton btnReportar = new JButton("Reportar!");
		btnReportar.setBounds(10, 435, 103, 31);
		btnReportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.reportarMascota(pVentanaReporte, "pets.rgf");
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnReportar);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAtrs.setBounds(495, 435, 104, 31);
		contentPane.add(btnAtrs);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(Tamaño.values()));
		comboBox_5.setBounds(329, 36, 126, 30);
		contentPane.add(comboBox_5);
		
		JLabel lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setBounds(365, 11, 46, 14);
		contentPane.add(lblTamao);
	}

	
	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}

	public JComboBox getComboBox_2() {
		return comboBox_2;
	}

	public void setComboBox_2(JComboBox comboBox_2) {
		this.comboBox_2 = comboBox_2;
	}

	public JComboBox getComboBox_3() {
		return comboBox_3;
	}

	public void setComboBox_3(JComboBox comboBox_3) {
		this.comboBox_3 = comboBox_3;
	}

	public JComboBox getComboBox_4() {
		return comboBox_4;
	}

	public void setComboBox_4(JComboBox comboBox_4) {
		this.comboBox_4 = comboBox_4;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}


	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JCheckBox getChckbxHayRecompensa() {
		return chckbxHayRecompensa;
	}

	public void setChckbxHayRecompensa(JCheckBox chckbxHayRecompensa) {
		this.chckbxHayRecompensa = chckbxHayRecompensa;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	public JEditorPane getEditorPane() {
		return editorPane;
	}

	public void setEditorPane(JEditorPane editorPane) {
		this.editorPane = editorPane;
	}

	public JFormattedTextField getFormattedTextField() {
		return formattedTextField;
	}

	public void setFormattedTextField(JFormattedTextField formattedTextField) {
		this.formattedTextField = formattedTextField;
	}

	public ReporteMascota getpVentanaReporte() {
		return pVentanaReporte;
	}

	public void setpVentanaReporte(ReporteMascota pVentanaReporte) {
		this.pVentanaReporte = pVentanaReporte;
	}

	
	/*** Lista de tamaños ***/
	public JComboBox getComboBox_5() {
		return comboBox_5;
	}

	public void setComboBox_5(JComboBox comboBox_5) {
		this.comboBox_5 = comboBox_5;
	}
}
