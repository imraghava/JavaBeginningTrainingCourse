package com.tyshchenko.java.cources.oop.lesson3;

/**
 * @author Alexander Tyshchenko.
 */
public class InstanceOfExample {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat("Tom");
        isCat(cat);
        isCat(dog);

    }

    public static boolean isCat(Animal animal) {
        if (animal instanceof Cat) {
            System.out.println(((Cat)animal).getName());
            return true;
        }
        else
            return false;
    }

    static class Animal {}

    static class Dog extends Animal {}

    static class Cat extends Animal {

        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
