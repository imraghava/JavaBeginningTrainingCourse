package com.tyshchenko.java.oop.lesson3;

import java.io.File;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class IOExceptionExample {

    private static void createFileWithTryCatch() {
        try {
            File f = File.createTempFile("test", ".dat");
            System.out.println(f.getCanonicalPath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createFileWithThrows() throws IOException {
        File f = File.createTempFile("test", ".dat");
        System.out.println(f.getCanonicalPath());
    }

    public static void main(String[] args) {
        try {
            createFileWithThrows();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        createFileWithTryCatch();
    }

}
