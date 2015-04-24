package com.tyshchenko.training.java.beginning.lesson5.jmx;

/**
 * @author Alexander Tyshchenko.
 */
public class Hello implements HelloMBean {
    @Override
    public String sayHello() {
        return "Hello from JMX";
    }
}
