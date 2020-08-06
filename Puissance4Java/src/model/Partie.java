package model;
import java.util.ArrayList;
import java.util.Scanner;
public class Partie {
	
	
private Joueur joueur;
private ArrayList<Joueur> lj;
private Grille grille;
protected Scanner sc;




//constructeur



public Partie () {}


// initialisation de la partie via un menu


public void initMenu () {
	
	sc = new Scanner(System.in);
	
	affiche("Bienvenue dans Puissance 4 Amélie");
	affiche("[1] Démarrer une partie");
	affiche("[2] Quitter ");
	
	int  selection = Integer.parseInt(sc.nextLine());
	
	switch (selection){
		case 1:
			initPartie(lj, grille);
			
		case 2:
			affiche("Exit");
			System.exit(0);
			
		 default:
	    	 affiche("La selection n'est pas valide");
	    	 initMenu();
		
	}
	
}



public void initPartie (ArrayList<Joueur> lj, Grille grille) {
	
	
	Scanner sc = new Scanner(System.in);
	affiche("Entrez est le nom de deux joueurs?");
	String nom = sc.nextLine();
	ArrayList<Joueur> lj1 = new ArrayList<Joueur>();
	Joueur j1 = new Joueur (nom = sc.nextLine());
	Joueur j2 = new Joueur (nom = sc.nextLine());
		
	
	setListJoueurs(lj1);
	lj1.add(j1);
	lj1.add(j2);
	 for(Joueur elem: lj1)
     {
		 
     	 System.out.println ("nom"+ nom);
     }
	

	
	Grille.AfficheGrille();
	
}




public void affiche(String string) {
	System.out.println(string);		
}
	


public static void main(String[] args)
{
	 
	
	 
	 Partie p1 = new Partie();
	 p1.initMenu();
	 ArrayList<Joueur> lj1 = new ArrayList<Joueur>();
	 Grille g1=new Grille(6,7);
	 p1.initPartie(lj1,g1); 
	 
	 

}





// getter setter

public ArrayList<Joueur> getListJoueurs() {
	return listJoueurs;
}


public void setListJoueurs(ArrayList<Joueur> listJoueurs) {
	this.listJoueurs = listJoueurs;
}


public Grille getGrille() {
	return grille;
}


public void setGrille(Grille grille) {
	this.grille = grille;
}


public Joueur getJoueur() {
	return joueur;
}


public void setJoueur(Joueur joueur) {
	this.joueur = joueur;
}

}