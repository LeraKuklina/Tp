package org.vyatsu.task1.animals;

public class Fly extends Arthropods {
    public static int count;
    public Fly(String name, int age, int maxRunDistance,int maxSwimDistance) {
        super(name, "Муха",age, maxRunDistance, maxSwimDistance);
        count++;
    }
    public String dangerous() {
        if (this.getType() == "Муха") return "Муха может быть переносчиком различных болезней.";
        return null;
    }
}