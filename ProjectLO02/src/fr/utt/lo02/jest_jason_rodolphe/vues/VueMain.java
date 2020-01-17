package fr.utt.lo02.jest_jason_rodolphe.vues;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VueMain extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LinkedList<Image> main;
	private boolean carteVisible[];
	
	public VueMain(LinkedList<Image> j){
		super();
		this.main = main;
		for(int i=0;i<main.size();i++)
		     this.carteVisible[i] = false;
		
		this.setOpaque(false);
		this.setLayout(null);
		
	}
	
	public LinkedList<Image> getMain() {
		return this.main;
	}

	public void setMain(LinkedList<Image> carte) {
		this.main = main;
	}

	public boolean isCartesVisibles(int i) {
		return carteVisible[i];
	}

	public void setCartesVisibles(int i) {
		this.carteVisible[i] = true ;
	}
	
	public void setCartesVisibles(boolean visibles) {
		for(int i=0;i<main.size();i++)
			this.carteVisible[i] = visibles ;
	}
	
	public void setCartesDown(int i) {
		this.carteVisible[i] = false ;
	}
	
	public void paintComponent(Graphics g){
		Image down = null;
		try {
			down = ImageIO.read(new File("C:\\Users\\jbria\\eclipse-workspace\\VueCarte\\face_down"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0;i<main.size();i++){
			if (carteVisible[i]==true)
				g.drawImage(main.get(i), ((i-1)*30), 0, 80, 140, this);
			else{			
				g.drawImage(down, ((i-1)*30), 0, 80, 140, this);
			}
			
		}
	}
}

