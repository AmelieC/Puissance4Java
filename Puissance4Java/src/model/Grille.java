package model;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Grille extends Observable {
	
	private int nbrColonne = 0;
	private int nbrLigne = 0;
	private Jeton[][] grille;
	private int dernièreLigneJouée = 0;
	private int dernièreColonneJouée = 0;
	
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
	
	public int getDernièreLigneJouée() {
		return this.dernièreLigneJouée;
	}

	public int getDernièreColonneJouée() {
		return this.dernièreColonneJouée;
	}
	
	public void setNbrColonne(int nbrColonne) {
		this.nbrColonne = nbrColonne;
	}

	public void setNbrLigne(int nbrLigne) {
		this.nbrLigne = nbrLigne;
	}
	
	public void setJeton(int ligne, int colonne, Jeton jeton) {
		this.grille[ligne][colonne] = jeton;
		
		this.dernièreLigneJouée = ligne;
		this.dernièreColonneJouée = colonne;
		
		setChanged();
		notifyObservers();
	}
	
	public boolean estPleine() {
		for (int x=0;x<this.nbrColonne;x++) {
			if (this.grille[0][x] == null) return false;
		}
		
		return true;
	}
	
	public boolean checkVictoire(Joueur joueur) {
		// Combinaison gagnante horizontale
		int somme = 0;
		for (int x = 0;x<this.nbrColonne;x++) {
			if (this.grille[this.dernièreLigneJouée][x] != null && this.grille[this.dernièreLigneJouée][x].getCouleur() == joueur.getCouleur()) {
				somme++;
				if (somme > 3) return true;
			} else {
				somme = 0;
			}
		}
		
		// Combinaison gagnante verticale
		somme = 0;
		for (int x = 0;x<this.nbrLigne;x++) {
			if (this.grille[x][this.dernièreColonneJouée] != null && this.grille[x][this.dernièreColonneJouée].getCouleur() == joueur.getCouleur()) {
				somme++;
				if (somme > 3) return true;
			} else {
				somme = 0;
			}
		}
		
		// Combinaison gagnante oblique montante
		// On trouve le bord "bas gauche" de la diagonale
		int bordDiagLigne = this.dernièreLigneJouée;
		int bordDiagColonne = this.dernièreColonneJouée;
		boolean trouvé = false;
		while(!trouvé) {
			if (bordDiagLigne == this.nbrLigne - 1 || bordDiagColonne == 0) trouvé = true;
			else {
				bordDiagLigne++;
				bordDiagColonne--;
			}
		}
		somme = 0;
		boolean estVérifié = false;
		while(!estVérifié) {
			try {
				if (this.grille[bordDiagLigne][bordDiagColonne] != null && this.grille[bordDiagLigne][bordDiagColonne].getCouleur() == joueur.getCouleur()) {
					somme++;
					if (somme > 3) return true;
				} else {
					somme = 0;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				estVérifié = true;
			}
			
			bordDiagLigne--;
			bordDiagColonne++;
		}
		
		// Combinaison gagnante oblique descendante
		// On trouve le bord "haut gauche" de la diagonale
		bordDiagLigne = this.dernièreLigneJouée;
		bordDiagColonne = this.dernièreColonneJouée;
		trouvé = false;
		while(!trouvé) {
			if (bordDiagLigne == 0 || bordDiagColonne == 0) trouvé = true;
			else {
				bordDiagLigne--;
				bordDiagColonne--;
			}
		}
		somme = 0;
		estVérifié = false;
		while(!estVérifié) {
			try {
				if (this.grille[bordDiagLigne][bordDiagColonne] != null && this.grille[bordDiagLigne][bordDiagColonne].getCouleur() == joueur.getCouleur()) {
					somme++;
					if (somme > 3) return true;
				} else {
					somme = 0;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				estVérifié = true;
			}
			
			bordDiagLigne++;
			bordDiagColonne++;
		}
		
		return false;
	}
}
