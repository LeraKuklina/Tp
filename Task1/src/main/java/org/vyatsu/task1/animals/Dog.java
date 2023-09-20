package org.vyatsu.task1.animals;

public class Dog extends Animal {
    public static int count;
    public Dog(String name, int age, int maxRunDistance,int maxSwimDistance) {
        super(name, "Собака",age, maxRunDistance, maxSwimDistance);
        count++;
    }
}