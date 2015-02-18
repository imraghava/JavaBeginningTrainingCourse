package com.tyshchenko.java.cources.oop.lesson2.car;

/**
 * @author Alexander Tyshchenko.
 */
public class CarExample {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");
        Car ferrari = new Car("Ferrari", 20000);

        System.out.println(bmw);

        bmw.turnOn();
        ferrari.turnOn();

        final int[] speeds = {20, 60, 100};

        for (int s : speeds)
            bmw.start(s, 0.5);
        for (int s : speeds)
            ferrari.start(s, 1);

        bmw.turnOff();
        ferrari.turnOff();

        System.out.println(bmw.getName() + ": " + bmw.getMileage());
        System.out.println(ferrari.getName() + ": " + ferrari.getMileage());
    }
}
