package com.tyshchenko.java.cources.beginning.lesson4;

/**
 * @author Alexander Tyshchenko.
 */
public class BreakDemo2 {
    public static void main(String[] args) {
        int i = 0;

        while (i < 100) {
            if (i == 10) {
                break;
            }
            System.out.println("i: " + i);
            i++;
        }
        System.out.println("Loop is finished");
    }
}


