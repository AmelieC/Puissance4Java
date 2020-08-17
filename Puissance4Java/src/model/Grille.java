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
	
	public boolean estPleine() {
		for (int x=0;x<this.nbrColonne;x++) {
			if (this.grille[0][x] == null) return false;
		}
		
		return true;
	}
	
	public boolean checkVictoire(Joueur joueur, int nbrLigne, int nbrColonne) {
		int somme = 0;
		
		// Combinaison gagnante horizontale
		for (int x = 0;x<this.nbrColonne;x++) {
			if (this.grille[nbrLigne][x] != null && this.grille[nbrLigne][x].getCouleur() == joueur.getCouleur()) {
				somme++;
				if (somme > 3) return true;
			} else {
				somme = 0;
			}
		}
		
		// Combinaison gagnante verticale
		for (int x = 0;x<this.nbrLigne;x++) {
			if (this.grille[x][nbrColonne] != null && this.grille[x][nbrColonne].getCouleur() == joueur.getCouleur()) {
				somme++;
				if (somme > 3) return true;
			} else {
				somme = 0;
			}
		}
		
		// Combinaison gagnante oblique
		
		
		return false;
	}
}
