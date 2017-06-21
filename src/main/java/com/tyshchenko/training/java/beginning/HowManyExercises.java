package com.tyshchenko.training.java.beginning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko
 */

public class HowManyExercises {
    public static void main(String[] args) throws IOException {
        int total = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("./Exercises.md"))) {
            int exercises = 0;
            for (String line; (line = reader.readLine()) != null;) {
                if (line.length() == 0)
                    continue;
                if (line.charAt(0) == '#') {
                    if (exercises != 0) {
                        System.out.println("Exercises - " + exercises);
                        exercises = 0;
                    }
                    System.out.println("Section - " + line.substring(3));
                    continue;
                }
                if (line.charAt(0) == '-') {
                    ++exercises;
                    ++total;
                }
            }
            System.out.println("Exercises - " + exercises);
        }
        System.out.println("\nTotal exercises - " + total);
    }
}
