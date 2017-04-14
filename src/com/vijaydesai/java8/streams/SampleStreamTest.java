package com.vijaydesai.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by vijaydes on 4/13/2017.
 */
public class SampleStreamTest {
    public static void main(String []args) {

        /**
         * Greedy URL matcher
         * */
        List<String> urls = Arrays.asList("a/", "a/b/c/", "a/d", "a/b/c/d/e/f");
        String urlToBeMatched = "a/b/c/j/k/l";
        Optional<String> matchedUrlOption = urls.stream().sorted(Comparator.reverseOrder()).filter(u -> urlToBeMatched
                .contains
                        (u)).findFirst();
        String matchedUrl = matchedUrlOption.get();
        System.out.println(matchedUrl);

        /**
         * Pythagorian triplets
         * */
        Stream<double[]> tripletsStream = IntStream.rangeClosed(1, 100).boxed().flatMap(
                a -> IntStream.rangeClosed(a, 100).
                        mapToObj(b -> new double[] {a, b, Math.sqrt(a*a + b*b)})).filter(
                                t -> t[2] % 1.0 == 0
        );

        tripletsStream.forEach(
                t -> System.out.println((int)t[0] +", "+(int)t[1] +", "+(int)t[2])
        );

        /**
         * Pythagorian triplets using infinite streams
         * */
        Stream.iterate(new int[] {0, 1}, t-> new int[] {t[1], t[0]+t[1]}).limit(20).forEach(
                t -> System.out.println(t[0])
        );

        IntSupplier fib = new IntSupplier() {
            int prev = 0;
            int curr = 1;
            @Override
            public int getAsInt() {
                int oldPrev = prev;
                int newVal = prev + curr;
                prev = curr;
                curr = newVal;
                return oldPrev;
            }
        };

        IntStream.generate(fib).limit(20).forEach(
                System.out::println
        );
    }
}
