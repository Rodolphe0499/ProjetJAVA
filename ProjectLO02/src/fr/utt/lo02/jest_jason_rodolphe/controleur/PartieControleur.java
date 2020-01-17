package fr.utt.lo02.jest_jason_rodolphe.controleur;

import java.awt.event.*;

import javax.swing.JOptionPane;

import fr.utt.lo02.jest_jason_rodolphe.modeles.*;
import fr.utt.lo02.jest_jason_rodolphe.vues.*;

public class PartieControleur implements ActionListener {
	 private Partie partie;
	 private EcranAccueil accueil;
	 private Configuration parametres;
	 private VueInterface plateau;

	 public PartieControleur() {
		 partie = null;
		 accueil = null;
		 parametres = null;
		 plateau = null;
	 }

	 /* Permettra de connaitre le modŽle */
	 public void setModele(Partie partie) {
		 this.partie = partie;
	 }

	 /* Permettra de connaitre la vue */
	 public void setVue(EcranAccueil a, Configuration p, VueInterface pl) {
		 this.accueil = a;
		 this.parametres = p;
		 this.plateau = pl;
	 }
	 
	 /* C'est ici que l'on traite l'action rŽcupŽrŽ : implŽmentation due ˆ l'interface ActionListener */
	 public void actionPerformed(ActionEvent e) {
		 if (e.getActionCommand() == "nouvellepartie"){
			 parametres.setVisible(true);
			 accueil.setVisible(false);
		 }
	
		 if (e.getActionCommand() == "quitterpartie"){
			 System.exit(0);
		 }
		 if (e.getActionCommand() == "jouer"){
			 if (parametres.getDifficulte() == 0){
				 JOptionPane.showMessageDialog(null, "Vous n'avez pas choisi la difficultŽ !", "Erreur", JOptionPane.ERROR_MESSAGE);
			 }
			 else if ((parametres.getNbrVirtuels() + parametres.getNbrReels()) > 10 || (parametres.getNbrVirtuels() + parametres.getNbrReels()) < 2){
				 JOptionPane.showMessageDialog(null, "Le nombre de joueurs choisi n'est pas correct !", "Erreur", JOptionPane.ERROR_MESSAGE);
			 }
			 else{
				 parametres.setVisible(false);
				 plateau.getFrame().setVisible(true);
				 partie.demanderDifficulté(parametres.getDifficulte());
				 partie.demanderNombreJoueurPhysique(parametres.getNbrReels());
				 partie.demanderNombreJoueur(parametres.getNbrReels(), parametres.getNbrVirtuels());
				 Thread tour = new Thread(partie);
				 tour.start();
			 }
		 }
		 if (e.getActionCommand() == "affichercartes"){
			 plateau.afficherJeu(plateau.getPjJoue());
		 }
		 
	 }


	
}
