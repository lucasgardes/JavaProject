package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mot {
	private int taille;
	private Case caseStart;
	private String word;
	
	public Mot(int taille, Case caseStart, String word) {
		this.taille = taille;
        this.caseStart = caseStart;
        this.word = word;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public Case getStartCase() {
        return caseStart;
    }
	
	public void addMot(int choiceDirections, JButton[][] caseButtons) {
	    switch (choiceDirections) {
	        case 0:
	            for (int k = 1; k <= this.taille; k++) {
	                char letter = this.word.charAt(k - 1);
	                String letterString = String.valueOf(letter);
	                caseStart = this.caseStart;
	                int x = caseStart.getX();
	                int y = caseStart.getY();
	                Case cases = new Case(x, y + k);
	                cases.setContent(letterString);
	                caseButtons[x][y + k].setText(cases.getContent());
	            }
	            break;
	        case 1:
	            for (int k = 0; k < this.taille; k++) {
	                char letter = this.word.charAt(k);
	                String letterString = String.valueOf(letter);
	                caseStart = this.caseStart;
	                int x = caseStart.getX();
	                int y = caseStart.getY();
	                Case cases = new Case(x + 1, y + k);
	                cases.setContent(letterString);
	                caseButtons[x + 1][y + k].setText(cases.getContent());
	            }
	            break;
	        case 2:
	            for (int k = 1; k <= this.taille; k++) {
	                char letter = this.word.charAt(k - 1);
	                String letterString = String.valueOf(letter);
	                caseStart = this.caseStart;
	                int x = caseStart.getX();
	                int y = caseStart.getY();
	                Case cases = new Case(x + k, y);
	                cases.setContent(letterString);
	                caseButtons[x + k][y].setText(cases.getContent());
	            }    
	            break;
	        case 3:
	            for (int k = 0; k < this.taille; k++) {
	                char letter = this.word.charAt(k);
	                String letterString = String.valueOf(letter);
	                caseStart = this.caseStart;
	                int x = caseStart.getX();
	                int y = caseStart.getY();
	                Case cases = new Case(x + k, y + 1);
	                cases.setContent(letterString);
	                caseButtons[x + k][y + 1].setText(cases.getContent());
	            }
	            break;
	        default:
	            break;
	    } 
	}
	
	public void deleteMot(int choiceDirections, JButton[][] caseButtons) {
		switch (choiceDirections) {
        case 0:
            for (int k = 1; k <= this.taille; k++) {
                caseStart = this.caseStart;
                int x = caseStart.getX();
                int y = caseStart.getY();
                Case cases = new Case(x, y + k);
                cases.setContent("");
                caseButtons[x][y + k].setText("");
            }
            break;
        case 1:
            for (int k = 0; k < this.taille; k++) {
                caseStart = this.caseStart;
                int x = caseStart.getX();
                int y = caseStart.getY();
                Case cases = new Case(x + 1, y + k);
                cases.setContent("");
                caseButtons[x + 1][y + k].setText("");
            }
            break;
        case 2:
            for (int k = 1; k <= this.taille; k++) {
                caseStart = this.caseStart;
                int x = caseStart.getX();
                int y = caseStart.getY();
                Case cases = new Case(x + k, y);
                cases.setContent("");
                caseButtons[x + k][y].setText("");
            }    
            break;
        case 3:
            for (int k = 0; k < this.taille; k++) {
                caseStart = this.caseStart;
                int x = caseStart.getX();
                int y = caseStart.getY();
                Case cases = new Case(x + k, y + 1);
                cases.setContent("");
                caseButtons[x + k][y + 1].setText("");
            }
            break;
        default:
            break;
    } 
		
	}
}
