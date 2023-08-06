package Tests;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import main.Fichier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FichierTest {
	private Fichier dictionnaire;

    @Before
    public void setUp() {
        dictionnaire = new Fichier();
    }

    @Test
    public void testRechercherMot() {
    	ArrayList<String> motsTrouves = dictionnaire.rechercherMot("^.{4}y.$");
    	assertEquals(10, motsTrouves.size());
    }
}
