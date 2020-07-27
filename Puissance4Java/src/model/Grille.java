package model;

public class Grille {
	
	int nbrColonne = 7;
	int nbrLigne = 6;
	int totCase = nbrColonne*nbrLigne ;
	int align = 4;
	
	
	//tableau de ligne et de colonne = grille

	public Grille (int nbrColonne, int nbrLigne) {
		boolean[][] grille = new boolean[nbrColonne][nbrLigne];
	for(int x = 0 ; x < nbrColonne ; x++)
		for(int y = 0 ; y < nbrLigne ; y++)
			grille[x][y] = '.';
	}
	

}
