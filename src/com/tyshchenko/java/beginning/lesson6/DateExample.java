package com.tyshchenko.java.beginning.lesson6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;


/**
 * @author Alexander Tyshchenko.
 */
public class DateExample {
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


        LocalDate ld = LocalDate.now();
        LocalDateTime ldt = LocalDateTime.now();

        ldt = ldt.plus(1, ChronoUnit.YEARS);

        System.out.println(ldt);
        System.out.println(ldt.getMonth());
    }
}
