package com.tyshchenko.java.cources.oop.lesson1;

/**
 * @author Alexander Tyshchenko.
 */
public class InnerLocalClassExample {

    private int outerVariable = 10;

    public static void main(String[] args) {
        InnerLocalClassExample nestedInnerClassExample = new InnerLocalClassExample();
        nestedInnerClassExample.print();
    }

    public void print() {
        for (int i = 0; i < 10; i++) {
            class Inner {
                public void print() {
                    System.out.println("Inner class outerVariable is " + outerVariable);
                }
            }
            Inner inner = new Inner();
            inner.print();
        }
    }
}
