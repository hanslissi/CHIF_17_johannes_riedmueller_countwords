package bl;

import java.util.HashMap;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author johannesriedmueller
 */
public class BookTest {

    public BookTest() {
    }

    /**
     * Test of countWords method, of class Book.
     */
    @Test
    public void testCountWords() throws Exception {
        Book book = new Book("./files/testText.txt");
        HashMap<String, Integer> map = book.countWords();
        String result = "";
        for (String string : map.keySet()) {
            result += string + ": " + map.get(string) + "\n";
        }
        String expected = "hallo: 3\nJohannes: 2\nbin: 2\n";
        assertTrue(result.equals(expected));
    }

}
