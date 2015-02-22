package com.tyshchenko.java.training.oop.lesson3;

/**
 * @author Alexander Tyshchenko.
 */
public class InstanceOfExample {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        sayHello(cat);
        sayHello(dog);
    }

    public static void sayHello(Animal animal) {
        if (animal instanceof Cat)
            ((Cat)animal).meows();
        else if (animal instanceof Dog)
            ((Dog)animal).barks();
        else {
            System.out.println("Unknown animal");
        }
    }

    static class Animal {}

    static class Dog extends Animal {

        public void barks() {
            System.out.println("Woof! Woof!");
        }

    }

    static class Cat extends Animal {

        public void meows() {
            System.out.println("Meow! Meow!");
        }

    }

}
