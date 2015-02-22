package com.tyshchenko.java.training.beginning.lesson4;

/**
 * @author Alexander Tyshchenko.
 */
public class IfElseIfExample {
    public static void main(String[] args) {
        int a = 120;
        if(a < 100) {
            System.out.println("Variable is less than 100");
        } else if(a == 100) {
            System.out.println("Variable is equal to 100");
        } else if (a > 100) {
            System.out.println("Variable is greater than 100");
        }
    }
}
