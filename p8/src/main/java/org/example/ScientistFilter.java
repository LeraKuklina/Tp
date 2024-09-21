package org.example;
import java.util.*;
import java.util.stream.*;

public class ScientistFilter {
    public static void main(String[] args) {
        Scientist[] scientists = {
                new Scientist("Эйнштейн", 1879, "Мужчина", "Физика"),
                new Scientist("Кюри", 1867, "Женщина", "Химия"),
                new Scientist("Ньютон", 1643, "Мужчина", "Физика"),
                new Scientist("Хокинг", 1942, "Мужчина", "Физика"),
                new Scientist("Тесла", 1856, "Мужчина", "Инженерия")
        };

        String fieldOfScience = "Физика";
        int N = 3;

        System.out.println(N + " ученых зовут: " + String.join(", ",
                Arrays.stream(scientists)
                        .filter(s -> s.getGender().equals("Мужчина") && s.getFieldOfScience().equals(fieldOfScience))
                        .sorted(Comparator.comparingInt(Scientist::getBirthYear).reversed())
                        .limit(N)
                        .map(Scientist::getLastName)
                        .collect(Collectors.toList())) + ";");
    }
}
