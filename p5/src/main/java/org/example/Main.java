package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] words = {"яблоко", "банан", "яблоко", "апельсин", "киви", "манго", "слива", "слива", "апельсин", "киви"};
        Map<String, Integer> wordCount = WordProcessor.processWords(words);
        System.out.println("Уникальные слова и их количество: ");
        System.out.println(wordCount.entrySet());

        Schedule schedule = new Schedule();
        schedule.add("Понедельник", "Математика");
        schedule.add("Понедельник", "Физика");
        schedule.add("Вторник", "Программирование");
        schedule.add("Среда", "Химия");
        schedule.add("Среда", "Английский");
        schedule.add("Суббота", "Математика");
        schedule.add("Понедельник", "Английский");

        schedule.printSchedule();
    }
}



