package com.tyshchenko.java.training.beginning.lesson8;

import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class FindUniqueElementsInArray {

    public static void main(String[] args) {
        int[] array = { 1, 2, 4, 5, 3 , 1, 5  };

        Arrays.sort(array);

        if (array[0] != array[1])
            System.out.println(array[0]);
        if (array[array.length - 2] != array[array.length - 1])
            System.out.println(array[array.length - 1]);

        for (int i = 1; i < array.length - 2; i++) {
            if (array[i] != array[i - 1] && array[i] != array[i + 1])
                System.out.println(array[i]);
        }
    }

}