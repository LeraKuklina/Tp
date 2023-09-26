package org.vyatsu.task1;

import org.vyatsu.task1.animals.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");


        Animal[] animals = {
                new Cat("Barsik", 5, 200, 0),
                new Cat("Murzik", 2, 200, 0),
                new Dog("Bobik", 3, 300, 10),
                new Tiger("Pol", 7, 400, 50),
                new Tiger("Ivan", 4, 400, 50),
                new Cancer("Oleg", 3, 50, 10, "Раки имеют особенность накапливать в организме стойкие органические загрязнители и пестициды, при употреблении «заболевших» особей у человека возникает опасность неспецифического пищевого отравления."),
                new Spider("Gosha", 1, 20, 0, " Для человека большинство из них, кроме нескольких видов, опасности не представляет из-за слабого яда и неспособности прокусить кожу человека. "),
                new Fly("Igor", 1, 10, 0, " Муха может быть переносчиком различных болезней. ", 25)
        };
        for (Animal a : animals) {
            a.run(170);
            a.swim(150);
        }
        ((Fly) animals[7]).flyy(20);

        System.out.println("Количество котов " + Cat.count);
        System.out.println("Количество собак " + Dog.count);
        System.out.println("Количество тигров " + Tiger.count);

        ((Cancer) animals[5]).dangerous();
        ((Spider) animals[6]).dangerous();
        ((Fly) animals[7]).dangerous();

    }
}