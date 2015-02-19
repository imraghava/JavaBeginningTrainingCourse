package com.tyshchenko.java.cources.oop.lesson3;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Alexander Tyshchenko.
 */
public class CarExamples {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Car car = new Car();
        System.out.println(car.getName());

        if (str.equals("1"))
            car = new BMW();
        else if (str.equals("2"))
            car = new BMW_M();
        else
            car = new Lada();

        System.out.println(car.getName());
    }

}

class Car {

    public String getName() {
        return "car";
    }

}

class BMW extends Car {

    @Override
    public String getName() {
        return "BMW";
    }

}

class Lada extends Car {

    @Override
    public String getName() {
        return "Lada";
    }

}

class BMW_M extends BMW {

    @Override
    public String getName() {
        return super.getName() + "_M";
    }

}