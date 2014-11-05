package view;

import model.*;
import control.*;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.Panel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * 
 */
public class View {

	public static Login login;
	private JFrame frame;
	private static View pView;
	public  static Version credits;
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
    private JButton btnTabloidePblico;
    private JButton btnControlDeAcceso;
    private JMenuItem mntmSalir;
    private JMenuItem mntmCrditos;
    public JFrame window;
    private JMenuItem ayudaMenuItem;


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
					window = new JFrame();
					window.setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/resources/logo.png")));
					window.getContentPane().setBackground(Color.WHITE);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setTitle("Pet Lovers");
					window.setBounds(25, 25, 500, 171);
					
					JMenuBar menuBar = new JMenuBar();
					window.setJMenuBar(menuBar);
					
					JMenu mnArchivo = new JMenu("Archivo");
					
					menuBar.add(mnArchivo);
					
					mntmSalir = new JMenuItem("Salir");
					mntmSalir.setIcon(null);
					mnArchivo.add(mntmSalir);
					
					JMenu mnAyuda = new JMenu("Ayuda");
					menuBar.add(mnAyuda);
					
					mntmCrditos = new JMenuItem("Cr\u00E9ditos");
					mnAyuda.add(mntmCrditos);
					
					ayudaMenuItem = new JMenuItem("Ayuda");
					ayudaMenuItem.setIcon(null);
					mnAyuda.add(ayudaMenuItem);
					window.getContentPane().setLayout(null);
					
					btnTabloidePblico = new JButton("");
					btnTabloidePblico.setFocusable(false);
					btnTabloidePblico.setBorderPainted(false);
					btnTabloidePblico.setLocation(34, 34);
					window.getContentPane().add(btnTabloidePblico);
					btnTabloidePblico.setSize(new Dimension(181, 53));
					btnTabloidePblico.setRolloverSelectedIcon(new ImageIcon(View.class.getResource("/resources/Tabloid181x53_pressed.png")));
					btnTabloidePblico.setRolloverIcon(new ImageIcon(View.class.getResource("/resources/Tabloid181x53_pressed.png")));
					btnTabloidePblico.setIcon(new ImageIcon(View.class.getResource("/resources/Tabloid181x53.png")));
					
					btnControlDeAcceso = new JButton("");
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
					
					/** Instala los eventos gráficos al controlador **/
					mntmCrditos.addActionListener(controller);
					ayudaMenuItem.addActionListener(controller);
					mntmSalir.addActionListener(controller);
					btnControlDeAcceso.addActionListener(controller);
					btnTabloidePblico.addActionListener(controller);
					
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


	public JButton getBtnTabloidePblico() {
		return btnTabloidePblico;
	}


	public void setBtnTabloidePblico(JButton btnTabloidePblico) {
		this.btnTabloidePblico = btnTabloidePblico;
	}


	public JButton getBtnControlDeAcceso() {
		return btnControlDeAcceso;
	}


	public void setBtnControlDeAcceso(JButton btnControlDeAcceso) {
		this.btnControlDeAcceso = btnControlDeAcceso;
	}


	public JMenuItem getMntmSalir() {
		return mntmSalir;
	}


	public void setMntmSalir(JMenuItem mntmSalir) {
		this.mntmSalir = mntmSalir;
	}


	public JMenuItem getMntmCrditos() {
		return mntmCrditos;
	}


	public void setMntmCrditos(JMenuItem mntmCrditos) {
		this.mntmCrditos = mntmCrditos;
	}


	public JMenuItem getAyudaMenuItem() {
		return ayudaMenuItem;
	}


	public void setAyudaMenuItem(JMenuItem ayudaMenuItem) {
		this.ayudaMenuItem = ayudaMenuItem;
	}


	public static Version getCredits() {
		return credits;
	}


	public static void setCredits(Version credits) {
		View.credits = credits;
	}
}