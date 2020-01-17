package fr.utt.lo02.jest_jason_rodolphe.vues;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.utt.lo02.jest_jason_rodolphe.controleur.PartieControleur;

public class EcranAccueil extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private VueAccueil pa;
	private JButton nouvellePartie;
	private JButton quitter;
	
	public EcranAccueil(){
		this.setTitle("Jest by good little games");
		this.setSize(1000, 800);
	    this.setLocationRelativeTo(null);               
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.pa = new VueAccueil();
	    
	    Font font = new Font("Courier", Font.BOLD, 15);
	    
		this.nouvellePartie = new JButton("Nouvelle partie");
		this.nouvellePartie.setFont(font);
		this.nouvellePartie.setActionCommand("nouvellepartie");
		
		
		this.quitter = new JButton("Quitter");
		this.quitter.setFont(font);
		this.quitter.setActionCommand("quitterpartie");
		
	    this.pa.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(20,20,20,20);
	    gbc.ipadx = 75;
	    gbc.ipady = 10;
	    
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    this.pa.add(nouvellePartie, gbc);
	    
	    GridBagConstraints gdc = new GridBagConstraints();
	    gdc.insets = new Insets(20,20,20,20);
	    gdc.ipadx = 75;
	    gdc.ipady = 10;
	    gdc.gridy = 3;
	    this.pa.add(quitter, gdc);
	    
	    this.setContentPane(pa);
	    this.setVisible(true);
	}

	public void setListener(PartieControleur controleur) {
		nouvellePartie.addActionListener(controleur);
		quitter.addActionListener(controleur);
	}
}
