package model;

public class Grille {
	
	private static int nbrColonne = 7;
	private static int nbrLigne = 6;
	int align = 4;
	private boolean[][] grille;
	
	
	//tableau de ligne et de colonne = grille

	public Grille (int nbrColonne, int nbrLigne) {
		this.nbrColonne=nbrColonne;
		this.nbrLigne=nbrLigne;
		this.grille=grille;
		
		
	}
	
	public void AfficheGrille () {
		
		boolean[][] grille = new boolean[nbrColonne][nbrLigne];
		//for(int x = 0 ; x < nbrColonne ; x++)
			//for(int y = 0 ; y < nbrLigne ; y++)
				//grille[x][y] = true;
		//System.out.println(grille);
		
		for(int y = 0 ; y < nbrLigne ; y++){
			//System.out.print('|');
			for(int x = 0 ; x < nbrColonne ; x++){
				System.out.print('|');
				System.out.print(" " + grille[x][y] + " ");
			}
			System.out.println('|');
		}
		
	}
	

	 public static void main(String[] args)
     {
		 
		 Grille g1 = new Grille(6,7);
		 g1.AfficheGrille();

 }
}
