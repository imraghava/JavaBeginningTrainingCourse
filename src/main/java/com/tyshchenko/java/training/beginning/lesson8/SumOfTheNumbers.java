package com.tyshchenko.java.training.beginning.lesson8;

/**
 * @author Alexander Tyshchenko.
 */
public class SumOfTheNumbers {

    public static void main(String[] args) {
        int value = 12345;
        System.out.println(getSum(value));
    }


    public static int getSum(int value) {
       int total = 0;
       int check = value;
        while (check > 0){
            total += check % 10;
            check /= 10;
        }
        return total;
    }
}
