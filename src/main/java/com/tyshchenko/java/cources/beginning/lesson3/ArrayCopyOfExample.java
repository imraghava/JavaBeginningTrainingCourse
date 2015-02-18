package com.tyshchenko.java.cources.beginning.lesson3;

import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class ArrayCopyOfExample {
    public static void main(String[] args) {
        // initializing an array arr1
        byte[] arr1 = new byte[] {5, 62, 15};

        // printing the array
        System.out.println(Arrays.toString(arr1));
        // copying array arr1 to arr2 with new length as 5
        byte[] arr2 = Arrays.copyOf(arr1, 5);
        arr2[3] = 70;
        arr2[4] = 45;

        // printing the array arr2
        System.out.println("Printing new array:");
        System.out.println(Arrays.toString(arr2));
    }
}


