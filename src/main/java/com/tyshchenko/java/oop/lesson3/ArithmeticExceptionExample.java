package com.tyshchenko.java.oop.lesson3;

/**
 * @author Alexander Tyshchenko.
 */
public class ArithmeticExceptionExample {

    private static void divide() {
        try {
            int x = 1, y = 0;
            int z = x / y;
        } catch (ArithmeticException e) {
            System.out.println("division by 0");
        }
    }

    public static void main(String[] args) {
        divide();
    }

}
