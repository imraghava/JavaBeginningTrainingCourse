package com.tyshchenko.java.beginning.lesson2;

/**
 * @author Alexander Tyshchenko.
 */
public class StringComparison {
    public static void main(String[] args) {

        String test1 = "test";
        String test2 = "test";
        String test3 = new String("test");
        String test4 = new String("test").intern();

        System.out.println(test1 == test2);
        System.out.println(test2 == test3);
        System.out.println(test3 == test4);
        System.out.println(test1 == test4);


        System.out.println("test".equals(test1));
    }
}



