package com.tyshchenko.java.cources.beginning.lesson6;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class BigIntegerExample {
    public static void main(String[] args) {
        BigInteger i1 = new BigInteger("342354678352476834526783457683245786");
        BigInteger i2 = new BigInteger("9645879834765893748763745868723465723457862345");



        System.out.println(i1.add(i2));
        System.out.println(i1.subtract(i2));
        System.out.println(i2.multiply(i1));
        System.out.println(i2.divide(i1));

        byte[] b = i1.toByteArray();
        System.out.println(Arrays.toString(b));
    }
}
