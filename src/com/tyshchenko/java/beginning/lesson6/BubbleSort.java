package com.tyshchenko.java.beginning.lesson6;

import java.util.Arrays;

/**
 * author Alexander Tyshchenko.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int a[] = {5,7,3,5,9,1};
        System.out.println(Arrays.toString(a));
        bubble_sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void bubble_sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    System.out.println(Arrays.toString(a));
                }
            }
            System.out.println("---------------------");
            
        }       
    }

    private static void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
}
