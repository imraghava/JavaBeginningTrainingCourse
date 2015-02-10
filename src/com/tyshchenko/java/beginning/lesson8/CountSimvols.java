package com.tyshchenko.java.beginning.lesson8;

/**
 * @author Alexander Tyshchenko.
 */
public class CountSimvols {

    public static void main(String[] args) {
        String s = "(x – 8)+a(y – 1)";
        System.out.println(checkExpression(s));

    }

    public static boolean checkExpression(String expression) {
        int openCounter = 0;
        int closeCounter = 0;
        for(char i = 0; i < expression.length(); i++) {
            if (expression.charAt(i)=='(')
                openCounter++;
            else if (expression.charAt(i)==')')
                closeCounter++;

        }
        return openCounter == closeCounter;
    }
}
