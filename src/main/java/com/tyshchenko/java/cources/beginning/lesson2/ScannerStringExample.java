package com.tyshchenko.java.cources.beginning.lesson2;

import java.util.Scanner;

/**
 * @author Alexander Tyshchenko.
 */
public class ScannerStringExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = scanner.nextLine();
        System.out.println("You printed: " + s);
        System.out.print("Enter integer: ");
        int i = scanner.nextInt();
        System.out.println("You printed: " + i);
    }
}
