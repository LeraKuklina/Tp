package org.example;

public class Human implements Contestant {
    private String name;
    private int runLimit;
    private int jumpLimit;
    private static int superJumpCount = 2; // Общее количество экстра прыжков

    public Human(String name, int runLimit, int jumpLimit) {
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
        } else if (superJumpCount > 0) {
            superJumpCount--;
            System.out.println(name + " использовал супер прыжок и преодолел высоту " + height + " метров! Осталось супер прыжков: " + superJumpCount);
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