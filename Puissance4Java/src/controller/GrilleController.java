/**
 * 
 */
package controller;

import java.util.Observer;

import model.Grille;
import model.Jeton;
import model.Joueur;

/**
 * @author amé
 *
 */
public class GrilleController {
	public int ajouterJeton(Grille grille, Joueur joueur, int colonne) {
		int nbrLigne = grille.getNbrLigne() - 1;
		colonne -= 1;
		for (int x = nbrLigne; x >= 0 ; x--) {
			if (grille.getGrille()[x][colonne] == null) {
				char symbole;
				if (joueur.getCouleur() == "rouge") symbole = 'R';
				else symbole = 'J';
				grille.setJeton(x, colonne, new Jeton(joueur.getCouleur(), symbole, joueur));
				
				return 0;
			}
		}
		
		return -1;
	}
	
	public void ajouterObserver(Grille grille, Observer o) {
		grille.addObserver(o);
	}
}
