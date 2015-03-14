package com.tyshchenko.java.training.oop.lesson11;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Alexander Tyshchenko.
 */
public class InetAddressExample {

    public static void main(String[] args) {
        String name = "google.com";
        try {
            InetAddress inetAddress = InetAddress.getByName(name);
            System.out.println("Ip address " + inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
