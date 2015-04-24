package com.tyshchenko.java.training.beginning.lesson8;

import java.util.Scanner;

/**
 * @author Alexander Tyshchenko.
 */
public class EnglishToUkrainianTranslator {

    private static String[] englishWords = null;
    private static String[] ukrainianWords = null;

    public static void main(String[] args) {

        String result = "";
        String dictionary = "apple=яблуко,pear=груша,expression=вираз";


        buildDictionary(dictionary);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please, enter english word ('q' - for exit): ");
            String input = scanner.nextLine();
            if ("q".equals(input.toLowerCase()))
                break;
            result = translateFromEnglish(input);
            System.out.println("Translation: " + result);
        }
    }
    private static String translateFromEnglish(String englishWord) {

        for (int i = 0; i < englishWords.length; i++) {
            if (englishWords[i].equals(englishWord)){
                return ukrainianWords[i];
            }
        }
        return "Sorry, you have entered absent word = " + englishWord;
    }

    private static void buildDictionary(String strDictionary) {
        String[] pair = strDictionary.split(",");
        englishWords = new String[pair.length];
        ukrainianWords = new String[pair.length];
        for (int i = 0; i < pair.length; i++) {
            String[] array = pair[i].split("=");
            englishWords[i] = array[0];
            ukrainianWords[i] = array[1];
        }
    }

}