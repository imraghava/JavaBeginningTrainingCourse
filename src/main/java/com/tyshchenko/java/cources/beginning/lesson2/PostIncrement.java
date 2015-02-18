package com.tyshchenko.java.cources.beginning.lesson2;

/**
 * @author Alexander Tyshchenko.
 */
public class PostIncrement {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;

        System.out.println("num1 = " + (num1++));
        System.out.println("num2 = " + (num2++));

        System.out.println("num1 = " + num1++);
        System.out.println("num2 = " + num2++);
    }
}
