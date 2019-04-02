/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import bl.Book;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author johannesriedmueller
 */
@RunWith(value = Parameterized.class)
public class MyQueueTest {

    public MyQueueTest() {
    }

    @Parameter(value = 0)
    public int maxSize;

    @Parameters(name = "{index}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
            {3},
            {5},
            {1},
            {10}
        });
    }

    @Test
    public void testPut() {
        Book book = new Book("./files/testText.txt");
        MyQueue<Book> queue = new MyQueue<>(maxSize);
        for (int i = 1; i <= maxSize + 1; i++) {
            try {
                queue.put(book);
            } catch (FullException ex) {
                if (i - 1 == maxSize) {
                    assertTrue(true);
                }
            }
        }
    }

    /**
     * Test of get method, of class MyQueue.
     */
    @Test
    public void testGet() {
        Book book = new Book("./files/testText.txt");
        MyQueue<Book> queue = new MyQueue<>(maxSize);
        for (int i = 1; i <= maxSize; i++) {
            try {
                queue.put(book);
            } catch (FullException ex) {
                //just to catch...
            }
        }
        for (int i = maxSize; i >= 0; i--) {
            try {
                queue.get();
            } catch (EmptyException ex) {
                if (i == 0) {
                    assertTrue(true);
                }
            }
        }
    }

}
