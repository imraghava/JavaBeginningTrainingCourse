package com.tyshchenko.java.training.oop.lesson8.serialize;

import com.tyshchenko.java.training.oop.util.Constants;

import java.io.*;

/**
 * @author Alexander Tyshchenko.
 */
public class Point2DSerializableExample {

    public static void main(String[] args) {
        Point2D point = new Point2D(1, 2);

        try (OutputStream fos = new FileOutputStream(Constants.FILE_PATH_LESSON_8 + "/temp.out");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(point);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Point2D point2;
        try (InputStream fis = new FileInputStream(Constants.FILE_PATH_LESSON_8 + "/temp.out");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            point2 = (Point2D) ois.readObject();
            System.out.println(point2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static final class Point2D implements Serializable {
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

        @Override
        public String toString() {
            return "Point2D{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
