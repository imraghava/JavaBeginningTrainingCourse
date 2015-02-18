package com.tyshchenko.java.cources.beginning.lesson2;

/**
 * @author Alexander Tyshchenko.
 */
public class AutoboxingAndUnboxing {
    public static void main(String[] args) {
        //before autoboxing
        Integer iObject;
        int iPrimitive;

        iObject = Integer.valueOf(3);
        iPrimitive = iObject.intValue();

        //after java 1.5
        iObject = 3; //autoboxing - primitive to wrapper conversion
        iPrimitive = iObject; //unboxing - object to primitive conversion
    }
}
