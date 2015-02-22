package com.tyshchenko.java.training.oop.lesson3.exceptions;

/**
 * @author Alexander Tyshchenko.
 */
public class ExceptionsExample {

    public static class WidthException extends Exception {
        public WidthException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "WidthException: " + super.getMessage();
        }
    }

    public static class HeightException extends Exception {
        public HeightException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "HeightException: " + super.getMessage();
        }
    }

    public static class Rectangle {
        private int height;
        private int width;

        public void setHeight(int height) throws HeightException {
            if (height < 0)
                throw new HeightException("wrong height");
            this.height = height;
        }

        public void setWidth(int width) throws WidthException {
            if (width < 0)
                throw new WidthException("wrong width");
            this.width = width;
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();

        try {
            rectangle.setHeight(10);
            rectangle.setWidth(-5);
        } catch (HeightException e) {
            System.out.println(e.getMessage());
        } catch (WidthException e) {
            System.out.println(e.getMessage());
        }

        try {
            rectangle.setHeight(-9);
            rectangle.setWidth(-5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
