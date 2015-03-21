package com.tyshchenko.java.training.oop;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class Example {

    public static void main(String[] args) throws UnknownHostException {

        List<String> list = doJob(10);

        if (!list.isEmpty()) {
            ///dlfksjgksdfg
        }

    }

    public static List<String> doJob(int a) {
        if (a > 0)
            return Collections.emptyList();
        else
            return Arrays.asList("1", "2");
    }

}
