package tyshchenko.java.beginning.lesson3;

import java.util.Arrays;

/**
 * author Alexander Tyshchenko.
 */
public class ArraysCopyOfRangeExample {
    public static void main(String[] args) {
        // initializing an array arr1
        long[] arr1 = new long[] {5, 62, 15};

        // printing the array
        System.out.println("Printing 1st array:");
        System.out.println(Arrays.toString(arr1));

        // copying array arr1 to arr2 with range of index from 2 to 5
        long[] arr2 = Arrays.copyOfRange(arr1, 2, 5);

        // printing the array arr2
        System.out.println("Printing new array:");
        System.out.println(Arrays.toString(arr2));
    }
}


