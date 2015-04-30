package com.tyshchenko.training.java.beginning.lesson8;

/**
 * @author Alexander Tyshchenko.
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        System.out.println(" * |  1  2  3  4  5  6  7  8  9");
        System.out.println("-------------------------------");
        for (int i = 1; i <= 9; i++) {
            System.out.print(" " + i + " | ");
            for (int j = 1; j <= 9 ; j++) {
                int cell = i * j;
                System.out.print((cell >= 10 ? cell : " " + cell) + " ");
            }
            System.out.println();
        }
    }

}
