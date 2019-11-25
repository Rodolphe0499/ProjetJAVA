package projet;

import java.util.*;


public class dekCarte {
    public final static int NOMBRE_DE_CARTES = Valeur.values().length *
    		Couleur.values().length +1;
    
    private LinkedList<Carte> dek;
    public dekCarte () {
    	
    	dek = new LinkedList<Carte>();
    	Carte joker = new Carte(Couleur.PIQUE,Valeur.Zero,false,Trophee.BestJest);
    	
    	for (Valeur v : Valeur.values()) {
    		Carte carte = new Carte(Couleur.COEUR,v, false, Trophee.Joker);
    		dek.add(carte);
    		
    	}
    	
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
    
    public  void melanger() {
    	Collections.shuffle(dek);
    }
    
    
    public Carte tirerCarteDuDessus() {
    	return dek.pop();
    }
  
    public Carte tirerCarte() {
    	int position = (int) Math.round((dekCarte.NOMBRE_DE_CARTES -1)*Math.random());
    	return dek.remove(position);
    }
    
    public boolean estVide() {
    	return dek.isEmpty();
    }
    
    public String toString() {
    	return dek.toString();
    }


}
