package org.example;

public class Main {
    public static void main(String[] args) {
// Создаем участников
        Contestant[] contestants = {
                new Human("Вася", 500, 2),
                new Cat("Кот Степан", 200, 3),
                new Robot("Робот Макс", 1000, 1),
                new Robot("Робот Макс1", 1000, 1)
        };

// Создаем препятствия
        Obstacle[] obstacles = {
                new Wall(3),
//                new Wall(3),
                new Treadmill(300),
                new Wall(3)
        };

// Проходим препятствия
        for (Contestant contestant : contestants) {
            boolean passedAll = true;
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(contestant)) {
                    System.out.println(contestant.getName() + " не смог преодолеть препятствие.");
                    passedAll = false;
                    break;
                }
            }
            if (passedAll) {
                System.out.println(contestant.getName() + " прошел все препятствия!");
            }
        }
    }
}