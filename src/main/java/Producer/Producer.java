/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer;

import bl.Book;
import java.io.File;
import queue.MyQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import queue.FullException;

/**
 *
 * @author johannesriedmueller
 */
public class Producer implements Runnable {

    private final MyQueue<Book> queue;
    private final File folderPath;

    public Producer(MyQueue<Book> queue, File folderPath) {
        this.queue = queue;
        this.folderPath = folderPath;
    }

    @Override
    public void run() {
        for (File file : folderPath.listFiles()) {
            boolean isInQueue = false;
            while (!isInQueue) {
                if (!file.isDirectory()) {
                    synchronized (queue) {
                        try {
                            queue.put(new Book(file.getAbsolutePath()));
                            System.out.println("File: " + file.getAbsolutePath() + "\n");
                            queue.notifyAll();
                            isInQueue = true;
                        } catch (FullException full) {
                            try {
                                queue.wait();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        }
    }

}
