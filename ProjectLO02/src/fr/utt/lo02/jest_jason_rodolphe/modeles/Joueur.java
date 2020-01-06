package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.*;
public class Joueur extends Joueurs {


	private String pseudo;
	private LinkedList<Carte> main;
	private Partie partie;
	private Jest jest;
	private StrategyJoueurReel strategie;
    private int score;
	
	public Joueur(String name, Partie partie) {
		super(true,partie);
		this.pseudo=name;
		strategie= new StrategyJoueurReel(this,partie);
		main = new LinkedList<Carte>();
		jest= new Jest(this);
		this.score=0;
	}
	
	public String getNom() {
		return this.pseudo;
	}
	
	public void setNom(String nom) {
		this.pseudo = nom;
	}
	public void retirerCarte(int i) {
		System.out.println("ca pue");
		main.remove(i);
	}


	@Override
	public void retirerCarte(Carte carte) {
		main.remove(carte);
	}
	@Override
	public void recevoirCarte(Carte cartes) {
		main.add(cartes);
	}

    public void choisirFaceCarte( ) {
    	StrategyJoueurReel	strategie = new StrategyJoueurReel(this,partie);
    	strategie.demanderSiAffichageCarte();
    }

	public int ChoisirJoueur() {
		
		return strategie.choisirJoueur();
	}
    public int ChoisirJoueur(int a) {
		
		return strategie.choisirJoueur(a);
	}

	public void choisirCarteDeLoffreATirer(int tour) {
		
		strategie.choisirCarteDeLoffreATirer(tour);
	}

   @Override
    public boolean aJouer() {
	 return strategie.aJouer();
   }
   
   @Override
	public boolean verifierOffre() {
		if (this.main.size()==2) {
			return true;
		}
		else {
			return false;
		}
	}
   @Override
    public String afficherMain() {
	  return main.toString();
   }
   @Override
    public Carte getMain(int i) {
	   Carte j= main.get(i);
		return j;
   }

	public  String afficherCarteFaceUp() {
		Carte carte = new Carte(null,null,false,null);
		if (main.get(0).getFaceCarte()==true) {
			carte= main.get(0);
		}
		if(main.get(1).getFaceCarte()==true) {
			carte= main.get(1);
		}
		return carte.toString();
	}
	public Carte getOffre() {
		int numero=0;
		if(main.size()==2) {
		if(main.get(0).getFaceCarte()==true) {
		}else
		if(main.get(1).getFaceCarte()==true) {
			numero=1;
		}
		return main.get(numero);
		}else
			return main.get(0);
	}

	@Override
	public Carte getCarteDown() {
    	int numero=0;
		if(main.size()==2) {
		if(main.get(0).getFaceCarte()==false) {
		}else
		if(main.get(1).getFaceCarte()==false) {
			numero=1;
		}
		return main.get(numero);
		}else
			return main.get(0);
    }

	@Override
	public void setAJouer() {
		strategie.setAJouer();
		
	}

	@Override
	public Jest getJest() {
		return jest;
	}

	@Override
	public int getSizeJest() {
		return jest.sizeJest();
	}

	@Override
	public Carte getJest(int k) {
		
		return jest.getJest(k);
	}

	@Override
	public int getScore() {
		return this.score;
	}
	@Override
	public void setScore(int valeur) {
		this.score=valeur;
	}
	public void envoyerCarteToJest(Carte cartes) {
		jest. envoyerCarte(cartes);
	}
    @Override
    public void envoyerCarteFinal() {
    	jest. envoyerCarte(main.get(0));
    }
}

