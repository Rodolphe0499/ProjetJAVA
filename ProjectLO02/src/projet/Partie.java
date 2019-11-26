package projet;


import java.util.*;


public class Partie {
	
	private int nbreJoueur ;
	private int nbreBots;
	private LinkedList<Joueur> joueurs;
	private dekCarte dek;
	private Stack stack;
	private TropheeTiree tropheeTiree;
	
	public Partie() {
		//Demande nombre de joueurs total
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous faire une partie à 3 ou à 4?");
		int numero = sc.nextInt();
		
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
		
		
		stack = new Stack();
		dek = new dekCarte();
		dek.melanger();
		distribuerDek();
		
		//Demande aux joueurs réels uniquement si ils souhaitent observer ses cartes et déterminer sa face
		for (int j=0; j<joueurs.size();j++) {
			if (joueurs.get(j).getType() == true) {
				Scanner sr = new Scanner(System.in);
				System.out.println("\n[Joueur] "+joueurs.get(j)+", veux-tu voir tes cartes ?(o/n)");
				String res = sr.nextLine();
				while((!res.equalsIgnoreCase("o"))&&(!res.equalsIgnoreCase("n"))){
					System.out.println(">>>Veuillez taper 'o' ou 'n' !");
					res = sr.nextLine();
				}
				if (res.equalsIgnoreCase("o")) {
					System.out.println("Voici tes cartes:"+joueurs.get(j).afficherCarteJoueur());
					joueurs.get(j).choisirFaceCarte();
				}
				else {
					joueurs.get(j).choisirFaceCarte();
				}
			}
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
		Valeur v= Valeur.AS;
		int j =0;
		int i=1;
	
			/*for(i=1; i <=joueurs.size(); i++) {
				if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.AS)&&(v== Valeur.AS)) {
					
				}
				
                 if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.DEUX)&&(v== Valeur.AS)) {
					v= Valeur.DEUX;
					j=i;
				}
                 
                 if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.TROIS)&&(v== Valeur.AS)) {
                	 v= Valeur.TROIS;
                	 j=i;
 				}
                 
                 if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.QUATRE)&&(v== Valeur.AS)) {
 					v=Valeur.QUATRE;
 					j=i;
 				}
                 if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.ZERO)&&(v== Valeur.AS)) {
 					v=Valeur.AS;
 					j=i;
 				} 
                 
                 if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.AS)&&(v== Valeur.DEUX)) {
 					
 				}
 				
                  if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.DEUX)&&(v== Valeur.DEUX)) {
 					
 				}
                  
                  if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.TROIS)&&(v== Valeur.DEUX)) {
                 	 v= Valeur.TROIS;
  				}
                  
                  if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.QUATRE)&&(v== Valeur.DEUX)) {
  					v=Valeur.QUATRE;
  				}
                  if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.ZERO)&&(v== Valeur.DEUX)) {
  					v=Valeur.DEUX;
  				} 
                  if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.AS)&&(v== Valeur.TROIS)) {
  					
  				}
  				
                   if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.DEUX)&&(v== Valeur.TROIS)) {
  					
  				}
                   
                   if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.TROIS)&&(v== Valeur.TROIS)) {
                  	
   				}
                   
                   if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.QUATRE)&&(v== Valeur.TROIS)) {
   					v=Valeur.QUATRE;
   				}
                   if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.ZERO)&&(v== Valeur.TROIS)) {
   					v=Valeur.TROIS;
   				} 
                   if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.AS)&&(v== Valeur.QUATRE)) {
   					
   				}
   				
                    if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.DEUX)&&(v== Valeur.QUATRE)) {
   					
   				}
                    
                    if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.TROIS)&&(v== Valeur.QUATRE)) {
                   	
    			}
                    
                    if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.QUATRE)&&(v== Valeur.QUATRE)) {
    					
    			}
                    if((joueurs.get(i).ValeurCarteFaceOuverte()==Valeur.ZERO)&&(v== Valeur.QUATRE)) {
    					v=Valeur.QUATRE;
                }	
    				
			}
			return v;*/
		ListIterator it = joueurs.listIterator();
		for(i=1; i <=joueurs.size(); i++) {
			if(it.hasNext()) {
				
				
			}
		}
		
		
	}
	
	
	
}
