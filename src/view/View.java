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
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Cursor;
import java.awt.Dimension;

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
	 * @wbp.parser.entryPoint
	 */
	public void boot() throws FileNotFoundException, ClassNotFoundException, IOException {
		pView = this;
		model = new Model();
		controller = new Control(this, model);
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					JFrame window = new JFrame();
					window.getContentPane().setBackground(Color.WHITE);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setTitle("Pet Lovers");
					window.setBounds(25, 25, 500, 171);
					
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
					
					JButton btnTabloidePblico = new JButton("");
					btnTabloidePblico.setFocusable(false);
					btnTabloidePblico.setBorderPainted(false);
					btnTabloidePblico.setLocation(34, 34);
					window.getContentPane().add(btnTabloidePblico);
					btnTabloidePblico.setSize(new Dimension(181, 53));
					btnTabloidePblico.setRolloverSelectedIcon(new ImageIcon(View.class.getResource("/resources/Tabloid181x53_pressed.png")));
					btnTabloidePblico.setRolloverIcon(new ImageIcon(View.class.getResource("/resources/Tabloid181x53_pressed.png")));
					btnTabloidePblico.setIcon(new ImageIcon(View.class.getResource("/resources/Tabloid181x53.png")));
					
					JButton btnControlDeAcceso = new JButton("");
					btnControlDeAcceso.setSize(new Dimension(181, 53));
					btnControlDeAcceso.setBounds(264, 34, 187, 53);
					window.getContentPane().add(btnControlDeAcceso);
					btnControlDeAcceso.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					btnControlDeAcceso.setContentAreaFilled(false);
					btnControlDeAcceso.setBorder(new CompoundBorder());
					btnControlDeAcceso.setRolloverIcon(new ImageIcon(View.class.getResource("/resources/Ingreso181x53_pressed.png")));
					btnControlDeAcceso.setSelectedIcon(new ImageIcon(View.class.getResource("/resources/Ingreso181x53_pressed.png")));
					btnControlDeAcceso.setIcon(new ImageIcon(View.class.getResource("/resources/Ingreso181x53.png")));
					btnControlDeAcceso.setFocusable(false);
					btnControlDeAcceso.setBorderPainted(false);
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
					btnTabloidePblico.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							publicTabloid news = new publicTabloid();
							news.setVisible(true);
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