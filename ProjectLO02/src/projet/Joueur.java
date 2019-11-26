package projet;

import java.util.*;
public class Joueur {


	private String pseudo;
	private boolean type_joueur;
	private LinkedList<Carte> main;
	

	public Joueur(String name, boolean type) {
		this.pseudo=name;
		this.type_joueur = type;
		main = new LinkedList<Carte>();
		
	}
	public String getNom() {
		return pseudo;
	}
	public boolean getType() {
		return this.type_joueur;
	}
	public void setNom(String nom) {
		this.pseudo = nom;
	}
	public void prendreCarte(Carte carte) {
		main.add(carte);
	}
	
	
	public void recevoirCarte(Carte cartes) {
		main.add(cartes);
	}
	
	public int choisirFaceCarte() {
		if (type_joueur == true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n[Joueur] "+this.pseudo+", voulez-vous retourner la première carte ou la seconde(1/2)?");
			int numero = sc.nextInt();
		
			while((numero != 1)&&(numero != 2)){
				System.out.println(">>>Veuillez taper 1 ou 2 !");
				numero = sc.nextInt();
			
			}		
		
			return numero;
		}
		else if (type_joueur == false) {
			 Random r = new Random();
			 int n = r.nextInt(1)+1;
			 return n;
		}
		else {
			return 0;
		}
	}
	
	
	public String afficherCarteJoueur() {
		return main.toString();

	}
	
	public String toString() {
		return this.pseudo.toString();
	}
	
	public Valeur ValeurCarteFaceOuverte() {    
		Valeur v = Valeur.AS;
		if (this.choisirCarte()==1) {
			v =main.get(0).getValeur();
		}
		if (this.choisirCarte()==2) {
			v =main.get(1).getValeur();
		}
		
		return v;
	}
	
	
}
