package com.tyshchenko.java.training.oop.lesson5.io;

import com.tyshchenko.java.training.oop.util.Constants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Alexander Tyshchenko.
 */
public class RandomAccessFileExample {

    public static void main(String[] args) {
        byte[] buf = new byte[10];

        try (RandomAccessFile in = new RandomAccessFile(Constants.FILE_PATH_LESSON_5 + "/Random.txt", "rw")) {
            in.seek(100);
            in.write(buf);
            in.writeInt(7);
            in.writeChars("test chars");
            int x = in.readInt();
            Boolean b = in.readBoolean();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
