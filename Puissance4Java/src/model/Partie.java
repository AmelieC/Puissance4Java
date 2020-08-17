package model;
import java.util.ArrayList;
import java.util.Scanner;
public class Partie {
	
	private ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
	private Grille grille;
	private boolean estTerminée;
	private Joueur joueurEnCours;
	private static int nbrParties = 0;
	
	protected Scanner sc;
	protected Scanner sc1;
	
	public Partie(Joueur joueur1, Joueur joueur2, Grille grille) {
	    this.listeJoueur.add(joueur1);
	    this.listeJoueur.add(joueur2);
		this.grille = grille;
		this.estTerminée = false;
		this.joueurEnCours = this.listeJoueur.get(0);
		Partie.nbrParties++;
	}
	
	public ArrayList<Joueur> getJoueurList() {
		return this.listeJoueur;
	}
	
	public Grille getGrille() {
		return this.grille;
	}
	
	public boolean getEstTerminée() {
		return this.estTerminée;
	}
	
	public Joueur getJoueurEnCours() {
		return this.joueurEnCours;
	}
	
	public static int getNbrParties() {
		return nbrParties;
	}
	
	public void setJoueurList(Joueur joueur1, Joueur joueur2) {
		this.listeJoueur.clear();
		this.listeJoueur.add(joueur1);
		this.listeJoueur.add(joueur2);
	}
	
	public void setGrille(Grille grille) {
		this.grille = grille;
	}
	
	public void setEstTerminée(boolean estTerminée) {
		this.estTerminée = estTerminée;
	}
	
	public void setJoueurEnCours(Joueur joueur) {
		this.joueurEnCours = joueur;
	}
	
	public static void setNbrParties(int newNbrParties) {
		nbrParties = newNbrParties;
	}
	
	public void joueurSuivant() {
		if (this.joueurEnCours.equals(this.listeJoueur.get(0))) {
			this.joueurEnCours = this.listeJoueur.get(1);
		} else {
			this.joueurEnCours = this.listeJoueur.get(0);
		}
	}
	
	public void finPartie() {
		
	}
}