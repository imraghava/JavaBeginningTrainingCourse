package com.tyshchenko.java.oop.lesson1;

/**
 * @author Alexander Tyshchenko.
 */
public class CalculatorNestedStaticClassExample {

    public static void main(String[] args) {
        System.out.println(CalculatorNestedStaticClassExample.Operation.MINUS.eval(2.0, 1.1));
    }

    public static abstract class Operation {

        private final String name;

        public Operation(String name)   {
            this.name = name;
        }
        public String toString() {
            return this.name;
        }

        abstract double eval(double x, double y);

        public static final Operation PLUS = new Operation("+") {
            public double eval(double x, double y) {
                return x + y;
            }
        };

        public static final Operation MINUS = new Operation("-") {
            double eval(double x, double y) {
                return x - y;
            }
        };

        public static final Operation TIMES = new Operation("*") {
            double eval(double x, double y) {
                return x * y;
            }
        };

        public static final Operation DIVIDE = new Operation("/") {
            double eval(double x, double y) {
                return x / y;
            }
        };

    }

    public double calculate(double x, Operation op, double y) {
        return op.eval(x, y);
    }
}
