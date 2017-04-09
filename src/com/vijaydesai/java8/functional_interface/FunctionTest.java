package com.vijaydesai.java8.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionTest {

    @FunctionalInterface
    interface Function<T, R> {
        R apply(T t);
    }

    public static <T, R> List<R> map(List<T> items, Function<T, R> function) {
        List<R> resultList = new ArrayList<R>();
        for(T item : items) {
            resultList.add(function.apply(item));
        }
        return resultList;
    }

    public static void main(String[] args) {
        String [] namesList = {"pralhad", "vijay", "buddha", "somebody"};
        System.out.println("Lengths : "+ map(Arrays.asList(namesList),(String str) -> str.length()));
        System.out.println("Capitalized names : "+ map(Arrays.asList(namesList),(String input) -> input.substring(0, 1).toUpperCase() + input.substring(1)));
    }
}
