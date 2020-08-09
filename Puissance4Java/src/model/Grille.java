package model;

public class Grille {
	
	private static int nbrColonne = 7;
	private static int nbrLigne = 6;
	int align = 4;
	private int[][] grille;
	
	
	//tableau de ligne et de colonne = grille

	public Grille (int nbrColonne, int nbrLigne) {
		this.nbrColonne=nbrColonne;
		this.nbrLigne=nbrLigne;
		this.grille=grille;
		
		
	}
	
	public static void AfficheGrille () {
		
		int[][] grille = new int[nbrColonne][nbrLigne];
		//for(int x = 0 ; x < nbrColonne ; x++)
			//for(int y = 0 ; y < nbrLigne ; y++)
				//grille[x][y] = true;
		//System.out.println(grille);
		
		for(int y = 0 ; y < nbrLigne ; y++){
			//System.out.print('|');
			for(int x = 0 ; x < nbrColonne ; x++){
				System.out.print('|');
				System.out.print(" " + "." + " ");
			}
			System.out.println('|');
		}
		
	}

	public static int getNbrColonne() {
		return nbrColonne;
	}

	public static void setNbrColonne(int nbrColonne) {
		Grille.nbrColonne = nbrColonne;
	}

	public static int getNbrLigne() {
		return nbrLigne;
	}

	public static void setNbrLigne(int nbrLigne) {
		Grille.nbrLigne = nbrLigne;
	}
	


}
