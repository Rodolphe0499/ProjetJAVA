package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.*;


public class DekCarte {
    public final static int NOMBRE_DE_CARTES = (Valeur.values().length-1) *
    		Couleur.values().length +1;
    
    protected LinkedList<Carte> dek;
    public DekCarte () {
    	
    	dek = new LinkedList<Carte>();
    	Carte joker = new Carte(Couleur.PIQUE,Valeur.ZERO,false,Trophee.BestJest);
    	
    	dek.add(new Carte(Couleur.COEUR,Valeur.AS, false, Trophee.Joker));
    	dek.add(new Carte(Couleur.COEUR,Valeur.DEUX, false, Trophee.Joker));	
    	dek.add(new Carte(Couleur.COEUR,Valeur.TROIS, false, Trophee.Joker));
    	dek.add(new Carte(Couleur.COEUR,Valeur.QUATRE, false, Trophee.Joker));
    	
    	dek.add(new Carte(Couleur.TREFLE,Valeur.AS, false, Trophee.HighestPIQUE));
    	dek.add(new Carte(Couleur.TREFLE,Valeur.DEUX, false, Trophee.LowestCOEUR));
    	dek.add(new Carte(Couleur.TREFLE,Valeur.TROIS, false, Trophee.HighestCOEUR));
    	dek.add(new Carte(Couleur.TREFLE,Valeur.QUATRE, false, Trophee.LowestPIQUE));
    	
    	dek.add(new Carte(Couleur.PIQUE,Valeur.AS, false, Trophee.HighestTREFLE));
    	dek.add(new Carte(Couleur.PIQUE,Valeur.DEUX, false, Trophee.MajorityTHREE));
    	dek.add(new Carte(Couleur.PIQUE,Valeur.TROIS, false, Trophee.MajorityTWO));
    	dek.add(new Carte(Couleur.PIQUE,Valeur.QUATRE, false, Trophee.LowestTREFLE));
    	
    	dek.add(new Carte(Couleur.CARREAU,Valeur.AS, false, Trophee.MajorityFOUR));
    	dek.add(new Carte(Couleur.CARREAU,Valeur.DEUX, false, Trophee.HighestCARREAU));
    	dek.add(new Carte(Couleur.CARREAU,Valeur.TROIS, false, Trophee.LowestCARREAU));
    	dek.add(new Carte(Couleur.CARREAU,Valeur.QUATRE, false, Trophee.BestJestNoJoke));
    	
    	dek.add(joker);
    	
    }
    
    /**
     * permet de melanger le tas de carte
     */
    public  void melanger() {
    	Collections.shuffle(dek);
    }
    
    /**
     * permet de tirer la carte au dessus du tas de carte
     * @return
     */
    public Carte tirerCarteDuDessus() {
    	return dek.pop();
    }
  
    /**
     * permet de retirer une carte de manière aleatoire 
     * @return
     */
    public Carte tirerCarte() {
    	int position = (int) Math.round((DekCarte.NOMBRE_DE_CARTES -1)*Math.random());
    	return dek.remove(position);
    }
    
    /**
     * permet de savoir si le dek est vide
     * @return
     */
    public boolean estVide() {
    	return dek.isEmpty();
    }
    
    /**
     * permet d'afficher le dek
     */
    public String toString() {
    	return dek.toString();
    }

    /**
     * permet de recuperer le nombre de carte dans le dek
     * @return
     */
    public int getSizeDek() {
    	return dek.size();
    }
}
