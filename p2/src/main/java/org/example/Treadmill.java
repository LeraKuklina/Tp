package org.example;

public class Treadmill implements Obstacle {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    // Метод для проверки, может ли участник пробежать дорожку
    @Override
    public boolean overcome(Contestant contestant) {
        return contestant.run(length);
    }

}