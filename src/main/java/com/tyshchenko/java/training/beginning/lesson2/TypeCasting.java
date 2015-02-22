package com.tyshchenko.java.training.beginning.lesson2;

/**
 * @author Alexander Tyshchenko.
 */
public class TypeCasting {
    public static void main(String[] args) {
        byte a = (byte)(127 + 1);
        short x = Byte.MAX_VALUE + 1; // 127 + 1 = 128
        byte y = (byte)x;
        byte z = (byte)(x + 129);
        System.out.println(a); // -128 !!! Переполнение
        System.out.println(x); // 128 все ок
        System.out.println(y); // -128
        System.out.println(z); // 1
    }

}
