package com.tyshchenko.java.oop.lesson3;

/**
 * @author Alexander Tyshchenko.
 */
public class ExceptionBasketExample {

    public static void divide() {
        try {
            int[] a = new int[2];
            a[0] = 22 / 2;
            a[1] = 33 / 3;
            a[2] = 33 / 0;
        }

        catch (ArithmeticException e) {
            System.out.println("Division by ZERO");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }
        catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public static void divideSinceJava7() {
        try {
            int[] a = new int[2];
            a[0] = 22 / 2;
            a[1] = 33 / 3;
            a[2] = 33 / 0;
        }
        catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        divide();
        System.out.println();
        divideSinceJava7();
    }

}
