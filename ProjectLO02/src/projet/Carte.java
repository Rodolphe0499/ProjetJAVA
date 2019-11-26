package projet;

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

public void retournerCarte() {
	if(this.faceCarte == true) {
		this.faceCarte = false;
	}
	else {
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
	return this.valeur+"de"+this.couleur+"trophee"+this.trophee;
}
	public static void main(String[] args) {
		

	}

}