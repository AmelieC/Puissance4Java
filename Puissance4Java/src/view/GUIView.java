package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import controller.GrilleController;
import controller.JetonController;
import controller.JoueurController;
import controller.PartieController;
import model.Grille;
import model.Joueur;
import model.Partie;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIView {

	private JFrame frame;
	private Partie partie;
	private PartieController partieC;
	private GrilleController grilleC;
	private JetonController jetonC;
	private JoueurController joueurC;
	private int dernièreLigneJouée;
	private GridBagConstraints gbc;
	private JTextArea infoTexte;
	private JLabel[][] GUIGrille;
	private JButton[] ajoutBoutons;
	
	/**
	 * Create the application.
	 */
	public GUIView(Partie partie) {
		this.partie = partie;
		this.partieC = new PartieController();
		this.grilleC = new GrilleController();
		this.jetonC = new JetonController();
		this.joueurC = new JoueurController();
		this.dernièreLigneJouée = 0;
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(new GridBagLayout());
		this.gbc = new GridBagConstraints();
	}
	
	private void ajouteComposant(Component composant, int gridx, int gridy, int gridwidth, int gridheight) {
		this.gbc.gridx = gridx;
		this.gbc.gridy = gridy;
		this.gbc.gridwidth = gridwidth;
		this.gbc.gridheight = gridheight;
		this.gbc.fill = GridBagConstraints.BOTH;
		
		this.frame.add(composant, gbc);
	}
	
	private void joueJeton(int colonne) {
		this.dernièreLigneJouée = this.grilleC.ajouterJeton(this.partie.getGrille(), this.partie.getJoueurEnCours(), colonne);
		
		if (this.dernièreLigneJouée == -1) {
			this.infoTexte.setText(this.infoTexte.getText() + "\n Cette colonne est remplie.\n");
		} else {
			if (this.partie.getJoueurEnCours().getCouleur() == "rouge") this.GUIGrille[this.dernièreLigneJouée][colonne - 1].setBackground(Color.red);
			else this.GUIGrille[this.dernièreLigneJouée][colonne - 1].setBackground(Color.yellow);
			
			if (!this.partie.getGrille().checkVictoire(this.partie.getJoueurEnCours(), this.dernièreLigneJouée, colonne - 1) && !this.partie.getGrille().estPleine()) {
				this.partie.joueurSuivant();
				this.infoTexte.setText("C'est à " + this.partie.getJoueurEnCours().getNom() + " de jouer ! (Jeton : " + this.partie.getJoueurEnCours().getCouleur() + ")");
			} else {
				this.partieC.setEstTerminée(this.partie, true);
				
				if (this.partie.getGrille().estPleine()) {
					this.infoTexte.setText("La grille est pleine, match nul !");
				} else {
					Joueur joueurGagnant = this.partie.getJoueurEnCours();
					this.joueurC.setNbrVictoire(joueurGagnant, joueurGagnant.getNbrVictoire() + 1);
					this.infoTexte.setText(joueurGagnant.getNom() + " gagne la partie, bravo ! Nombre de victoire(s) : " + joueurGagnant.getNbrVictoire());
				}
				
				for (int x = 0;x<this.ajoutBoutons.length;x++) {
					this.ajoutBoutons[x].setEnabled(false);
				}
				
				this.rejouer();
			}
		}
	}
	
	private void rejouer() {
		this.infoTexte.setText(this.infoTexte.getText() + "\nSouhaitez vous rejouer ?");
		
		JButton oui = new JButton("oui");
		JButton non = new JButton("non");
		
		this.ajouteComposant(oui, 0, this.partie.getGrille().getNbrLigne() + 2, 1, 1);
		this.ajouteComposant(non, 1, this.partie.getGrille().getNbrLigne() + 2, 1, 1);
		
		oui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				
				Partie nouvPartie = new Partie(partie.getJoueurList().get(0), partie.getJoueurList().get(1));
				GUIView vue = new GUIView(nouvPartie);
				vue.initMenu(nouvPartie.getJoueurList().get(0), nouvPartie.getJoueurList().get(1));
			}
		});
		
		non.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
	}
	
	private void initMenu(Joueur joueur1, Joueur joueur2) {		
		JLabel LJoueur1 = new JLabel("Nom joueur 1 : ");
		JLabel LomJoueur2 = new JLabel("Nom joueur 2 : ");
		JLabel LNbrColonne = new JLabel("Combien de colonne ? (défaut : 7, minimum : 4, maximum : 20)");
		JLabel LNbrLigne = new JLabel("Combien de lignes ? (défaut : 6, minimum : 4, maximum : 20)");
		
		JTextField nomJoueur1 = new JTextField();
		if (!joueur1.getNom().trim().isEmpty()) nomJoueur1.setText(joueur1.getNom());
		
		JTextField nomJoueur2 = new JTextField();
		if (!joueur2.getNom().trim().isEmpty()) nomJoueur2.setText(joueur2.getNom());
		
		JTextField nbrLigne = new JTextField();
		JTextField nbrColonne = new JTextField();
		
		JButton envoyer = new JButton("Envoyer");
		
		JTextArea infoTexte = new JTextArea("Veuillez remplir ces champs.");
		infoTexte.setEditable(false);
		
		this.ajouteComposant(LJoueur1, 0, 0, 1, 1);
		this.ajouteComposant(nomJoueur1, 0, 1, 1, 1);
		
		this.ajouteComposant(LomJoueur2, 0, 2, 1, 1);
		this.ajouteComposant(nomJoueur2, 0, 3, 1, 1);
		
		this.ajouteComposant(LNbrLigne, 0, 4, 1, 1);
		this.ajouteComposant(nbrLigne, 0, 5, 1, 1);
		
		this.ajouteComposant(LNbrColonne, 0, 6, 1, 1);
		this.ajouteComposant(nbrColonne, 0, 7, 1, 1);
		
		this.ajouteComposant(envoyer, 0, 8, 1, 1);
		
		this.ajouteComposant(infoTexte, 0, 9, 1, 2);
		
		this.frame.setVisible(true);
				
		envoyer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int colonnes = 0;
				int lignes = 0;
				String out = "";
				boolean estOk = true;
				
				if (nomJoueur1.getText().trim().isEmpty() || nomJoueur2.getText().trim().isEmpty()) {
					out += "Les noms ne peuvent pas être vides.\n";
					estOk = false;
				}
				
				try {
					colonnes = Integer.parseInt(nbrColonne.getText());
					lignes = Integer.parseInt(nbrLigne.getText());
					
					if ((colonnes < 4 || colonnes > 20) || (lignes < 4 || lignes > 20)) {
						out += "Veuillez entrez un nombre de lignes/colonnes entre 4 et 20";
						estOk = false;
					}
				} catch (NumberFormatException x) {
					out += "Veuillez entrez un nombre de lignes/colonnes entre 4 et 20";
					estOk = false;
				}
				
				if (!estOk) {
					infoTexte.setText(out);
				}
				else {
					joueurC.setNom(joueur1, nomJoueur1.getText());
					joueurC.setNom(joueur2, nomJoueur2.getText());
					partieC.setGrille(partie, new Grille(lignes, colonnes));
					frame.dispose();
					start();
				}
			}
		});
	}

	private void start() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 1450, 900);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(new GridBagLayout());
		
		// Boutons pour ajouter une pièce
		int nbrColonnes = this.partie.getGrille().getNbrColonne();
		this.ajoutBoutons = new JButton[nbrColonnes];
		for (int x = 0;x<nbrColonnes;x++) {
			JButton button = new JButton(String.valueOf(x + 1));
			this.ajoutBoutons[x] = button;
			this.ajouteComposant(button, x, 0, 1, 1);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					joueJeton(Integer.parseInt(button.getText()));
				}
			});
		}
		
		// La grille
		this.GUIGrille = new JLabel[this.partie.getGrille().getNbrLigne()][this.partie.getGrille().getNbrColonne()];
		for (int x = 0;x<this.partie.getGrille().getNbrLigne();x++) {
			for (int y = 0;y<this.partie.getGrille().getNbrColonne();y++) {
			 	JLabel label = new JLabel("");
			 	label.setOpaque(true);
			 	label.setBackground(Color.white);
			 	label.setBorder(BorderFactory.createLineBorder(Color.black));
			 	label.setPreferredSize(new Dimension(30, 30));
			 	label.setMinimumSize(new Dimension(30, 30));
				
				this.GUIGrille[x][y] = label;
				this.ajouteComposant(label, y, x + 1, 1, 1);
			}
		}
		
		// Les textes d'informations
		this.infoTexte = new JTextArea("C'est à " + this.partie.getJoueurEnCours().getNom() + " de jouer ! (Jeton : " + this.partie.getJoueurEnCours().getCouleur() + ")");
		infoTexte.setEditable(false);
		this.ajouteComposant(infoTexte, 0, this.partie.getGrille().getNbrLigne() + 1, this.partie.getGrille().getNbrColonne(), 1);
		frame.add(infoTexte, gbc);
				
		this.frame.setVisible(true);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Joueur joueur1 = new Joueur("", "rouge");
				Joueur joueur2 = new Joueur("", "jaune");
				
				Partie partie = new Partie(joueur1, joueur2);
				
				try {
					GUIView vue = new GUIView(partie);
					vue.initMenu(joueur1, joueur2);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
