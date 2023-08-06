package Tests;
import org.junit.Test;

import main.ModeleGrille;
import main.Case;
import main.Definition;

import static org.junit.Assert.*;

public class ModeleGrilleTest {
	@Test
    public void testGrillePositive() {
        ModeleGrille modeleGrille = new ModeleGrille(6, 6, 10, 1);
        assertTrue(modeleGrille.checkSize() == 0);
    }

    @Test
    public void testGrilleNegativeZero() {
        ModeleGrille modeleGrille = new ModeleGrille(0, 0, 10, 1);
        assertTrue(modeleGrille.checkSize() < 0);
    }

    @Test
    public void testGrilleNegativeNegativeSize() {
        ModeleGrille modeleGrille = new ModeleGrille(-6, -6, 10, 1);
        assertTrue(modeleGrille.checkSize() < 0);
    }

    @Test
    public void testGrilleNegativeMaxSize() {
        ModeleGrille modeleGrille = new ModeleGrille(11, 11, 10, 1);
        assertTrue(modeleGrille.checkSize() < 0);
    }
    
    @Test
    public void testGetContenuCaseEmptyGrid() {
        ModeleGrille modeleGrille = new ModeleGrille(6, 6, 10, 1);
        String contenuCase = modeleGrille.getContent(1, 1);
        assertEquals("vide", contenuCase);
    }

    @Test
    public void testGetContenuCaseWithLetter() {
        ModeleGrille modeleGrille = new ModeleGrille(6, 6, 10, 1);
        Case cell = new Case(1,1);
        cell.setContent("A");
        String contenuCase = modeleGrille.getContent(1, 1);
        assertEquals("lettre", contenuCase);
    }
    
    @Test
    public void testGetNbCaseVideHorizontalDirect() {
    	ModeleGrille modeleGrille = new ModeleGrille(6, 10, 100, 1);
    	int x = 1;
        int y = 1;
        ModeleGrille.Direction direction = ModeleGrille.Direction.HORIZONTALDIRECT;
        int result = modeleGrille.getNbCaseVide(x, y, direction);
        assertEquals(9, result);
    }

    @Test
    public void testGetNbCaseVideHorizontalIndirect() {
    	ModeleGrille modeleGrille = new ModeleGrille(6, 10, 100, 1);
        int x = 1;
        int y = 1;
        ModeleGrille.Direction direction = ModeleGrille.Direction.HORIZONTALINDIRECT;
        int result = modeleGrille.getNbCaseVide(x, y, direction);
        assertEquals(10, result);
    }

    @Test
    public void testGetNbCaseVideVerticalDirect() {
    	ModeleGrille modeleGrille = new ModeleGrille(6, 10, 100, 1);
        int x = 1;
        int y = 1;
        ModeleGrille.Direction direction = ModeleGrille.Direction.VERTICALDIRECT;
        int result = modeleGrille.getNbCaseVide(x, y, direction);
        assertEquals(5, result);
    }

    @Test
    public void testGetNbCaseVideVerticalIndirect() {
    	ModeleGrille modeleGrille = new ModeleGrille(6, 10, 100, 1);
        int x = 1;
        int y = 1;
        ModeleGrille.Direction direction = ModeleGrille.Direction.VERTICALINDIRECT;
        int result = modeleGrille.getNbCaseVide(x, y, direction);
        assertEquals(6, result);
    }
}
