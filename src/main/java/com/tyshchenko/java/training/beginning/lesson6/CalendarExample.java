package com.tyshchenko.java.training.beginning.lesson6;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Alexander Tyshchenko.
 */
public class CalendarExample {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        System.out.println("Year " + calendar.get(Calendar.YEAR));
        System.out.println("Month " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("Day " + calendar.get(Calendar.DAY_OF_MONTH));

        calendar.add(Calendar.YEAR, 1);
        calendar.add(Calendar.MONTH, 2);
        calendar.add(Calendar.DAY_OF_MONTH, -2);

        Date date = calendar.getTime();
        System.out.println(date);
    }

}
