package com.tyshchenko.training.java.beginning.lesson8;

/**
 * @author Alexander Tyshchenko.
 */
public class ReverseStringChars {

    public static void main(String[] args) {
        String string = "123456789test";

        System.out.println(reverse(string));
        System.out.println(new StringBuilder().append(string).reverse().toString());
    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}
