package fr.utt.lo02.jest_jason_rodolphe.modeles;

public class StrategyFacile extends Strategy {
	
	private Partie partie;
	protected JoueurVirtuel joueur;
	private boolean ajouer;
	private int numero;
	
	public StrategyFacile(JoueurVirtuel joueur,Partie partie) {
		super(joueur);
		this.joueur=joueur;
		this.partie=partie;
		this.ajouer=false;
		this.numero=0;
	}
	
	 public void choisirFaceCarte() {
	       
	        int choix=(int)( Math.random() < .5? 0:1);
	    	if(choix == 0) {
	    		this.joueur.getMain(0).retournerCarte();
	    	}
	    	
	    	else if (choix == 1) {
	    		this.joueur.getMain(1).retournerCarte();
	    	}
	    	
	   
	    }

	public int choisirJoueur() {
		this.numero = (int)(Math.random()*this.partie.getNombreJoueurs()-1);
		while( (this.partie.getJoueur(this.numero).verifierOffre()==false) || (this.partie.getJoueur(this.numero).equals(joueur))) {
			 this.numero = (int)(Math.random()*this.partie.getNombreJoueurs());
		 }
             	
		 this.ajouer=true;
		 System.out.println("Le "+joueur.getNom()+" a pris la carte de  "+partie.getJoueur(this.numero).getNom());
		 return this.numero;
	}
	public int choisirJoueur(int nbreJoueurrestant) {
		this.numero = (int)(Math.random()*this.partie.getNombreJoueurs());
		if(nbreJoueurrestant!=1) {
		while( (this.partie.getJoueur(this.numero).verifierOffre()==false) || (this.partie.getJoueur(this.numero) == this.joueur)) {
			 this.numero = (int)(Math.random()*this.partie.getNombreJoueurs());
		 }
		}else if(nbreJoueurrestant==1){
			if(this.joueur.verifierOffre()==false) {
				while( (this.partie.getJoueur(this.numero).verifierOffre()==false) || (this.partie.getJoueur(this.numero) == this.joueur)) {
					 this.numero = (int)(Math.random()*this.partie.getNombreJoueurs());
				}
			}else {
			 while(this.partie.getJoueur(this.numero) != this.joueur) {
	                this.numero = (int)(Math.random()*this.partie.getNombreJoueurs());
	              }
			}
		}
		 this.ajouer=true;
		 System.out.println("Le "+joueur.getNom()+" a pris la carte de  "+partie.getJoueur(this.numero).getNom());
		 return this.numero;
	}
	@Override
    public boolean aJouer() {
		   return ajouer;
	   }
	public void choisirCarteDeLoffreATirer(int tour) {
		int choix =(int)( Math.random() < .5? 0:1);
		 if((partie.getNombreTour()-tour)!=0) {
			if(choix==0) {
				joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(0));
				this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
				this.partie.getJoueur(this.numero).getMain(0).setFaceDown();;
				this.partie.ajouterCarteStack(this.partie.getJoueur(this.numero).getMain(0));
				this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
			}
			if(choix==1) {
				joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(1));
				this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(1));
				this.partie.getJoueur(this.numero).getMain(0).setFaceDown();
				this.partie.ajouterCarteStack(this.partie.getJoueur(this.numero).getMain(0));
				this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
			}
		 }else {
			 if(choix==0) {
					joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(0));
					this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(0));
					this.partie.getJoueur(this.numero).envoyerCarteFinal();
			 }
			 if(choix==1) {
					joueur.envoyerCarteToJest(this.partie.getJoueur(this.numero).getMain(1));
					this.partie.getJoueur(this.numero).retirerCarte(this.partie.getJoueur(this.numero).getMain(1));
					this.partie.getJoueur(this.numero).envoyerCarteFinal();
					
			 }
		 }
	}
	
	public static void main(String[] args) {
		

	}

	@Override
	public void setAJouer() {
		this.ajouer=false;
		
	}

}
