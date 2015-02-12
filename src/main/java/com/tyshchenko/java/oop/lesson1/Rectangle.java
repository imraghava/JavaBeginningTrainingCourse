package com.tyshchenko.java.oop.lesson1;

/**
 * @author Alexander Tyshchenko.
 */
public class Rectangle extends Figure {

    private final String name = Rectangle.class.getSimpleName();

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        this(0, 0);
    }

    public int square() {
        return this.height * this.width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
