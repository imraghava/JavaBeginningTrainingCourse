package com.tyshchenko.java.beginning.lesson8;

/**
 * @author Alexander Tyshchenko.
 */
public class PrimeNumbers {

    public static void main(String[] args) {
        int number = 300;
        simpleNumbersPrint(number);
    }

    public static void simpleNumbersPrint(int num) {
    label: for (int i = 2; i <= num; i++) {
            for (int j = 2; j < i; j++) {
                if ((i % j) == 0){
                    continue label;
                }
            }
            System.out.print(i + " ");
        }
    }
}
