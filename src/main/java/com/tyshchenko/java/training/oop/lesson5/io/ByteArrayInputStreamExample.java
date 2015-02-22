package com.tyshchenko.java.training.oop.lesson5.io;

import java.io.ByteArrayInputStream;

/**
 * @author Alexander Tyshchenko.
 */
public class ByteArrayInputStreamExample {

    public static void main(String[] args) {
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        byte b[] = tmp.getBytes();

        ByteArrayInputStream input1 = new ByteArrayInputStream(b);
        ByteArrayInputStream input2 = new ByteArrayInputStream(b,0,3);
    }

}
