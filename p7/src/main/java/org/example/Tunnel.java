package org.example;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static final Semaphore tunnelSemaphore = new Semaphore(1);
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);

            tunnelSemaphore.acquire();
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            tunnelSemaphore.release();
        }
    }
}
