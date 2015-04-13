package com.tyshchenko.java.training.beginning.lesson6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author Alexander Tyshchenko.
 */
public class DateExample2 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        localDateTime = localDateTime.plus(1, ChronoUnit.YEARS);

        System.out.println(localDate);
        System.out.println(localDateTime);
        System.out.println(localDateTime.getMonth());
    }

}
