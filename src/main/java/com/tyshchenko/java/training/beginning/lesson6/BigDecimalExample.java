package com.tyshchenko.java.training.beginning.lesson6;

import java.math.BigDecimal;

/**
 * @author Alexander Tyshchenko.
 */
public class BigDecimalExample {

    public static void main(String[] args) {
        double a = 2.0 - 1.1;

        System.out.println(a);


        BigDecimal var1 = new BigDecimal("2.0");
        BigDecimal var2 = new BigDecimal("1.1");

        var1 = var1.subtract(var2);

        System.out.println(var1);

    }
}
