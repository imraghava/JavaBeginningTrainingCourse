package com.tyshchenko.java.training.oop.lesson8.serialize;

import com.tyshchenko.java.training.oop.util.Constants;

import java.io.*;

/**
 * @author Alexander Tyshchenko.
 */
public class SerializableExample {

    public static void main(String[] args) {
        Point2D point = new Point2D(1, 2, "undefined");

//        try (OutputStream fos = new FileOutputStream(Constants.FILE_PATH_LESSON_8 + "/temp.out");
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(point);
//            System.out.println(point);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        Point2D point2;
        try (InputStream fis = new FileInputStream(Constants.FILE_PATH_LESSON_8 + "/temp.out");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            point2 = (Point2D) ois.readObject();
            System.out.println(point2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static final class MyClass implements Serializable {
        private String name = "name";

        public String getName() {
            return name;
        }
    }

    private static final class Point2D implements Serializable {


        /*
        *
        * The serialVersionUID is used as a version control in a Serializable class.
        * If you do not explicitly declare a serialVersionUID, JVM will do it for you automatically,
        * based on various aspects of your Serializable class
        *
        */
        private static final long serialVersionUID = 1L;

        private transient String name;
        private int x;
        private int y;
        private MyClass clazz = new MyClass();

        public Point2D(int x, int y, String name) {
            this.x = x;
            this.y = y;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point2D point2D = (Point2D) o;

            if (x != point2D.x) return false;
            if (y != point2D.y) return false;
            if (!name.equals(point2D.name)) return false;
            return clazz.equals(point2D.clazz);

        }


        /*
        *
        * According to Joshua Bloch's Effective Java (a book that can't be recommended enough,
        * and which I bought thanks to continual mentions on stackoverflow):
        * The value 31 was chosen because it is an odd prime. If it were even and the multiplication overflowed,
        * information would be lost, as multiplication by 2 is equivalent to shifting.
        * The advantage of using a prime is less clear, but it is traditional. A nice property of 31 is that
        * the multiplication can be replaced by a shift and a subtraction for better performance: 31 * i == (i << 5) - i.
        * Modern VMs do this sort of optimization automatically.
        *
        */

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + x;
            result = 31 * result + y;
            result = 31 * result + clazz.hashCode();
            return result;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Point2D{" +
                    "name='" + name + '\'' +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
