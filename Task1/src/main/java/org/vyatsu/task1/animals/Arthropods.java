package org.vyatsu.task1.animals;

import java.util.Objects;

public abstract class Arthropods extends Animal {
    private String mes;

    public Arthropods(String name, String type, int age, int maxRunDistance, int maxSwimDistance, String mes) {
        super(name, type, age, maxRunDistance, maxSwimDistance);
        this.mes = mes;

    }

    public void dangerous() {
        System.out.println(this.getType() + " " + this.getName() + " " + mes);
    }
}