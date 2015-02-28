package com.tyshchenko.java.training.oop.lesson7.recursion;

/**
 * @author Alexander Tyshchenko.
 */
public class EuclidAlgorithm {

    public static void main(String[] args) {
        int p = 12;
        int q = 15;

        int d  = gcd(p, q);
        int d2 = gcd2(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);
        System.out.println("gcd(" + p + ", " + q + ") = " + d2);
    }

    // recursive implementation
    public static int gcd(int p, int q) {
        return q == 0 ? p : gcd(q, p % q);
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

}
