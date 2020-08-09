package model;
import java.util.ArrayList;
import java.util.Scanner;
public class Partie {
	
	
private Joueur joueur;
private Joueur joueurEnCours;
private ArrayList<Joueur> lj;
private Grille grille;
protected Scanner sc;
protected Scanner sc1;





//constructeurs


public Partie(ArrayList<Joueur> lj, Grille grille) {
	
    this.lj = lj;
	this.grille = grille;
}


public Partie () {}


// initialisation de la partie via un menu


public void initMenu () {
	
	sc = new Scanner(System.in);
	sc1 = new Scanner(System.in);
	
	affiche("Bienvenue dans Puissance 4 Amélie");
	affiche("[1] Démarrer une partie");
	affiche("[2] Quitter ");
	
	int  selection = Integer.parseInt(sc.nextLine());
	
	switch (selection){
		case 1:
			initPartie(lj, grille);
			
		case 2:
			affiche("au revoir!");
			System.exit(0);
			
		 default:
	    	 affiche("La selection n'est pas valide");
	    	 initMenu();
		
	}
	
}



public void initPartie (ArrayList<Joueur> lj, Grille grille) {
	
	String nom ;
	Scanner sc = new Scanner(System.in);
	affiche("Entrez est le nom du joueur 1");
	Joueur j1 = new Joueur (nom = sc.nextLine(),0);
	ArrayList<Joueur> lj1 = new ArrayList<Joueur>();
	affiche("Entrez est le nom du joueur 2");
	Joueur j2 = new Joueur (nom = sc.nextLine(),0);	
	
	setListJoueurs(lj1);
	lj1.add(j1);
	lj1.add(j2);
	
	 for(int i = 0; i<lj1.size();i++)
	        System.out.println("Voici les deux joueurs : " + lj1.get(i).getPrenom());
	 
	 Scanner sc1 = new Scanner(System.in);
	 for(int i = 0; i<lj1.size()-1;i++)
	 affiche(" La partie peut commencer, c'est au tour de "+ ((i%2==1 ? j1.getPrenom() : j2.getPrenom()))+  " " + "entrez le numero de colonne souhaitée!"+ " " ) ;
	 int numCo = sc1.nextInt();
	 if (numCo > Grille.getNbrColonne()) {
		 affiche("Colonne non valide!");
	 }
	 else { affiche (" la colonne choisie est :"+ numCo); }
	 
	 Grille.AfficheGrille();
	 
	  }
	
public void affiche(String string) {
	System.out.println(string);		
}
	

public Joueur determinerJoueur () {
	return getJoueurEnCours();
}


private Joueur getJoueurEnCours() {
	// TODO Auto-generated method stub
	return null;
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
	return lj;
}


public void setListJoueurs(ArrayList<Joueur> listJoueurs) {
	this.lj = listJoueurs;
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