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
	
	public static void main(String[] args) {
		
	}

}
