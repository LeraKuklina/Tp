package org.vyatsu.task1.animals;

public class Fly extends Arthropods {
    public static int count;
    private int maxFlydistance;

    public Fly(String name, int age, int maxRunDistance, int maxSwimDistance, String mes,int maxFlyDistance) {
        super(name, "Муха", age, maxRunDistance, maxSwimDistance, mes);
        count++;
        this.maxFlydistance = maxFlyDistance;
    }
    public void flyy(
            int flyDist) {
        if (maxFlydistance == 0) {
            System.out.println( " не умеет летать ");
        }
        else if (flyDist >= maxFlydistance) {
            System.out.println( "Igor не пролетела " + flyDist);
        }
        else
        {
            System.out.println( "Igor пролетела " + flyDist);
        }
    }
}


