package com.tyshchenko.java.training.oop.lesson5.io;

import com.tyshchenko.java.training.oop.Constants;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class FileWriterExample {

    public static void main(String[] args) {
        String source = "Test string";
        char buffer[] = new char[source.length()];
        source.getChars(0, source.length(), buffer, 0);

        try ( FileWriter f0 = new FileWriter(Constants.FILE_PATH + "/file1.txt");
              FileWriter f1 = new FileWriter(Constants.FILE_PATH + "/file2.txt");
              FileWriter f2 = new FileWriter(Constants.FILE_PATH + "/file3.txt") )
        {
            // write to first file
            for (int i = 0; i < buffer.length; i += 2) {
                f0.write(buffer[i]);
            }

            // write to second file
            f1.write(buffer);

            // write to third file
            f2.write(buffer, buffer.length-buffer.length/4, buffer.length/4);

        } catch(IOException e) {
            System.out.println("An I/O Error Occured");
        }
    }

}
