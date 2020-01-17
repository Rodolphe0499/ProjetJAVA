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

public class VueStack extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LinkedList<Image> stack;
	
	public VueStack(){
		super();
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.stack = new LinkedList<Image>();
	}
	
	public void paintComponent(Graphics g){
		try {
		      Image img = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\face_down"));
		      g.drawImage(img, 0, 0, 100, 180, this);
		     
		} catch (IOException e) {
		      e.printStackTrace();
		}
	}
	
	
		
	
	public void ajouterAuStack(Image c){
		this.stack.add(c);
	}
	
	public LinkedList<Image> getStack() {
		return stack;
	}

}
