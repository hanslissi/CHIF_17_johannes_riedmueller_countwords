/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 *
 * @author johannesriedmueller
 */
public class Book {
    private final String inputFilename;
    private final String text;

    public Book(String inputFilename, String text) {
        this.inputFilename = inputFilename;
        this.text = text;
    }
    
    public HashMap<String, Integer> countWords() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(inputFilename));
        
    }
}
