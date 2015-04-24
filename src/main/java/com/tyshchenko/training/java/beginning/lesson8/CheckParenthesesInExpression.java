package com.tyshchenko.training.java.beginning.lesson8;

import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class CheckParenthesesInExpression {

    public static void main(String[] args) {
        String expression = "(x – 8)+a(y – 1)";
        System.out.println(checkExpression(expression));

    }

    public static boolean checkExpression(String expression) {
        int counter = 0;
        for(char c : expression.toCharArray()) {
            if (c == '(' || c == ')')
                counter++;
        }
        return counter % 2 == 0;
    }
}