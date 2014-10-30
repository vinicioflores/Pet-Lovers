package view;
import java.util.*;
import java.util.stream.Stream;

import javax.xml.*;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.*;
import javax.swing.event.CaretEvent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */
public class Login extends JFrame {

    /**
     * 
     */
    public Login() {
    	super();
    	setTitle("PetLovers Control de Acceso");
    	setBounds(20,20,300,150);
    	getContentPane().setLayout(null);
    	
    	JLabel lblUsuario = new JLabel("Usuario");
    	lblUsuario.setBounds(10, 11, 46, 14);
    	getContentPane().add(lblUsuario);
    	
    	JLabel lblContrasea = new JLabel("Contrase\u00F1a");
    	lblContrasea.setBounds(10, 36, 80, 14);
    	getContentPane().add(lblContrasea);
    	
    	textField = new JTextField();
    	textField.setBounds(100, 8, 174, 20);
    	getContentPane().add(textField);
    	textField.setColumns(10);
    	
    	JButton btnRegistrarse = new JButton("Registrarse");
    	btnRegistrarse.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			RegWin regwin = new RegWin();
    			regwin.move(15,15);
    			regwin.setVisible(true);
    		}
    	});
    	btnRegistrarse.setBounds(10, 78, 165, 23);
    	getContentPane().add(btnRegistrarse);
    	
    	JButton btnIngresar = new JButton("Ingresar");
    	btnIngresar.setBounds(185, 78, 89, 23);
    	getContentPane().add(btnIngresar);
    	
    	passwordField = new JPasswordField();
    	passwordField.setBounds(100, 33, 174, 20);
    	getContentPane().add(passwordField);
    }

    /**
     * 
     */
    private ArrayList <User> users ;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * 
     */


    /**
     * @param username 
     * @param password 
     * @return
     */
    public boolean login(String username, String password) {
        // TODO implement here
        return false;
    }

    /**
     * @param username 
     * @param password 
     * @return
     */
    public void signup(String username, String password) {
        // TODO implement here
    }

    /**
     * @param username 
     * @return
     */
    private boolean exists(String username) {
        // TODO implement here
        return false;
    }
}