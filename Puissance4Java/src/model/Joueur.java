package model;

import java.util.ArrayList;
import java.util.Collection;

public class Joueur {
	
	private static ArrayList<Joueur> listJoueurs;
	private String prenom;
	//private Jeton jeton;

	
	
	
	public Joueur(String prenom) {
		
		this.prenom = prenom;
	}


	
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the listJoueurs
	 */
	public static ArrayList<Joueur> getListJoueurs() {
		return getListJoueurs();
	}

	/**
	 * @param listJoueurs the listJoueurs to set
	 */
	public void setListJoueurs(ArrayList<Joueur> listJoueurs) {
		Joueur.listJoueurs = listJoueurs;
	}
	
}
