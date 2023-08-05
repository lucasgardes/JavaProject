package Tests;
import org.junit.Test;

import main.ModeleGrille;
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
        modeleGrille.setCase(1, 1, "A");
        String contenuCase = modeleGrille.getContent(1, 1);
        assertEquals("lettre", contenuCase);
    }

    @Test
    public void testGetContenuCaseWithDefSimple() {
        ModeleGrille modeleGrille = new ModeleGrille(6, 6, 10, 1);
        Definition definition = new Definition("intitule", "direction");
        modeleGrille.setCase(1, 1, definition);
        String contenuCase = modeleGrille.getContent(1, 1);
        assertEquals("def simple", contenuCase);
    }

    @Test
    public void testGetContenuCaseWithDefDouble() {
        ModeleGrille modeleGrille = new ModeleGrille(6, 6, 10, 1);
        Definition definition = new Definition("intitule", "direction");
        definition.setIntitule("double intitule");
        modeleGrille.setCase(1, 1, definition);
        String contenuCase = modeleGrille.getContent(1, 1);
        assertEquals("def double", contenuCase);
    }
}
