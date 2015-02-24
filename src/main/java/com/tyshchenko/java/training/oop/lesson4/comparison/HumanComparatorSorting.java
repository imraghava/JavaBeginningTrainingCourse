package com.tyshchenko.java.training.oop.lesson4.comparison;

import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class HumanComparatorSorting {

    public static void main(String[] args) {
        Human[] humans = {
                new Human(40),
                new Human(20),
                new Human(3),
                new Human(7)
        };

        Arrays.sort(humans, new HumanComparator());

        for (Human h : humans)
            System.out.println(h.getAge());

    }

}
