package com.tyshchenko.training.java.beginning.lesson8;

import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class ArraySortedConcatenation {

    public static void main(String[] args) {
        int[] array1 = {1, 5, 10, 40, 121, 200};
        int[] array2 = {3 ,7, 121, 300, 1000, 2001, 4002, 7002};

        System.out.println(Arrays.toString(concatenate(array1, array2)));
    }

    private static int[] concatenate(int[] array1, int[] array2) {
        int[] array = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, array, 0, array1.length);
        System.arraycopy(array2, 0, array, array1.length - 1, array2.length);
        Arrays.sort(array);
        return array;
    }

}
