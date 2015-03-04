package com.tyshchenko.java.training.oop.lesson7.recursion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class RecursionExample {

    public static void main(String[] args) {
        final String path = "src/main/java";
        List<String> list = new ArrayList<>();

        try {
            listAll(path, list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : list)
            System.out.println(s);

//        Java 8 static method reference
//        list.forEach(System.out::println);
    }


    private static void listAll(String path, List<String> res) throws IOException
    {
        File dir = new File(path);
        File[] list = dir.listFiles();

        for (File f : list) {
            if (f.isFile()) {
                res.add("F: " + f.getCanonicalPath());
            } else {
                res.add("D: " + f.getCanonicalPath());
                listAll(f.getCanonicalPath(), res);
            }
        }
    }

}
