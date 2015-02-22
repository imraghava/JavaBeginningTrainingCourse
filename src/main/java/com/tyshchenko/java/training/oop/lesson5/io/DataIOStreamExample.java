package com.tyshchenko.java.training.oop.lesson5.io;

import com.tyshchenko.java.training.oop.Constants;

import java.io.*;

/**
 * @author Alexander Tyshchenko.
 */
public class DataIOStreamExample {

    public static void main(String[] args) {
        String path = Constants.FILE_PATH + "/Test.dat";

        // First, write the data.
        try ( DataOutputStream dos =
                      new DataOutputStream(new FileOutputStream(path)) )
        {
            dos.writeDouble(98.6);
            dos.writeInt(1000);
            dos.writeBoolean(true);

        } catch(FileNotFoundException e) {
            System.out.println("Cannot Open Output File");
            return;
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }

        // Now, read the data back.
        try ( DataInputStream dis =
                      new DataInputStream(new FileInputStream(path)) )
        {

            double d = dis.readDouble();
            int i = dis.readInt();
            boolean b = dis.readBoolean();

            System.out.println("Here are the values: " +
                    d + " " + i + " " + b);
        } catch(FileNotFoundException e) {
            System.out.println("Cannot Open Input File");
            return;
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

}
