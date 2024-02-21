package org.example;

import java.util.HashMap;

public class Product {
//
//    1) Создать HashMap
//    Создайте HashMap, содержащий пары значений  - имя игрушки и объект игрушки (класс Product).
//    Перебрать и распечатать пары значений - entrySet().
//    Перебрать и распечатать набор из имен продуктов  - keySet().
//    Перебрать и распечатать значения продуктов - values().
//    Для каждого перебора создать свой метод.
    private String type;
    private int agePlus;

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", agePlus=" + agePlus +
                '}';
    }

    public Product(String type, int agePlus){
        this.type = type;
        this.agePlus = agePlus;
    }



    public static void main(String[] args) {
        HashMap<String, Product> map = new HashMap<>();
        map.put("Аня", new Product("Кукла", 6));
        map.put("Медвежонок", new Product("Мягкая игрушка", 0));
        map.put("Кубик Pубика", new Product("Головоломка", 12));
        map.put("Древний Ужас", new Product("Настольная игра", 18));
        entrySet(map);
        keySet(map);
        values(map);
    }

    public static void entrySet(HashMap<String, Product> map){
        System.out.println("Пары значений: " + map.entrySet());
    }

    public static void keySet(HashMap<String, Product> map){
        System.out.println("Ключи: " + map.keySet());
    }

    public static void values(HashMap<String, Product> map){
        System.out.println("Значения продуктов: " + map.values());
    }





}