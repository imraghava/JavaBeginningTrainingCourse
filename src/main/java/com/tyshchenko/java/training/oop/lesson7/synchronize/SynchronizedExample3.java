package com.tyshchenko.java.training.oop.lesson7.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class SynchronizedExample3 {

    public static void main(String[] args) {
        final SynchronizedCounter counter = new SynchronizedCounter();

        List<Modifier> modifiers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Modifier modifier = new Modifier(counter);
            modifiers.add(modifier);
            modifier.start();
        }
        System.out.println(counter.value());
    }


    private static final class Modifier extends Thread {

        private final SynchronizedCounter counter;

        public Modifier(SynchronizedCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }

    private static final class SynchronizedCounter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public synchronized void decrement() {
            count--;
        }

        public synchronized int value() {
            return count;
        }
    }

}
