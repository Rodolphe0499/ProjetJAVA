package fr.utt.lo02.jest_jason_rodolphe.vues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image ;
import java.io.File; 
import javax.imageio.ImageIO ;
import java.io.IOException;

import javax.swing.JPanel ;

public class AllureVue extends JPanel {

	 public void paintComponent(Graphics g) {
		 try {
			Image img = ImageIO.read( new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\JEST"));
			g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 Font font= new  Font("Courier",Font.BOLD,50);
		 g.setFont(font);
		 g.setColor(Color.black);
		 g.drawString("JEST", 330, 200);
		
		 
	 }
	 
	 
	
	
}