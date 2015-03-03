package com.tyshchenko.java.training.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class MyThreadExample2 {

    public static void main(String[] args) {
        String name = "MyThread";
        Thread thread = new Thread(new MyThread(name), name);
//        thread.setDaemon(true);
        thread.start();
    }

    private static final class MyThread implements Runnable {

        private final String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("Thread " + name + " is running");
        }
    }
}
