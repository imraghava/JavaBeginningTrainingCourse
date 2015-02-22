package com.tyshchenko.java.training.oop.lesson5.io;

import com.tyshchenko.java.training.oop.Constants;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class FileOutputStreamExample {

    public static void main(String[] args) {
        String source = "This text was written in file automatically\n";
        byte buf[] = source.getBytes();
        FileOutputStream fos0 = null;
        FileOutputStream fos1 = null;
        FileOutputStream fos2 = null;

        try {
            fos0 = new FileOutputStream(Constants.FILE_PATH + "/file1.txt");
            fos1 = new FileOutputStream(Constants.FILE_PATH + "/file2.txt");
            fos2 = new FileOutputStream(Constants.FILE_PATH + "/file3.txt");

            // write to first file
            for (int i=0; i < buf.length; i += 2)
                fos0.write(buf[i]);

            // write to second file
            fos1.write(buf);

            // write to third file
            fos2.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch(IOException e) {
            System.out.println("An I/O Error Occured");
        } finally {
            try {
                if(fos0 != null) fos0.close();
            } catch(IOException e) {
                System.out.println("Error Closing file1.txt");
            }
            try {
                if(fos1 != null) fos1.close();
            } catch(IOException e) {
                System.out.println("Error Closing file2.txt");
            }
            try {
                if(fos2 != null) fos2.close();
            } catch(IOException e) {
                System.out.println("Error Closing file3.txt");
            }
        }
    }

}
