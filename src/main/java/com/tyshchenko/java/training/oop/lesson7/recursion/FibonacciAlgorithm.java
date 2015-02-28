package com.tyshchenko.java.training.oop.lesson7.recursion;

/**
 * @author Alexander Tyshchenko.
 */
public class FibonacciAlgorithm {

    public static void main(String[] args) {
        int number = 10;

        System.out.println("Fibonacci series upto " + number +" numbers : ");
        for(int i = 1; i <= number; i++){
            System.out.print(fibonacciRecursion(i) +" ");
        }
    }

    public static int fibonacciRecursion(int number){
        if(number == 1 || number == 2) {
            return 1;
        }

        return fibonacciRecursion(number - 1) + fibonacciRecursion(number - 2);
    }

    public static int fibonacciLoop(int number){
        if(number == 1 || number == 2){
            return 1;
        }

        int fibo1 = 1;
        int fibo2 = 1;
        int fibonacci = 1;

        for(int i = 3; i<= number; i++){
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci; //Fibonacci number
    }

}
