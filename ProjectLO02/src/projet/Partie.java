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
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous faire une partie à 3 ou à 4?");
		int numero = sc.nextInt();
		
		while((numero != 3)&&(numero != 4)){
			System.out.println("Veuillez taper 3 ou 4 ");
			numero = sc.nextInt();
	   }
		Scanner sd = new Scanner(System.in);
		System.out.println("Veuillez rentrer le nombre de joueur physique (1 ou 2 joueur)?");
		int nbrejoueur = sc.nextInt();
		
		while((nbrejoueur != 1)&&(nbrejoueur != 2)){
			System.out.println("Veuillez taper 1 ou 2 ");
			nbrejoueur = sd.nextInt();
		}
		
		this.nbreJoueur=nbrejoueur;
		this.nbreBots= numero-nbrejoueur;
		
		joueurs = new ArrayList<Joueur>();
		
		int i =1;
		for(i =1; i < this.nbreJoueur; i++ ) {
			Scanner sf = new Scanner(System.in);
			System.out.println("Veuillez rentrer votre pseudo");
			String name = sc.nextLine();
			
			Joueur j = new Joueur(name,true);
			joueurs.add(j);
		}
		
		for(i =1; i < this.nbreBots; i++ ) {
			Scanner sf = new Scanner(System.in);
			System.out.println("Voulez-vous faire une partie à 3 ou à 4?");
			String name = sc.nextLine();
			
			Joueur j = new Joueur("bot"+i,false);
			joueurs.add(j);
		}
		
		stack = new Stack();
		
		dek = new dekCarte();
		
		dek.melanger();		
    }
	
	public void distribuerCarte() {
		
		
	}
	
		
	
}
