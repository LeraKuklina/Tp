package org.vyatsu.task1.animals;

public class Cancer extends Arthropods {
    public static int count;
    public Cancer(String name, int age, int maxRunDistance,int maxSwimDistance) {
        super(name, "Рак",age, maxRunDistance, maxSwimDistance);
        count++;
    }
    public String dangerous() {
        if (this.getType() == "Рак") return "Раки имеют особенность накапливать в организме стойкие органические загрязнители и пестициды, при употреблении «заболевших» особей у человека возникает опасность неспецифического пищевого отравления.";
        return null;
    }
}