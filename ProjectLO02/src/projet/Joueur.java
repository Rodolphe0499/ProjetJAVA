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
	public void setNom(String nom) {
		this.pseudo = nom;
	}
	public void prendreCarte(Carte carte) {
		main.add(carte);
	}
	
	
	public void recevoirCarte(Carte cartes) {
		main.add(cartes);
	}
	
	public int choisirCarte() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous jouez la premi�re carte ou la seconde(tapez 1 ou 2)?");
		int numero = sc.nextInt();
		
		while((numero != 1)&&(numero != 2)){
			System.out.println("Veuillez taper 1 ou 2 ");
			numero = sc.nextInt();
			
		}
				
		
		return numero;
	}
	
	
	public void afficherCarte() {
		int i=1;
		for (i=1; i<=2; i++) {
			if(main.get(i).getFaceCarte()==true)
			System.out.println(main.get(i).toString());
		}
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.pseudo);
		sb.append(";");
		sb.append(main);
		sb.append("\n");
		return sb.toString();
	}
	
	
}
