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

    public HashMap<String, Integer> countWords() throws Exception {
        HashMap<String, Integer> wordsMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(inputFilename));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] data = line.split("[^a-zA-Z']+");
            for (String string : data) {
                if (wordsMap.containsKey(string)) {
                    wordsMap.put(string, wordsMap.get(string) + 1);
                } else {
                    wordsMap.put(string, 1);
                }
            }
        }

        Object[] keys = wordsMap.keySet().toArray();

        for (Object key : keys) {
            if (wordsMap.get(key.toString()) == 1) {
                wordsMap.remove(key.toString());
            }
        }

        return wordsMap;
    }
}
