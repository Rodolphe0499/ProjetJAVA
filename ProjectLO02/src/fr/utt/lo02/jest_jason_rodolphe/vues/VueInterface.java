package fr.utt.lo02.jest_jason_rodolphe.vues;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import fr.utt.lo02.jest_jason_rodolphe.controleur.PartieControleur;
import fr.utt.lo02.jest_jason_rodolphe.modeles.Carte;
import fr.utt.lo02.jest_jason_rodolphe.modeles.Joueurs;
import fr.utt.lo02.jest_jason_rodolphe.modeles.Partie;
import fr.utt.lo02.jest_jason_rodolphe.modeles.Valeur;


public class VueInterface extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Partie partie;
	private PartieControleur controleur;
	
	private JFrame frame;
	private VueJoueurs pjJoue;
	private VueDek dek;
	private VueJest jest;
	private VueStack stack;
	private ArrayList<VueJoueurs> pj;
	
	public VueInterface(Partie p, PartieControleur c){
		super();
		ArrayList<VueJoueurs> pj = new ArrayList<VueJoueurs>();
		this.partie = p;
		this.partie.addObserver(this);
		this.controleur = c;
		
		this.frame = new JFrame();
		this.frame.setTitle("Jest Jason_Rodolphe");
		this.frame.setSize(1500, 1000);
		this.frame.setLocationRelativeTo(null);               
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(null);
		
		this.frame.setContentPane(this);
	}
	
	public void afficherJeu(VueJoueurs pj){
		pj.setCartesVisibles(0);
		pj.setCartesVisibles(1);
	}
	
	public void afficherDek(){
		this.dek = new VueDek();
		dek.setBounds(600, 320, 300, 200);
		this.add(dek);
		this.frame.setContentPane(this);
	}
	
	public void afficherJoueurs(){
		for(int i=0; i<this.partie.getNombreJoueurs();i++){
			pj.add(new VueJoueurs(this.partie.getJoueur(i)));
		}
		if (this.partie.getNombreJoueurs()== 3){
			pj.get(0).setBounds(0, 0, 500, 200);
			this.add(pj.get(0));
			pj.get(1).setBounds(700, 0, 500, 200);
			this.add(pj.get(1));
			pj.get(2).setBounds(500, 550, 500, 200);
			this.add(pj.get(2));
		}
		if (this.partie.getNombreJoueurs() == 4){
			pj.get(0).setBounds(0, 300, 500, 200);
			this.add(pj.get(0));
			pj.get(1).setBounds(500, 0, 500, 200);
			this.add(pj.get(1));
			pj.get(2).setBounds(1000, 300, 500, 200);
			this.add(pj.get(2));
			pj.get(3).setBounds(500, 550, 500, 200);
			this.add(pj.get(3));
		}
	    	this.frame.setContentPane(this);
	}
	
	public Image attribuerCarte(Carte c){
		Image carte = null;
			switch(c.getValeur()){
				case ZERO:
					carte = dek.getCartes().get(0);
						break;		
				case AS:
					switch(c.getCouleur()){
						case CARREAU:
							carte = dek.getCartes().get(1);
							break;
						case COEUR:
							carte = dek.getCartes().get(2);
							break;
						case PIQUE:
							carte = dek.getCartes().get(3);
							break;
						case TREFLE:
							carte = dek.getCartes().get(4);
							break;
					}
					break;
				case DEUX:
					switch(c.getCouleur()){
					case CARREAU:
						carte = dek.getCartes().get(5);
						break;
					case COEUR:
						carte = dek.getCartes().get(6);
						break;
					case PIQUE:
						carte = dek.getCartes().get(7);
						break;
					case TREFLE:
						carte = dek.getCartes().get(8);
						break;
					}
					break;
				case QUATRE:
					switch(c.getCouleur()){
					case CARREAU:
						carte = dek.getCartes().get(9);
						break;
					case COEUR:
						carte = dek.getCartes().get(10);
						break;
					case PIQUE:
						carte = dek.getCartes().get(11);
						break;
					case TREFLE:
						carte = dek.getCartes().get(12);
						break;
					}
					break;
				case TROIS:
				switch(c.getCouleur()){
				case CARREAU:
					carte = dek.getCartes().get(13);
					break;
				case COEUR:
					carte = dek.getCartes().get(4);
					break;
				case PIQUE:
					carte = dek.getCartes().get(15);
					break;
				case TREFLE:
					carte = dek.getCartes().get(16);
					break;
					}
					break;
			}
		return carte;
	}
	
	public void afficherCartes(Joueurs joueur){
		ListIterator<VueJoueurs> iPj = this.pj.listIterator();
		while (iPj.hasNext()){
			VueJoueurs vuej = iPj.next();
			if (vuej.getNomJoueur() == joueur.getNom()){
				ListIterator<Carte> iCartes = joueur.getMain().listIterator();
				while (iCartes.hasNext()){
					vuej.recevoirCarte(this.attribuerCarte(iCartes.next()));
				}
			}
		}
	}
	
	public void afficherJoueurCommence(){
		ListIterator<VueJoueurs> vuej = pj.listIterator();
		while (vuej .hasNext()){
			vuej .next().setCartesVisibles(0);
			vuej .next().setCartesVisibles(1);
		}
		ListIterator<Joueurs> iJoueurs = partie.getJoueurs().listIterator();
		while (iJoueurs.hasNext()){
			this.afficherCartes(iJoueurs.next());
		}
		/*JOptionPane.showMessageDialog(null, this.partie.premierJoueur().getNom() + " commence ce tour !", "Qui Commence ?", JOptionPane.INFORMATION_MESSAGE);
		while (vuej.hasPrevious()){
			vuej.previous().retirerTout();
		}*/
		this.frame.setContentPane(this);
	}
	
	public void afficherDistribution(){
		ListIterator<VueJoueurs> iPj = pj.listIterator();
		while (iPj.hasNext()){
			iPj.next().setCartesVisibles(true);
		}
		ListIterator<Joueurs> iJoueurs = partie.getJoueurs().listIterator();
		while (iJoueurs.hasNext()){
			this.afficherCartes(iJoueurs.next());
		}
		this.frame.setContentPane(this);
	}
	
	public void choisirCarte(){
		this.changerVisibiliteCartes(true);
		Object[] option ={1,2};
		 int choix = JOptionPane.showOptionDialog(null, 
                 "Voulez-vous prendre la première carte ou la seconde", 
                 "Choix de sa carte", 
                 JOptionPane.YES_NO_OPTION, 
                 JOptionPane.QUESTION_MESSAGE, 
                 null, option, option[0]);
 
		if(choix == 1){
			controleur.controlePioche();
			this.actualiserPlateau();
		}
		if(choix == 2){
			controleur.controleCarte(carte);
		}
		controleur.controleUNO();
		this.changerVisibiliteCartes(false);
	}
	
	public void choisirJoueur(){
		
		  Object[] option ={1,2};
		 int choix = JOptionPane.showOptionDialog(null, 
                 "Voulez-vous prendre la première carte ou la seconde", 
                 "Choix de sa carte", 
                 JOptionPane.YES_NO_OPTION, 
                 JOptionPane.QUESTION_MESSAGE, 
                 null, option, option[0]);
 
		if(choix == 1){
			controleur.controlePioche();
			this.actualiserPlateau();
		}
		if(choix == 2){
			controleur.controleCarte(carte);
		}
		controleur.controleUNO();
		this.changerVisibiliteCartes(false);
	
	}
	
	public void actualiserPlateau(){
		ListIterator<Joueur> iJoueur = partie.getJoueurs().listIterator();
		while (iJoueur.hasNext()){
			Joueur j = iJoueur.next();
			this.supprimerJeu(j);
			this.afficherCartes(j);
		}
		this.piles.getTalon().removeAll(piles.getTalon());
		this.piles.getTalon().add(this.verifierCarte(partie.getTalon().getPile().getLast()));
		this.frame.setContentPane(this);
	}
	
	public void changerVisibiliteCartes(Boolean visibles){
		ListIterator<PanelJoueur> iPj = pj.listIterator();
		while (iPj.hasNext()){
			PanelJoueur pj = iPj.next();
			if (pj.getNomJoueur() == partie.getJoueurJoue().getNomJoueur()){
				pj.setCartesVisibles(visibles);
			}
		}
		this.frame.setContentPane(this);
	}
	
	public void afficherScore(){
		
	}
	
	public void paintComponent(Graphics g){
	    try {
	      Image img = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\JEST"));
	      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}

	public void update(Observable o, Object arg) {
		if (arg == "joueurs"){
			this.afficherJoueurs(partie.getJoueurs().size());
		}
		if (arg == "piles"){
			this.afficherPiles();
		}
		if (arg == "joueurcommence"){
			this.afficherJoueurCommence();
		}
		if (arg == "distribuer"){
			this.afficherDistribution();
		}
		if (arg == "passerTour"){
			JOptionPane.showMessageDialog(null, "Le tour de " + partie.getJoueurJoue() + " est passe !", "A qui de jouer ?", JOptionPane.INFORMATION_MESSAGE);
		}
		if (arg == "declareJoueur"){
			String[] action = {"Dire contre UNO", "Ne rien faire"};
		    int reponseCO=JOptionPane.showOptionDialog(null, 
		      "C'est le tour de "+ partie.getJoueurJoue()+ "\nQue faire ?",
		      "Action",
		      JOptionPane.YES_NO_OPTION,
		      JOptionPane.QUESTION_MESSAGE,
		      null,
		      action,
		      action[1]);
		    if(reponseCO==0){
		    	controleur.controleContreUNO();
		    }
		}
		if (arg == "joue"){
			this.choisirCarte();
		}
		if (arg == "actualiserPlateau"){
			this.actualiserPlateau();
		}
		if (arg == "changementCouleur"){
			this.choisirCouleur();
			JOptionPane.showMessageDialog(null, "Nouvelle couleur du talon : " + partie.getTalon().afficherCouleurTalon(), "Couleur du talon", JOptionPane.INFORMATION_MESSAGE);
		}
		if (arg == "afficherCouleur"){
			JOptionPane.showMessageDialog(null, "Nouvelle couleur du talon : " + partie.getTalon().afficherCouleurTalon(), "Couleur du talon", JOptionPane.INFORMATION_MESSAGE);
		}
		if (arg == "demandeBluff"){
			
		}
		if(arg == "afficheVainqueurEtScore"){
			JOptionPane.showMessageDialog(null, "C'est " + partie.getVainqueurManche() + " qui gagne la manche !", "Information", JOptionPane.INFORMATION_MESSAGE);
			this.actualiserPlateau();
			Scores tabScores = new Scores(partie);
			tabScores.setVisible(true);
			this.afficherNouvelleManche();
			tabScores.setVisible(false);
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public VueJoueurs getPjJoue() {
		return pjJoue;
	}

	public void setPjJoue( VueJoueurs pjJoue) {
		this.pjJoue = pjJoue;
	}
}
