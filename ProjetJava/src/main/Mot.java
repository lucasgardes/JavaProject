package main;

public class Mot {
	private int taille;
	private int caseStart;
	
	public Mot(int taille, int caseStart) {
        this.taille = taille;
        this.caseStart = caseStart;
    }
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public int getCase() {
        return caseStart;
    }
	
	public void addMot() {
		
	}
	
	public void deleteMot() {
		
	}
}
