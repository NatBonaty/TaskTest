package org.example;

public class Parrot extends Pet{
    Parrot(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
