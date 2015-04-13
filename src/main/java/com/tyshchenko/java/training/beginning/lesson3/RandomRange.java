package com.tyshchenko.java.training.beginning.lesson3;

import java.util.Random;

/**
 * @author Alexander Tyshchenko.
 */
public class RandomRange {
    public static void main(String[] args) {
        System.out.println("Generating random integers in the range 20..30.");

        int start = 20;
        int end = 30;
        Random random = new Random();
        for (int i = 1; i <= 10; i++){
            showRandomInteger(start, end, random);
        }

        System.out.println("Done.");
    }

    private static void showRandomInteger(int start, int end, Random random){
        if (start > end) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        int range = end - start + 1;
        int fraction = (int)(range * random.nextDouble());
        int randomNumber = (fraction + start);
        System.out.println("Generated : " + randomNumber);
    }
}