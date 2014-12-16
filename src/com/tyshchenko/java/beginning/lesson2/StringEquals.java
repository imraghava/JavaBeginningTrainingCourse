package com.tyshchenko.java.beginning.lesson2;

/**
 * author Alexander Tyshchenko.
 */
public class StringEquals {
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "abcd";
        String s3 = "abcd";

        System.out.println(s3.equals(s1));
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));
        System.out.println(s1.equalsIgnoreCase(s2));

        System.out.println(((short) 'A'));
    }
}
