package main;

import javax.swing.JButton;

public class CaseButton extends JButton {
    private Case cell;

    public CaseButton(Case cell) {
        this.cell = cell;
    }

    public Case getCell() {
        return cell;
    }
}

