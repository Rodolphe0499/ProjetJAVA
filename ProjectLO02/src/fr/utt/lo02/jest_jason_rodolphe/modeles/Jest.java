package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.LinkedList;

public class Jest {
 
	private Joueurs joueur;
	private LinkedList<Carte> jest;
	
	public Jest (Joueurs joueur) {
		this.joueur=joueur;
		jest= new  LinkedList<Carte>();
	}
	
	public int sizeJest() {
		return jest.size();
	}
	
	public Carte getJest(int i) {
		return jest.get(i);
	}
	public void  envoyerCarte(Carte carte) {
		jest.add(carte);
	}
	public LinkedList<Carte> getCartes(){
		return jest;
	}
	public boolean contiensCouleur(Couleur carte) {
	        for(int i=0 ; i<this.jest.size() ; i++) {
	            if( jest.get(i).getCouleur() == carte ) {
	                    return true;
	                }
	            }
	        
	        return false;
	    }
    public boolean contiensCarte(Carte carte) {
    for(int i=0 ; i<this.jest.size() ; i++) {
        if( jest.get(i).getCouleur() == carte.getCouleur() ) {
        	if(jest.get(i).getValeur()==carte.getValeur()) {
                return true;
            }
        }
    }
    return false;
}
	
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
    public Carte plusGrandeCarteJest() {
    	int maxVal=0;
    	int j=0;
    	for (int i=0;i<jest.size();i++) {
    		 if(jest.get(i).getValeurInt()>maxVal){
   			  maxVal=jest.get(i).getValeurInt();
   			  j=i;
   		     }else
   		      if(jest.get(i).getValeurInt()==maxVal){
   				if(jest.get(i).getCouleurInt()>jest.get(j).getCouleurInt() ){
   					if(jest.get(i).getValeurInt()!=0) {
   		    	     j=i;
   					}
   				}
    		  }
        }
    	return jest.get(j);
    	}
    
     public Carte highestCarteJest(Couleur couleur) {
    	 int maxCol=0;
    	 int j=0;
    	 for (int i=0;i<jest.size();i++) {
	            if( jest.get(i).getCouleur()== couleur ) {
	            	if(jest.get(i).getValeurInt()>maxCol) {
	            		maxCol=jest.get(i).getValeurInt();
	            		j=i;
	            	}
	            }
    	 }       
     return jest.get(j);
     }
     public Carte lowestCarteJest(Couleur couleur) {
    	 int maxCol=4;
    	 int j=0;
    	 for (int i=0;i<jest.size();i++) {
	            if( jest.get(i).getCouleur()== couleur ) {
	            	if(jest.get(i).getValeurInt()<=maxCol) {
	            		maxCol=jest.get(i).getValeurInt();
	            		j=i;
	            	}
	            }
    	 }       
     return jest.get(j);
     }
     public int majorityJestValeur(Valeur valeur) {
    	 int j=0;
    	 for (int i=0;i<jest.size();i++) {
	            if( jest.get(i).getValeur()== valeur ) {
	            		j+=1;
	            	}
 	 }   
    	 return j;
     }
     public int majorityJestCouleur(Valeur valeur) {
    	 int j=0;
    	 int maxCol=0;
    	 for (int i=0;i<jest.size();i++) {
	            if( jest.get(i).getValeur()== valeur ) {
	            	if( jest.get(i).getCouleurInt() >maxCol) {
	            		j=i;	
	            		maxCol=	jest.get(i).getCouleurInt();
	            	}
	            	}
 	 }  
    	 return jest.get(j).getCouleurInt();
     }

     public String toString() {
    	 return jest.toString();
     }
}

