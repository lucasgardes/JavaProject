package main;

import javax.swing.JButton;

public class Definition {
    private String intitule;
    private Mot mot;
    private int direction;
    private Case Case;

    public Definition(String intitule, int direction, Mot mot, Case Case) {
        this.intitule = intitule;
        this.direction = direction;
        this.mot = mot;
        this.Case = Case;
    }

    public String getIntitule() {
        return this.intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getDirection() {
        return this.direction;
    }
    
    public Mot getMot() {
        return this.mot;
    }
    
    public Case getCase() {
        return this.Case;
    }

    public void addDefinition(Case cases) {
    	
    }

    public void deleteDefinition(Case cases, JButton[][] caseButtons) {
    	cases.setContent("");
    	int x = cases.getX();
    	int y = cases.getY();
        caseButtons[x][y].setText("");
        Mot mot = this.getMot();
        mot.deleteMot(this.getDirection(), caseButtons);
    }

    public void changeDirection(int newDirection) {
        this.direction = newDirection;
    }
}