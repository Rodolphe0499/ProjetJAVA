package projet;

import java.util.*;
public class Joueur {


	private String pseudo;
	private boolean type_joueur;
	private LinkedList<Carte> main;
	private int carteUP;

	public Joueur(String name, boolean type) {
		this.pseudo=name;
		this.type_joueur = type;
		main = new LinkedList<Carte>();
		this.carteUP=0;
		
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
	
	public void choisirFaceCarte() {
	
		if (type_joueur == true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("[Joueur] "+this.pseudo+", veux-tu retourner la première carte ou la seconde(1/2)?");
			int numero = sc.nextInt();
			this.carteUP=numero;
			
			while((numero != 1)&&(numero != 2)){
				System.out.println(">>>Veuillez taper 1 ou 2 !");
				numero = sc.nextInt();
				this.carteUP=numero;
			}	
			
			if(numero == 1) {
				main.get(0).retournerCarte();
			}
			
			else if (numero == 2) {
				main.get(1).retournerCarte();
			}
		
		}
		
		if (type_joueur == false) {
			 Random r = new Random();
			 int n = r.nextInt(1)+1;
			 this.carteUP=n;
			 if(n == 1) {
					main.get(1).retournerCarte();
				}
			 else if (n == 2) {
			    	main.get(2).retournerCarte();
			}
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
		if (this.carteUP==1) {
			v = main.get(0).getValeur();
		}
		if (this.carteUP==2) {
			v = main.get(1).getValeur();
		}
		
		return v;
	}
	
	public int ValeurIntCarteFaceOuverte() {
		switch (ValeurCarteFaceOuverte()) {
			case QUATRE:
				return 4;
			case TROIS:
				return 3;
			case DEUX:
				return 2;
			case AS:
				return 1;
			case ZERO:
				return 0;
		}
		return 0;
	}

	public Couleur CouleurCarteFaceOuverte() {    
		Couleur c = Couleur.COEUR;
		if (this.carteUP==1) {
			c = main.get(0).getCouleur();
		}
		if (this.carteUP==2) {
			c = main.get(1).getCouleur();
		}
		
		return c;
	}
	public int CouleurIntCarteFaceOuverte() {
		switch (CouleurCarteFaceOuverte()) {
		case PIQUE:
			return 4;
		case TREFLE:
			return 3;
		case CARREAU:
			return 2;
		case COEUR:
			return 1;
	}
	return 0;
	}
}
