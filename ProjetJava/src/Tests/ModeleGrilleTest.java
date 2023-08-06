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
    
    @BeforeEach
    public void setUp() {
        modeleGrille = new ModeleGrille(6, 10, 30, 1);
    }

    @Test
    public void testGetNbCaseVideHorizontalDirect() {
        int x = 1;
        int y = 1;
        ModeleGrille.Direction direction = ModeleGrille.Direction.HORIZONTAL;
        int result = modeleGrille.getNbCaseVide(x, y, direction);
        assertEquals(9, result);
    }

    @Test
    public void testGetNbCaseVideHorizontalIndirect() {
        int x = 1;
        int y = 1;
        ModeleGrille.Direction direction = ModeleGrille.Direction.HORIZONTAL_INDIRECT;
        int result = modeleGrille.getNbCaseVide(x, y, direction);
        assertEquals(10, result);
    }

    @Test
    public void testGetNbCaseVideVerticalDirect() {
        int x = 1;
        int y = 1;
        ModeleGrille.Direction direction = ModeleGrille.Direction.VERTICAL;
        int result = modeleGrille.getNbCaseVide(x, y, direction);
        assertEquals(5, result);
    }

    @Test
    public void testGetNbCaseVideVerticalIndirect() {
        int x = 1;
        int y = 1;
        ModeleGrille.Direction direction = ModeleGrille.Direction.VERTICAL_INDIRECT;
        int result = modeleGrille.getNbCaseVide(x, y, direction);
        assertEquals(6, result);
    }

    @Test
    public void testIsDirectionEmptyVerticalIndirect() {
        int x = 1;
        int y = 6;
        int numberOfLetters = 6;
        ModeleGrille.Direction direction = ModeleGrille.Direction.VERTICAL_INDIRECT;
        boolean result = modeleGrille.isDirectionEmpty(x, y, numberOfLetters, direction);
        assertEquals(true, result);

        // Check the letter at (x, y - 1), which should be 'y'
        assertEquals("y", modeleGrille.getCase(x, y - 1).getContent());
    }
}
