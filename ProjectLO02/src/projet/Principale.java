package projet;

public class Principale {

	public static void main(String[] args) {
			Partie partie1 = new Partie();
			
			Joueur rodolphe = new Joueur("Rodolphe", true);
			Joueur jason = new Joueur("Jason", true);
			partie1.AjouterJoueur(rodolphe);
			partie1.AjouterJoueur(jason);
			System.out.println(partie1);
						
		
	}

}
