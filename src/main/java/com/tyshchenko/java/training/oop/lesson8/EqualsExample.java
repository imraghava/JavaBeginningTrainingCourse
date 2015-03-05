package com.tyshchenko.java.training.oop.lesson8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tyshchenko.java.training.oop.lesson8.Point2DHashcodeExample.Point2D;
/**
 * @author Alexander Tyshchenko.
 */
public class EqualsExample {

    public static void main(String[] args) {

        String str1 = "string1";
        String str2 = "string2";

        Point2D point1 = new Point2D(1, 1);
        Point2D point2 = new Point2D(1, 2);
        Point2D point3 = point1;

        System.out.println(str1.equals(str2));

        System.out.println(point1.equals(point2));
        System.out.println(point1.equals(point3));
        System.out.println(point2.equals(point3));
    }

}
