package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.Collections;
import java.util.LinkedList;

public class Stack {
	
	 private LinkedList<Carte> stack;
   
	 public Stack () {
	    	
	    	stack = new LinkedList<Carte>();
	    	
	    }
	 
	 public static void shuffle(LinkedList<Carte>dek) {
	    	
	    }
	    
	 public Carte tirerCarteDuDessus() {
	    	return stack.pop();
	    }
	 
	    public Carte tirerCarte() {
	    	int position = (int) Math.round((DekCarte.NOMBRE_DE_CARTES -1)*Math.random());
	    	return stack.remove(position);
	    }
	    
	    public boolean estVide() {
	    	return stack.isEmpty();
	    }
	    
	    public String toString() {
	    	return stack.toString();
	    }
	    public void ajouterStack(Carte carte) {
	    	stack.add(carte);
	    }

	    public void melangerStack() {
	    	Collections.shuffle(stack);
	    }
	public static void main(String[] args) {
		

	}

}
