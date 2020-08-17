package model;

public class Joueur extends Personne{
	
	private String couleur;
	private int nbrVictoire;
	
	public Joueur(String nom, String couleur) {
		super(nom);
		this.couleur = couleur;
		this.nbrVictoire = 0;
	}
	
	public String getNom() {
		return super.getNom();
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
	public int getNbrVictoire() {
		return this.nbrVictoire;
	}
	
	public void setNom(String nom) {
		super.setNom(nom);
	}
	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public void setNbrVictoire(int nbrVictoire) {
		this.nbrVictoire = nbrVictoire;
	}
}
