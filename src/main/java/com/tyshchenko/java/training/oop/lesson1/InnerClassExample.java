package com.tyshchenko.java.training.oop.lesson1;

/**
 * @author Alexander Tyshchenko.
 */
public class InnerClassExample {

    private int outerVariable = 10;

    public static void main(String[] args) {
        InnerClassExample innerClassExample = new InnerClassExample();
        innerClassExample.print();

        InnerClassExample.Inner inner = innerClassExample.new Inner();
    }

    public void print() {
        Inner inner = new Inner();
        inner.print();
    }

    /*
     *  Available 4 modification
     *
     *  public
     *  private
     *  protected
     *  package-protected
     *
     */
    public class Inner {
        public void print() {
            System.out.println("Inner class outerVariable is " + outerVariable);
        }
    }

}
