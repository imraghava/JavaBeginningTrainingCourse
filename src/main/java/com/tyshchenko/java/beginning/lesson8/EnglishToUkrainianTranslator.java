package com.tyshchenko.java.beginning.lesson8;

import java.util.Scanner;

/**
 * @author Alexander Tyshchenko.
 */
public class EnglishToUkrainianTranslator {
    public static void main(String[] args) {
        String result = "";
        String dictionary = "apple=яблуко,pear=груша,expression=вираз";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please, enter ukrainian word: ");
            result = translateFromUkrainian(dictionary, scanner.nextLine());
            System.out.println("English translate: " + result);
        }
    }
    public static String translateFromUkrainian(String dictionary, String ukrainianWord){
       String[] pair = dictionary.split(",");
        String[] englishWords = new String[pair.length];
        String[] ukrainianWords = new String[pair.length];
        for (int i = 0; i < pair.length; i++) {
            String[] array = pair[i].split("=");
            englishWords[i] = array[0];
            ukrainianWords[i] = array[1];
        }
        for (int i = 0; i < ukrainianWords.length; i++) {
            if (ukrainianWords[i].equals(ukrainianWord)){
                return englishWords[i];
            }
        }
        return "Sorry, you have entered absent word = " + ukrainianWord;
    }

}
