package com.tyshchenko.java.training.beginning.lesson4;

/**
 * @author Alexander Tyshchenko.
 */
public class NestedForExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print((i * j) + " ");
            }
        }
    }
}