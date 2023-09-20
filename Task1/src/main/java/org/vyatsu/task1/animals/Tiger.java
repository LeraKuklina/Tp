package org.vyatsu.task1.animals;

public class Tiger extends Animal {
    public static int count;
    public Tiger(String name, int age, int maxRunDistance, int maxSwimDistance) {
        super(name, "Тигр",age, maxRunDistance, maxSwimDistance);
        count++;
    }
}
