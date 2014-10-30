package view;

import model.*;
import control.*;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

/**
 * 
 */
public class View {

	private static Login login;
	private JFrame frame;
    /**
     * 
     */

    /**
     * 
     */
    private Model model ;

    /**
     * 
     */
    private Control controller;


    /**
     * @param model  
     * @return
     */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame window = new JFrame();
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
					mnAyuda.add(mntmCrditos);
					
					JMenuItem mntmNewMenuItem = new JMenuItem("Ayuda");
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
							login = new Login();
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

	/**
	 * Create the application.
	 */
	public void MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}