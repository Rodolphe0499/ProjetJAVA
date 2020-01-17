package fr.utt.lo02.jest_jason_rodolphe.vues;

import java.awt.*;

import javax.swing.*;

import fr.utt.lo02.jest_jason_rodolphe.controleur.PartieControleur;
import fr.utt.lo02.jest_jason_rodolphe.vues.VueAccueil;

public class Configuration extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private VueAccueil pp;
	private JButton validation;
	private JRadioButton extension1;
	private JRadioButton extension2;
	private ButtonGroup extensionGroup;
	private JRadioButton difficulte1;
	private JRadioButton difficulte2;
	private ButtonGroup difficulteGroup;
	private JComboBox nbrReels;
	private JComboBox nbrVirtuels;
	private JPanel difficulte;
	private JPanel extension;
	private JPanel virtuels;
	private JPanel reels;
	private JLabel lDifficulte;
	private JLabel lNbrVirtuels;
	private JLabel lNbrReels;
	private JLabel lNextension;
	
	public Configuration(){
		super();
		this.setTitle("Configuration du jeu");
		this.setSize(1000, 800);
	    this.setLocationRelativeTo(null);               
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    pp = new VueAccueil();
	    difficulte = new JPanel();
	    extension= new JPanel();
		virtuels = new JPanel();
		reels = new JPanel();
		Font font = new Font("Courier", Font.BOLD, 15);
		validation = new JButton("Jouer");
		validation.setFont(font);
		validation.setActionCommand("jouer");
		
		difficulteGroup = new ButtonGroup();
		difficulte1 = new JRadioButton("Facile");
		difficulte1.setFont(font);
		difficulte1.setOpaque(false);
		difficulte2 = new JRadioButton("Moyen");
		difficulte2.setFont(font);
		difficulte2.setOpaque(false);
		
		extensionGroup = new ButtonGroup();
		extension1 = new JRadioButton("oui");
		extension1.setFont(font);
		extension1.setOpaque(false);
		extension2 = new JRadioButton("non");
		extension2.setFont(font);
		extension2.setOpaque(false);
		
		
		
		nbrReels = new JComboBox();
		nbrVirtuels = new JComboBox();
		
		lDifficulte = new JLabel("Difficulte : ");
		lDifficulte.setFont(font);
		
		lNextension = new JLabel("Partie avec extension : ");
		lNextension.setFont(font);
		
		lNbrVirtuels = new JLabel("Joueurs Virtuels : ");
		lNbrVirtuels.setFont(font);
		
		lNbrReels = new JLabel("Joueurs Reels : ");
		lNbrReels.setFont(font);
		
		for (int i=0;i<4;i++){nbrReels.addItem(i+1);}
		for (int i=0;i<4;i++){nbrVirtuels.addItem(i);}
		
		difficulteGroup.add(difficulte1);
		difficulteGroup.add(difficulte2);
		
		extensionGroup.add(extension1);
		extensionGroup.add(extension2);
		
		difficulte.add(lDifficulte);
		difficulte.add(difficulte1);
		difficulte.add(difficulte2);
		difficulte.setOpaque(false);
		
		extension.add(lNextension);
		extension.add(extension1);
		extension.add(extension2);
		extension.setOpaque(false);
		
		virtuels.add(lNbrVirtuels);
		virtuels.add(nbrVirtuels);
		virtuels.setOpaque(false);
		
		reels.add(lNbrReels);
		reels.add(nbrReels);
		reels.setOpaque(false);
		
		pp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(10,10,10,10);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    pp.add(virtuels, gbc);
	    
	    
	    GridBagConstraints gdc = new GridBagConstraints();
	    gdc.insets = new Insets(10,10,10,10);
	    gdc.gridy = 1;
	    pp.add(reels, gdc);
	    
	    GridBagConstraints gec = new GridBagConstraints();
	    gec.insets = new Insets(10,10,10,10);
	    gec.gridy = 2;
	    pp.add(difficulte, gec);
	    
	    GridBagConstraints gpc = new GridBagConstraints();
	    gpc.insets = new Insets(10,10,10,10);
	    gpc.gridy = 3;
	    pp.add(extension, gpc);
	    
	    GridBagConstraints gfc = new GridBagConstraints();
	    gfc .insets = new Insets(10,10,10,10);
	    gfc .ipadx = 100;
	    gfc .ipady = 10;
	    gfc .gridy = 4;
		pp.add(validation, gfc);
		
	    this.setContentPane(pp);
	}
	
	public int getDifficulte(){
		int difficulte = 0;
		if (difficulte1.isSelected()){difficulte = 1;}
		if (difficulte2.isSelected()){difficulte = 2;}
		return difficulte;
	}
	
	public int getNbrVirtuels(){
		return (Integer) nbrVirtuels.getSelectedItem();
	}
	
	public int getNbrReels(){
		return (Integer) nbrReels.getSelectedItem();
	}
	
	public void setListener(PartieControleur controleur) {
		validation.addActionListener(controleur);
	}
	public boolean getExtension() {
		
	}
}