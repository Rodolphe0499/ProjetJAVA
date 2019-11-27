package projet;

import java.util.*;

public class TropheeTiree {
	

	 private ArrayList<Trophee> trophee;  	

	public TropheeTiree() {
		trophee = new ArrayList<Trophee>();
		
	}
	
	public void ajouterTrophee(Carte cartes) {
		trophee.add(cartes.getTrophee());
	}
	
	public void afficherTrophee() {
		System.out.println("Voici les trophees pour cette partie:" +trophee.get(0)+" et "+trophee.get(1));
	}
}
