package org.vyatsu.task1.animals;

public class Spider extends Arthropods {
    public static int count;
    public Spider(String name, int age, int maxRunDistance,int maxSwimDistance) {
        super(name, "Паук",age, maxRunDistance, maxSwimDistance);
        count++;
    }
    public String dangerous() {
        if (this.getType() == "Паук") return "Для человека большинство из них, кроме нескольких видов, опасности не представляет из-за слабого яда и неспособности прокусить кожу человека.";
        return null;
    }
}