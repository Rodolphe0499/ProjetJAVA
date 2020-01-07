package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.Random;
import java.util.Scanner;

public class StrategyJoueurReel extends Strategy{

	private Partie partie;
	private Joueur joueur;
	private int carteUP;
	private int numero;
	private boolean ajouer;
	
	public StrategyJoueurReel(Joueur joueur,Partie partie) {
		super(joueur);
		this.joueur = joueur;
		this.partie=partie;
		this.ajouer=false;
	}
	

	public void choisirFaceCarte() {
		
			Scanner sc = new Scanner(System.in);
			System.out.println("[Joueur] "+this.joueur.getNom()+", veux-tu retourner la première carte ou la seconde(1/2)?");
			int numero = sc.nextInt();
			this.carteUP=numero;
			
			while((numero != 1)&&(numero != 2)){
				System.out.println(">>>Veuillez taper 1 ou 2 !");
				numero = sc.nextInt();
				this.carteUP=numero;
			}	
			
			if(numero == 1) {
				joueur.getMain(0).retournerCarte();
			}
			
			if (numero == 2) {
				joueur.getMain(1).retournerCarte();
			}

		}
	public void demanderSiAffichageCarte() {
		
			Scanner sr = new Scanner(System.in);
			System.out.println("\n[Joueur] "+this.joueur.getNom()+", veux-tu voir tes cartes ?(o/n)");
			String res = sr.nextLine();
			while((!res.equalsIgnoreCase("o"))&&(!res.equalsIgnoreCase("n"))){
				System.out.println(">>>Veuillez taper 'o' ou 'n' !");
				res = sr.nextLine();
			}
			if (res.equalsIgnoreCase("o")) {
				System.out.println("Voici tes cartes:"+joueur.afficherMain());
				choisirFaceCarte();
			}
			else {
				choisirFaceCarte();
			}
	}
	public int choisirJoueur() {
		Scanner sc = new Scanner(System.in);
		System.out.println(joueur.getNom()+" ,Veuillez entrer le numero du joueur dont l'offre vous interesse");
		this.numero = sc.nextInt();
		this.ajouer=true;
		
		if(partie.getNombreJoueurs()==3) {
			while (this.numero!=0 && this.numero!=1 && this.numero!=2) {
				Scanner sd = new Scanner(System.in);
				System.out.println("Veuillez rentrer un des numeros placés à côté des noms des joueurs");
				this.numero = sd.nextInt();
			}
			while(partie.getJoueur(this.numero).equals(this.joueur)) {
				Scanner sd = new Scanner(System.in);
				System.out.println("Vous ne pouvez pas prendre votre propre offre. Veuillez choisir un autre joueur");
				this.numero = sd.nextInt();
			}
		}
		if(partie.getNombreJoueurs()==4) {
			while (this.numero!=0 && this.numero!=1 && this.numero!=2 && this.numero!=3) {
				Scanner sd = new Scanner(System.in);
				System.out.println("Veuillez rentrer un des numeros placés à côté des noms des joueurs");
				this.numero = sd.nextInt();
			}
			while(partie.getJoueur(this.numero).equals(this.joueur)) {
				Scanner sd = new Scanner(System.in);
				System.out.println("Vous ne pouvez pas prendre votre propre offre. Veuillez choisir un autre joueur");
				this.numero = sd.nextInt();
			}
		}
		
		while(!this.partie.getJoueur(this.numero).verifierOffre()){
			Scanner sf = new Scanner(System.in);
			System.out.println("la main de "+this.partie.getJoueur(this.numero).getNom()+" n'est pas complète.Veuillez prendre une autre offre");
			this.numero = sf.nextInt();
			
			if(partie.getNombreJoueurs()==3) {
				while (this.numero!=0 && this.numero!=1 && this.numero!=2) {
					Scanner sd = new Scanner(System.in);
					System.out.println("Veuillez rentrer un des numeros placés à côté des noms des joueurs");
					this.numero = sd.nextInt();
				}
			}
			if(partie.getNombreJoueurs()==4) {
				while (this.numero!=0 && this.numero!=1 && this.numero!=2 &&this.numero!=3) {
					Scanner sd = new Scanner(System.in);
					System.out.println("Veuillez rentrer un des numeros placés à côté des noms des joueurs");
					this.numero = sd.nextInt();
				}
			}
		}	
		 System.out.println(joueur.getNom()+" a pris la carte de  "+partie.getJoueur(this.numero).getNom());
		return this.numero;
	}
	public int choisirJoueur(int nbreJoueurrestant) {
		Scanner sc = new Scanner(System.in);
		System.out.println(joueur.getNom()+" ,Veuillez entrer le numero du joueur dont l'offre vous interesse");
		this.numero = sc.nextInt();
		this.ajouer=true;
		
		if(partie.getNombreJoueurs()==3) {
			while (this.numero!=0 && this.numero!=1 && this.numero!=2) {
				Scanner sd = new Scanner(System.in);
				System.out.println("Veuillez rentrer un des numeros placés à côté des noms des joueurs");
				this.numero = sd.nextInt();
			}
			if(nbreJoueurrestant!=1) {
			while(partie.getJoueur(this.numero).equals(this.joueur)) {
				Scanner sd = new Scanner(System.in);
				System.out.println("Vous ne pouvez pas prendre votre propre offre. Veuillez choisir un autre joueur");
				this.numero = sd.nextInt();
			}
			}
			else {
				if (!this.joueur.verifierOffre()) {
				while(partie.getJoueur(this.numero).equals(this.joueur)) {
					Scanner sd = new Scanner(System.in);
					System.out.println("Vous ne pouvez pas prendre votre propre offre. Veuillez choisir un autre joueur");
					this.numero = sd.nextInt();
			}
				}else {
				while(!partie.getJoueur(this.numero).equals(this.joueur)) {
					Scanner sd = new Scanner(System.in);
					System.out.println("Vous ne pouvez  prendre que votre propre offre.");
					this.numero = sd.nextInt();
			}
		}
		}
		}
		if(partie.getNombreJoueurs()==4) {
			while (this.numero!=0 && this.numero!=1 && this.numero!=2 && this.numero!=3) {
				Scanner sd = new Scanner(System.in);
				System.out.println("Veuillez rentrer un des numeros placés à côté des noms des joueurs");
				this.numero = sd.nextInt();
			}
			if(nbreJoueurrestant!=1) {
				while(partie.getJoueur(this.numero).equals(this.joueur)) {
					Scanner sd = new Scanner(System.in);
					System.out.println("Vous ne pouvez pas prendre votre propre offre. Veuillez choisir un autre joueur");
					this.numero = sd.nextInt();
				}
				}
				else {
					if (!this.joueur.verifierOffre()) {
					while(partie.getJoueur(this.numero).equals(this.joueur)) {
						Scanner sd = new Scanner(System.in);
						System.out.println("Vous ne pouvez pas prendre votre propre offre. Veuillez choisir un autre joueur");
						this.numero = sd.nextInt();
				}
					}else {
					while(!partie.getJoueur(this.numero).equals(this.joueur)) {
						Scanner sd = new Scanner(System.in);
						System.out.println("Vous ne pouvez  prendre que votre propre offre.");
						this.numero = sd.nextInt();
				}
			}
			}
		}
		
		while(!this.partie.getJoueur(this.numero).verifierOffre()){
			Scanner sf = new Scanner(System.in);
			System.out.println("la main de "+this.partie.getJoueur(this.numero).getNom()+" n'est pas complète.Veuillez prendre une autre offre");
			this.numero = sf.nextInt();
			
			if(partie.getNombreJoueurs()==3) {
				while (this.numero!=0 && this.numero!=1 && this.numero!=2) {
					Scanner sd = new Scanner(System.in);
					System.out.println("Veuillez rentrer un des numeros placés à côté des noms des joueurs");
					this.numero = sd.nextInt();
					
					if(nbreJoueurrestant!=1) {
						while(partie.getJoueur(this.numero).equals(this.joueur)) {
							
							System.out.println("Vous ne pouvez pas prendre votre propre offre. Veuillez choisir un autre joueur");
							this.numero = sd.nextInt();
						}
						}
						else {
							if (!this.joueur.verifierOffre()) {
							while(partie.getJoueur(this.numero).equals(this.joueur)) {
								System.out.println("Vous ne pouvez pas prendre votre propre offre. Veuillez choisir un autre joueur");
								this.numero = sd.nextInt();
						}
							}else {
							while(!partie.getJoueur(this.numero).equals(this.joueur)) {
								System.out.println("Vous ne pouvez  prendre que votre propre offre.");
								this.numero = sd.nextInt();
						}
					}
					}
			}
			}
			if(partie.getNombreJoueurs()==4) {
				while (this.numero!=0 && this.numero!=1 && this.numero!=2 &&this.numero!=3) {
					Scanner sd = new Scanner(System.in);
					System.out.println("Veuillez rentrer un des numeros placés à côté des noms des joueurs");
					this.numero = sd.nextInt();
				}
				if(nbreJoueurrestant!=1) {
					while(partie.getJoueur(this.numero).equals(this.joueur)) {
						Scanner sd = new Scanner(System.in);
						System.out.println("Vous ne pouvez pas prendre votre propre offre. Veuillez choisir un autre joueur");
						this.numero = sd.nextInt();
					}
					}
					else {
						if (!this.joueur.verifierOffre()) {
						while(partie.getJoueur(this.numero).equals(this.joueur)) {
							Scanner sd = new Scanner(System.in);
							System.out.println("Vous ne pouvez pas prendre votre propre offre. Veuillez choisir un autre joueur");
							this.numero = sd.nextInt();
					}
						}else {
						while(!partie.getJoueur(this.numero).equals(this.joueur)) {
							Scanner sd = new Scanner(System.in);
							System.out.println("Vous ne pouvez  prendre que votre propre offre.");
							this.numero = sd.nextInt();
					}
				}
				}
			}
		}
		 System.out.println("Le "+joueur.getNom()+" a pris la carte de  "+partie.getJoueur(this.numero).getNom());
		return this.numero;
	}
	@Override
	public void choisirCarteDeLoffreATirer(int tour) {
		Scanner se = new Scanner(System.in);
		System.out.println("Voulez-vous prendre la carte face ouverte ou la face cachée(up/down)");
		String res = se.nextLine();
		
		while((!res.equalsIgnoreCase("up"))&&(!res.equalsIgnoreCase("down"))){
			System.out.println(">>>Veuillez taper 'up' ou 'down' !");
			res = se.nextLine();
		}
		if (res.equalsIgnoreCase("up")) {
			if((partie.getNombreTour()-tour)!=0) {
			if(this.partie.getJoueur(this.numero).getMain(0).getFaceCarte()==true) {
				System.out.println("Voici la carte que "+joueur.getNom()+" a prise "+this.partie.getJoueur(this.numero).getMain(0).toString());
				joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(0));
				this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
				Carte j=this.partie.getJoueur(this.numero).getMain(0);
				j.setFaceDown();
				this.partie.ajouterCarteStack(this.partie.getJoueur(this.numero).getMain(0));
				this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
				
			}else
			if(this.partie.getJoueur(this.numero).getMain(1).getFaceCarte()==true) {
				System.out.println("Voici la carte que "+joueur.getNom()+" a prise "+this.partie.getJoueur(this.numero).getMain(1).toString());
				joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(1));
				this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(1));
				Carte j=this.partie.getJoueur(this.numero).getMain(0);
				j.setFaceDown();
				this.partie.ajouterCarteStack(this.partie.getJoueur(this.numero).getMain(0));
				this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
			}
			}else {
				if(this.partie.getJoueur(this.numero).getMain(0).getFaceCarte()==true) {
					System.out.println("Voici la carte que "+joueur.getNom()+" a prise "+this.partie.getJoueur(this.numero).getMain(0).toString());
					joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(0));
					this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
					this.partie.getJoueur(this.numero).envoyerCarteFinal();
				}else
					if(this.partie.getJoueur(this.numero).getMain(1).getFaceCarte()==true) {
						System.out.println("Voici la carte que "+joueur.getNom()+" a prise "+this.partie.getJoueur(this.numero).getMain(1).toString());
						joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(1));
						this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(1));
						this.partie.getJoueur(this.numero).envoyerCarteFinal();
			}
			}
			}
		 if (res.equalsIgnoreCase("down")) {
			 if((partie.getNombreTour()-tour)!=0) {
				if(this.partie.getJoueur(this.numero).getMain(0).getFaceCarte()==false) {
					System.out.println("Voici la carte que "+joueur.getNom()+" a prise "+this.partie.getJoueur(this.numero).getMain(0).toString());
					joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(0));
					this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
					Carte j=this.partie.getJoueur(this.numero).getMain(0);
					j.setFaceDown();
					this.partie.ajouterCarteStack(this.partie.getJoueur(this.numero).getMain(0));
					this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
				}else
	    	       if(this.partie.getJoueur(this.numero).getMain(1).getFaceCarte()==false) {
	    	    	   System.out.println("Voici la carte que "+joueur.getNom()+" a prise "+this.partie.getJoueur(this.numero).getMain(1).toString());
		         	joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(1));
			        this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(1));
		        	Carte j=this.partie.getJoueur(this.numero).getMain(0);
		        	j.setFaceDown();
		        	this.partie.ajouterCarteStack(this.partie.getJoueur(this.numero).getMain(0));
			        this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
				}
					
		    }else
			  if(this.partie.getJoueur(this.numero).getMain(0).getFaceCarte()==false) {
				  System.out.println("Voici la carte que "+joueur.getNom()+" a prise "+this.partie.getJoueur(this.numero).getMain(0).toString());
				joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(0));
				this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
				this.partie.getJoueur(this.numero).envoyerCarteFinal();
			  }else 
				  if(this.partie.getJoueur(this.numero).getMain(1).getFaceCarte()==false) {
					  System.out.println("Voici la carte que "+joueur.getNom()+" a prise "+this.partie.getJoueur(this.numero).getMain(1).toString());
			         	joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(1));
				        this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(1));
				        this.partie.getJoueur(this.numero).envoyerCarteFinal();
				  }
		 }
	}

	 @Override
	   public boolean aJouer() {
		   return ajouer;
	   }	
	public static void main(String[] args) {
		
	}


	@Override
	public void setAJouer() {
		this.ajouer=false;
		
	}	
}
