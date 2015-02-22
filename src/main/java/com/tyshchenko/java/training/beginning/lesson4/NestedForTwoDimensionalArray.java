package com.tyshchenko.java.training.beginning.lesson4;

/**
 * @author Alexander Tyshchenko.
 */
public class NestedForTwoDimensionalArray {
    public static void main(String[] args) {
        String city[][]={ {"NewYork","Muscat","London"} , {"Cairo","Beijing","CapeTown"} };

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city[i].length; j++) {
                System.out.print(city[i][j] + "\t");
            }
        }

    }
}


