package com.tyshchenko.java.cources.beginning.lesson3;

import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class ArraySortDemo {
    public static void main(String[] args) {
        // initializing unsorted int array
        int iArr[] = {2, 1, 9, 6, 4};

        // let us print all the elements available in list

        System.out.println("Numbers = " + Arrays.toString(iArr));

//        for (int number : iArr) {
//            System.out.println("Number = " + number);
//        }

        // sorting array
        Arrays.sort(iArr);

        // let us print all the elements available in list
        System.out.println("The sorted int array is:");

        System.out.println("Numbers = " + Arrays.toString(iArr));

//        for (int number : iArr) {
//            System.out.println("Number = " + number);
//        }
    }
}


