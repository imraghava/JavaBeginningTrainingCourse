package com.tyshchenko.java.training.oop.lesson5.io.character;

import com.tyshchenko.java.training.oop.util.Constants;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class FileReaderExample {

    public static void main(String[] args) {
        try ( FileReader reader = new FileReader(Constants.FILE_PATH_LESSON_5 + "/FileReaderExample.java") )
        {
            int c;

            // Read and display the file.
            while((c = reader.read()) != -1)
                System.out.print((char) c);

        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

}
