package fr.utt.lo02.jest_jason_rodolphe.modeles;


import java.util.*;


public class Partie {
	private int nbretotaljoueur;
	private int nbreJoueur ;
	private int nbreBots;
	private int niveau;
	private LinkedList<Joueurs> joueurs;
	private DekCarte dek;
	private Stack stack;
	private TropheeTiree tropheeTiree;
	private Joueur dernierJoueur;
	private boolean terminer;
	private String extension;
	private boolean variante;
	
	
	public Partie() {
		       
		joueurs = new LinkedList<Joueurs>();	
		stack = new Stack();
		tropheeTiree = new TropheeTiree();
		terminer=false;
    }
	public void demanderNombreJoueur() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous faire une partie à 3 ou à 4?");
		this.nbretotaljoueur = sc.nextInt();
		
		
		while((this.nbretotaljoueur != 3)&&(this.nbretotaljoueur != 4)){
			System.out.println(">>>Veuillez taper 3 ou 4!");
			this.nbretotaljoueur = sc.nextInt();
		}
	}

	public void demanderNombreJoueurPhysique() {
				if (this.nbretotaljoueur == 4) {
					Scanner sd = new Scanner(System.in);
					System.out.println("Veuillez rentrer le nombre de joueur physique (1 à 4 joueurs)?");
					this.nbreJoueur = sd.nextInt();
				
					while((this.nbreJoueur != 1)&&(this.nbreJoueur != 2)&&(this.nbreJoueur != 3)&&(this.nbreJoueur != 4)){
						System.out.println(">>>Veuillez taper 1, 2, 3 ou 4 !");
						this.nbreJoueur = sd.nextInt();
					}
					
					this.nbreBots=this.nbretotaljoueur -this.nbreJoueur;
				}
				else if (this.nbretotaljoueur ==3){
					Scanner sd = new Scanner(System.in);
					System.out.println("Veuillez rentrer le nombre de joueur physique (1 à 3 joueurs)?");
					this.nbreJoueur = sd.nextInt();
				
					while((this.nbreJoueur != 1)&&(this.nbreJoueur!= 2)&&(this.nbreJoueur != 3)){
						System.out.println(">>>Veuillez taper 1, 2, 3!");
						this.nbreJoueur = sd.nextInt();
					}
					
					this.nbreBots= this.nbretotaljoueur-this.nbreJoueur;
				}
				
	}
    
	public void demanderDifficulté() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quelle niveau de difficulté voulez-vous, 1 ou 2");
		this.niveau = sc.nextInt();
		
		while((niveau != 1)&&(niveau != 2)){
			System.out.println(">>>Veuillez taper 3 ou 4!");
			this.niveau= sc.nextInt();
	   }
	}
	
	public void demanderExtension() {
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous jouer avec l'extension des cartes(il s'agit de l'ajout de la famille des valets (oui/non)");
        this.extension=sc.nextLine();
        
    	while((!extension.equalsIgnoreCase("oui"))&&(!extension.equalsIgnoreCase("non"))){
			System.out.println(">>>Veuillez taper 'oui' ou 'non' !");
			this.extension = sc.nextLine();
		}
    	//creation du dek 
    			if(extension.equalsIgnoreCase("non")) {
    			   dek = new DekCarte();
    			   dek.melanger();
    			} else {
    				dek= new DekcarteExtension();
    				 dek.melanger();
    			}
	}
    public void demanderVariante() {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous jouer avec les regles normales ou les une variante des regles (taper 'oui' pour les regles classiques et 'non' pour la variante) ");
        String res=sc.nextLine();
        while((!res.equalsIgnoreCase("oui"))&&(!res.equalsIgnoreCase("non"))){
			System.out.println(">>>Veuillez taper 'oui' ou 'non' !");
			res = sc.nextLine();
        }
        if(res.equalsIgnoreCase("non")) {
 		  this.variante=true;
 		} else {
 			this.variante=false;
 		}
    }
	public void creerJoueur() {
		//Création des joueurs rééls
				int i =0;
				for(i =0; i < this.nbreJoueur; i++ ) {
					Scanner sf = new Scanner(System.in);
					System.out.println("Veuillez rentrer le pseudo du joueur n°"+(i+1)+":");
					String name = sf.nextLine();
					Joueur j = new Joueur(name,this);
					joueurs.add(j);
					
				}
				
				//Création des joueurs virtuels si nombre de joueurs rééls != 4
				if (this.nbreBots != 0) {
					for(i =0; i < this.nbreBots; i++ ) {			
						JoueurVirtuel j = new JoueurVirtuel("Bot"+i,this,this.niveau);
						joueurs.add(j);
					}
				}
	}
	
	public void afficherParticipant() {
		System.out.println("Voici la liste des participants:");
		for (int i=0; i<joueurs.size();i++) {
			System.out.println(joueurs.get(i).getNom());
		}
		System.out.println();
	}
	public void tirerTrophee() {
		tropheeTiree.ajouterTrophee(dek.tirerCarteDuDessus());
		tropheeTiree.ajouterTrophee(dek.tirerCarteDuDessus());
		tropheeTiree.afficherTrophee();
	}
	public void MakeOffer() {
		for (int j=0; j<joueurs.size();j++) {
			joueurs.get(j).choisirFaceCarte();
		}
	}
	public void distribuerDek() {
		for (int i=0; i<joueurs.size();i++) {
			joueurs.get(i).recevoirCarte(dek.tirerCarteDuDessus());
			joueurs.get(i).recevoirCarte(dek.tirerCarteDuDessus());
		}
		
	}
	public void ajouterCarteStack(Carte carte) {
		stack.ajouterStack(carte);
	}
	
	public void distribuerStack() {
		stack.melangerStack();
		if(dek.getSizeDek()>=this.nbretotaljoueur) {
		for (int i=0; i<joueurs.size();i++) {
			joueurs.get(i).recevoirCarte(stack.tirerCarteDuDessus());
			joueurs.get(i).recevoirCarte(stack.tirerCarteDuDessus());
		}
		}else
		if(dek.getSizeDek()<this.nbretotaljoueur && terminer==false) {
			 System.out.println("il s'agit du dernier tour");
			 for (int i=0; i<joueurs.size();i++) {
					joueurs.get(i).recevoirCarte(stack.tirerCarteDuDessus());
					joueurs.get(i).recevoirCarte(stack.tirerCarteDuDessus());
					terminer=true;
		}
		}
	}
	
	public void afficherMainsJoueurs() {
		int i=0;
		for (i=0; i<joueurs.size();i++) {
			System.out.println(joueurs.get(i)+" ");  
	    }
    }

	public void ajouterDekToStack() {
		if(dek.getSizeDek()>=this.nbretotaljoueur) {
		 for (int i=0; i<this.nbretotaljoueur;i++) {	
		 stack.ajouterStack(dek.tirerCarteDuDessus());
		 joueurs.get(i).setAJouer();
			}
		 }
	}

 	public void afficherPremierJoueur() {
		System.out.println("[Joueur]"+premierJoueur().getNom()+" commence la partie.");
	}
    public void afficherOffres() {
		System.out.println("Voici les offres disponibles:");
		for(int i=0;i<joueurs.size();i++) {
			System.out.println((i)+")[Joueur]"+joueurs.get(i).getNom()+" : "+joueurs.get(i).afficherCarteFaceUp()+ " / carte face-down.");
		}
	}
	public Joueurs getJoueur(int i) {
		return joueurs.get(i);
	}
 
	public int getNombreJoueurs() {
		return this.nbretotaljoueur;
	}
	
	
	public void prendreDesOffres(int tour) {
      int nextJoueur= 0;
      int suivant=0; 
      Joueurs premier= premierJoueur();
      nextJoueur= premier.ChoisirJoueur();
      premier.choisirCarteDeLoffreATirer(tour);
      for(int i=0;i<joueurs.size()-1;i++) {
      int nbreJoueurrestant= this.nbretotaljoueur-1-i;
	  if(joueurs.get(nextJoueur).aJouer()==true){
		Joueurs j= this.npremierJoueur(nbreJoueurrestant);
		suivant=j.ChoisirJoueur(nbreJoueurrestant);
		j.choisirCarteDeLoffreATirer(tour);
		nextJoueur = suivant;
		}else
	 if(joueurs.get(nextJoueur).aJouer()==false) {
		suivant= joueurs.get(nextJoueur).ChoisirJoueur(nbreJoueurrestant);
		joueurs.get(nextJoueur).choisirCarteDeLoffreATirer(tour);
		   nextJoueur = suivant;
		}
		}
	}
    public Joueurs premierJoueur() {
    	int max=1;
    	int j=0;
    	for (int i=0;i<joueurs.size();i++) {
    	 if(joueurs.get(i).aJouer()==false){
    		if(joueurs.get(i).verifierOffre()==true) {   			
    	       	 if(joueurs.get(i).getOffre().getValeurInt()>max){
    			  max=joueurs.get(i).getOffre().getValeurInt();
    			  j=i;
    		     }else
    		      if(joueurs.get(i).getOffre().getValeurInt()==max){
    				if(joueurs.get(i).getOffre().getCouleurInt()>joueurs.get(j).getOffre().getCouleurInt() );{
    		    	  j=i;
    				}
     		     }
    	     }else {
    		
    	}
    	}
    	}
    	return joueurs.get(j);
    }
    public Joueurs npremierJoueur(int nbreJoueurrestant ) {
     	int max=0;
    	int j=0;
    	if(nbreJoueurrestant!=1) {
    	for (int i=0;i<joueurs.size();i++) {
    	 if(joueurs.get(i).aJouer()==false){			
    	       	 if(joueurs.get(i).getOffre().getValeurInt()>max){
    			  max=joueurs.get(i).getOffre().getValeurInt();
    			  j=i;
    		     }else
    		      if(joueurs.get(i).getOffre().getValeurInt()==max){
    				if(joueurs.get(i).getOffre().getCouleurInt()>joueurs.get(j).getOffre().getCouleurInt() );{
    		    	  j=i;
    				}
     		     }
    	     }else {
    		
    	}
    	}
    	}else {
    		for (int i=0;i<joueurs.size();i++) {
    			 if(joueurs.get(i).aJouer()==false){
    				 j=i;	
    		}
    	}
    	}
    	return joueurs.get(j);
    }
    public void attribuerTrophee() {
    	Visitor scoreVisitor= new ScoreVisitor();
    	scoreVisitor.changerRegleComptage("tout");
    	for(int i=0;i<=1;i++) {
    		Carte joker = new Carte(Couleur.PIQUE,Valeur.ZERO,false,Trophee.BestJest);
    		int choix=0;
    		int max=0;
    		int min=4;
    		switch (tropheeTiree.getTropheeTiree(i).getTrophee()) {
    		case HighestPIQUE:
    		    max=1;
    			for(int j=0;j<this.nbretotaljoueur;j++) {
    				if(joueurs.get(j).getJest().highestCarteJest(Couleur.PIQUE).getValeurInt()>=max) {
    						max=joueurs.get(j).getJest().highestCarteJest(Couleur.PIQUE).getValeurInt();
    						choix=j;
    					}
    				}
    			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
    			System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
    			break;
    		case HighestTREFLE:
    			 max=1;
     			for(int j=0;j<this.nbretotaljoueur;j++) {
     				if(joueurs.get(j).getJest().highestCarteJest(Couleur.TREFLE).getValeurInt()>=max) {
     						max=joueurs.get(j).getJest().highestCarteJest(Couleur.TREFLE).getValeurInt();
     						choix=j;
     					}
     				}
     			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
     			System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			break;
    		case HighestCARREAU:
    			 max=1;
     			for(int j=0;j<this.nbretotaljoueur;j++) {
     				if(joueurs.get(j).getJest().highestCarteJest(Couleur.CARREAU).getValeurInt()>=max) {
     						max=joueurs.get(j).getJest().highestCarteJest(Couleur.CARREAU).getValeurInt();
     						choix=j;
     					}
     				}
     			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
     			System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			break;
    		case HighestCOEUR:
    			 max=1;
     			for(int j=0;j<this.nbretotaljoueur;j++) {
     				if(joueurs.get(j).getJest().highestCarteJest(Couleur.COEUR).getValeurInt()>=max) {
     						max=joueurs.get(j).getJest().highestCarteJest(Couleur.COEUR).getValeurInt();
     						choix=j;
     					}
     				}
     			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
     			System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			break;
    		case LowestPIQUE:
     			for(int j=0;j<this.nbretotaljoueur;j++) {
     				if(joueurs.get(j).getJest().lowestCarteJest(Couleur.PIQUE).getValeurInt()<=min) {
     						min=joueurs.get(j).getJest().lowestCarteJest(Couleur.PIQUE).getValeurInt();
     						choix=j;
     					}
     				}
     			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
     			System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			break;
    		case LowestTREFLE:
    			for(int j=0;j<this.nbretotaljoueur;j++) {
     				if(joueurs.get(j).getJest().lowestCarteJest(Couleur.TREFLE).getValeurInt()<=min) {
     						min=joueurs.get(j).getJest().lowestCarteJest(Couleur.TREFLE).getValeurInt();
     						choix=j;
     					}
     				}
     			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
     			System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			break;
    		case LowestCARREAU:
    			for(int j=0;j<this.nbretotaljoueur;j++) {
     				if(joueurs.get(j).getJest().lowestCarteJest(Couleur.CARREAU).getValeurInt()<=min) {
     						min=joueurs.get(j).getJest().lowestCarteJest(Couleur.CARREAU).getValeurInt();
     						choix=j;
     					}
     				}
     			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
     			System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			break;
    		case LowestCOEUR:
    			for(int j=0;j<this.nbretotaljoueur;j++) {
     				if(joueurs.get(j).getJest().lowestCarteJest(Couleur.COEUR).getValeurInt()<=min) {
     						min=joueurs.get(j).getJest().lowestCarteJest(Couleur.COEUR).getValeurInt();
     						choix=j;
     					}
     				}
     			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
     			System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			break;
    		case MajorityTWO:
     			for(int j=0;j<this.nbretotaljoueur;j++) {
     				if(joueurs.get(j).getJest().majorityJestValeur(Valeur.DEUX)>max) {
     					max=joueurs.get(j).getJest().majorityJestValeur(Valeur.DEUX);
     					choix=j;
     				}else if(joueurs.get(j).getJest().majorityJestValeur(Valeur.DEUX)==max) {
     					if(joueurs.get(j).getJest().majorityJestValeur(Valeur.DEUX)!=0) {
     						if(joueurs.get(j).getJest().majorityJestCouleur(Valeur.DEUX)>joueurs.get(choix).getJest().majorityJestCouleur(Valeur.DEUX)) {	
     							choix=j;
     						}
     					}
     				}
     			}
     			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
     			System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			break;
    		case MajorityTHREE:
    			for(int j=0;j<this.nbretotaljoueur;j++) {
     				if(joueurs.get(j).getJest().majorityJestValeur(Valeur.TROIS)>max) {
     					max=joueurs.get(j).getJest().majorityJestValeur(Valeur.TROIS);
     					choix=j;
     				}else if(joueurs.get(j).getJest().majorityJestValeur(Valeur.TROIS)==max) {
     					if(joueurs.get(j).getJest().majorityJestValeur(Valeur.TROIS)!=0) {
     						if(joueurs.get(j).getJest().majorityJestCouleur(Valeur.TROIS)>joueurs.get(choix).getJest().majorityJestCouleur(Valeur.TROIS)) {	
     							choix=j;
     						}
     					}
     				}
     			}
     			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
     			System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			break;
    		case MajorityFOUR:
    			for(int j=0;j<this.nbretotaljoueur;j++) {
     				if(joueurs.get(j).getJest().majorityJestValeur(Valeur.QUATRE)>max) {
     					max=joueurs.get(j).getJest().majorityJestValeur(Valeur.QUATRE);
     					choix=j;
     				}else if(joueurs.get(j).getJest().majorityJestValeur(Valeur.QUATRE)==max) {
     					if(joueurs.get(j).getJest().majorityJestValeur(Valeur.QUATRE)!=0) {
     						if(joueurs.get(j).getJest().majorityJestCouleur(Valeur.QUATRE)>joueurs.get(choix).getJest().majorityJestCouleur(Valeur.QUATRE)) {	
     							choix=j;
     						}
     					}
     				}
     			}
     			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
     			System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			break;
    		case Joker:
    			boolean jokerExist=false;
     			for(int j=0;j<this.nbretotaljoueur;j++) {
     					if(joueurs.get(j).getJest().contiensCarte(joker) ) {
     						choix=j;
     						jokerExist=true;
     					}
    		       }
     			if(jokerExist=true) {
     			    joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
					System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			}else {System.out.println("Aucun joueur n'a le Joker dans son Jest");}
	     			break;
    		case BestJest:
      			for (int j=0;j<this.nbretotaljoueur;j++) {
 					if(joueurs.get(j).getJest().accept(scoreVisitor)>max ) {
 						max=joueurs.get(j).getJest().accept(scoreVisitor);
 						choix=j;
 					}else if(joueurs.get(j).getJest().accept(scoreVisitor)== max ) {
 						if(joueurs.get(j).getJest().plusGrandeCarteJest().getValeurInt()>joueurs.get(choix).getJest().plusGrandeCarteJest().getValeurInt()) {
 							choix=j;
 						}else if(joueurs.get(j).getJest().plusGrandeCarteJest().getValeurInt()==joueurs.get(choix).getJest().plusGrandeCarteJest().getValeurInt()) {
 							if(joueurs.get(j).getJest().plusGrandeCarteJest().getCouleurInt()>joueurs.get(choix).getJest().plusGrandeCarteJest().getCouleurInt()) {
 								choix=j;
 							}
 						}
 					}		
		       }
      			joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
				System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
    			break;
    		case BestJestNoJoke:
    			 for (int j=0;j<this.nbretotaljoueur;j++) {
    			 if(!(joueurs.get(j).getJest().contiensCarte(joker))){
  					if(joueurs.get(j).getJest().accept(scoreVisitor)>max ) {
  						max=joueurs.get(j).getJest().accept(scoreVisitor);
  						choix=j;
  					}else if(joueurs.get(j).getJest().accept(scoreVisitor)== max ) {
  						if(joueurs.get(j).getJest().plusGrandeCarteJest().getValeurInt()>joueurs.get(choix).getJest().plusGrandeCarteJest().getValeurInt()) {
  							choix=j;
  						}else if(joueurs.get(j).getJest().plusGrandeCarteJest().getValeurInt()==joueurs.get(choix).getJest().plusGrandeCarteJest().getValeurInt()) {
  							if(joueurs.get(j).getJest().plusGrandeCarteJest().getCouleurInt()>joueurs.get(choix).getJest().plusGrandeCarteJest().getCouleurInt()) {
  								choix=j;
  							}
  						}
  					}	
    				}
 		       }
    			 joueurs.get(choix).envoyerCarteToJest(tropheeTiree.getTropheeTiree(i));
				System.out.println(joueurs.get(choix).getNom()+" recoit en trophee la carte "+tropheeTiree.getTropheeTiree(i).toString());
     			break;
    }
}
}
	public int getNombreTour() {
	    return	 ((dek.NOMBRE_DE_CARTES-2)-((dek.NOMBRE_DE_CARTES-2))%this.nbretotaljoueur)/this.nbretotaljoueur -1;
	} 

    public void compterScore() {
    	
    	Visitor scoreVisitor = null;

         if(this.variante) {
        	 scoreVisitor= new ScoreVisitorVariante();
         }else {
        	 scoreVisitor= new ScoreVisitor();
         }
    	 	
    	int s=0;
	    int[] scores = new int[this.nbretotaljoueur];
        for( int i=0 ; i<scores.length ; i++ ) {
           scores[i] = 0;
        }
         
         String[] regles = scoreVisitor.getReglesComptageDisponibles();
         for( String regle : regles ) {
           scoreVisitor.changerRegleComptage(regle);
           for( int i=0 ; i<this.nbretotaljoueur ; i++ ) {
              s =joueurs.get(i).getJest().accept(scoreVisitor);
            scores[i] += s;
            }
           for( int i=0 ; i<this.nbretotaljoueur ; i++ ) {
             joueurs.get(i).setScore(scores[i]);
         }
         }
}
     
    public void afficherScore() {
    	for( int i=0 ; i<this.nbretotaljoueur ; i++ ) {
    		System.out.println("Score "+joueurs.get(i).getNom()+" : "+joueurs.get(i).getScore());
    	}
    }
    public void afficherVainqueur() {
    	int max=0;
    	int vainqueur=0;
    	for( int i=0 ; i<this.nbretotaljoueur ; i++ ) {
    		if(joueurs.get(i).getScore()>max) {
    			vainqueur=i;
    			max=joueurs.get(i).getScore();
    		}else if (joueurs.get(i).getScore()==max)
    			    if(joueurs.get(i).getScore()!=0) {
    			      if(joueurs.get(i).getJest().plusGrandeCarteJest().estPlusGrand(joueurs.get(vainqueur).getJest().plusGrandeCarteJest())){
    			    	  vainqueur=i;
    			      }
    			    }
    	}
    	System.out.println("Le vainqueur de la partie est "+joueurs.get(vainqueur).getNom());
    }

    public void afficherJest() {
    	for( int i=0 ; i<this.nbretotaljoueur ; i++ ) {
    		System.out.println("Jest de "+joueurs.get(i).getNom()+"  "+joueurs.get(i).getJest().toString());
    	}
    }
}    

