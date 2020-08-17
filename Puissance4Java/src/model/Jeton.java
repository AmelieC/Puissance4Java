package model;

import java.util.HashMap;

public class Jeton {
	
	private HashMap<String, Integer> coordonnées = new HashMap<String, Integer>();
	private String couleur;
	private char symbole;
	private Joueur joueur;
	
	public Jeton(String couleur, char symbole, Joueur joueur) {
		this.coordonnées.put("colonne", 0);
		this.coordonnées.put("ligne", 0);
		this.couleur = couleur;
		this.symbole = symbole;
		this.joueur = joueur;
	}
	
	public int getColonne() {
		return this.coordonnées.get("colonne");
	}
	
	public int getLigne() {
		return this.coordonnées.get("ligne");
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
	public char getSymbole() {
		return this.symbole;
	}
	
	public Joueur getJoueur() {
		return this.joueur;
	}
	
	public void setColonne(int colonne) {
		this.coordonnées.put("colonne", colonne);
	}
	
	public void setLigne(int ligne) {
		this.coordonnées.put("ligne", ligne);
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public void setSymbole(char symbole) {
		this.symbole = symbole;
	}
	
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
}
