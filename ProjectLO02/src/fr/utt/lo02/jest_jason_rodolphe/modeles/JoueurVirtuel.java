package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.Iterator;
import java.util.LinkedList;

public class JoueurVirtuel extends Joueurs{
	
	private String pseudo;
	private LinkedList<Carte> main;
	private Partie partie;
	private Jest jest;
	private Strategy strategie;
	private int score;
	
	
	public JoueurVirtuel(String pseudo,Partie partie, int niveau) {
		
        super(false,partie);
		jest= new Jest(this);
		main = new LinkedList<Carte>();
		this.partie=partie;
		this.pseudo=pseudo;
		this.score=0;
		
		if (niveau==1) {
			strategie=new StrategyFacile(this,partie);
		}
		if(niveau==2) {
			strategie=new StrategyDifficile(this,partie);
		}
	}
	
		
	public String getNom() {
		return pseudo;
	}
	
	public void setNom(String nom) {
		this.pseudo = nom;
	}

	public void retirerCarte(Carte carte){
		main.remove(carte);
	}
	public void recevoirCarte(Carte cartes) {
		main.add(cartes);
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
		}
		if(main.get(1).getFaceCarte()==false) {
			numero=1;
		}
		return main.get(numero);
		}else
			return main.get(0);
    }
	
	public int accept(Visitor visitor) {
		return 0;
	}
	public static void main(String[] args) {
		

	}


	public void choisirFaceCarte() {
		strategie.choisirFaceCarte();
	}

	public int ChoisirJoueur() {
		
		return strategie.choisirJoueur();
	}
	@Override
    public int ChoisirJoueur(int a) {
		
		return strategie.choisirJoueur(a);
	}

	public void choisirCarteDeLoffreATirer(int tour) {
		strategie.choisirCarteDeLoffreATirer(tour);
		
	}


	
	public void envoyerCarteToJest(Carte cartes) {
		jest. envoyerCarte(cartes);
	}
	
    public Carte getMain(int i){
		Carte j= main.get(i);
		return j;
	}

	
	public void prendreCarte(Carte carte) {
		main.add(carte);
	}
	public String afficherMain() {
		return main.toString();
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


	public String afficherCarteFaceUp() {
		Carte carte = new Carte(null,null,false,null);
		if (main.get(0).getFaceCarte()==true) {
			carte= main.get(0);
		}
		if(main.get(1).getFaceCarte()==true) {
			carte= main.get(1);
		}
		return carte.toString();
	}
	

	public Carte getJest(int i) {
		return jest.getJest(i);
	}
	public int getSizeJest() {
		return jest.sizeJest();
	}


	@Override
	public boolean aJouer() {
		 return strategie.aJouer();
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
	public int getScore() {
		return this.score;
	}


	@Override
	public void setScore(int valeur) {
		this.score=valeur;
		
	}


    @Override
    public void envoyerCarteFinal() {
    	jest. envoyerCarte(main.get(0));
    }
    @Override
    public boolean isVirtuel() {
    	return true;
    }


	@Override
	public LinkedList<Carte> getMain() {
		return main;
	}
}
