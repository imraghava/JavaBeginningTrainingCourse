package com.tyshchenko.java.training.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadJoinExample {

    public static void main(String[] args) {
        MyCounter counter = new MyCounter();
        counter.start();

        try {
            counter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final class MyCounter extends Thread {

        @Override
        public void run() {
            int x = 1;
            while (x < 1000) {
                System.out.println(x);
                x++;
            }
            System.out.println("MyCounter thread finished");
        }
    }

}
