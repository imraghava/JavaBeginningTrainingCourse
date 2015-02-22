package com.tyshchenko.java.training.oop.lesson4.comparison;

/**
 * @author Alexander Tyshchenko.
 */
public class Human {

    private int age;

    public Human(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                '}';
    }
}
