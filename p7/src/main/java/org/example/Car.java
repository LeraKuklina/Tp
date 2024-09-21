package org.example;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier startBarrier;
    private ConcurrentLinkedQueue<String> winnersQueue;

    static {
        CARS_COUNT = 0;
    }
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier startBarrier, ConcurrentLinkedQueue<String> winnersQueue) {
        this.race = race;
        this.speed = speed;
        this.startBarrier = startBarrier;
        this.winnersQueue = winnersQueue;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");

            startBarrier.await();

            System.out.println(this.name + " стартовал");

            for (Stage stage : race.getStages()) {
                stage.go(this);
            }
            winnersQueue.add(this.name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
