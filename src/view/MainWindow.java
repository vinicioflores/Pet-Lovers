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

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.AbstractListModel;

import control.*;

import javax.swing.ListSelectionModel;

import model.Mascota;

public class MainWindow extends JFrame {

	private Control controller;
	private String file = "pets.rgf";
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public MainWindow(Control controller) throws FileNotFoundException, ClassNotFoundException, IOException {
		this.controller = controller;
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
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(10, 11, 276, 498);
		cargarRegistros(list);
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(329, 11, 296, 520);
		desktopPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Reportar Mascota");
		btnNewButton.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ReporteMascota reports = new ReporteMascota(controller);
				  reports.setVisible(true);
				  reports.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(10, 11, 276, 43);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("B\u00FAsquedas");
		btnNewButton_1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 65, 276, 43);
		panel_1.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Adopciones");
		btnNewButton_2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_2.setBounds(10, 119, 276, 43);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Lista Negra");
		btnNewButton_3.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_3.setBounds(10, 173, 276, 43);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Donaciones");
		btnNewButton_4.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_4.setBounds(10, 227, 276, 43);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Beneficiarios");
		btnNewButton_5.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_5.setBounds(10, 281, 276, 43);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Puntuar Adoptantes");
		btnNewButton_6.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnNewButton_6.setBounds(10, 335, 276, 43);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Cerrar Sistema");
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
	
	public void cargarRegistros(JList <JLabel>  listaMascotas) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		ArrayList<Mascota> petList= controller.leerArchivoRegistroMascotas(file);
			
		try {
			for(int i = 0; petList.get(i) != null; i++){
				listaMascotas.add(new JLabel(petList.get(i).toString()));
			}
		} catch (Exception e) {
			System.out.println("Error de indexación ... ");
		}
	}
}
