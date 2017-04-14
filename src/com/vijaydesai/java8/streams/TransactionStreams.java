package com.vijaydesai.java8.streams;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by vijaydes on 4/10/2017.
 */
public class TransactionStreams {
    private static Trader raoul = new Trader("Raoul", "Cambridge");
    private static Trader mario = new Trader("Mario", "Milan");
    private static Trader alan = new Trader("Alan", "Cambridge");
    private static Trader brian = new Trader("Brian", "Cambridge");
    private static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        /**
         * 1 Find all transactions in the year 2011 and sort them by value (small to high).
         */
        List<Transaction> filteredTransactions = transactions.stream().filter(t -> t.getYear() == 2011).
                sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println("Transactions in the year 2011, sorted by value");
        filteredTransactions.stream().forEach(System.out::println);

        /**
         * 2 What are all the unique cities where the traders work?
         * */
        List<String> uniqueCities = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList());
        System.out.println("Unique cities where the traders work");
        uniqueCities.stream().forEach(System.out::println);

        /**
         * 3 Find all traders from Cambridge and sort them by name.
         * */
        List<Trader> cambridgeTraders = transactions.stream().map(Transaction::getTrader).
                filter(t -> "Cambridge".equals(t.getCity())).sorted(Comparator.comparing(Trader::getName)).distinct()
                .collect(Collectors.toList());
        System.out.println("Traders from Cambridge");
        cambridgeTraders.stream().forEach(System.out::println);

        /**
         * 4 Return a string of all traders’ names sorted alphabetically.
         * */
        System.out.println("Sorted trader names");
        transactions.stream().map(Transaction::getTrader).sorted(Comparator.comparing
                (Trader::getName)).map(Trader::getName).distinct().reduce(String::concat).ifPresent(System.out::println);

        /**
         *5 Are any traders based in Milan?
         * */
        if(transactions.stream().map(Transaction::getTrader).anyMatch(t -> "Milan".equals(t.getCity()))) {
            System.out.println("There are traders based out of Milan");
        }

        /**
         *6 Print all transactions’ values from the traders living in Cambridge.
         * */
        System.out.println("All transactions’ values from the traders living in Cambridge");
         transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(t -> t.getValue()).forEach(
                 System.out::println
         );

        /**
         *7 What’s the highest value of all the transactions?
         * */
        System.out.println("Highest transaction value");
        transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);

        /**
         *8 Find the transaction with the smallest value.
         * */
        System.out.println("Smallest transaction value");
        transactions.stream().map(Transaction::getValue).reduce(Integer::min).ifPresent(System.out::println);
    }
}
