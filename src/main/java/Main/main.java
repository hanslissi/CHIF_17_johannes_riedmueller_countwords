/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Consumer.Consumer;
import Producer.Producer;
import bl.Book;
import java.io.File;
import java.io.IOException;
import queue.MyQueue;

/**
 *
 * @author johannesriedmueller
 */
public class main {

    public static void main(String[] args) throws IOException {
        MyQueue<Book> queue = new MyQueue<>(3);

        Producer producer = new Producer(queue, new File("./files"));

        Consumer consumer1 = new Consumer(queue);

        new Thread(producer, "Producer").start();
        new Thread(consumer1, "Consumer 1").start();
        
    }
}
