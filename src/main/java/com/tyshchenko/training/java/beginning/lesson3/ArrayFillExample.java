package com.tyshchenko.training.java.beginning.lesson3;

import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class ArrayFillExample {
    public static void main(String[] args) {
        // initializing byte array
        byte arr[] = new byte[] {1, 6, 3};

        // let us print the values
        System.out.println("Actual values: ");
        System.out.println(Arrays.toString(arr));

        // using fill for placing 8
        // converting int to byte
        Arrays.fill(arr,(byte)8);

        // let us print the values
        System.out.println("New values after using fill() method: ");
        System.out.println(Arrays.toString(arr));
    }
}
