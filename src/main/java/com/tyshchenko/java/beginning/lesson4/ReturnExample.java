package com.tyshchenko.java.beginning.lesson4;

/**
 * @author Alexander Tyshchenko.
 */
public class ReturnExample {
    public static void main(String[] args) {
        boolean ret = true;

        System.out.println("Before return");

        if (ret) {
            return;
        }

        System.out.println("Unreachable code");
    }
}


