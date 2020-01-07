package fr.utt.lo02.jest_jason_rodolphe.vues;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent ;

import javax.swing.JButton;
import javax.swing.JFrame ;
import javax.swing.JPanel;

public class InterfaceGraphiqueJeu extends JFrame implements ActionListener {
	
	private static 	JButton quitter = new JButton ("Quitter la partie");
	
	
	
	public InterfaceGraphiqueJeu() {
		
		CardLayout c2=new CardLayout(10,20) ;
		JPanel cartes= new JPanel();
		cartes.setLayout( new GridLayout(1,4));
		cartes.add(new Carte_Joueurs());
		JPanel corps2=new JPanel() ;
		corps2.setLayout(c2);
		corps2.add(new AllureVue());
		//this.getContentPane().add(corps2);
		this.setContentPane(corps2);
		
		//this.getContentPane().add(new Carte_Joueurs ());
		this.getContentPane().add(quitter, BorderLayout.SOUTH);
		
	
		
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setTitle("Jest_Jason_Rodolphe");
		 this.setLocationRelativeTo(null);
		 this.setSize(800,700);
		 //this.setResizable(false);
		 this.setVisible(true);
		 quitter.addActionListener(this); 
		 
		 
	}
	
	
	
	

public void actionPerformed (ActionEvent e) {
		
		if(e.getSource()==quitter) {
			this.setVisible(false);
		}
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}


