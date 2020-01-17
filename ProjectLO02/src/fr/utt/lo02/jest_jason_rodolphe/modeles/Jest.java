package fr.utt.lo02.jest_jason_rodolphe.modeles;

import java.util.LinkedList;

public class Jest {
 
	private Joueurs joueur;
	private LinkedList<Carte> jest;
	
	public Jest (Joueurs joueur) {
		this.joueur=joueur;
		jest= new  LinkedList<Carte>();
	}
	
	/**
	 * permet de renvoyer le nombre de carte dans le jest
	 * @return
	 */
	public int sizeJest() {
		return jest.size();
	}
	
	/**
	 * permet de recuperer une carte du jest 
	 * @param i
	 * @return
	 */
	public Carte getJest(int i) {
		return jest.get(i);
	}
	
	/**
	 * permet d'ajouter une carte dans le jest 
	 * @param carte
	 */
	public void  envoyerCarte(Carte carte) {
		jest.add(carte);
	}
	
	/**
	 * permet de recuperer le jest
	 * @return
	 */
	public LinkedList<Carte> getCartes(){
		return jest;
	}
	
	/**
	 * permet de savoir si le jest contient une couleur bien précise
	 * @param carte
	 * @return
	 */
	public boolean contiensCouleur(Couleur carte) {
	        for(int i=0 ; i<this.jest.size() ; i++) {
	            if( jest.get(i).getCouleur() == carte ) {
	                    return true;
	                }
	            }
	        
	        return false;
	    }
   
	/**
	 * permet de savoir si le jest contient une carte bien précise
	 * @param carte
	 * @return
	 */
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
	
	/**
	 * permet d'implementer le patron visiteur
	 * @param visitor
	 * @return
	 */
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
    
    /**
     * permet de savoir quel est la plus grande carte du jest
     * @return
     */
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
    /**
     * permet de savoir quel est la plus grande carte d'une couleur couleur rentré en paramètre que le joueur ait
     * @param couleur
     * @return
     */
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
     
     /**
      * permet de savoir quel est la plus petite carte d'une couleur couleur rentré en paramètre que le joueur ait
      * @param couleur
      * @return
      */
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
     
     /**
      * permet de savoir combien de carte d'une valeur donnée le joueur a
      * @param valeur
      * @return
      */
     public int majorityJestValeur(Valeur valeur) {
    	 int j=0;
    	 for (int i=0;i<jest.size();i++) {
	            if( jest.get(i).getValeur()== valeur ) {
	            		j+=1;
	            	}
 	 }   
    	 return j;
     }
     
     /**
      * permet de savoir combien de carte d'une valeur donnée le joueur a
      * @param valeur
      * @return
      */
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
 
     /**
      * permet d'afficher le jest
      */
     public String toString() {
    	 return jest.toString();
     }
}

