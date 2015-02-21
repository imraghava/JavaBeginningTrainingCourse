package com.tyshchenko.java.cources.oop.lesson4.comparison;

/**
 * @author Alexander Tyshchenko.
 */
public class HumanRight implements Comparable<HumanRight> {

    private int age;

    public HumanRight(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(HumanRight o) {
        HumanRight human = (HumanRight) o;
        if (getAge() < human.getAge()) return -1;
        else if (getAge() == human.getAge()) return 0;
        else if (getAge() > human.getAge()) return 1;
        else
            return 0;
    }
}
