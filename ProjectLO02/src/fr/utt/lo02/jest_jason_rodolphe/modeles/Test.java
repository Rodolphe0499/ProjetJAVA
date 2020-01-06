package fr.utt.lo02.jest_jason_rodolphe.modeles;


public class Test {

	public static void main(String[] args) {
		
		Partie p = new Partie();
		p.demanderNombreJoueur();
		p.demanderNombreJoueurPhysique() ;
		p.demanderDifficulté() ;
 		p.demanderExtension() ;
 		p.demanderVariante();
		p.creerJoueur() ;
		p.afficherParticipant();
		p.tirerTrophee();
		p.distribuerDek();
		for(int i=1;i<=p.getNombreTour();i++ ) {
		System.out.println(" tour n°"+ i);
		p.MakeOffer();
		p.afficherOffres();
		p.afficherPremierJoueur();
		p.prendreDesOffres(i);
		p.ajouterDekToStack();
		p.distribuerStack();
		}
		p.attribuerTrophee();
		p.compterScore();
		p.afficherJest();
		p.afficherScore();
		p.afficherVainqueur();
	    }

}
