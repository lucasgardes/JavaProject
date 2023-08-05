package main;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

	private static ModeleGrille modeleGrille;
	private static JButton[][] caseButtons;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Bienvenue dans l'application de création de grilles de mots croisés!");
            System.out.println("Veuillez spécifier la hauteur de la grille :");
            int hauteur = scanner.nextInt();

            System.out.println("Veuillez spécifier la largeur de la grille :");
            int largeur = scanner.nextInt();


            modeleGrille = new ModeleGrille(hauteur, largeur, 30, 1);
            if (modeleGrille.checkSize() != 0) {
                System.out.println("Le résultat est négatif.");
            } else {
                afficherInterfaceGraphique(hauteur, largeur);
            }
        });
    }

    private static void afficherInterfaceGraphique(int hauteur, int largeur) {
        JFrame frame = new JFrame("Grille de mots croisés");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(hauteur, largeur));
        
        caseButtons = new JButton[hauteur][largeur];
        
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                JButton caseButton = new JButton();
                
                caseButtons[i][j] = caseButton;
                
                caseButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	
                    	Case caseCliquee = modeleGrille.getCase(i, j);
                        String contenuCase = caseCliquee.getContent();
                        
                        if (contenuCase == "") {
                        	String[] directions = {"Horizontal", "Vertical"};
                            int choiceDirections = JOptionPane.showOptionDialog(frame, "", "Direction",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, directions, directions[0]);	
                        } else {
                        	String[] deleteDef = {"Supprimer définition (haut)", "Supprimer définition (bas)","Supprimer les 2 définitions"};
                            int choiceDeleteDef = JOptionPane.showOptionDialog(frame, "", "Definitions",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, deleteDef, deleteDef[0]);
                        }
                        
                        if (choiceDirections == 0) {
                            String inputLetters = JOptionPane.showInputDialog(frame, "Entrez le nombre de lettres du mot :");
                            int numberOfLetters = Integer.parseInt(inputLetters);

                            String word = JOptionPane.showInputDialog(frame, "Entrez le mot :");
                            modeleGrille.setCase(i, j, "H"); 
                        } else if (choiceDirections == 1) {
                            String inputLetters = JOptionPane.showInputDialog(frame, "Entrez le nombre de lettres du mot :");
                            int numberOfLetters = Integer.parseInt(inputLetters);

                            String word = JOptionPane.showInputDialog(frame, "Entrez le mot :");
                            modeleGrille.setCase(i, j, "V");
                        }
                    }
                });
                frame.add(caseButton);
            }
        }

        frame.pack();
        frame.setVisible(true);
    }

}
