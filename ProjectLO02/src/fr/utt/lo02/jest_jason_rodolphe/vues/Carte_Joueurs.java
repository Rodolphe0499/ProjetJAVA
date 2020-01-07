package fr.utt.lo02.jest_jason_rodolphe.vues;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Carte_Joueurs extends JPanel {
	public Carte_Joueurs() {
	}

	
	 public void paintComponent(Graphics g) {
		 try {
			Image img = ImageIO.read( new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\joker_BestJest"));
			g.drawImage(img, 0, 0, this) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}