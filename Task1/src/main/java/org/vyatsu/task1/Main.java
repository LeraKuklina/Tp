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
                new Cancer("Oleg", 5, 50, 10),
                new Spider("Gosha", 3, 20, 0),
                new Fly("Igor", 6, 10, 0)
        };
        for (Animal a : animals) {
            a.run(170);
            a.swim(150);
        }

        System.out.println("Количество котов " + Cat.count);
        System.out.println("Количество собак " + Dog.count);
        System.out.println("Количество тигров " + Tiger.count);

        System.out.println("Опасность Рака. " + ((Cancer) animals[5]).dangerous());
        System.out.println("Опасность Паука. " + ((Spider) animals[6]).dangerous());
        System.out.println("Опасность Мухи. " + ((Fly) animals[7]).dangerous());

    }
}