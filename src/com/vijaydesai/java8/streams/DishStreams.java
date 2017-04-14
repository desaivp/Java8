package com.vijaydesai.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vijaydes on 4/10/2017.
 */
public class DishStreams {

    private static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
        System.out.println("All dishes");
        menu.stream().forEach(d -> System.out.println(d));

        System.out.println("\n\nTop 3 vegetarian dishes");
        List<Dish> top3Veg = menu.stream().filter(Dish::isVegetarian).limit(3).collect(Collectors.toList());
        top3Veg.stream().forEach(d -> System.out.println(d));

        System.out.println("\n\nFirst two meat dishes");
        List<Dish> meatDishes = menu.stream().filter(d -> Dish.Type.MEAT.equals(d.getType())).limit(2).collect(Collectors.toList());
        System.out.println(meatDishes);

        System.out.println("Printing out Dish name lengths");
        menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList()).stream().forEach(System.out::println);

        String[] words = {"Hello", "World"};
        System.out.println("Printing distinct characters");
        Arrays.asList(words).stream().map(w -> w.split("")).flatMap(Arrays::stream).
                distinct().collect(Collectors.toList()).stream().forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                        .map(n -> n * n)
                        .collect(Collectors.toList()).stream().forEach(System.out::println);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5);
        List<int []> pairs = numbers1.stream().flatMap(
                i -> numbers2.stream().map(j -> new int[] {i, j})
        ).collect(Collectors.toList());

        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        if(isHealthy) {
            System.out.println("Menu has all healthy options");
        }

        isHealthy = menu.stream().noneMatch(dish -> dish.getCalories() > 1000);
        if(isHealthy) {
            System.out.println("Menu has all healthy options");
        }

        boolean isVeganFriendly = menu.stream().anyMatch(dish -> dish.isVegetarian());

        if(isVeganFriendly) {
            System.out.println("Menu is vegan friendly");
        }

        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(System.out::println);

        menu.stream().filter(Dish::isVegetarian).findFirst().ifPresent(System.out::println);

        System.out.println("Total number of dishes in menu " + menu.stream().count());

        menu.stream().map(d -> d.getCalories()).reduce(Integer::sum).ifPresent(System.out::println);
    }

}
