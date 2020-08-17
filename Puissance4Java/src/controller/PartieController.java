/**
 * 
 */
package controller;

import model.Partie;

/**
 * @author amé
 *
 */
public class PartieController {
	public void setEstTerminée(Partie partie, boolean estTerminée) {
		partie.setEstTerminée(estTerminée);
	}
}
