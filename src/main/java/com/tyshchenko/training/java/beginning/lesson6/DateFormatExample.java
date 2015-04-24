package com.tyshchenko.training.java.beginning.lesson6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Alexander Tyshchenko.
 */
public class DateFormatExample {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
        String res = format.format(date);
        System.out.println(res);

        format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        res = format.format(date);
        System.out.println(res);

        format = new SimpleDateFormat("dd.MM.yy D");
        res = format.format(date);
        System.out.println(res);

        try {
            format.parse("");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
