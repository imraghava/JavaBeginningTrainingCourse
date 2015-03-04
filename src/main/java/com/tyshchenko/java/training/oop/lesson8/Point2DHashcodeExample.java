package com.tyshchenko.java.training.oop.lesson8;

import java.util.stream.Stream;

/**
 * @author Alexander Tyshchenko.
 */
public class Point2DHashcodeExample {

    public static void main(String[] args) {
        Point2D point1 = new Point2D(1, 1);
        Point2D point2 = new Point2D(1, 2);
        Point2D point3 = new Point2D(2, 1);

        int hashcode1 = point1.hashCode();
        int hashcode2 = point2.hashCode();
        int hashcode3 = point3.hashCode();


        System.out.println(hashcode1 + ", " + hashcode2 + ", " + hashcode3);
//        Java 8
        Stream.of(hashcode1, hashcode2, hashcode3).forEach(System.out::println);
    }

    public static class Point2D {
        private int x;
        private int y;

        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point2D point2D = (Point2D) o;

            if (x != point2D.x) return false;
            return y == point2D.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        //        @Override
//        public int hashCode() {
//            return x + y;
//        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
