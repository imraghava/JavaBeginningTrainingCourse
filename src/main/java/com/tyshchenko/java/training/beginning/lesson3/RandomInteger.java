package com.tyshchenko.java.training.beginning.lesson3;

import java.util.Random;

/**
 * @author Alexander Tyshchenko.
 */
public class RandomInteger {
    public static void main(String[] args) {
        System.out.println("Generating 10 random integers in range 0..99.");

        //note a single Random object is reused here
        Random randomGenerator = new Random();
        for (int i = 1; i <= 10; i++){
            int randomInt = randomGenerator.nextInt(100);
            System.out.println("Generated : " + randomInt);
        }

        System.out.println("Done.");
    }
}