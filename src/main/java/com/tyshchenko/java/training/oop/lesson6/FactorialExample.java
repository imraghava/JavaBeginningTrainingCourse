package com.tyshchenko.java.training.oop.lesson6;

import java.math.BigInteger;

/**
 * @author Alexander Tyshchenko.
 */
public class FactorialExample {

    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator(new BigInteger("11000"), new Finish());
        calculator.start();
        System.out.println("Done!");
    }

    private interface IFinish {
        void done(BigInteger result);
    }

    private static class Finish implements IFinish {
        @Override
        public void done(BigInteger result) {
            System.out.println(result);
        }
    }

    private static final class FactorialCalculator extends Thread {
        private IFinish finish;
        private BigInteger n;

        public FactorialCalculator(BigInteger n, IFinish finish) {
            this.n = n;
            this.finish = finish;
        }

        private BigInteger fact(BigInteger x) {
            if (x.equals(BigInteger.ZERO))
                return BigInteger.ONE;
            else
                return x.multiply(fact(x.subtract(BigInteger.ONE)));
        }

        @Override
        public void run() {
            BigInteger res = fact(n);
            if (finish != null)
                finish.done(res);
        }
    }


}
