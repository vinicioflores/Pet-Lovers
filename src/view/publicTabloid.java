package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import java.awt.Button;

public class publicTabloid extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public publicTabloid() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 0 0,grow");
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Extraviados", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Encontrados", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("En Adopción", null, panel_2, null);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, "cell 0 1");
		
		Button button = new Button("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		toolBar.add(button);
	}

}
