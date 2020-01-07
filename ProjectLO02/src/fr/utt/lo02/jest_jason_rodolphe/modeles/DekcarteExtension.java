package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.LinkedList;


public class DekcarteExtension extends DekCarte{
	
	public final static int NOMBRE_DE_CARTES = (Valeur.values().length-1) *
    		Couleur.values().length +1;
	
	public DekcarteExtension() {
		super();
		dek = new LinkedList<Carte>();
		
		Carte joker = new Carte(Couleur.PIQUE,Valeur.ZERO,false,Trophee.BestJest);
		dek.add(joker);
		
    	dek.add(new Carte(Couleur.PIQUE,Valeur.VALET, false, Trophee.HighestTREFLE));
    	dek.add(new Carte(Couleur.TREFLE,Valeur.VALET, false, Trophee.BestJest));
    	dek.add(new Carte(Couleur.CARREAU,Valeur.VALET, false, Trophee.MajorityTWO));
    	dek.add(new Carte(Couleur.COEUR,Valeur.VALET, false, Trophee.LowestTREFLE));
    	
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
    	
	}

}
