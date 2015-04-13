package com.tyshchenko.java.training.beginning.lesson3;

import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class ArrayCloneExample {
    public static void main(String[] args) {
        int[] numbers = { 1, 1, 1, 1 };
        int[] clones = numbers.clone();

        System.out.println(clones[0] + clones[1] + clones[2] + clones[3]);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(clones));
    }
}