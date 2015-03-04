package com.tyshchenko.java.training.oop.lesson8;

/**
 * @author Alexander Tyshchenko.
 */
public class StringHashcodeExample {

    public static void main(String[] args) {
        String str = "Test string";
        int hash = str.hashCode();
        System.out.println(hash);
    }

}
