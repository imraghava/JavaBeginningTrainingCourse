package com.tyshchenko.java.training.beginning.lesson2;

/**
 * @author Alexander Tyshchenko.
 */
public class AutoboxingAndUnboxing {
    public static void main(String[] args) {
        //before autoboxing
        Integer intObject;
        int intPrimitive;

        intObject = Integer.valueOf(3);
        intPrimitive = intObject.intValue();

        //after java 1.5
        intObject = 3; //autoboxing - primitive to wrapper conversion
        intPrimitive = intObject; //unboxing - object to primitive conversion
    }
}
