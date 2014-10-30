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

/**
 * 
 */
public class Login extends JFrame {

	private RegWin regwin;
	private JFrame mainWin;
	private Control controller;
	private String file = "users.rgf";
	
	
    /**
     * 
     */
    Login(Control controller) {
    	super();
    	this.controller = controller;
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
    			regwin = new RegWin();
    			regwin.move(15,15);
    			regwin.setVisible(true);
    			try {
					signup(textField.getText(),String.valueOf(passwordField.getPassword()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	});
    	btnRegistrarse.setBounds(10, 78, 165, 23);
    	getContentPane().add(btnRegistrarse);
    	
    	JButton btnIngresar = new JButton("Ingresar");
    	btnIngresar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
					mainWin = new MainWindow(controller);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			mainWin.setVisible(true);
    			mainWin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    		}
    	});
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
    	
        return false;
    }

    /**
     * @param username 
     * @param password 
     * @return
     * @throws IOException 
     */
    public void signup(String username, String password) throws IOException {
        
    	try {
    		users.add(new User(username,password));
    	} catch (NullPointerException e){
    		users = new ArrayList<User>();
    		users.add(new User(username,password));
    	}
        ObjectOutputStream oos = null;
        try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			System.out.println("Error, no se encontró el archivo de registro de usuarios ... ");
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        for (int i = 0; i < users.size(); i++)
        {
            // ojo, se hace un new por cada Persona. El new dentro del bucle.
            User pUser = users.get(i);
            try {
				oos.writeObject(pUser);
			} catch (IOException e) {
				System.out.println("Error al intentar escribir en el archivo de registro de usuarios ... ");
			}
        }
        oos.close();  // Se cierra al terminar.
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