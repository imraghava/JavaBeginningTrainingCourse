package tyshchenko.java.beginning.lesson3;

import java.util.Random;

/**
 * author Alexander Tyshchenko.
 */
public class RandomRange {
    public static void main(String[] args) {
        System.out.println("Generating random integers in the range 20..30.");

        int START = 20;
        int END = 30;
        Random random = new Random();
        for (int i = 1; i <= 10; i++){
            showRandomInteger(START, END, random);
        }

        System.out.println("Done.");
    }

    private static void showRandomInteger(int start, int end, Random random){
        if (start > end) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        int range = end - start + 1;
        int fraction = (int)(range * random.nextDouble());
        int randomNumber =  (int)(fraction + start);
        System.out.println("Generated : " + randomNumber);
    }
}


