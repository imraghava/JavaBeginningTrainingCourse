package com.tyshchenko.java.training.oop.lesson7._selfstudy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Alexander Tyshchenko.
 *
 * https://blogs.oracle.com/CoreJavaTechTips/entry/get_netbeans_6
 */
public class CallableExample {

    public static void main(String args[]) throws Exception {
        String[] words = {"apple", "pear", "ukraine"};
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<Integer>> futures = new HashSet<>(words.length);

        Arrays.stream(words).forEach(
            (e) -> {
                Callable<Integer> callable = new WordLengthCallable(e);
                Future<Integer> future = pool.submit(callable);
                futures.add(future);
            }
        );

        int sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        System.out.printf("The sum of lengths is %s\n", sum);
        System.exit(sum);
    }

    private static class WordLengthCallable implements Callable {
        private String word;
        public WordLengthCallable(String word) {
            this.word = word;
        }
        public Integer call() {
            return Integer.valueOf(word.length());
        }
    }

}
