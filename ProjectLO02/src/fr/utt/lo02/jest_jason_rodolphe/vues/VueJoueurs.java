package fr.utt.lo02.jest_jason_rodolphe.vues;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;

import fr.utt.lo02.jest_jason_rodolphe.modeles.Joueurs;

public class VueJoueurs extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomJoueur;
	private Boolean virtuel = true;
	private JLabel nomJoueurLabel;
	private VueMain pc;
	private VueJest jest;
	private Font font = new Font("Courier", Font.BOLD, 20);
	
	private LinkedList<Image> main;
	
	public VueJoueurs(Joueurs joueur){
		super();
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.setJeu(new LinkedList<Image>());
		
		this.pc = new VueMain(main);
		this.add(pc);
		
		if (!joueur.isVirtuel()){
			this.virtuel = false;
		}
		
		this.nomJoueur = joueur.getNom();
		this.nomJoueurLabel = new JLabel(nomJoueur);
		this.nomJoueurLabel.setFont(font);
		this.nomJoueurLabel.setForeground(Color.BLUE);
		this.add(nomJoueurLabel, BorderLayout.NORTH);
	}
	
	public void retirer(Image carte){
		this.main.remove(carte);
	}
	
	public void retirerTout(){
		this.main.removeAll(main);
	}

	public void setCartesVisibles(int i){
		this.pc.setCartesVisibles(i);
	}
	
	public void setCartesVisibles(Boolean visibles){
		this.pc.setCartesVisibles(visibles);
	}
	
	public LinkedList<Image> getMain() {
		return main;
	}

	public void setJeu(LinkedList<Image> main) {
		this.main = main;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public VueMain getVueMain() {
		return pc;
	}

	public void setPc(VueMain pc) {
		this.pc = pc;
	}
	public void recevoirCarte(Image carte){
		this.main.add(carte);
	}
	public Boolean isVirtuel() {
		return virtuel;
	}

	public void setVirtuel(Boolean virtuel) {
		this.virtuel = virtuel;
	}
}