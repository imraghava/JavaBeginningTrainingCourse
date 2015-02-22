package com.tyshchenko.java.training.oop.lesson4.interfaces;

/**
 * @author Alexander Tyshchenko.
 */
public interface Addressable {

    String getStreet();
    String getCity();

    default String getFullAddress() {
        return getStreet() + ", " + getCity();
    }

}
