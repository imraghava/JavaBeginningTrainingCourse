package com.tyshchenko.java.training.oop.lesson9.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Tyshchenko.
 */
public class HashMapExample {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "value2");
        map.put("1", "value1");
        map.put("3", "value3");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key=" + entry.getKey() + " Value=" + entry.getValue());
        }

        System.out.println(map);

//        Java 8
//        map.forEach((k, v) -> System.out.println("Key=" + entry.getKey() + " Value=" + entry.getValue()));

        // iterating over keys only
        for (String key : map.keySet()) {
            System.out.println("Key=" + key);
        }

        // iterating over values only
        for (String value : map.values()) {
            System.out.println("Value=" + value);
        }
    }

}
