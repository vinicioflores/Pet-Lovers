package view;

import control.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Chip;
import model.Contacto;
import model.Estado;
import model.EstadoTipos;
import model.Mascota;
import model.Raza;
import model.Razas;
import model.PetColor;
import model.RazasGatos;
import model.Recompensa;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import model.RazasPerros;

public class Búsqueda extends JFrame {

	private JPanel contentPane;
	private JTextField lugarTextField;
	private JTextField chipTextField;
	private JTextField recompensaTextField;
	private JTextField contactoTextField;
	private JInternalFrame despliegueFrame;
	private JRadioButton rdbtnPorLugar;
	private JRadioButton rdbtnPorChip;
	private JRadioButton rdbtnPorEstado;
	private JRadioButton rdbtnPorRaza;
	private JRadioButton rdbtnPorColor;
	private JRadioButton rdbtnPorContacto;
	private JRadioButton rdbtnPorRecompensa;
	private JComboBox estadosComboBox;
	private JComboBox tipoComboBox;
	private JComboBox colorComboBox;
	private Listado busquedaList;

	private JComboBox tiposComboBox;
	private Control controller;
	private JButton buscarButton;
	
	private int rdbtnsOn=0;         // Radio Botones encendidos
	private ArrayList <Mascota> tmpBufMascotas=null;
	private JComboBox razasComboBox;
	private JComboBox monedaComboBox;

	/**
	 * Create the frame.
	 */
	public Búsqueda(Control controller) {
		this.controller = controller;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 419, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 36, 386, 192);
		contentPane.add(panel);
		
		rdbtnPorLugar = new JRadioButton("Por lugar");
		rdbtnPorLugar.setBounds(6, 7, 78, 23);
		rdbtnPorLugar.setBackground(Color.WHITE);
		rdbtnPorLugar.setForeground(Color.BLUE);
		
		rdbtnPorChip = new JRadioButton("Por chip");
		rdbtnPorChip.setBounds(6, 33, 78, 23);
		rdbtnPorChip.setBackground(Color.WHITE);
		rdbtnPorChip.setForeground(Color.BLUE);
		
		rdbtnPorEstado = new JRadioButton("Por estado");
		rdbtnPorEstado.setBounds(6, 59, 78, 23);
		rdbtnPorEstado.setBackground(Color.WHITE);
		rdbtnPorEstado.setForeground(Color.BLUE);
		
		rdbtnPorRaza = new JRadioButton("Por raza y tipo");
		rdbtnPorRaza.setBounds(6, 85, 103, 23);
		rdbtnPorRaza.setForeground(Color.BLUE);
		rdbtnPorRaza.setBackground(Color.WHITE);
		
		rdbtnPorColor = new JRadioButton("Por color");
		rdbtnPorColor.setBounds(6, 111, 78, 23);
		rdbtnPorColor.setBackground(Color.WHITE);
		rdbtnPorColor.setForeground(Color.BLUE);
		
		rdbtnPorContacto = new JRadioButton("Por involucrado");
		rdbtnPorContacto.setBounds(6, 137, 103, 23);
		rdbtnPorContacto.setBackground(Color.WHITE);
		rdbtnPorContacto.setForeground(Color.BLUE);
		panel.setLayout(null);
		
		rdbtnPorRecompensa = new JRadioButton("Por recompensa");
		rdbtnPorRecompensa.setBounds(6, 160, 103, 23);
		rdbtnPorRecompensa.setBackground(Color.WHITE);
		rdbtnPorRecompensa.setForeground(Color.BLUE);
		
		panel.add(rdbtnPorRecompensa);
		panel.add(rdbtnPorEstado);
		panel.add(rdbtnPorRaza);
		panel.add(rdbtnPorColor);
		panel.add(rdbtnPorContacto);
		panel.add(rdbtnPorChip);
		panel.add(rdbtnPorLugar);
		
		lugarTextField = new JTextField();
		lugarTextField.setBounds(120, 7, 191, 20);
		panel.add(lugarTextField);
		lugarTextField.setColumns(10);
		lugarTextField.setEnabled(false);
		
		chipTextField = new JTextField();
		chipTextField.setColumns(10);
		chipTextField.setBounds(120, 33, 191, 20);
		panel.add(chipTextField);
		chipTextField.setEnabled(false);
		
		contactoTextField = new JTextField();
		contactoTextField.setColumns(10);
		contactoTextField.setBounds(120, 137, 191, 20);
		contactoTextField.setEnabled(false);
		panel.add(contactoTextField);
		
		recompensaTextField = new JTextField();
		recompensaTextField.setColumns(10);
		recompensaTextField.setBounds(120, 160, 154, 20);
		recompensaTextField.setEnabled(false);
		panel.add(recompensaTextField);
		
		estadosComboBox = new JComboBox();
		estadosComboBox.setBackground(Color.WHITE);
		estadosComboBox.setFocusable(false);
		estadosComboBox.setBorder(null);
		estadosComboBox.setForeground(Color.BLUE);
		estadosComboBox.setModel(new DefaultComboBoxModel(EstadoTipos.values()));
		estadosComboBox.setBounds(120, 64, 191, 20);
		estadosComboBox.setEnabled(false);
		panel.add(estadosComboBox);
		
		tiposComboBox = new JComboBox();
		tiposComboBox.setModel(new DefaultComboBoxModel(Razas.values()));
		tiposComboBox.setForeground(Color.BLUE);
		tiposComboBox.setFocusable(false);
		tiposComboBox.setBorder(null);
		tiposComboBox.setBackground(Color.WHITE);
		tiposComboBox.setBounds(120, 87, 63, 20);
		tiposComboBox.setEnabled(false);
		
		panel.add(tiposComboBox);
		
		colorComboBox = new JComboBox();
		colorComboBox.setModel(new DefaultComboBoxModel(PetColor.values()));
		colorComboBox.setForeground(Color.BLUE);
		colorComboBox.setFocusable(false);
		colorComboBox.setBorder(null);
		colorComboBox.setBackground(Color.WHITE);
		colorComboBox.setBounds(120, 111, 191, 20);
		colorComboBox.setEnabled(false);
		panel.add(colorComboBox);
		
		buscarButton = new JButton("");
		buscarButton.setRolloverIcon(new ImageIcon(Búsqueda.class.getResource("/resources/search55x176_pressed.png")));
		buscarButton.setIcon(new ImageIcon(Búsqueda.class.getResource("/resources/search55x176.png")));
		buscarButton.setBorder(new LineBorder(new Color(0, 0, 255), 2, true));
		buscarButton.setContentAreaFilled(false);
		buscarButton.setFocusable(false);
		buscarButton.setForeground(Color.BLUE);
		buscarButton.setBounds(321, 7, 55, 176);
		panel.add(buscarButton);
		
		razasComboBox = new JComboBox();
		razasComboBox.setModel(new DefaultComboBoxModel(RazasPerros.values()));
		razasComboBox.setEnabled(false);
		razasComboBox.setBounds(193, 86, 118, 22);
		panel.add(razasComboBox);
		
		monedaComboBox = new JComboBox();
		monedaComboBox.setModel(new DefaultComboBoxModel(new String[] {"$", "\u20AC", "\u20A1"}));
		monedaComboBox.setBounds(277, 160, 32, 20);
		panel.add(monedaComboBox);
		
		JLabel lblCamposAConsultar = new JLabel("Campos a consultar");
		lblCamposAConsultar.setBounds(10, 11, 147, 14);
		contentPane.add(lblCamposAConsultar);
		lblCamposAConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCamposAConsultar.setForeground(new Color(0, 0, 255));
		
		despliegueFrame = new JInternalFrame("Despliegue de B\u00FAsqueda");
		despliegueFrame.getContentPane().setBackground(Color.WHITE);
		despliegueFrame.setBounds(10, 234, 386, 317);
		contentPane.add(despliegueFrame);
		despliegueFrame.getContentPane().setLayout(null);
		
		busquedaList = new Listado();
		busquedaList.setBounds(10, 11, 350, 253);
		despliegueFrame.getContentPane().add(busquedaList);
		despliegueFrame.setVisible(true);
	
		configurarHabilitacionCamposTexto();
		configurarEventosBusquedas();
	}

	public JTextField getLugarTextField() {
		return lugarTextField;
	}

	public void setLugarTextField(JTextField lugarTextField) {
		this.lugarTextField = lugarTextField;
	}

	public JTextField getChipTextField() {
		return chipTextField;
	}

	public void setChipTextField(JTextField chipTextField) {
		this.chipTextField = chipTextField;
	}

	public JTextField getRecompensaTextField() {
		return recompensaTextField;
	}

	public void setRecompensaTextField(JTextField recompensaTextField) {
		this.recompensaTextField = recompensaTextField;
	}

	public JTextField getContactoTextField() {
		return contactoTextField;
	}

	public void setContactoTextField(JTextField contactoTextField) {
		this.contactoTextField = contactoTextField;
	}

	public JInternalFrame getDespliegueFrame() {
		return despliegueFrame;
	}

	public void setDespliegueFrame(JInternalFrame despliegueFrame) {
		this.despliegueFrame = despliegueFrame;
	}

	public JRadioButton getRdbtnPorLugar() {
		return rdbtnPorLugar;
	}

	public void setRdbtnPorLugar(JRadioButton rdbtnPorLugar) {
		this.rdbtnPorLugar = rdbtnPorLugar;
	}

	public JRadioButton getRdbtnPorChip() {
		return rdbtnPorChip;
	}

	public void setRdbtnPorChip(JRadioButton rdbtnPorChip) {
		this.rdbtnPorChip = rdbtnPorChip;
	}

	public JRadioButton getRdbtnPorEstado() {
		return rdbtnPorEstado;
	}

	public void setRdbtnPorEstado(JRadioButton rdbtnPorEstado) {
		this.rdbtnPorEstado = rdbtnPorEstado;
	}

	public JRadioButton getRdbtnPorRaza() {
		return rdbtnPorRaza;
	}

	public void setRdbtnPorRaza(JRadioButton rdbtnPorRaza) {
		this.rdbtnPorRaza = rdbtnPorRaza;
	}

	public JRadioButton getRdbtnPorColor() {
		return rdbtnPorColor;
	}

	public void setRdbtnPorColor(JRadioButton rdbtnPorColor) {
		this.rdbtnPorColor = rdbtnPorColor;
	}

	public JRadioButton getRdbtnPorContacto() {
		return rdbtnPorContacto;
	}

	public void setRdbtnPorContacto(JRadioButton rdbtnPorContacto) {
		this.rdbtnPorContacto = rdbtnPorContacto;
	}

	public JRadioButton getRdbtnPorRecompensa() {
		return rdbtnPorRecompensa;
	}

	public void setRdbtnPorRecompensa(JRadioButton rdbtnPorRecompensa) {
		this.rdbtnPorRecompensa = rdbtnPorRecompensa;
	}

	public JComboBox getEstadosComboBox() {
		return estadosComboBox;
	}

	public void setEstadosComboBox(JComboBox estadosComboBox) {
		this.estadosComboBox = estadosComboBox;
	}

	public JComboBox getTipoComboBox() {
		return tipoComboBox;
	}

	public void setTipoComboBox(JComboBox tipoComboBox) {
		this.tipoComboBox = tipoComboBox;
	}

	public JComboBox getColorComboBox() {
		return colorComboBox;
	}

	public void setColorComboBox(JComboBox colorComboBox) {
		this.colorComboBox = colorComboBox;
	}

	public Listado getBusquedaList() {
		return busquedaList;
	}

	public void setBusquedaList(Listado busquedaList) {
		this.busquedaList = busquedaList;
	}

	public JComboBox getTiposComboBox() {
		return tiposComboBox;
	}

	public void setTiposComboBox(JComboBox tiposComboBox) {
		this.tiposComboBox = tiposComboBox;
	}
	
	/*** Métodos de coordinación de eventos puramente VISUALES !! **/
	private void configurarHabilitacionCamposTexto()
	{
		tiposComboBox.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0){
				if(tiposComboBox.getSelectedIndex() == 0){
					razasComboBox.setModel(new DefaultComboBoxModel(RazasPerros.values()));			
				}
				
				else if(tiposComboBox.getSelectedIndex() == 1){
					razasComboBox.setModel(new DefaultComboBoxModel(RazasGatos.values()));
				}
				
				else razasComboBox.setModel(new DefaultComboBoxModel());
			}
		});
		
		rdbtnPorLugar.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rdbtnPorLugar.isSelected() == true){
					lugarTextField.setEnabled(true);
					rdbtnsOn++;
				}
				else {
					lugarTextField.setEnabled(false);
					rdbtnsOn--;
				}
				System.out.println("INFO: Powered ON RadioButtons: " + rdbtnsOn);
			}
		});
		
		rdbtnPorChip.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rdbtnPorChip.isSelected() == true){
					chipTextField.setEnabled(true);
					rdbtnsOn++;
				}
				else {
					chipTextField.setEnabled(false);
					rdbtnsOn--;
				}
				System.out.println("INFO: Powered ON RadioButtons: " + rdbtnsOn);
			}
		});
		
		rdbtnPorContacto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rdbtnPorContacto.isSelected() == true){
					contactoTextField.setEnabled(true);
					rdbtnsOn++;
				}
				else {
					contactoTextField.setEnabled(false);
					rdbtnsOn--;
				}
				System.out.println("INFO: Powered ON RadioButtons: " + rdbtnsOn);
			}
		});
		
		rdbtnPorRecompensa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rdbtnPorRecompensa.isSelected() == true){
					recompensaTextField.setEnabled(true);
					rdbtnsOn++;
				}
				else {
					recompensaTextField.setEnabled(false);
					rdbtnsOn--;
				}
				System.out.println("INFO: Powered ON RadioButtons: " + rdbtnsOn);
			}
		});
		
		rdbtnPorRaza.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rdbtnPorRaza.isSelected() == true){
					tiposComboBox.setEnabled(true);
					razasComboBox.setEnabled(true);
					rdbtnsOn++;
				}
				else { 
					tiposComboBox.setEnabled(false);
					razasComboBox.setEnabled(false);
					rdbtnsOn--;
				}
				System.out.println("INFO: Powered ON RadioButtons: " + rdbtnsOn);
			}
		});
		
		rdbtnPorColor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rdbtnPorColor.isSelected() == true){
					colorComboBox.setEnabled(true);
					rdbtnsOn++;
				}
				else {
					colorComboBox.setEnabled(false);
					rdbtnsOn--;
				}
				System.out.println("INFO: Powered ON RadioButtons: " + rdbtnsOn);
			}
		});
		
		rdbtnPorEstado.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rdbtnPorEstado.isSelected() == true){
					estadosComboBox.setEnabled(true);
					rdbtnsOn++;
				}
				else {
					estadosComboBox.setEnabled(false);
					rdbtnsOn--;
				}
				System.out.println("INFO: Powered ON RadioButtons: " + rdbtnsOn);
			}
		});
		
	}

	/*** Métodos de configuración de eventos de búsquedas y consultas **/
	private void configurarEventosBusquedas()
	{	
		Búsqueda pThis = this;
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(pThis.rdbtnPorLugar.isSelected() == true){
						busquedaList.JListShowLugar(controller.getModel().getRegistro().getMascotas(),
								lugarTextField.getText(), false);
				}
				
				if(pThis.rdbtnPorChip.isSelected() == true){
						busquedaList.JListShowChip(controller.getModel().getRegistro().getMascotas(), 
								new Chip(chipTextField.getText()), false);	
				}
				
				if(pThis.rdbtnPorColor.isSelected() == true){
					
					PetColor[] mapColor = {  
							PetColor.ROJO,
							PetColor.NEGRO,
							PetColor.CAFE,
							PetColor.BLANCO,
							PetColor.GRIS,
							PetColor.BEIGE
					};
					
						busquedaList.JListShowColor(controller.getModel().getRegistro().getMascotas(), 
								mapColor[colorComboBox.getSelectedIndex()], false);	
				}
				
				if(pThis.rdbtnPorRaza.isSelected() == true)
				{
					Raza mapRaza = new Raza();
					String strRaza = new String();
					
					if(pThis.tiposComboBox.getSelectedIndex() == 0)
						strRaza = mapRaza.get_perro(pThis.razasComboBox.getSelectedIndex());
					else if(pThis.tiposComboBox.getSelectedIndex() == 1)
						strRaza = mapRaza.get_gato(pThis.razasComboBox.getSelectedIndex());
					
					busquedaList.JListShowRaza(controller.getModel().getRegistro().getMascotas(),
							strRaza, false);
				}
				
				if(pThis.rdbtnPorContacto.isSelected() == true)
				{
					busquedaList.JListShowContacto(controller.getModel().getRegistro().getMascotas(), 
							controller.getModel().getRegistro().findContacto(contactoTextField.getText()), false);
				}
				
				if(pThis.rdbtnPorEstado.isSelected() == true)
				{
					Estado e = new Estado();
					EstadoTipos[] mapEstados = { 
													EstadoTipos.EXTRAVIADO,
													EstadoTipos.ENCONTRADO,
													EstadoTipos.ADOPTADO,
													EstadoTipos.ENADOPCION,
													EstadoTipos.RECUPERADO
												};
					e.setEstado(mapEstados[estadosComboBox.getSelectedIndex()]);
					busquedaList.JListShowEstado(controller.getModel().getRegistro().getMascotas(), e, false);
				}
			
				if(pThis.rdbtnPorRecompensa.isSelected() == true)
				{
					char[] monedaMap = {'$', '\u20AC', '\u20A1'};
					Recompensa r = new Recompensa();
					r.setMonto(Float.parseFloat(recompensaTextField.getText()));
					r.setMoneda(monedaMap[monedaComboBox.getSelectedIndex()]);
					busquedaList.JListShowRecompensa(controller.getModel().getRegistro().getMascotas(), r, false);
				}
				
			}
				
		});
	}

	public JComboBox getRazasComboBox() {
		return razasComboBox;
	}

	public void setRazasComboBox(JComboBox razasComboBox) {
		this.razasComboBox = razasComboBox;
	}
}
