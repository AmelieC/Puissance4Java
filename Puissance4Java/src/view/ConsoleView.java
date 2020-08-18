package view;

import model.Grille;
import model.Joueur;
import model.Partie;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.*;

@SuppressWarnings("deprecation")
public class ConsoleView implements Observer{
	
	private Partie partie;
	private PartieController partieC;
	private GrilleController grilleC;
	private JetonController jetonC;
	private JoueurController joueurC;
	private Scanner scanner;
	private int réponse;
	private boolean estValide;
	
	public ConsoleView(Partie partie) {
		this.partie = partie;
		this.partieC = new PartieController();
		this.grilleC = new GrilleController();
		this.jetonC = new JetonController();
		this.joueurC = new JoueurController();
		this.scanner = new Scanner(System.in);
		this.réponse = 0;
		this.estValide = true;
	}
	
	private String initMenu() {
		System.out.println("Bienvenue dans Puissance 4 !");
		System.out.println("[1] Démarrer une partie");
		System.out.println("[2] Quitter");
		
		do {
			try {
				this.estValide = true;
				this.réponse = Integer.parseInt(this.scanner.nextLine());
				
				if (this.réponse != 1 && this.réponse != 2) {
					this.estValide = false;
					System.out.println("Veuillez entrer 1 ou 2.");
				}
				
			} catch (NumberFormatException e) {
				this.estValide = false;
				System.out.println("Veuillez entrer 1 ou 2.");
			}
		} while(!this.estValide);
		
		if (this.réponse == 2) {
			System.out.println("Au revoir !");
			System.exit(0);
		}
		
		System.out.println("Combien de lignes ? (défaut : 6, minimum : 4, maximum : 20)");
		
		do {
			try {
				this.estValide = true;
				this.réponse = Integer.parseInt(this.scanner.nextLine());
				
				if (this.réponse < 4 && this.réponse > 20) {
					this.estValide = false;
					System.out.println("Veuillez entrer un nombre de lignes entre 4 et 20.");
				}
				
			} catch (NumberFormatException e) {
				this.estValide = false;
				System.out.println("Veuillez entrer un nombre de lignes entre 4 et 20.");
			}
		} while(!this.estValide);
		int nbrLignes = this.réponse;
		
		System.out.println("Combien de colonne ? (défaut : 7, minimum : 4, maximum : 20)");
		
		do {
			try {
				this.estValide = true;
				this.réponse = Integer.parseInt(this.scanner.nextLine());
				
				if (this.réponse < 4 && this.réponse > 20) {
					this.estValide = false;
					System.out.println("Veuillez entrer un nombre de colonnes entre 4 et 20.");
				}
				
			} catch (NumberFormatException e) {
				this.estValide = false;
				System.out.println("Veuillez entrer un nombre de colonnes entre 4 et 20.");
			}
		} while(!this.estValide);
		int nbrColonnes = this.réponse;
		
		return nbrLignes + " " + nbrColonnes;
	}
	
	private void nomJoueurs(Joueur joueur1, Joueur joueur2) {
		System.out.println("Entrez le nom du joueur 1 : ");
		String nom = this.scanner.nextLine();
		
		while (nom.trim().isEmpty()) {
			System.out.println("Le nom ne peut pas être vide.");
			nom = this.scanner.nextLine();
		}
		
		joueurC.setNom(joueur1, nom);
		
		System.out.println("Entrez le nom du joueur 2 : ");
		nom = this.scanner.nextLine();
		
		while (nom.trim().isEmpty()) {
			System.out.println("Le nom ne peut pas être vide.");
			nom = this.scanner.nextLine();
		}
		joueurC.setNom(joueur2, nom);
	}
	
	private void afficheGrille() {
		for (int y=0;y<this.partie.getGrille().getNbrLigne();y++) {
			for (int x=0;x<this.partie.getGrille().getNbrColonne();x++) {
				System.out.print("|");
				if (this.partie.getGrille().getGrille()[y][x] == null) System.out.print(" . ");
				else if (this.partie.getGrille().getGrille()[y][x].getSymbole() == 'R') System.out.print(" R ");
				else if (this.partie.getGrille().getGrille()[y][x].getSymbole() == 'J') System.out.print(" J ");				
			}
			System.out.println("|");
		}
	}
	
	private void joueJeton() {
		System.out.println("C'est à " + this.partie.getJoueurEnCours().getNom() + " de jouer ! (Jeton : " + this.partie.getJoueurEnCours().getCouleur() + ")");
		System.out.println("Entrez le numéro de colonne : (1-" + this.partie.getGrille().getNbrColonne() + ")");
		
		do {
			try {
				this.estValide = true;
				this.réponse = Integer.parseInt(this.scanner.nextLine());
				
				if (this.réponse < 1 || this.réponse > this.partie.getGrille().getNbrColonne()) {
					this.estValide = false;
					System.out.println("Veuillez entrer un numéro entre 1 et " + this.partie.getGrille().getNbrColonne() + ".");
				}
				
			} catch (NumberFormatException e) {
				this.estValide = false;
				System.out.println("Veuillez entrer un numéro entre 1 et " + this.partie.getGrille().getNbrColonne() + ".");
			}
			
			if (this.estValide) {
				if (this.grilleC.ajouterJeton(this.partie.getGrille(), this.partie.getJoueurEnCours(), this.réponse) == -1) {
					this.estValide = false;
					System.out.println("Cette colonne est remplie. Veuillez en choisir une autre.");
				}
			}
				
		} while (!this.estValide);
		
	}
	
	private void rejouer() {
		System.out.println("Souhaitez vous rejouer ?");
		System.out.println("[1] Nouvelle partie");
		System.out.println("[2] Quitter");
		
		do {
			try {
				this.estValide = true;
				this.réponse = Integer.parseInt(this.scanner.nextLine());
				
				if (this.réponse != 1 && this.réponse != 2) {
					this.estValide = false;
					System.out.println("Veuillez entrer 1 ou 2.");
				}
			} catch (NumberFormatException e) {
				this.estValide = false;
				System.out.println("Veuillez entrer 1 ou 2.");
			}
		} while(!this.estValide);
	}
	
	public void update(Observable o, Object arg) {
		this.afficheGrille();
	}
	
	public static void main(String[] args) {
		Joueur joueur1 = new Joueur("", "rouge");
		Joueur joueur2 = new Joueur("", "jaune");
		
		Partie partie = new Partie(joueur1, joueur2);
		
		ConsoleView vue = new ConsoleView(partie);
		
		String[] nbrLignesColonnes = vue.initMenu().split(" ");
		int nbrLignes = Integer.parseInt(nbrLignesColonnes[0]);
		int nbrColonnes = Integer.parseInt(nbrLignesColonnes[1]);
		Grille grille = new Grille(nbrLignes, nbrColonnes);
		vue.grilleC.ajouterObserver(grille, vue);
		vue.partieC.setGrille(partie, grille);
		
		vue.nomJoueurs(joueur1, joueur2);
		
		vue.afficheGrille();
		
		while(!vue.partie.getEstTerminée()) {
			vue.joueJeton();
			
			if (!vue.partie.getGrille().checkVictoire(vue.partie.getJoueurEnCours()) && !vue.partie.getGrille().estPleine()) {
				vue.partie.joueurSuivant();
			} else {
				vue.partieC.setEstTerminée(vue.partie, true);
				
				if (vue.partie.getGrille().estPleine() && !vue.partie.getGrille().checkVictoire(vue.partie.getJoueurEnCours())) {
					System.out.println("La grille est pleine, match nul !");
				} else {
					Joueur joueurGagnant = vue.partie.getJoueurEnCours();
					vue.joueurC.setNbrVictoire(joueurGagnant, joueurGagnant.getNbrVictoire() + 1);
					System.out.println(joueurGagnant.getNom() + " gagne la partie, bravo ! Nombre de victoire(s) : " + joueurGagnant.getNbrVictoire());
				}
				
				vue.rejouer();
				if (vue.réponse == 1) {
					grille = new Grille(nbrLignes, nbrColonnes);
					partie = new Partie(joueur1, joueur2);
					vue.partieC.setGrille(partie, grille);
					vue = new ConsoleView(partie);
					vue.grilleC.ajouterObserver(grille, vue);
					vue.afficheGrille();
				} else {
					System.out.println("Au revoir !");
					System.exit(0);
				}
			}
		}
	}

}
