package com.tyshchenko.java.beginning.lesson5;

/**
 * author Alexander Tyshchenko.
 */
public class AssertionExample2 {
    public static void main(String[] args) {
        int a = 100;

        assert a > 100 : "Result must be 100";
        System.out.println("done");
    }
}


