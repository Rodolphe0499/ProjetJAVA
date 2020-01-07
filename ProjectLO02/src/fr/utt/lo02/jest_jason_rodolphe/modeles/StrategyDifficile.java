package fr.utt.lo02.jest_jason_rodolphe.modeles;

public class StrategyDifficile extends Strategy {
	
	private Partie partie;
	private JoueurVirtuel joueur;
	private int  numero;
	private boolean ajouer;
	public StrategyDifficile(JoueurVirtuel joueur, Partie partie) {
        super(joueur);
        this.joueur=joueur;
        this.partie=partie;
        this.ajouer=false;
    }
	
	
	public void choisirFaceCarte() {
	int choix=0;
    if(  this.joueur.getMain(0).getValeurInt() == 1 || this.joueur.getMain(0).getValeurInt() == 2) {
        choix=0 ;
    }
    if(this.joueur.getMain(1).getValeurInt() == 1 || this.joueur.getMain(1).getValeurInt() == 2) {
        choix=1 ;
    }
	if(choix == 0) {
		joueur.getMain(0).setFaceUp();
	}
	
	else if (choix == 1) {
		joueur.getMain(1).setFaceUp();
	}
	
   }
	
    public int choisirJoueur() {
    	int max=0;
	   for(int i=0;i<partie.getNombreJoueurs();i++) {
		   if(!partie.getJoueur(i).equals(this.joueur)) {
		   if(partie.getJoueur(i).verifierOffre()==true) {
		    if(partie.getJoueur(i).getOffre().getValeurInt()>max && partie.getJoueur(i).getOffre().getCouleurInt()!=1 ) {
			 max=partie.getJoueur(i).getOffre().getValeurInt();
			 this.numero=i;
		    }
	      }	  
	     }
	   }
	   this.ajouer=true;
	   System.out.println("Le "+joueur.getNom()+" a pris la carte de  "+partie.getJoueur(this.numero).getNom());
	   return this.numero;
   }
    public int choisirJoueur(int nbreJoueurrestant) {
    	int max=0;
    	if(nbreJoueurrestant==1) {
    		if(this.joueur.verifierOffre()) {
    		 for(int i=0;i<partie.getNombreJoueurs();i++) {
    			 if(partie.getJoueur(i).equals(this.joueur) ) { 
    		   		  this.numero=i;
    		 }
    		 }
    	}else	if(!this.joueur.verifierOffre()) {
    		for(int i=0;i<partie.getNombreJoueurs();i++) {
    			 if(partie.getJoueur(i).verifierOffre()) {
    	   		   		  this.numero=i;
    		}
   		 }
    	}
    	}else {
    		 for(int i=0;i<partie.getNombreJoueurs();i++) {
    			   if(!partie.getJoueur(i).equals(this.joueur)) {
    			   if(partie.getJoueur(i).verifierOffre()==true) {
    			    if(partie.getJoueur(i).getOffre().getValeurInt()>max && partie.getJoueur(i).getOffre().getCouleurInt()!=1 ) {
    				 max=partie.getJoueur(i).getOffre().getValeurInt();
    				 this.numero=i;
    			    }
    		      }	  
    		     }
    		   }
    	}
	   this.ajouer=true;
	   System.out.println("Le "+joueur.getNom()+" a pris la carte de  "+partie.getJoueur(this.numero).getNom());
	   return this.numero;
   }
   @Override
	public void choisirCarteDeLoffreATirer(int tour) {
	   if((partie.getNombreTour()-tour)!=0) {
		if(partie.getJoueur(this.numero).getOffre().getCouleurInt()==3 || partie.getJoueur(this.numero).getOffre().getCouleurInt()==4) {
			joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getOffre());
			this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getOffre());
			this.partie.getJoueur(this.numero).getCarteDown().setFaceDown();
			this.partie.ajouterCarteStack(this.partie.getJoueur(this.numero).getCarteDown());
			this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getCarteDown());
		}
		else {
			joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getCarteDown());
			this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getCarteDown());
			this.partie.getJoueur(this.numero).getOffre().setFaceDown();
			this.partie.ajouterCarteStack(this.partie.getJoueur(this.numero).getOffre());
			this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getOffre());
		}
	   }else {
		   if(partie.getJoueur(this.numero).getOffre().getCouleurInt()==3 || partie.getJoueur(this.numero).getOffre().getCouleurInt()==4) {
				joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getOffre());
				this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getOffre());
				this.partie.getJoueur(this.numero).envoyerCarteFinal();
			}
			else {
				joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getCarteDown());
				this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getCarteDown());
				this.partie.getJoueur(this.numero).envoyerCarteFinal();
	   }
	   }
	}
   @Override
   public boolean aJouer() {
	   return ajouer;
   }

	@Override
	public void setAJouer() {
		this.ajouer=false;
		
	}


}
