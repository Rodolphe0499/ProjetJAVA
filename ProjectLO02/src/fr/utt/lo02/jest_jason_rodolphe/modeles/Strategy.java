package fr.utt.lo02.jest_jason_rodolphe.modeles;

public abstract class Strategy {

	protected Joueurs joueur;

    public Strategy(Joueurs j) {
        this.joueur = j;
    }
    
    /**
     * permet de choisir la carte que le joueur veut mettre face up pour le tour de jeu.
     */
    public abstract void choisirFaceCarte(); 
    
    /**
     * permet de choisir dont on veut saisir la carte
     * @return
     */
    public abstract int choisirJoueur();
    
    /**
     *  permet de choisir dont on veut saisir la carte. 
     *  Celui prend egalement en paramètre le nombre de joueur dont l'offre est disponible
     * @param nbreJoueurRestant
     * @return
     */
    public abstract int  choisirJoueur(int nbreJoueurRestant);
    
    /**
     * permet de choisir quel carte de l'adversaire on veut mettre dans son jest
     * @param tour
     */
    public abstract void choisirCarteDeLoffreATirer(int tour);
    
    /**
     * permet de savoir si le joueur a déja joué
     * @return
     */
    public abstract boolean aJouer();
    
    /**
     * permet de reinitialiser la methode aJouer()
     */
    public abstract void setAJouer();

    
    
    
    
    
   
    
}
