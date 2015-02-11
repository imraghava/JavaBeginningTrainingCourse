package com.tyshchenko.java.beginning.lesson6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Alexander Tyshchenko.
 */
public class DateFormatExample {
    public static void main(String[] args) {
        Date dt = new Date();
        System.out.println(dt);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
        String res = sdf.format(dt);
        System.out.println(res);

        sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        res = sdf.format(dt);
        System.out.println(res);

        sdf = new SimpleDateFormat("dd.MM.yy D");
        res = sdf.format(dt);
        System.out.println(res);

        try {
            sdf.parse("");
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
