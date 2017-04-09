package com.vijaydesai.java8.functional_interface;

import java.util.Arrays;
import java.util.Collections;

public class MethodReferencesTest {
    public static void main(String[] args) {
        String [] names = {"jeff", "jasmin", "ashita", "vijay", "mark", "Imsung", "Tianhao", "robert", "tina"};
        System.out.println("Before sorting: ");
        System.out.println(Arrays.asList(names));
        Collections.sort(Arrays.asList(names), String::compareToIgnoreCase);
        System.out.println(Arrays.asList(names));
    }
}
