package com.vijaydesai.java8.functinal_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    @FunctionalInterface
    interface Predicte<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(final List<T> list, final Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<T>();
        for (T listItem : list) {
            if(predicate.test(listItem)) {
                filteredList.add(listItem);
            }
        }
        return filteredList;
    }

    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.trim().isEmpty();
        String[] stringArray = {"", "Abc", "DEF", "  ", "MongoDB"};
        System.out.println("Actual List "+ Arrays.asList(stringArray));
        List<String> filteredList = filter(Arrays.asList(stringArray), nonEmptyStringPredicate);
        System.out.println("Filtered non empty Strings List "+ filteredList);
        filteredList =  filter(Arrays.asList(stringArray), (String s) -> s.trim().isEmpty());
        System.out.println("Filtered non empty Strings List "+ filteredList);
    }
}
