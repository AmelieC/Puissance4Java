/**
 * 
 */
package controller;

import model.Grille;
import model.Partie;

/**
 * @author amé
 *
 */
public class PartieController {
	public void setEstTerminée(Partie partie, boolean estTerminée) {
		partie.setEstTerminée(estTerminée);
	}
	
	public void setGrille(Partie partie, Grille nouvGrille) {
		partie.setGrille(nouvGrille);
	}
}
