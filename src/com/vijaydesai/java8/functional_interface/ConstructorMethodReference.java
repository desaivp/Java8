package com.vijaydesai.java8.functional_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ConstructorMethodReference {

    static Map<String, BiFunction<String, Integer, Fruit>> fruitMap = new HashMap<String, BiFunction<String, Integer, Fruit>> ();

    static interface Fruit {}

    static class Orange implements Fruit{
        String color;
        int weight;

        public Orange(String color, int weight) {
            this.color = color.substring(0, 1).toUpperCase() + color.substring(1);
            this.weight = weight;
        }

        @Override
        public String toString() {
            return color+" orange weighing "+ weight + " lbs.";
        }
    }

    static class Banana implements Fruit{
        String color;
        int weight;

        public Banana(String color, int weight) {
            this.color = color.substring(0, 1).toUpperCase() + color.substring(1);
            this.weight = weight;
        }

        @Override
        public String toString() {
            return color+" banana weighing "+ weight + " lbs.";
        }
    }

    static class Apple implements Fruit{
        String color;
        int weight;

        public Apple(String color, int weight) {
            this.color = color.substring(0, 1).toUpperCase() + color.substring(1);
            this.weight = weight;
        }

        @Override
        public String toString() {
            return color+" apple weighing "+ weight + " lbs.";
        }
    }

    static {
        fruitMap.put("yellow", Banana::new);
        fruitMap.put("orange", Orange::new);
        fruitMap.put("green", Apple::new);
        fruitMap.put("red", Apple::new);
    }

    public static Fruit getFruit(String color, int weight) {
        return fruitMap.get(color.toLowerCase()).apply(color, weight);
    }

    public static void main(String[] args) {
        String [] colors = {"yellow", "orange", "green", "red"};
        System.out.println("Random fruits");
        for(int i=0; i<20; i++) {
            int weight = (int) (Math.random() * 200 + 150);
            String color = colors[(int) (Math.random() * 4)];
            System.out.println(getFruit(color, weight));
        }
    }
}
