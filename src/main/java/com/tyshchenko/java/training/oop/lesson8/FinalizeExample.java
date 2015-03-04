package com.tyshchenko.java.training.oop.lesson8;

/**
 * @author Alexander Tyshchenko.
 */
public class FinalizeExample {

    public static void main(String[] args) {
        int i = 1_000_000;
        while (i-- > 0) {
            new WithFinalization();
            System.out.println(i);
        }
    }

    private static final class WithFinalization {

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Object is finalising");
        }
    }

}
