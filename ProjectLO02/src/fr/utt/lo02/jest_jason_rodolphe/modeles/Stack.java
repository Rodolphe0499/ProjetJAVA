package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.Collections;
import java.util.LinkedList;

public class Stack {
	
	 private LinkedList<Carte> stack;
   
	 public Stack () {
	    	
	    	stack = new LinkedList<Carte>();
	    	
	    }
	    
	 /**
	  * permet de tirer la carte du dessus du stack
	  * @return
	  */
	 public Carte tirerCarteDuDessus() {
	    	return stack.pop();
	    }
	 
	 /**
	  * permet de tirer une carte de manière aleatoire dans le stack
	  * @return
	  */
	 public Carte tirerCarte() {
	    	int position = (int) Math.round((DekCarte.NOMBRE_DE_CARTES -1)*Math.random());
	    	return stack.remove(position);
	    }
	   
	 /**
	  * permet de savoir si le stack est vide
	  * @return
	  */
	 public boolean estVide() {
	    	return stack.isEmpty();
	    }
	    
	 /**
	  * permet d'afficher le stack
	  */
     public String toString() {
	    	return stack.toString();
	    }
	 
     /**
      * permet d'ajouter une carte au stack
      * @param carte
      */
     public void ajouterStack(Carte carte) {
	    	stack.add(carte);
	    }

     /**
      * permet de melanger le stack
      */
	 public void melangerStack() {
	    	Collections.shuffle(stack);
	    }

}
