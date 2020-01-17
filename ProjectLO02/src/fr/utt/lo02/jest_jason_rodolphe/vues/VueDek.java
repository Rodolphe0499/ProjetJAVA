package fr.utt.lo02.jest_jason_rodolphe.vues;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VueDek extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LinkedList<Image> cartes;
	
	public VueDek(){
		super();
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.cartes = new LinkedList<Image>();
		this.genererCartes();
	}
	
	public void paintComponent(Graphics g){
		try {
		      Image img = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\face_down"));
		      g.drawImage(img, 0, 0, 100, 180, this);
		} catch (IOException e) {
		      e.printStackTrace();
		}
	}
	
	public void genererCartes(){
		try {
			Image joker = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\joker_BestJest"));
			cartes.add(joker);
			
			Image asdecarreau = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\as_de_carreau_MajorityFour"));
			cartes.add(asdecarreau);
			Image asdecoeur = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\as_de_coeur_joker"));
			cartes.add(asdecoeur);
			Image asdepique = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\as_de_pique_HighestTrefle"));
			cartes.add(asdepique);
			Image asdetrefle = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\as_de_trefle_HighestPique"));
			cartes.add(asdetrefle);
			
			Image deuxdecarreau = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\deux_de_carreau_HighestCarreau"));
			cartes.add(deuxdecarreau);
			Image deuxdecoeur = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\deux_de_coeur_joker"));
			cartes.add(deuxdecoeur);
			Image deuxdepique = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\deux_de_pique_MajorityThree"));
			cartes.add(deuxdepique);
			Image deuxdetrefle = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\deux_de_trefle_LowestCoeur"));
			cartes.add(deuxdetrefle);
			
			Image quatredecarreau = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\quatre_de_carreau_BestJestNoJoke"));
			cartes.add(quatredecarreau );
			Image quatredecoeur  = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\quatre_de_coeur_joker"));
			cartes.add(quatredecoeur);
			Image quatredepique = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\quatre_de_pique_LowestTrefle"));
			cartes.add(quatredepique);
			Image quatredetrefle = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\quatre_de_trefle_LowestPique"));
			cartes.add(quatredetrefle);
			
			Image troisdecarreau = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\trois_de_carreau_LowestCarreau"));
			cartes.add(troisdecarreau);
			Image troisdecoeur = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\trois_de_coeur_joker"));
			cartes.add(troisdecoeur);
			Image troisdepique = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\trois_de_pique_MajorityTwo"));
			cartes.add(troisdepique);
			Image troisdetrefle = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\trois_de_trefle_HighestCoeur"));
			cartes.add(troisdetrefle);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public LinkedList<Image> getCartes() {
		return cartes;
	}

	public void setCartes(LinkedList<Image> cartes) {
		this.cartes = cartes;
	}



	

	
}
