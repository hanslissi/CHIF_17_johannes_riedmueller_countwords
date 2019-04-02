/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.HashMap;
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
        Book book = new Book("./files/testText.txt", "");
        HashMap<String, Integer> map = book.countWords();
        for (String string : map.keySet()) {
            System.out.println(string+": "+map.get(string));
        }
    }
    
}
