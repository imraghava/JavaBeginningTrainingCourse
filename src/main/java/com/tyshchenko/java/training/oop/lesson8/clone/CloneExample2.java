package com.tyshchenko.java.training.oop.lesson8.clone;

import java.util.Arrays;

/**
 * @author Alexander Tyshchenko.
 */
public class CloneExample2 {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};

        int[] array2 = Arrays.copyOf(array1, array1.length);

        Arrays.stream(array2).forEach(System.out::println);

        int[] array3 = array2.clone();

        Arrays.stream(array3).forEach(System.out::println);

        ValueHolder[] values = {new ValueHolder(1), new ValueHolder(2), new ValueHolder(3)};

        ValueHolder[] valuesCloned = values.clone();

        Arrays.stream(valuesCloned).forEach(System.out::println);

        values[0].setValue(10);

        Arrays.stream(valuesCloned).forEach(System.out::println);

    }


    private static final class ValueHolder {

        private int value;

        public ValueHolder(int value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "ValueHolder{" +
                    "value=" + value +
                    '}';
        }
    }

}
