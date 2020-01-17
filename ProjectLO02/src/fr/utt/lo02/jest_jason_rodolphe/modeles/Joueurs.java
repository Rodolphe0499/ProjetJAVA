package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.LinkedList;
/**
* Cette classe représente un joueur, on declinera les joueurs joués par l'ordinateur avec la class JoueurVirtuel  qui héritera de Joueurs.
* Un joueur est définis par son nom, sa main et son jest. 
* Chaque joueurs comporte aussi une LinkedList de carte correspondant au carte qu'il possède en main. 
* Chaque joueurs comporte aussi une LinkedList de carte correspondant au carte qu'il possède dans son jest. 
* (On a choisi une LinkedList car elle permet d'avoir un ordonnacement dans les cartes.)
*  
* 
* @author Jason Mekam
*
*/
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
	
	/**
	 * envoie la carte choisit dans l'offre adversaire dans son jest
	 */
	public void envoyerCarteToJest(Carte cartes) {
		jest.envoyerCarte(cartes);
	}
	
	/**
	 * permet de prendre une carte dans la main du joueur
	 * @param i
	 * @return
	 */
    public abstract Carte getMain(int i);	
    
    /**
     * permet de savoir s'il s'agit d'un joueur réel ou d'un joueur virtuel
     * @return
     */
	public boolean getType() {
		return this.type_joueur;
	}
	
	/**
	 * permet d'ajouter une carte à sa main 
	 * @param carte
	 */
	public void prendreCarte(Carte carte) {
		main.add(carte);
	}
	
	/**
	 * permet de recevoir une carte provenant du dek
	 */
	public abstract void recevoirCarte(Carte cartes);
	
	/**
	 * permet d'afficher la main d'un joueur
	 * @return
	 */
	public abstract String afficherMain();
    
	/**
	 * permet de verifier si l'offre du joueur est complète
	 * @return
	 */
	public abstract boolean verifierOffre() ;
    
	/**
	 * permet d'afficher la carte face up du joueur
	 * @return
	 */
	public abstract String afficherCarteFaceUp();
	
	/**
	 * permet d'obtenir une liste de carte contenant toutes les cartes du jest du joueur
	 * @return
	 */
	public abstract Jest getJest() ;
	
	/**
	 * permet de connaitre le nombre de carte dans le jest de chaque joueur
	 * @return
	 */
	public abstract int getSizeJest();
	
	/**
	 * permet d'obenir une carte bien precise du jest du joueur
	 * @param k
	 * @return
	 */
	public abstract Carte getJest(int k);
	
	/**
	 * permet de recuperer la carte face up d'un joueur virtuel
	 * @return
	 */
	public abstract Carte getOffre() ;
	
	/**
	 * permet d'obtenir la main d'un joueur
	 * @return
	 */
	public abstract LinkedList<Carte> getMain();
	
	/**
	 * permet de recuperer la carte face cachee 
	 * @return
	 */
    public abstract Carte getCarteDown();
    
    public abstract void choisirFaceCarte();
    public abstract int ChoisirJoueur();
    public abstract int ChoisirJoueur(int nbreJoueurrestant);
    public abstract void choisirCarteDeLoffreATirer(int tour);
    public abstract void setAJouer();
    public abstract boolean aJouer();
    
    /**
     * permet de retirer une carte de la main d'un joueur
     * @param carteDown
     */
	public abstract void retirerCarte(Carte carteDown);
	
	/**
	 * permet d'afficher le nom d'un joueur
	 * @return
	 */
	public abstract String getNom();
	
	/**
	 * permet de recuperer le score d'un joueur
	 * @return
	 */
    public abstract int getScore();
    
    /**
     * permet de reinitialiser le score
     * @param valeur
     */
    public abstract void setScore(int valeur);
    
    /**
     * permet d'envoyer la derniere carte dans sa main dans son jest à la fin du jeu
     */
	public abstract void envoyerCarteFinal();
	
	/**
	 * permet de savoir s'il s'agit d'un joueur virtuel
	 * @return
	 */
	public abstract boolean isVirtuel();
	
}
