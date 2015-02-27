package com.tyshchenko.java.training.oop.lesson5.io.binary;

import com.tyshchenko.java.training.oop.util.Constants;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class FileOutputStreamExampleTryWithResources {

    public static void main(String[] args) {
        String source = "This text was written in file automatically\n";
        byte buf[] = source.getBytes();

        // Use try-with-resources to close the files.
        try (FileOutputStream f0 = new FileOutputStream(Constants.FILE_PATH_LESSON_5 + "/FileOutputStreamExample.txt");
             FileOutputStream f1 = new FileOutputStream(Constants.FILE_PATH_LESSON_5 + "/FileOutputStreamExample.txt");
             FileOutputStream f2 = new FileOutputStream(Constants.FILE_PATH_LESSON_5 + "/FileOutputStreamExample.txt") )
        {

            // write to first file
            for (int i=0; i < buf.length; i += 2)
                f0.write(buf[i]);

            // write to second file
            f1.write(buf);

            // write to third file
            f2.write(buf, buf.length-buf.length/4, buf.length/4);
        } catch(IOException e) {
            System.out.println("An I/O Error Occured");
        }
    }

}
