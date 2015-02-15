package com.tyshchenko.java.oop.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Alexander Tyshchenko.
 */
public class CarExamples {
    public static void main(String[] args) throws IOException {
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        String s = d.readLine();

        Car c = new Car();
        System.out.println(c.getName());

        if (s.equals("1"))
            c = new BMW();
        else if (s.equals("2"))
            c = new BMW_M();
        else
            c = new Lada();

        System.out.println(c.getName());
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