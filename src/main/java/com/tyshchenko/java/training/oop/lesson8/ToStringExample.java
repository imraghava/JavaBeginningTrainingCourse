package com.tyshchenko.java.training.oop.lesson8;

/**
 * @author Alexander Tyshchenko.
 */
public class ToStringExample {

    public static void main(String[] args) {
        Item item = new Item();
        System.out.println(item);
        System.out.println(item.toString());

//        ItemImproved item = new ItemImproved(100, Color.Red);
//        System.out.println(item);
//        System.out.println(item.toString());
    }

    enum Color {
        Red,
        Write,
        Black
    }

    private static class Item {
        protected int weight = 10;
        protected Color color = Color.Black;

    }

    private static class ItemImproved extends Item {

        public ItemImproved(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "weight=" + weight +
                    ", color=" + color +
                    '}';
        }
    }

}
