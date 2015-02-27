package com.tyshchenko.java.training.oop.lesson5.io.character;

import com.tyshchenko.java.training.oop.util.Constants;

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

        try ( FileWriter fw1 = new FileWriter(Constants.FILE_PATH_LESSON_5 + "/FileWriterExample1.txt");
              FileWriter fw2 = new FileWriter(Constants.FILE_PATH_LESSON_5 + "/FileWriterExample2.txt");
              FileWriter fw3 = new FileWriter(Constants.FILE_PATH_LESSON_5 + "/FileWriterExample3.txt") )
        {
            // write to first file
            for (int i = 0; i < buffer.length; i += 2) {
                fw1.write(buffer[i]);
            }

            // write to second file
            fw2.write(buffer);

            // write to third file
            fw3.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);

        } catch(IOException e) {
            System.out.println("An I/O Error Occured");
        }
    }

}
