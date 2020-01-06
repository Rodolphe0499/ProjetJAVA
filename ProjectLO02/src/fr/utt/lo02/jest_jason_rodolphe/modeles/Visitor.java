package fr.utt.lo02.jest_jason_rodolphe.modeles;

public abstract class Visitor {
	
	public Visitor() {}
	protected String methodeActuelle = "tout";

    /** 
     * Permet de changer la regle de comptage de carte pour les lancer une par une
     *
     * @param nouvelleMethode La methode de comptage
     */
    public void changerRegleComptage( String nouvelleMethode ) {
        this.methodeActuelle = nouvelleMethode;
    }
    
    /** 
     * Donne toutes les regles de comptages disponibles
     *
     * @return Les regles de comptages disponibles
     */
    public String[] getReglesComptageDisponibles() {

        return new String[] {"piques", "trefles", "carreaux",  "coeurs", "paires","joker","valet"};
           
    }
    
    /** 
     * Appelee lorsque l'on veut compter le score pout un Joueur
     *
     * @param j Le joueur pour qui on veut compter le score
     *
     * @return Le score
     */
	 public int visit(Jest j) {
		 int score = 0;
		 switch( this.methodeActuelle ) {
         case "piques":
        	 return this.compterPiques(j);
         case "trefles":
        	 return this.compterTrefles(j);
         case "carreaux":
        	 return this.compterCarreaux(j);
         case "coeurs":
        	 return this.compterCoeurs(j);
         case "paires":
        	 return this.compterPaires(j);
         case "joker":
        	 return this.compterJoker(j);
         case "valet":
        	 return this.compterValet(j);
         case "tout":
             score += this.compterPiques(j);
             score += this.compterTrefles(j);
             score += this.compterCarreaux(j);
             score += this.compterCoeurs(j);
             score += this.compterPaires(j);
             score += this.compterJoker(j);
             score += this.compterValet(j);
            
     }

		 return score;
	    }
	  /**
     * Regle de comptage de score pour les piques
     * Chaque pique augmente le score de sa valeur
     * Si il n'y a que le 1, il vaut 5 points
     *
     * @param j Le jest pour lequel compter la regle
     * @return Le score obtenu pour cette regle
     */
    protected abstract int compterPiques(Jest j);

    /**
     * Regle de comptage de score pour les trefles
     * Chaque trefle augmente le score de sa valeur
     * Si il n'y a que le 1, il vaut 5 points
     *
     * @param j Le jest pour lequel compter la regle
     * @return Le score obtenu pour cette regle
     */
    protected abstract int compterTrefles(Jest j);

    /**
     * Regle de comptage de score pour les carreaux
     * Chaque carreau diminue le score de sa valeur
     * Si il n'y a que le 1, il vaut -5 points
     *
     * @param j Le jest pour lequel compter la regle
     * @return Le score obtenu pour cette regle
     */
    protected abstract int compterCarreaux(Jest j);

    /**
     * Regle de comptage de score pour les coeurs
     * Si il n'y a pas de joker, les coeurs ne valent rien
     * Si il y a le joker:
     *  - Si il y a 4 coeurs: on ajoute la valeur de chaque carte au score
     *  - Si il y a moins de 4 coeurs: on deduit la valeur de chaque carte au score
     *    Dans le second cas, si il n'y a que le 1 de coeur, il vaut -5 points
     *
     * @param j Le jest pour lequel compter la regle
     * @return Le score obtenu pour cette regle
     */
    protected abstract int compterCoeurs(Jest j);

    /**
     * Regle de comptage de score pour les paires
     * Si il y a des paires noires, il y a un bonus de 2 points par paires
     *
     * @param j Le jest pour lequel compter la regle
     * @return Le score obtenu pour cette regle
     */
    protected abstract int compterPaires(Jest j);

    /**
     * Regle de comptage de score pour le Joker
     * Si il y a un joker, mais pas de coeur, on ajoute 4 au score
     *
     * @param j Le jest pour lequel compter la regle
     * @return Le score obtenu pour cette regle
     */
    protected abstract int compterJoker(Jest j);

    /**
    /**
     * Regle de comptage de score pour le Valet
     * Si il y a deux valets, mais pas de coeur, on retire 4 au score
     *
     * @param j Le jest pour lequel compter la regle
     * @return Le score obtenu pour cette regle
     */
    protected abstract int compterValet(Jest j);

}
