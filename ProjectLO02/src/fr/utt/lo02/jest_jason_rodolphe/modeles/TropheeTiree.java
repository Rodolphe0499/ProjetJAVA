package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.*;

public class TropheeTiree {
	

    private ArrayList<Carte> trophee;  	

	public TropheeTiree() {
		trophee = new ArrayList<Carte>();
		
	}
	
	public void ajouterTrophee(Carte cartes) {
		trophee.add(cartes);
	}
	public Carte getTropheeTiree(int i) {
		return trophee.get(i);
	}
	public void afficherTrophee() {
		System.out.println("Voici les trophees pour cette partie: " +trophee.get(0).getTrophee()+" et "+trophee.get(1).getTrophee());
	}
}
