package com.tyshchenko.java.beginning.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class CodeSpeedTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < Short.MAX_VALUE; i++) {
            System.out.println(i);
        }

        long res = System.currentTimeMillis() - start;
        System.out.println("Result " + res);
    }
}
