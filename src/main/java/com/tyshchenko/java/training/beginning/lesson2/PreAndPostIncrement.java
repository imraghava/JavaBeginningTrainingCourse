package com.tyshchenko.java.training.beginning.lesson2;

/**
 * @author Alexander Tyshchenko.
 */
public class PreAndPostIncrement {
    public static void main(String[] args) {
        int num1;
        int num2;
        int num3;

        num1 = 100;
        num2 = ++num1;
        num3 = num2++ + ++num1;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);

        int a = new Integer(5);
    }
}
