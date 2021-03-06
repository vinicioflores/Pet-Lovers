package view;

import java.util.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.awt.Font;

import javax.swing.AbstractListModel;

import control.*;

import javax.swing.ListSelectionModel;

import model.Mascota;

import javax.swing.ImageIcon;

public class MainWindow extends JFrame {

	private ReporteMascota reports;
	private B�squeda searchWindow;
	private Control controller;
	private String file = "pets.rgf";
	private JPanel contentPane;
	private MainWindow pThis = this;
	private Listado list = new Listado();
	private JButton verPerfilButton;
	public PerfilMascota ventanaPerfil;  

	/**
	 * Construye el marco principal.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public MainWindow(Control controller) throws FileNotFoundException, ClassNotFoundException, IOException {
		this.controller = controller;
		controller.getView().getLogin().dispose();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 661, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 0, 204));
		contentPane.add(desktopPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 296, 520);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		list = new Listado();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(10, 11, 276, 486);
		cargarRegistros();
		
		panel.add(list);
		
		verPerfilButton = new JButton("Ver perfil");
		verPerfilButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		verPerfilButton.setForeground(new Color(255, 0, 0));
		verPerfilButton.setBounds(10, 499, 276, 21);
		verPerfilButton.addActionListener(controller);
		panel.add(verPerfilButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(329, 11, 296, 520);
		desktopPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(new ImageIcon(MainWindow.class.getResource("/resources/reportarMascota276x43_pressed.png")));
		btnNewButton.setFocusable(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/reportarMascota276x43.png")));
		btnNewButton.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  reports = new ReporteMascota(controller);
				  reports.setVisible(true);
				  reports.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				  reports.addWindowListener(new WindowListener() {

					@Override
					public void windowActivated(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosed(WindowEvent arg0) {
						try {
							cargarRegistros();
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					@Override
					public void windowClosing(WindowEvent arg0) {
						try {
							cargarRegistros();
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					@Override
					public void windowDeactivated(WindowEvent arg0) {
						try {
							cargarRegistros();
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					@Override
					public void windowDeiconified(WindowEvent arg0) {
						try {
							cargarRegistros();
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					@Override
					public void windowIconified(WindowEvent arg0) {
						try {
							cargarRegistros();
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					@Override
					public void windowOpened(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					  
				  });
			}
		});
		btnNewButton.setBounds(10, 11, 276, 43);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setRolloverIcon(new ImageIcon(MainWindow.class.getResource("/resources/busquedas276x43_pressed.png")));
		btnNewButton_1.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/busquedas276x43.png")));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setRolloverSelectedIcon(new ImageIcon(MainWindow.class.getResource("/resources/busquedas276x43_pressed.png")));
		btnNewButton_1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		
		/*** Evento para el Bot�n de B�squedas **/
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchWindow = new B�squeda(controller);
				searchWindow.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 65, 276, 43);
		panel_1.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setRolloverIcon(new ImageIcon(MainWindow.class.getResource("/resources/adopciones276x43_pressed.png")));
		btnNewButton_2.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/adopciones276x43.png")));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_2.setBounds(10, 119, 276, 43);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setRolloverIcon(new ImageIcon(MainWindow.class.getResource("/resources/listanegra276x43_pressed.png")));
		btnNewButton_3.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/listanegra276x43.png")));
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_3.setBounds(10, 173, 276, 43);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setRolloverIcon(new ImageIcon(MainWindow.class.getResource("/resources/donaciones276x43_pressed.png")));
		btnNewButton_4.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/donaciones276x43.png")));
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setVerifyInputWhenFocusTarget(false);
		btnNewButton_4.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_4.setBounds(10, 227, 276, 43);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setRolloverIcon(new ImageIcon(MainWindow.class.getResource("/resources/beneficiarios276x43_pressed.png")));
		btnNewButton_5.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/beneficiarios276x43.png")));
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_5.setBounds(10, 281, 276, 43);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setFocusable(false);
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/puntuar276x43.png")));
		btnNewButton_6.setRolloverIcon(new ImageIcon(MainWindow.class.getResource("/resources/puntuar276x43_pressed.png")));
		btnNewButton_6.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_6.setBounds(10, 335, 276, 43);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setRolloverIcon(new ImageIcon(MainWindow.class.getResource("/resources/cerrar276x93_pressed.png")));
		btnNewButton_7.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/cerrar276x93.png")));
		btnNewButton_7.setFocusable(false);
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		btnNewButton_7.setForeground(new Color(0, 0, 102));
		btnNewButton_7.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_7.setToolTipText("Cierra PetLovers Manager");
		btnNewButton_7.setBounds(10, 417, 276, 92);
		panel_1.add(btnNewButton_7);
	}
	
	public void cargarRegistros() throws FileNotFoundException, ClassNotFoundException, IOException
	{	
		list.JListAddMascotas(controller.getModel().getRegistro().getMascotas());
	}

	public ReporteMascota getReports() {
		return reports;
	}

	public void setReports(ReporteMascota reports) {
		this.reports = reports;
	}

	public B�squeda getSearchWindow() {
		return searchWindow;
	}

	public void setSearchWindow(B�squeda searchWindow) {
		this.searchWindow = searchWindow;
	}

	public JButton getVerPerfilButton() {
		return verPerfilButton;
	}

	public void setVerPerfilButton(JButton verPerfilButton) {
		this.verPerfilButton = verPerfilButton;
	}

	public Listado getList() {
		return list;
	}

	public void setList(Listado list) {
		this.list = list;
	}
}
