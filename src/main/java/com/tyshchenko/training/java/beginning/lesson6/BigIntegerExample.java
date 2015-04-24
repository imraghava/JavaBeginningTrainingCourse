package com.tyshchenko.training.java.beginning.lesson6;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class BigIntegerExample {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("342354678352476834526783457683245786");
        BigInteger b = new BigInteger("9645879834765893748763745868723465723457862345");

        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.subtract(b));
        System.out.println("a * b = " + a.multiply(b));
        System.out.println("a / b = " + a.divide(b));
        System.out.println("b / a = " + b.divide(a));

        byte[] array = b.toByteArray();
        System.out.println(Arrays.toString(array));
    }
}
