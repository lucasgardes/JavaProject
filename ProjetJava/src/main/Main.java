package main;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main {

	private static ModeleGrille modeleGrille;
	private static JButton[][] caseButtons;
	private static Mot mot;
	private static Definition definition;
	private static Fichier dictionnaire;
	private static JFrame frame;

    public static void main(String[] args) {
    	dictionnaire = new Fichier();
        SwingUtilities.invokeLater(() -> {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Bienvenue dans l'application de création de grilles de mots croisés!");
            System.out.println("Veuillez spécifier la hauteur de la grille :");
            int hauteur = scanner.nextInt();

            System.out.println("Veuillez spécifier la largeur de la grille :");
            int largeur = scanner.nextInt();


            modeleGrille = new ModeleGrille(hauteur, largeur, 100, 1);
            if (modeleGrille.checkSize() != 0) {
                System.out.println("Le résultat est négatif.");
            } else {
                afficherInterfaceGraphique(hauteur, largeur);
            }
        });
    }

    private static void afficherInterfaceGraphique(int hauteur, int largeur) {
    	frame = new JFrame("Grille de mots croisés");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        JPanel gridPanel = new JPanel(new GridLayout(hauteur, largeur));
        frame.add(gridPanel, BorderLayout.CENTER);
        
        JButton dictionnaireButton = new JButton("Dictionnaire");
        dictionnaireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rechercherDansDictionnaire();
            }
        });
        frame.add(dictionnaireButton, BorderLayout.SOUTH);
        
        caseButtons = new JButton[hauteur][largeur];
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
            	Case cell = new Case(i,j);
            	final int i2 = i;
                final int j2 = j;
            	CaseButton caseButton = new CaseButton(cell);
            	caseButton.setPreferredSize(new Dimension(50, 50));
                caseButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(caseButton, BorderLayout.CENTER);
                panel.setBackground(Color.WHITE);
                gridPanel.add(panel);
                caseButtons[i2][j2] = caseButton;
               
                caseButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	String contenuCase = cell.getContent();
                    	System.out.println("Contenu de la Case : " + contenuCase);
                        
                    	if (contenuCase == "") {
                        	String[] directions = {"Horizontal direct", "Horizontal indirect", "Vertical direct", "Vertical indirect"};
                    	    int choiceDirections = JOptionPane.showOptionDialog(frame, "", "Direction",
                    	            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, directions, directions[0]);
                    	    
                    	    String inputLetters = JOptionPane.showInputDialog(frame, "Entrez le nombre de lettres du mot :");
	                  	    int numberOfLetters = Integer.parseInt(inputLetters);
	
	                  	    String word = JOptionPane.showInputDialog(frame, "Entrez le mot :");
	                  	    String def = JOptionPane.showInputDialog(frame, "Entrez la définition du mot :");
	                  	    
	                  	    
	                  	    mot = new Mot(numberOfLetters, cell, word);
	                  	    definition = new Definition(def, choiceDirections, mot, cell);

	                  	    int x = cell.getX();
	                  	    int y = cell.getY();
	                  	    if (x > hauteur || y > largeur) {
	                  	    	JOptionPane.showMessageDialog(null, "La position de départ du mot dépasse la limite de la grille.", "Erreur", JOptionPane.ERROR_MESSAGE);
	                  	    	return;
	                  	    }
	                  	    
	                  	  switch (choiceDirections) {
                          case 0: // Horizontal direct
                              if (y + 1 + numberOfLetters > largeur) {
                                  JOptionPane.showMessageDialog(null, "La longueur du mot dépasse la largeur restante de la grille.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                  return;
                              }
                              break;
                          case 1: // Horizontal indirect
                              if (x + 1 >= hauteur || y + numberOfLetters > largeur) {
                                  JOptionPane.showMessageDialog(null, "La position de départ du mot dépasse la limite de la grille.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                  return;
                              }
                              break;
                          case 2: // Vertical direct
                              if (x + 1 + numberOfLetters > hauteur) {
                                  JOptionPane.showMessageDialog(null, "La longueur du mot dépasse la hauteur restante de la grille.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                  return;
                              }
                              break;
                          case 3: // Vertical indirect
                              if (x + numberOfLetters > hauteur || y + 1 >= largeur) {
                                  JOptionPane.showMessageDialog(null, "La position de départ du mot dépasse la limite de la grille.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                  return;
                              }
                              break;
                          default:
                              break;
	                  	  }
		                  	for (int k = 1; k <= numberOfLetters; k++) {
		                  		char letter = word.charAt(k - 1);
		    	                String letterString = String.valueOf(letter);
		    	                Case cases = new Case(x, y + k);
			                  	 if (cases.getContent() != "") {
			 	                	if (cases.getContent() != letterString) {
			 	                		JOptionPane.showMessageDialog(null, "Le mot chevauche une autre lettre déjà présentes dans la grille.\nPosition (" + x + ", " + y+k + ")", "Erreur", JOptionPane.ERROR_MESSAGE);
			 	                		return;
			 	                	}
			                  	 }
		                  	}
		                  	cell.setContent(definition.getIntitule());
		                  	cell.setDefinition(definition);
	                  	    caseButtons[i2][j2].setText(cell.getContent());
	                  	    mot.addMot(choiceDirections, caseButtons);
                    	 } else if (contenuCase != "" && contenuCase.length() > 1) {
                    	   String[] deleteDef = {"Supprimer définition (haut)", "Supprimer définition (bas)","Supprimer les 2 définitions"};
                    	   int choiceDeleteDef = JOptionPane.showOptionDialog(frame, "", "Definitions",
                    	           JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, deleteDef, deleteDef[0]);
                    	   switch (choiceDeleteDef) {
                           case 0: 
                        	   Definition definitionToDelete = cell.getDefinition();
                        	   definitionToDelete.deleteDefinition(cell, caseButtons);
                               break;
                           case 1: 
                        	   //Definition definitionToDelete = cell.getDefinition();
                        	   //definitionToDelete.deleteDefinition(cell, caseButtons);
                               break;
                           case 2: 
                        	   //Definition definitionToDelete = cell.getDefinition();
                        	   //definitionToDelete.deleteDefinition(cell, caseButtons);
                               break;
                           default:
                               break;
 	                  	  } 
                    	 
                    	 }
                    }
                });
            }
        }

        frame.pack();
        frame.setVisible(true);
    }
    private static void rechercherDansDictionnaire() {
        String motRecherche = JOptionPane.showInputDialog(frame, "Entrez le mot à rechercher dans le dictionnaire :");
        if (motRecherche != null && !motRecherche.isEmpty()) {
            Fichier fichierDictionnaire = new Fichier();
            ArrayList<String> motsTrouves = fichierDictionnaire.rechercherMot(motRecherche);
            fichierDictionnaire.printMotsDebut(motRecherche);

        }
    }

}
