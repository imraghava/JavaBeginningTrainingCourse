package com.tyshchenko.java.oop.lesson3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alexander Tyshchenko.
 */
public class TryCatchWithResources {

    private static final String filePath = "src/main/resources/TryWithResourcesExplanation.txt";

    private static void printFile() throws IOException {
        InputStream input = null;

        try {
            input = new FileInputStream(filePath);

            int data = input.read();
            while(data != -1) {
                System.out.print((char) data);
                data = input.read();
            }
            System.out.println();
        } finally {
            if(input != null){
                input.close();
            }
        }
    }

    private static void printFileJava7() {

        try(FileInputStream input = new FileInputStream(filePath)) {

            int data = input.read();
            while(data != -1) {
                System.out.print((char) data);
                data = input.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            printFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
        printFileJava7();
    }

}
