package projet;


import java.util.*;


public class Partie {
	
	private int nbreJoueur ;
	private int nbreBots;
	private ArrayList<Joueur> joueurs;
	private dekCarte dek;
	private Stack stack;
	private TropheeTiree tropheeTiree;
	
	public Partie() {
		//Demande nombre de joueurs total
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous faire une partie à 3 ou à 4?");
		int numero = sc.nextInt();
		
		while((numero != 3)&&(numero != 4)){
			System.out.println("Veuillez taper 3 ou 4 ");
			numero = sc.nextInt();
	   }
		//Demande nombre de joueurs physique
		if (numero == 4) {
			Scanner sd = new Scanner(System.in);
			System.out.println("Veuillez rentrer le nombre de joueur physique (1 à 4 joueurs)?");
			int nbrejoueur = sc.nextInt();
		
			while((nbrejoueur != 1)&&(nbrejoueur != 2)&&(nbrejoueur != 3)&&(nbrejoueur != 4)){
				System.out.println("Veuillez taper 1, 2, 3 ou 4 !");
				nbrejoueur = sd.nextInt();
			}
			this.nbreJoueur=nbrejoueur;
			this.nbreBots= numero-nbrejoueur;
		}
		else if (numero ==3){
			Scanner sd = new Scanner(System.in);
			System.out.println("Veuillez rentrer le nombre de joueur physique (1 à 3 joueurs)?");
			int nbrejoueur = sc.nextInt();
		
			while((nbrejoueur != 1)&&(nbrejoueur != 2)&&(nbrejoueur != 3)){
				System.out.println("Veuillez taper 1, 2, 3!");
				nbrejoueur = sd.nextInt();
			}
			this.nbreJoueur=nbrejoueur;
			this.nbreBots= numero-nbrejoueur;
		}
				
		joueurs = new ArrayList<Joueur>();
		
		//Création des joueurs rééls
		int i =0;
		for(i =0; i < this.nbreJoueur; i++ ) {
			Scanner sf = new Scanner(System.in);
			System.out.println("Veuillez rentrer le pseudo du joueur n°"+(i+1)+":");
			String name = sf.nextLine();
			Joueur j = new Joueur(name,true);
			joueurs.add(j);
		}
		
		//Création des joueurs virtuels si nombre de joueurs rééls != 4
		if (this.nbreBots != 0) {
			for(i =0; i < this.nbreBots; i++ ) {			
				Joueur j = new Joueur("Bot"+i,false);
				joueurs.add(j);
			}
		}
		
		System.out.println("Voici la liste des participants:");
		for (i=0; i<joueurs.size();i++) {
			System.out.println(joueurs.get(i));
		}
		
		
		
		stack = new Stack();
		
		dek = new dekCarte();
		
		//dek.melanger();		
    }
	
	/*public void distribuerCarte() {
		
		
	}*/
	
		
	
}
