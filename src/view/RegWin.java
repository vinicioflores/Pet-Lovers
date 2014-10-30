package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	public RegWin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Primer nombre");
		lblNombre.setBounds(0, 8, 152, 21);
		contentPane.add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setBounds(0, 70, 152, 14);
		contentPane.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(0, 95, 152, 21);
		contentPane.add(lblSegundoApellido);
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setBounds(0, 40, 152, 14);
		contentPane.add(lblSegundoNombre);
		
		textField = new JTextField();
		textField.setBounds(181, 8, 176, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 37, 176, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(181, 69, 176, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(181, 95, 176, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(0, 132, 152, 14);
		contentPane.add(lblMail);
		
		textField_4 = new JTextField();
		textField_4.setBounds(181, 126, 176, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(0, 163, 152, 14);
		contentPane.add(lblTelfono);
		
		textField_5 = new JTextField();
		textField_5.setBounds(181, 157, 176, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setBounds(0, 195, 90, 14);
		contentPane.add(lblNombreUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(0, 230, 152, 14);
		contentPane.add(lblContrasea);
		
		textField_6 = new JTextField();
		textField_6.setBounds(181, 192, 176, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(181, 227, 176, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnFinalizarRegistro = new JButton("Finalizar registro");
		btnFinalizarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFinalizarRegistro.setBounds(10, 270, 111, 32);
		contentPane.add(btnFinalizarRegistro);
	}
}
