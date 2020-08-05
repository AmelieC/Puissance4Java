package model;
import java.util.Scanner;
public class Partie {
	
	

private Joueur joueur;
private Grille grille;
protected Scanner sc;




//constructeur
public Partie(Joueur joueur, Grille grille) {
		
		this.joueur = joueur;
		this.grille = grille;
	}


// initialisation de la partie via un menu


public void initMenu () {
	sc = new Scanner(System.in);
	
	affiche("Bienvenue dans Puissance 4 Amélie");
	affiche("[1] Démarrer une partie");
	affiche("[2] Quitter ");
	
	int  selection = Integer.parseInt(sc.nextLine());
	
	switch (selection){
		case 1:
			initPartie();
			
		case 2:
			affiche("Exit");
			System.exit(0);
			
		 default:
	    	 affiche("La selection n'est pas valide");
	    	 initMenu();
		
	}
	
}



public void initPartie () {
	
}

public void affiche(String string) {
	System.out.println(string);		
}
	
public static void main(String[] args)
{
	 
	 Grille g1 = new Grille(6,7);
	 g1.AfficheGrille();

}

}