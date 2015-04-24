package com.tyshchenko.training.java.beginning.lesson6;

import java.util.Date;


/**
 * @author Alexander Tyshchenko.
 */
public class DateExample1 {
    public static void main(String[] args) {
        @SuppressWarnings("deprecation")
        Date dt1 = new Date(2014-1900, 7, 25);
        System.out.println(dt1);

        long ctm = System.currentTimeMillis();
        Date dt2 = new Date();
        System.out.println(dt2);

        System.out.println(dt1.equals(dt2));
        System.out.println(dt1.compareTo(dt2));
        System.out.println(dt2.compareTo(dt1));
    }
}
