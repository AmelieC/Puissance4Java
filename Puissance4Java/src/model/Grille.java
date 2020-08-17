package model;

public class Grille {
	
	private int nbrColonne = 0;
	private int nbrLigne = 0;
	private Jeton[][] grille;
	
	//tableau de ligne et de colonne = grille
	public Grille (int nbrLigne, int nbrColonne) {
		this.nbrColonne = nbrColonne;
		this.nbrLigne = nbrLigne;
		this.grille = new Jeton[nbrLigne][nbrColonne];
	}
	
	public int getNbrColonne() {
		return this.nbrColonne;
	}
	
	public int getNbrLigne() {
		return this.nbrLigne;
	}
	
	public Jeton[][] getGrille() {
		return this.grille;
	}

	public void setNbrColonne(int nbrColonne) {
		this.nbrColonne = nbrColonne;
	}

	public void setNbrLigne(int nbrLigne) {
		this.nbrLigne = nbrLigne;
	}
}
