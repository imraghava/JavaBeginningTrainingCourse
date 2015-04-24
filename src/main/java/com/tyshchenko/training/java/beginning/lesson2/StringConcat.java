package com.tyshchenko.training.java.beginning.lesson2;

/**
 * @author Alexander Tyshchenko.
 */
public class StringConcat {
    public static void main(String[] args) {
        String s1 = "test";
        String s2 = "test";

        String result = s1 + s2;

        String[] strings = {"1", "2", "3", "4"};

        double doubles[] = { 3.14, 2, 5.5 };

        for (int i = 0; i < strings.length; i++) {
            result += strings[i];
        }
        System.out.println(result);
    }
}
