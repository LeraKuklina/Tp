package org.example;

@Table(title = "hamsters12")
public class Hamster {

    @Column(name = "name", type = "TEXT")
    private String name;

   // @Column(name = "age", type = "INTEGER")
    private int age;

    @Column(name = "color", type = "TEXT")
    private HamsterColor color;

    public Hamster(String name, int age, HamsterColor color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
