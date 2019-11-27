package projet;


import java.util.*;


public class Partie {
	private int nbretotaljoueur;
	private int nbreJoueur ;
	private int nbreBots;
	private LinkedList<Joueur> joueurs;
	private dekCarte dek;
	private Stack stack;
	private TropheeTiree tropheeTiree;
	private Joueur dernierJoueur;
	
	public Partie() {
		//Demande nombre de joueurs total
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous faire une partie à 3 ou à 4?");
		int numero = sc.nextInt();
		this.nbretotaljoueur=numero;
		
		while((numero != 3)&&(numero != 4)){
			System.out.println(">>>Veuillez taper 3 ou 4!");
			numero = sc.nextInt();
	   }
		//Demande nombre de joueurs physique
		if (numero == 4) {
			Scanner sd = new Scanner(System.in);
			System.out.println("Veuillez rentrer le nombre de joueur physique (1 à 4 joueurs)?");
			int nbrejoueur = sc.nextInt();
		
			while((nbrejoueur != 1)&&(nbrejoueur != 2)&&(nbrejoueur != 3)&&(nbrejoueur != 4)){
				System.out.println(">>>Veuillez taper 1, 2, 3 ou 4 !");
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
				System.out.println(">>>Veuillez taper 1, 2, 3!");
				nbrejoueur = sd.nextInt();
			}
			this.nbreJoueur=nbrejoueur;
			this.nbreBots= numero-nbrejoueur;
		}
				
	    joueurs = new LinkedList<Joueur>();
		
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
			System.out.print(joueurs.get(i)+" ");
		}
		System.out.println();
		
		
		stack = new Stack();
		dek = new dekCarte();
		dek.melanger();
		tropheeTiree = new TropheeTiree();
		
		//Afficher les offres disponibles pour chaque joueurs
		
		/*
		//Demande au premier joueur l'offre qu'il souhaite prendre ( s'il est reel)
		System.out.println(this.dernierJoueur);
		if(this.dernierJoueur.getType()==true) {
			Scanner sj = new Scanner(System.in);
			System.out.println("[Joueur]"+determinerPremierJoueur()+", l'offre de quel joueur veux-tu ?");
			String nomjoueur = sj.nextLine();
			if (VerifierNomJoueur(nomjoueur) == true) {
				System.out.println("Vous allez choisir l'offre de "+nomjoueur);
			}
			else {
				System.out.println(">>>Le joueur n'est pas existant.");
			}
		}
		*/
		
		
		
    }
	public void tirerTrophee() {
		tropheeTiree.ajouterTrophee(dek.tirerCarteDuDessus());
		tropheeTiree.ajouterTrophee(dek.tirerCarteDuDessus());
		tropheeTiree.afficherTrophee();
	}
	public void MakeOffer() {
		for (int j=0; j<joueurs.size();j++) {
			joueurs.get(j).faireUneOffre();
		}
	}
	public void distribuerDek() {
		for (int i=0; i<joueurs.size();i++) {
			joueurs.get(i).recevoirCarte(dek.tirerCarteDuDessus());
			joueurs.get(i).recevoirCarte(dek.tirerCarteDuDessus());
		}
		
	}
	
	public void distribuerStack() {
		for (int i=0; i<joueurs.size();i++) {
			joueurs.get(i).recevoirCarte(stack.tirerCarteDuDessus());
			joueurs.get(i).recevoirCarte(stack.tirerCarteDuDessus());
		}
	}
	
	public void afficherMainsJoueurs() {
		int i=0;
		for (i=0; i<joueurs.size();i++) {
			System.out.println(joueurs.get(i)+" ");  
	    }
    }
	
	public Joueur determinerPremierJoueur() {
		int max_valeur;
		if (this.nbretotaljoueur==3) {
			for(int i=0; i<joueurs.size();i++) {
				
				
				//Soit le premier joueur de la liste à une valeur SUPERIEUR au second
				if(joueurs.get(i).ValeurIntCarteFaceOuverte()>joueurs.get(i+1).ValeurIntCarteFaceOuverte()){
					max_valeur = joueurs.get(i).ValeurIntCarteFaceOuverte();
					//Soit le premier joueur de la liste à une valeur SUPERIEUR au troisieme
					if( max_valeur > joueurs.get(i+2).ValeurIntCarteFaceOuverte()) {
						this.dernierJoueur = joueurs.get(i);
						return joueurs.get(i);//OK
					}
					//Soit le premier joueur de la liste à une valeur EGALE au troisieme
					else if (max_valeur == joueurs.get(i+2).ValeurIntCarteFaceOuverte()) {
						//On compare alors les couleurs
						if (joueurs.get(i).CouleurIntCarteFaceOuverte()>joueurs.get(i+2).CouleurIntCarteFaceOuverte()) {
							this.dernierJoueur = joueurs.get(i);
							return joueurs.get(i);//OK
						}
						else {
							this.dernierJoueur = joueurs.get(i+2);
							return joueurs.get(i+2);//OK
						}
					}
					//Sinon c'est le 3eme qui à la plus grande carte
					else {
						this.dernierJoueur = joueurs.get(i+2);
						return joueurs.get(i+2);//OK
					}
				}
				
				
				
				else if(joueurs.get(i).ValeurIntCarteFaceOuverte()==joueurs.get(i+1).ValeurIntCarteFaceOuverte()){
					//On compare alors les couleurs
					if (joueurs.get(i).CouleurIntCarteFaceOuverte() > joueurs.get(i+1).CouleurIntCarteFaceOuverte()) {
						max_valeur = joueurs.get(i).ValeurIntCarteFaceOuverte();
						//Soit le premier joueur de la liste à une valeur SUPERIEUR au troisieme
						if( max_valeur > joueurs.get(i+2).ValeurIntCarteFaceOuverte()) {
							this.dernierJoueur = joueurs.get(i);
							return joueurs.get(i);//OK
						}
						//Soit le premier joueur de la liste à une valeur EGALE au troisieme
						else if (max_valeur == joueurs.get(i+2).ValeurIntCarteFaceOuverte()) {
							//On compare alors les couleurs
							if (joueurs.get(i).CouleurIntCarteFaceOuverte()>joueurs.get(i+2).CouleurIntCarteFaceOuverte()) {
								this.dernierJoueur = joueurs.get(i);
								return joueurs.get(i);//OK
							}
							else {
								this.dernierJoueur = joueurs.get(i+2);
								return joueurs.get(i+2);//OK
							}
						}
					}
				
					else {
						max_valeur = joueurs.get(i+1).ValeurIntCarteFaceOuverte();
						//Soit le second joueur à une valeur SUPERIEUR au troisieme
						if( max_valeur > joueurs.get(i+2).ValeurIntCarteFaceOuverte()) {
							this.dernierJoueur = joueurs.get(i+1);
							return joueurs.get(i+1);//OK
						}
						//Soit le second joueur de la liste à une valeur EGALE au troisieme
						else if (max_valeur == joueurs.get(i+2).ValeurIntCarteFaceOuverte()) {
							//On compare alors les couleurs
							if (joueurs.get(i+1).CouleurIntCarteFaceOuverte()>joueurs.get(i+2).CouleurIntCarteFaceOuverte()) {
								this.dernierJoueur = joueurs.get(i+1);
								return joueurs.get(i+1);
							}
							else {
								this.dernierJoueur = joueurs.get(i+2);
								return joueurs.get(i+2);
							}
						}
						else {
							this.dernierJoueur = joueurs.get(i+2);
							return joueurs.get(i+2);
						}
				
					}
				}
						
						
						
				//Soit le premier à une carte INFERIEUR au second
				else if(joueurs.get(i).ValeurIntCarteFaceOuverte()<joueurs.get(i+1).ValeurIntCarteFaceOuverte()){
					max_valeur = joueurs.get(i+1).ValeurIntCarteFaceOuverte();
					//Soit le second joueur de la liste à une valeur SUPERIEUR au troisieme
					if( max_valeur > joueurs.get(i+2).ValeurIntCarteFaceOuverte()) {
						this.dernierJoueur = joueurs.get(i+1);
						return joueurs.get(i+1);//OK
					}
					//Soit le second joueur de la liste à une valeur EGALE au troisieme
					else if (max_valeur == joueurs.get(i+2).ValeurIntCarteFaceOuverte()) {
						//On compare alors les couleurs
						if (joueurs.get(i+1).CouleurIntCarteFaceOuverte()>joueurs.get(i+2).CouleurIntCarteFaceOuverte()) {
							this.dernierJoueur = joueurs.get(i+1);
							return joueurs.get(i+1);//OK
						}
						else {
							this.dernierJoueur = joueurs.get(i+2);
							return joueurs.get(i+2);//OK
						}
					}
					//Sinon c'est le 3eme qui à la plus grande carte
					else {
						this.dernierJoueur = joueurs.get(i+2);
						return joueurs.get(i+2);//OK
					}
				}

			}
		}
		return null;
	}
	
	
	public boolean VerifierNomJoueur(String nom) {
		if(!nom.equals(this.dernierJoueur.getNom()) && joueurs.contains(joueurs.getNom()))) {
			return true;
		}
		else {
			return false;
		}
		return false;
		
	}

	public void afficherPremierJoueur() {
		System.out.println("[Joueur]"+determinerPremierJoueur().getNom()+" commence la partie.");
	}

	public void afficherOffres() {
		System.out.println("Voici les offres disponibles:");
		for(int i=0;i<joueurs.size();i++) {
			System.out.println((i+1)+")[Joueur]"+joueurs.get(i).getNom()+" : "+joueurs.get(i).afficherCarteFaceUp()+ " / carte face-down.");
		}
	}
}

