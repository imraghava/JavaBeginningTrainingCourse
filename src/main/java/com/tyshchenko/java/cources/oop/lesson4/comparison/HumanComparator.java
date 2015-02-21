package com.tyshchenko.java.cources.oop.lesson4.comparison;

import java.util.Comparator;

/**
 * @author Alexander Tyshchenko.
 */
public class HumanComparator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        Human h1 = (Human)o1;
        Human h2 = (Human)o2;
        if (h1.getAge() < h2.getAge())
            return -1;
        else if (h1.getAge() == h2.getAge())
            return 0;
        else if (h1.getAge() > h2.getAge())
            return 1;
        return 0;
    }

}
