package com.tyshchenko.java.training.oop.lesson5.io;

import java.io.File;

/**
 * @author Alexander Tyshchenko.
 */
public class DirectoryListExample {

    public static void main(String[] args) {
        String dirName = "/work/work";
        File file = new File(dirName);

        if (file.isDirectory()) {
            System.out.println("Directory of " + dirName);
            String list[] = file.list();

            for (int i=0; i < list.length; i++) {
                File f = new File(dirName + "/" + list[i]);
                if (f.isDirectory()) {
                    System.out.println(list[i] + " is a directory");
                } else {
                    System.out.println(list[i] + " is a file");
                }
            }
        } else {
            System.out.println(dirName + " is not a directory");
        }
    }

}
