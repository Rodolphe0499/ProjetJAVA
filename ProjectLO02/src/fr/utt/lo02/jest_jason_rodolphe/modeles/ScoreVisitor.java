package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.ArrayList;

public class ScoreVisitor extends Visitor {
	
	public ScoreVisitor() {
		super();
	}
	
	

	@Override
	protected int compterPiques(Jest j) {
		 int score=0;

	        for( Carte c : j.getCartes() ) {
	            if( c.getCouleur() == Couleur.PIQUE )
	            	if(c.getValeurInt()!=0)
	                score += c.getValeurInt();
	        }

	        // La seule carte trouvée est le 1, donc il se transforme en 5!
	        if( score == 1 ) score = 5;
		return score;
	}

	@Override
	protected int compterTrefles(Jest j) {
		 int score=0;

	        for( Carte c : j.getCartes() ) {
	            if( c.getCouleur() == Couleur.TREFLE )
	                score += c.getValeurInt();
	        }

	        // La seule carte trouvée est le 1, donc il se transforme en 5!
	        if( score == 1 ) score = 5;
		return score;
	}

	@Override
	protected int compterCarreaux(Jest j) {
		 int score=0;

	        for( Carte c : j.getCartes() ) {
	            if( c.getCouleur() == Couleur.CARREAU)
	                score -= c.getValeurInt();
	        }

	        // La seule carte trouvée est le 1, donc il se transforme en 5!
	        if( score == -1 ) score = -5;
		return score;
	}

	@Override
	protected int compterCoeurs(Jest j) {
		 boolean jokerTrouve = false;
	        for( Carte c : j.getCartes() )
	            if( c.getValeur() == Valeur.ZERO )
	                jokerTrouve = true;

	        if( !jokerTrouve )
	            return 0;


	        int score=0;

	        for( Carte c : j.getCartes() ) {
	            if( c.getCouleur() == Couleur.COEUR )
	                score -= c.getValeurInt();
	        }

	        // Toutes les cartes ont étés trouvées, on passe en positif!
	        if( score == (-1-2-3-4) ) score = -1;

	        // La seule carte trouvée est le 1, donc il se transforme en 5!
	        if( score == -1 ) score = -5;
	        
	        return score;
	}

	@Override
	protected int compterPaires(Jest j) {
		  int score=0;

	        ArrayList<Integer> cartesTrouvees = new ArrayList<Integer>();

	        for( Carte c : j.getCartes() ) {
	            if( c.getCouleur() == Couleur.TREFLE || c.getCouleur() == Couleur.PIQUE) {
	                if( cartesTrouvees.contains(c.getValeurInt() ))
	                    score += 2;
	                else
	                    cartesTrouvees.add(c.getValeurInt());
	            }
	        }
	        return score;
	}

	@Override
	protected int compterJoker(Jest j) {
		int score=0;
		Carte joker = new Carte(Couleur.PIQUE,Valeur.ZERO,false,Trophee.BestJest);
        if( !j.contiensCouleur(Couleur.COEUR) && j.contiensCarte(joker) )
            score = 4;

       
        return score;
	}



	@Override
	protected int compterValet(Jest j) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
