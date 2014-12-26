package com.tyshchenko.java.beginning.lesson6;

import java.text.MessageFormat;

/**
 * author Alexander Tyshchenko.
 */
public class MakeACallFromIphone {
    public static void main(String[] args) {
        IPhone phone = new IPhone();
        phone.call(0661112233);
    }
}
