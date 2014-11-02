package view;

import model.*;
import control.*;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 */
public class View {

	private static Login login;
	private JFrame frame;
	private static View pView;
	private  static Version credits;
    /**
     * 
     */

    /**
     * Es la relación con el módulo generador de datos
     * del sistema, alli se manejan todos los datos de personas y 
     * mascotas
     */
    private static Model model ;

    /**
     * Es la relación de asociación con el módulo
     * controlador, responsable de establecer la comunicación
     * entre subsistema de vista y modelo
     */
    private static Control controller;
    
    /**
     * Implementa la ventana principal
     * donde se lleva a cabo toda la actividad
     * una vez ya el usuario ha ingresado al sistema
     */
    private JFrame ventanaPrincipal;


    /**
     * @param model  
     * @return
     */

	/**
	 * Arranca la aplicación
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public void boot() throws FileNotFoundException, ClassNotFoundException, IOException {
		pView = new View();
		model = new Model();
		controller = new Control(pView, model);
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					JFrame window = new JFrame();
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setTitle("Pet Lovers");
					window.setBounds(25, 25, 500, 108);
					
					JMenuBar menuBar = new JMenuBar();
					window.setJMenuBar(menuBar);
					
					JMenu mnArchivo = new JMenu("Archivo");
					menuBar.add(mnArchivo);
					
					JMenuItem mntmSalir = new JMenuItem("Salir");
					mntmSalir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							window.dispose();
							System.exit(0);
						}
					});
					mntmSalir.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
					mnArchivo.add(mntmSalir);
					
					JMenu mnEdicin = new JMenu("Edici\u00F3n");
					menuBar.add(mnEdicin);
					
					JMenu mnHerramientas = new JMenu("Herramientas");
					menuBar.add(mnHerramientas);
					
					JMenu mnOpciones = new JMenu("Opciones");
					menuBar.add(mnOpciones);
					
					JMenu mnAyuda = new JMenu("Ayuda");
					menuBar.add(mnAyuda);
					
					JMenuItem mntmCrditos = new JMenuItem("Cr\u00E9ditos");
					mntmCrditos.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							credits = new Version();
							credits.setVisible(true);
						}
					});
					mnAyuda.add(mntmCrditos);
					
					JMenuItem mntmNewMenuItem = new JMenuItem("Ayuda");
					mntmNewMenuItem.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
					mnAyuda.add(mntmNewMenuItem);
					window.getContentPane().setLayout(null);
					
					Panel panel = new Panel();
					panel.setBounds(10, 10, 464, 33);
					window.getContentPane().add(panel);
					
					JButton btnTabloidePblico = new JButton("Tabloide P\u00FAblico");
					btnTabloidePblico.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							publicTabloid news = new publicTabloid();
							news.setVisible(true);
						}
					});
					panel.add(btnTabloidePblico);
					
					JButton btnControlDeAcceso = new JButton("Control de acceso");
					panel.add(btnControlDeAcceso);
					btnControlDeAcceso.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
								try {
									login = doLogin();
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								login.setVisible(true);
						}
					});
					
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void View() { pView = this; }
	public JFrame getVentanaPrincipal(){ return ventanaPrincipal; }
	
	public Login getLogin()
	{
		return login;
	}
	
    public Login doLogin() throws FileNotFoundException, ClassNotFoundException, IOException
    {
    	if(login == null){
    		Login PMW = new Login(controller);
    		return PMW;
    	}
    	return login;
    }
}