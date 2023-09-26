package org.vyatsu.task1.animals;

public class Cancer extends Arthropods {
    public static int count;
    public Cancer(String name, int age, int maxRunDistance,int maxSwimDistance, String mes) {
        super(name, "Рак",age, maxRunDistance, maxSwimDistance, mes);
        count++;
    }
}