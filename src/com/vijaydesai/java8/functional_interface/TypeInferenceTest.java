package com.vijaydesai.java8.functional_interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TypeInferenceTest {
    static class Apple {
        private int weight;
        private String color;
        private double price;

        int getWeight() {
            return weight;
        }

        void setWeight(int weight) {
            this.weight = weight;
        }

        String getColor() {
            return color;
        }

        void setColor(String color) {
            this.color = color;
        }

        Double getPrice() {
            return price;
        }

        void setPrice(double price) {
            this.price = price;
        }

        Apple(int weight, String color, double price) {
            this.weight = weight;
            this.color = color;
            this.price = price;
        }

        @Override
        public String toString() {
            return color+" apple weighing " + " gms costs $"+price+"\n";
        }

    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple(150, "green", 3.00));
        apples.add(new Apple(200, "red", 2.90));
        apples.add(new Apple(100, "green", 3.50));
        apples.add(new Apple(153, "red", 3.53));
        apples.add(new Apple(150, "red", 3.00));
        System.out.println("Before sorting: ");
        System.out.println(apples);
        System.out.println("After sorting");
        Comparator<Apple> priceComparator = (a1, a2) -> a1.getPrice().compareTo(a2.getPrice());
        Collections.sort(apples, priceComparator);
        System.out.println(apples);
    }
}
