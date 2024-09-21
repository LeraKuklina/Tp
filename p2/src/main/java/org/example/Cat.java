package org.example;

public class Cat implements Contestant {
    private String name;
    private int runLimit;
    private int jumpLimit;

    public Cat(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " успешно пробежал " + distance + " метров.");
            return true;
        } else {
            System.out.println(name + " не смог пробежать " + distance + " метров.");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height <= jumpLimit) {
            System.out.println(name + " успешно прыгнул на высоту " + height + " метров.");
            return true;
        } else {
            System.out.println(name + " не смог прыгнуть на высоту " + height + " метров.");
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}