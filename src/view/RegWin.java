package view;

import control.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegWin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the frame.
	 */
	public RegWin(Control controller) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 396, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Primer nombre");
		lblNombre.setBounds(10, 11, 152, 21);
		contentPane.add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setBounds(10, 73, 152, 14);
		contentPane.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(10, 98, 152, 21);
		contentPane.add(lblSegundoApellido);
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setBounds(10, 43, 152, 14);
		contentPane.add(lblSegundoNombre);
		
		textField = new JTextField();
		textField.setBounds(191, 11, 176, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 40, 176, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 72, 176, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 98, 176, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 135, 152, 14);
		contentPane.add(lblMail);
		
		textField_4 = new JTextField();
		textField_4.setBounds(191, 129, 176, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(10, 166, 152, 14);
		contentPane.add(lblTelfono);
		
		textField_5 = new JFormattedTextField();
		textField_5.setBounds(191, 160, 176, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setBounds(10, 198, 90, 14);
		contentPane.add(lblNombreUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 233, 152, 14);
		contentPane.add(lblContrasea);
		
		textField_6 = new JTextField();
		textField_6.setBounds(191, 195, 176, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(191, 230, 176, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnFinalizarRegistro = new JButton("Finalizar registro");
		btnFinalizarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(revisaDatosFaltantes()) {
		  			try {
		  				String fullName[] = { textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText() };
						controller.signup(textField_6.getText(),textField_7.getText(),fullName,textField_4.getText(), textField_5.getText());
					} catch (Exception e) {
						e.printStackTrace();
					} 
				} else return;
				dispose();
				controller.getView().getLogin().show();
			}
		});
		btnFinalizarRegistro.setBounds(20, 273, 111, 32);
		contentPane.add(btnFinalizarRegistro);
	}
	
	/**
	 * 
	 * @return true si todos los datos son validos, false si faltan datos (campos vacíos)
	 */
	private boolean revisaDatosFaltantes()
	{
		if(textField.getText().equals("") == true   ||
		   textField_1.getText().equals("") == true ||
		   textField_2.getText().equals("") == true ||
		   textField_3.getText().equals("") == true ||
		   textField_4.getText().equals("") == true ||
		   textField_5.getText().equals("") == true ||
		   textField_6.getText().equals("") == true ||
		   textField_7.getText().equals("") == true)
		{
			ErrorDialog dialogoErrorFaltanDatos = new ErrorDialog("Ha dejado campos con información faltante o inválida. Por favor rellene "
					+ "todos los campos con la información correspondiente");
			dialogoErrorFaltanDatos.setVisible(true);
			dialogoErrorFaltanDatos.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			return false;
		}
		return true;
	}
}
