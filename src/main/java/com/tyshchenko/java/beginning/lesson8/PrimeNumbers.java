package com.tyshchenko.java.beginning.lesson8;

/**
 * @author Alexander Tyshchenko.
 */
public class PrimeNumbers {

    public static void main(String[] args) {
        int number = 31;
        simpleNumbersPrint(number);
    }

    public static void simpleNumbersPrint(int num) {
        System.out.print(2 + " ");
    label: for (int i = 3; i <= num; i += 2) {
            for (int j = 2; j < i; j++) {
                if ((i % j) == 0){
                    continue label;
                }
            }
            System.out.print(i + " ");
        }
    }
}
