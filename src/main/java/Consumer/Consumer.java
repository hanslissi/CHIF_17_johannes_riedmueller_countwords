/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumer;

import bl.Book;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import queue.EmptyException;
import queue.MyQueue;

/**
 *
 * @author johannesriedmueller
 */
public class Consumer implements Runnable {

    private final MyQueue<Book> queue;

    public Consumer(MyQueue<Book> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            Book book = null;
            synchronized(queue){
                try{
                    book = queue.get();
                    queue.notifyAll();
                }
                catch(EmptyException empty){
                    try {
                        queue.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    continue;
                }
            }
            try {
                HashMap<String, Integer> wordsMap = book.countWords();
                StringBuilder sb = new StringBuilder();
                for (String string : wordsMap.keySet()) {
                    sb.append(string);
                    sb.append(": ");
                    sb.append(wordsMap.get(string));
                    sb.append("\n");
                }
                System.out.println(sb+"\n---------------------------------------");
                System.out.println(queue.size());
            } catch (Exception ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
