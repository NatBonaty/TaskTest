package org.example;

import java.util.HashMap;

public class Pet {


    //    3. Домашние животные
//    Создайте класс Pet и его наследников Cat, Dog, Parrot.
//    Создайте отображение из домашних животных, где в качестве ключа выступает имя животного, а в качестве значения класс Pet.
//    Добавьте в отображение разных животных. Создайте метод выводящий на консоль все ключи отображения.
    String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    int age;

    Pet(String name, int age){
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        HashMap<String, Pet> map = new HashMap<>();

        Pet cat = new Cat("Bat", 7);
        Pet parrot = new Parrot("Shon", 9);
        Pet dog = new Dog("Lon", 5);

        map.put(cat.getName(), cat);
        map.put(dog.getName(), dog);
        map.put(parrot.getName(), parrot);
        printPet(map);
    }

    public static void printPet(HashMap<String, Pet> map){
        System.out.println(map.keySet());
    }
}


