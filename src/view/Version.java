package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;

public class Version extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Version() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, Color.DARK_GRAY, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(44, 9, 354, 172);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		panel.add(label);
		label.setIcon(new ImageIcon(Version.class.getResource("/resources/logo.png")));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(10, 195, 414, 126);
		contentPane.add(verticalBox);
		
		JTextPane txtpnPetLoversSystem = new JTextPane();
		txtpnPetLoversSystem.setEditable(false);
		verticalBox.add(txtpnPetLoversSystem);
		txtpnPetLoversSystem.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtpnPetLoversSystem.setForeground(Color.ORANGE);
		txtpnPetLoversSystem.setText("Pet Lovers - Lost Pets System Manager");
		
		JTextPane txtpnAuthorVinicioFlores = new JTextPane();
		txtpnAuthorVinicioFlores.setEditable(false);
		txtpnAuthorVinicioFlores.setText("Author: Vinicio Flores Hern\u00E1ndez");
		verticalBox.add(txtpnAuthorVinicioFlores);
		
		JTextPane txtpnTecCosta = new JTextPane();
		txtpnTecCosta.setEditable(false);
		txtpnTecCosta.setText("TEC - Costa Rican Institute of Technology");
		verticalBox.add(txtpnTecCosta);
		
		JTextPane txtpnNovember = new JTextPane();
		txtpnNovember.setEditable(false);
		txtpnNovember.setText("November, 2014");
		verticalBox.add(txtpnNovember);
	}
}
