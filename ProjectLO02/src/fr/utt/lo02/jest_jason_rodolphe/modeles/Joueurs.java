package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.LinkedList;

public abstract class Joueurs {
	
	private boolean type_joueur;
	private LinkedList<Carte> main;
	private int carteUP;
	private Partie partie;
	private Jest jest;
	
	public Joueurs(boolean type_joueur,Partie partie) {
		
		jest= new Jest(this);
		main = new LinkedList<Carte>();
		this.partie=partie;
		this.type_joueur=type_joueur;
		
	}
	
	public void envoyerCarteToJest(Carte cartes) {
		jest.envoyerCarte(cartes);
	}
	
    public abstract Carte getMain(int i);	
	public boolean getType() {
		return this.type_joueur;
	}
	
	public void prendreCarte(Carte carte) {
		main.add(carte);
	}
	
	public abstract void recevoirCarte(Carte cartes);
	
	public abstract String afficherMain();
    
	public abstract boolean verifierOffre() ;

	public abstract String afficherCarteFaceUp();
	
	public abstract Jest getJest() ;
	public abstract int getSizeJest();
	public abstract Carte getJest(int k);
	public abstract Carte getOffre() ;
	
    public abstract Carte getCarteDown();
    public abstract void choisirFaceCarte();
    public abstract int ChoisirJoueur();
    public abstract void choisirCarteDeLoffreATirer(int tour);
    public abstract void setAJouer();
    public abstract boolean aJouer();
	public abstract void retirerCarte(Carte carteDown);
	public abstract String getNom();
	public abstract int ChoisirJoueur(int nbreJoueurrestant);
    public abstract int getScore();
    public abstract void setScore(int valeur);
	public abstract void envoyerCarteFinal();
}
