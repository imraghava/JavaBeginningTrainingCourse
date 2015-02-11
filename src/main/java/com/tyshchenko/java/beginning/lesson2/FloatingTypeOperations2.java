package com.tyshchenko.java.beginning.lesson2;

/**
 * @author Alexander Tyshchenko.
 */
public class FloatingTypeOperations2 {
    public static void main(String[] args) {
        double f = 0.0;
        for (int i=1; i <= 10; i++) {
            f += 0.1;
        }
        System.out.println(f);
        System.out.println(f == 1.0);
    }
}

