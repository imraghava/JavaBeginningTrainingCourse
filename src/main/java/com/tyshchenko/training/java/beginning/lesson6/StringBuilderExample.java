package com.tyshchenko.training.java.beginning.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class StringBuilderExample {

    public static void main(String[] args) {
        String str1 = "test1";
        String str2 = "test2";
        String str3 = "test3";
        String str4 = "test4";

        String result = str1 + str2 + str3 + str4; // effective
        System.out.println(result);

        String str = "";
        for (int i = 0; i < 100; i++) { // not effective
            str += i;
        }
        System.out.println(str);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(i);
        }
        System.out.println(sb);
    };

}