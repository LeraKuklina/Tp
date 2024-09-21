package org.example;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Contestant contestant) {
        return contestant.jump(height);
    }
}