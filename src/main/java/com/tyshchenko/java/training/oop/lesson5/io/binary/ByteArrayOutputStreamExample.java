package com.tyshchenko.java.training.oop.lesson5.io.binary;

import com.tyshchenko.java.training.oop.util.Constants;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class ByteArrayOutputStreamExample {

    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String s = "This should end up in the array";
        byte buf[] = s.getBytes();

        try {
            baos.write(buf);
        } catch(IOException e) {
            System.out.println("Error Writing to Buffer");
            return;
        }

        System.out.println("Buffer as a string");
        System.out.println(baos.toString());
        System.out.println("Into array");
        byte b[] = baos.toByteArray();
        for (int i=0; i<b.length; i++) System.out.print((char) b[i]);

        System.out.println("\nTo an OutputStream()");

        // Use try-with-resources to manage the file stream.
        try ( FileOutputStream f2 = new FileOutputStream(Constants.FILE_PATH_LESSON_5 + "/ByteArrayOutputStreamExample.txt") )
        {
            baos.writeTo(f2);
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
            return;
        }

        System.out.println("Doing a reset");
        baos.reset();

        for (int i = 0; i < 3; i++)
            baos.write('X');

        System.out.println(baos.toString());
    }

}
