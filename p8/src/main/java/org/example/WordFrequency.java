package org.example;

import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {
        String[] words = {"яблоко", "банан", "яблоко", "апельсин", "банан", "банан", "груша", "яблоко", "груша", "апельсин", "аренда", "аренда", "аренда", "аренда"};

        System.out.println(
                (Arrays.stream(words)
                        .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                        .entrySet().stream()
                        .collect(Collectors.groupingBy(Map.Entry::getValue))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByKey())
                        .map(Map.Entry::getValue)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(Map.Entry::getKey)
                        .sorted()
                        .collect(Collectors.toList()).size() == 1)
                        ? "Наиболее часто встречающееся слово: " + Arrays.stream(words)
                        .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                        .entrySet().stream()
                        .collect(Collectors.groupingBy(Map.Entry::getValue))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByKey())
                        .map(Map.Entry::getValue)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(Map.Entry::getKey)
                        .sorted()
                        .collect(Collectors.toList()).get(0)
                        : "Наиболее часто встречающиеся слова: " + String.join(", ", Arrays.stream(words)
                        .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                        .entrySet().stream()
                        .collect(Collectors.groupingBy(Map.Entry::getValue))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByKey())
                        .map(Map.Entry::getValue)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(Map.Entry::getKey)
                        .sorted()
                        .collect(Collectors.toList()))
        );
    }
}
