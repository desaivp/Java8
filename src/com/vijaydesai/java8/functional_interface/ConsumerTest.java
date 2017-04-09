package com.vijaydesai.java8.functional_interface;

import java.util.Arrays;
import java.util.List;

public class ConsumerTest {

    @FunctionalInterface
    interface Consumer<T> {
        void operate(T t);
    }

    static <T> void forEach(List<T> items, Consumer<T> consumer) {
        for (T item : items) {
            consumer.operate(item);
        }
    }

    public static void main(String[] args) {
        Double [] rawItemPrices = {6.98, 3.22, 1.89, 3.65};
        System.out.println("Raw prices: " + Arrays.asList(rawItemPrices));
        System.out.print("Rounded prices: [");
        forEach(Arrays.asList(rawItemPrices), (Double d) -> System.out.print(Math.ceil(d)+ " "));
        System.out.println("]");
    }
}
