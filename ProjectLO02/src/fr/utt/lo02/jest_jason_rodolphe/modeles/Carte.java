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
public void setFaceDown() {
	this.faceCarte=false;
}
public void setFaceUp() {
	this.faceCarte=true;
}
public void retournerCarte() {
	if(this.faceCarte == true) {
		this.faceCarte = false;
	}
	if(this.faceCarte == false){
		this.faceCarte = true;
	}
}

public void setCouleur(Couleur couleur) {
	this.couleur = couleur;
}

public Couleur getCouleur() {
	return this.couleur;
}

public void setValeur(Valeur valeur) {
	this.valeur = valeur;
}

public Valeur getValeur() {
	return this.valeur;
}
 
public void setFaceCarte(boolean face) {
	this.faceCarte = face;
}

public boolean getFaceCarte() {
	return this.faceCarte;
}

public void setTrophee(Trophee trophee) {
	this.trophee = trophee;
}

public Trophee getTrophee() {
	return this.trophee;
}

public String toString() {
	if(this.valeur== Valeur.ZERO) {
		return "Joker"+" trophee "+this.trophee;
}   
	else {
	 return this.valeur+" de "+this.couleur+" trophee "+this.trophee;
}
}
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