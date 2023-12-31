package main;

public class ModeleGrille {
	private int hauteur;
	private int largeur;
	private int maxSize;
	private int minSize;
	private Case[][] grille;
	
	public enum Direction {
		HORIZONTALDIRECT,
		HORIZONTALINDIRECT,
		VERTICALDIRECT,
	    VERTICALINDIRECT
	}
	
	public ModeleGrille(int hauteur, int largeur, int maxSize, int minSize) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.grille = new Case[hauteur][largeur];
        this.maxSize = maxSize;
        this.minSize = minSize;
    }
	
	public int getHauteur() {
        return this.hauteur;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
	
    public int checkSize() {
        if (hauteur * largeur > maxSize) {
            return 1;
        } else if (hauteur * largeur < minSize) {
            return -1;
        } else {
            return 0;
        }
    }
	
    public String getContent(int x, int y) {
        return grille[x][y].getContent();
    }
	
    public int getNbCaseVide(int x, int y, Direction dir) {
        int nbCasesVides = 0;
        int i = x;
        int j = y;

        while (i >= 0 && i < hauteur && j >= 0 && j < largeur) {
            if (grille[i][j].getContent().equals("")) {
                nbCasesVides++;
            } else {
                break;
            }

            switch (dir) {
                case HORIZONTALDIRECT:
                    j++;
                    break;
                case HORIZONTALINDIRECT:
                    j--;
                    break;
                case VERTICALDIRECT:
                    i++;
                    break;
                case VERTICALINDIRECT:
                    i--;
                    break;
                default:
                    break;
            }
        }

        return nbCasesVides;
    }
}
