package fr.utt.lo02.jest_jason_rodolphe.modeles;


public class Test  {

	public Test() {}
	
	/**
	 * permet de lancer une partie de jeu
	 * @param args
	 */
	public static void main(String[] args) {
		Partie p= new Partie(); 
		 Thread tour = new Thread(p);
		 tour.start();
	}
	
}
