package fr.utt.lo02.jest_jason_rodolphe.vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JComboBox;

public class InterfaceParametre {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceParametre window = new InterfaceParametre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceParametre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JCheckBox chckbxVintage = new JCheckBox("vintage");
		frame.getContentPane().add(chckbxVintage, BorderLayout.EAST);
		
		JCheckBox chckbxClassique = new JCheckBox("classique");
		frame.getContentPane().add(chckbxClassique, BorderLayout.CENTER);
	}

}
