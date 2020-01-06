package fr.utt.lo02.jest_jason_rodolphe.modeles;

public abstract class Strategy {

	protected Joueurs joueur;

    public Strategy(Joueurs j) {
        this.joueur = j;
    }
    
    public abstract void choisirFaceCarte(); 
    public abstract int choisirJoueur();
    public abstract int  choisirJoueur(int nbreJoueurRestant);
    public abstract void choisirCarteDeLoffreATirer(int tour);
    public abstract boolean aJouer();
    public abstract void setAJouer();

    
    
    
    
    
   
    
}
