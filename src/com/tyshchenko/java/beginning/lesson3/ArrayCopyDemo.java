package com.tyshchenko.java.beginning.lesson3;

/**
 * author Alexander Tyshchenko.
 */
public class ArrayCopyDemo {
    public static void main(String[] args) {
        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'e', 't', 'e', 'd' };
        char[] copyTo = new char[8];

        System.arraycopy(copyFrom, 2, copyTo, 0, 8
        );
        System.out.print(copyTo);
        System.out.println(String.valueOf(copyTo));

    }
}


