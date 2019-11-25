package projet;
import java.util.*;



public class Deck {
	public final static int NOMBRE_DE_CARTES = Valeur.values().length*Couleur.values().length;
	private LinkedList<Carte> tasDeCartes;
	
	public Deck() {
		tasDeCartes = new LinkedList<Carte>();
		for(Couleur c: Couleur.values()) {
			for (Valeur v: Valeur.values()) {
				Carte carte = new Carte(v,c);
				System.out.println(carte);
				tasDeCartes.add(carte);
			}
		}
	}
	
	public String toString() {
		return tasDeCartes.toString();
	}
	
	public static void main(String[]args) {
		Deck deck = new Deck();
	
	}
}
