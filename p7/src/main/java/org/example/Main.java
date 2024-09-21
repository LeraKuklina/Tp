package org.example;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static final int CARS_COUNT = 6;
    private static final CyclicBarrier startBarrier = new CyclicBarrier(CARS_COUNT, () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"));
    private static final ConcurrentLinkedQueue<String> winnersQueue = new ConcurrentLinkedQueue<>();
    private static final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < CARS_COUNT; i++) {
            cars[i] = new Car(race, 50 + (int) (Math.random() * 5), startBarrier, winnersQueue);
        }

        for (int i = 0; i < CARS_COUNT; i++) {
            new Thread(cars[i]).start();
        }

        while (winnersQueue.size() < CARS_COUNT) {
            Thread.sleep(100);
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        synchronized (monitor) {
            String firstPlace = winnersQueue.poll();
            String secondPlace = winnersQueue.poll();
            String thirdPlace = winnersQueue.poll();

            if (firstPlace != null) System.out.println(firstPlace + " занял 1 место");
            if (secondPlace != null) System.out.println(secondPlace + " занял 2 место");
            if (thirdPlace != null) System.out.println(thirdPlace + " занял 3 место");
        }
    }
}
