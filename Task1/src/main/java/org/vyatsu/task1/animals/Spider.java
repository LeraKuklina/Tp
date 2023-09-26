package org.vyatsu.task1.animals;

public class Spider extends Arthropods {
    public static int count;

    public Spider(String name, int age, int maxRunDistance, int maxSwimDistance, String mes) {
        super(name, "Паук", age, maxRunDistance, maxSwimDistance, mes);
        count++;
    }
}