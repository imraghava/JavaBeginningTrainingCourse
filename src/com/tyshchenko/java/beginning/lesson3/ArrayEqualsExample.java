package com.tyshchenko.java.beginning.lesson3;

import java.util.Arrays;

/**
 * author Alexander Tyshchenko.
 */
public class ArrayEqualsExample {
    public static void main(String[] args) {
        // initializing three integer arrays
        int[] arr1 = new int[] { 10, 12, 5, 6 };
        int[] arr2 = new int[] { 10, 12, 5, 6 };
        int[] arr3 = new int[] { 10, 5, 6, 12 };

        // comparing arr1 and arr2
        boolean retVal = Arrays.equals(arr1, arr2);
        System.out.println("arr1 and arr2 equal: " + retVal);

        // comparing arr2 and arr3
        boolean retVal2 = Arrays.equals(arr2, arr3);
        System.out.println("arr2 and arr3 equal: " + retVal2);
    }
}



