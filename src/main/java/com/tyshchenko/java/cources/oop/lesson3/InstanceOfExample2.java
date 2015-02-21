package com.tyshchenko.java.cources.oop.lesson3;

/**
 * @author Alexander Tyshchenko.
 */
public class InstanceOfExample2 {

    public static void main(String[] args) {
        objectIdentifier("instanceof");
        objectIdentifier(1);
        objectIdentifier(1.1);
        objectIdentifier(1L);
        objectIdentifier(1.1F);
    }


    private static void objectIdentifier(Object obj) {
        if (obj instanceof String) {
            System.out.println("String object");
        }
        if (obj instanceof Long) {
            System.out.println("Long object");
        }
        if (obj instanceof Integer) {
            System.out.println("Integer object");
        }
        if (obj instanceof Double) {
            System.out.println("Double object");
        }
        if (obj instanceof Float) {
            System.out.println("Float object");
        }
    }
}
