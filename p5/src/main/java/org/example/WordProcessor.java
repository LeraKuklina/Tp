package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordProcessor {
    public static Map<String, Integer> processWords(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
}
