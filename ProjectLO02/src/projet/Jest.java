package projet;

import java.util.*;

public class Jest {
	
	private Joueur joueur;
	private int nbreCarteJest;
	private  LinkedList<Carte> jest;
	
	public Jest (Joueur joueur) {
		this.joueur =joueur;
		
	}
	public void envoyerCarteToJest(Carte cartes) {
		jest.add(cartes);
	}
	
	
	public static void main(String[] args) {
		
	}

}
