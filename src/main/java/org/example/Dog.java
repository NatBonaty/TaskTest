package org.example;

public class Dog extends Pet{
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
