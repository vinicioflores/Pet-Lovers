package view;

import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

import javax.xml.*;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.*;
import javax.swing.event.CaretEvent;

import control.Control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * 
 */
public class Login extends JFrame {

	private RegWin regwin;
	private MainWindow mainWin;
	private Control controller;
	private static final long serialVersionUID=1092742389479238470L;
	private JButton btnIngresar;
	
    /**
     * 
     */
    Login(Control controller) {
    	super();
    	setResizable(false);
    	getContentPane().setBackground(Color.WHITE);
    	this.controller = controller;
    	setDefaultLookAndFeelDecorated(false);
    	
    	setTitle("PetLovers Control de Acceso");
    	setBounds(20,20,300,150);
    	getContentPane().setLayout(null);
    	
    	JLabel lblUsuario = new JLabel("Usuario");
    	lblUsuario.setForeground(Color.BLUE);
    	lblUsuario.setBounds(10, 11, 46, 14);
    	getContentPane().add(lblUsuario);
    	
    	JLabel lblContrasea = new JLabel("Contrase\u00F1a");
    	lblContrasea.setForeground(Color.BLUE);
    	lblContrasea.setBounds(10, 36, 80, 14);
    	getContentPane().add(lblContrasea);
    	
    	textField = new JTextField();
    	textField.setBounds(100, 8, 174, 20);
    	getContentPane().add(textField);
    	textField.setColumns(10);
    	
    	JButton btnRegistrarse = new JButton("");
    	btnRegistrarse.setContentAreaFilled(false);
    	btnRegistrarse.setBorderPainted(false);
    	btnRegistrarse.setFocusable(false);
    	btnRegistrarse.setRolloverIcon(new ImageIcon(Login.class.getResource("/resources/Registro165x23_pressed.png")));
    	btnRegistrarse.setIcon(new ImageIcon(Login.class.getResource("/resources/Registro165x23.png")));
    	btnRegistrarse.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			hide();
    			regwin = new RegWin(controller);
    			regwin.move(15,15);
    			regwin.setVisible(true);
    		}
    	});
    	btnRegistrarse.setBounds(10, 78, 165, 23);
    	getContentPane().add(btnRegistrarse);
    	
    	btnIngresar = new JButton("");
    	btnIngresar.setContentAreaFilled(false);
    	btnIngresar.setBorderPainted(false);
    	btnIngresar.setRolloverIcon(new ImageIcon(Login.class.getResource("/resources/Login89x23_pressed.png")));
    	btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/resources/Login89x23.png")));
    	btnIngresar.setFocusable(false);
    	btnIngresar.addActionListener(controller);
    	btnIngresar.setBounds(185, 78, 89, 23);
    	getContentPane().add(btnIngresar);
    	
    	passwordField = new JPasswordField();
    	passwordField.setBounds(100, 33, 174, 20);
    	getContentPane().add(passwordField);
    }
    
    public MainWindow doMainWindow() throws FileNotFoundException, ClassNotFoundException, IOException
    {
    	if(mainWin == null){
    		MainWindow PMW = new MainWindow(controller);
    		return PMW;
    	}
    	return mainWin;
    }
    

    /**
     * 
     */
    private JTextField textField;
    private JPasswordField passwordField;


	public RegWin getRegwin() {
		return regwin;
	}

	public void setRegwin(RegWin regwin) {
		this.regwin = regwin;
	}

	public MainWindow getMainWin() {
		return mainWin;
	}

	public void setMainWin(MainWindow mainWin) {
		this.mainWin = mainWin;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

    /**
     * 
     */
}