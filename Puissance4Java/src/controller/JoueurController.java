/**
 * 
 */
package controller;

import model.Joueur;

/**
 * @author amé
 *
 */
public class JoueurController {
	public void setNom(Joueur joueur, String nom) {
		joueur.setNom(nom);
	}
	
	public void setNbrVictoire(Joueur joueur, int nbrVictoire) {
		joueur.setNbrVictoire(nbrVictoire);
	}
}
