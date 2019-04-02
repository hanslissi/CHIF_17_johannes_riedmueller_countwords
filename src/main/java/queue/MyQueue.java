/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import java.util.LinkedList;

/**
 *
 * @author johannesriedmueller
 */
public class MyQueue<T> {
    private final LinkedList<T> data = new LinkedList<>();
    private final int maxSize;
    private int size;
    
    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public void put(T value) throws FullException{
        if(size == maxSize ){
            throw new FullException();
        }
        data.add(value);
        size++;
    }
    
    public int size(){
        return size;
    }
    
    public T get() throws EmptyException{
        if( data.isEmpty() ){
            throw new EmptyException();
        }
        size--;
        return data.poll();
    }
}
