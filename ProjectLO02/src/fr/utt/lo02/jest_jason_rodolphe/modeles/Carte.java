package fr.utt.lo02.jest_jason_rodolphe.modeles;

public class Carte {

 private Couleur couleur;
 private Valeur valeur;
 private boolean faceCarte;
 private Trophee trophee;
  
public Carte(Couleur couleur,Valeur valeur,boolean faceCarte,Trophee trophee ) {
	this.couleur= couleur;
	this.valeur= valeur;
	this.faceCarte= faceCarte;
	this.trophee= trophee;
	
	
}

/**
 * permet de mettre la carte faceDown
 */
public void setFaceDown() {
	this.faceCarte=false;
}
/**
 * permet de mettre la carte face up
 */
public void setFaceUp() {
	this.faceCarte=true;
}

/**
 * permet de retourner la carte 
 */
public void retournerCarte() {
	if(this.faceCarte == true) {
		this.faceCarte = false;
	}
	if(this.faceCarte == false){
		this.faceCarte = true;
	}
}

/**
 * permet d'attribuer la couleur d'une carte
 * @param couleur
 */
public void setCouleur(Couleur couleur) {
	this.couleur = couleur;
}

/**
 * permet de recuperer la couleur d'une carte
 * @return
 */
public Couleur getCouleur() {
	return this.couleur;
}

/**
 * permet de fixer la valeur d'une carte
 * @param valeur
 */
public void setValeur(Valeur valeur) {
	this.valeur = valeur;
}

/**
 * permet de recuperer la valeur d'une carte
 * @return
 */
public Valeur getValeur() {
	return this.valeur;
}
 /**
  * permet d'attribuer une face à la carte
  * @param face
  */
public void setFaceCarte(boolean face) {
	this.faceCarte = face;
}

/**
 * permet de savoir si la carte est face up ou face down
 * @return
 */
public boolean getFaceCarte() {
	return this.faceCarte;
}

/**
 * permet d'attribuer un trophee à la carte
 * @param trophee
 */
public void setTrophee(Trophee trophee) {
	this.trophee = trophee;
}

/**
 * permet de recuperer quel est le trophee attibué à la carte
 * @return
 */
public Trophee getTrophee() {
	return this.trophee;
}

/**
 * permet d'afficher une carte avec toutes ses caractéristiques
 */
public String toString() {
	if(this.valeur== Valeur.ZERO) {
		return "Joker"+" trophee "+this.trophee;
}   
	else {
	 return this.valeur+" de "+this.couleur+" trophee "+this.trophee;
}
}

/**
 * pemet de recuper sous forme d'entier la valeur de la carte 
 * @return
 */
public int getValeurInt() {
	int j=0;
	if(this.valeur== Valeur.AS) {
		j=1;
	}
	if(this.valeur== Valeur.DEUX) {
		j=2;
	}
	if(this.valeur== Valeur.TROIS) {
		j=3;
	}
	if(this.valeur== Valeur.QUATRE) {
		j=4;
	}
	if(this.valeur== Valeur.ZERO) {
		j=0;
	}
	if(this.valeur== Valeur.VALET) {
		j=5;
	}
	return j;
}

/**
 * permet d'attribuer à une couleur une valeur
 * permet de recuperer cette valeur
 * @return
 */
public int getCouleurInt() {
	int j=0;
	if(this.couleur== Couleur.PIQUE) {
		j=4;
	}
	if(this.couleur== Couleur.TREFLE) {
		j=3;
	}
	if(this.couleur== Couleur.CARREAU) {
		j=2;
	}
	if(this.couleur== Couleur.COEUR) {
		j=1;
	}
	
	return j;
}
 /**
  * permet de comparer la carte courrante avec une autre carte 
  * il renvoie vrai si la carte courrante est plus grande que la carte rentrée en paramètre
  * @param carte
  * @return
  */
public boolean estPlusGrand(Carte carte) {
	boolean estplusgrand=false;
	if(this.getValeurInt()>carte.getValeurInt()) {
		estplusgrand=true;
	}else if(this.getValeurInt()==carte.getValeurInt()) {
		    if(this.getCouleurInt()>carte.getCouleurInt()) {
		    	estplusgrand=true;
		    }
	}
	return estplusgrand;
}
	public static void main(String[] args) {
		

	}

}