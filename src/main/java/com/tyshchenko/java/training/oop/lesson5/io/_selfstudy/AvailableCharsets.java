package com.tyshchenko.java.training.oop.lesson5.io._selfstudy;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * @author Alexander Tyshchenko.
 */
public class AvailableCharsets {

    public static void main(String[] args) {
        SortedMap<String, Charset> charsetsMap = Charset.availableCharsets();
        System.out.println("Charsets available: " + charsetsMap.size());

        charsetsMap.forEach((k, v) -> {
            Charset charset = charsetsMap.get(k);
            System.out.print(k + " (");
            charset.aliases().forEach((a) ->System.out.print(a + ","));
            System.out.print(")\n");
        });

    }
}
