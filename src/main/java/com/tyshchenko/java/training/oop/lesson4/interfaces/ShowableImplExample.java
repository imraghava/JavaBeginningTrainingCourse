package com.tyshchenko.java.training.oop.lesson4.interfaces;

import static com.tyshchenko.java.training.oop.lesson4.interfaces.Showable.Message;

/**
 * @author Alexander Tyshchenko.
 */
public class ShowableImplExample implements Message {

    public static void main(String[] args) {
        Message showable = new ShowableImplExample();
        showable.msg();
    }

    @Override
    public void msg() {
        System.out.println("Nested interface");
    }
}
