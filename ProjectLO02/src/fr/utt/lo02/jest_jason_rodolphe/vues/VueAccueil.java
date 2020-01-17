package fr.utt.lo02.jest_jason_rodolphe.vues;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VueAccueil extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VueAccueil (){
		super();
	}
	
	public void paintComponent(Graphics g){
	    try {
	      Image img = ImageIO.read(new File("UNO_Accueil.jpg"));
	      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	      Font font = new Font("Courier", Font.BOLD, 18);
		  g.setFont(font);
		  g.drawString("PROJET-LO02", 10, 760);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	} 
}

