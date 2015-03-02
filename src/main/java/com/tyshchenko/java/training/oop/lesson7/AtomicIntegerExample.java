package com.tyshchenko.java.training.oop.lesson7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alexander Tyshchenko.
 */
public class AtomicIntegerExample {

    private volatile int counter1;
    private AtomicInteger counter2;


    public int getNextUniqueIndexNotAtomic() {
        return counter1++; // Not counter2, multiple threads could get the same result
    }

    public int getNextUniqueIndex() {
        return counter2.getAndIncrement();
    }
}
