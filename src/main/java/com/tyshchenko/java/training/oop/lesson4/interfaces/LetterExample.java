package com.tyshchenko.java.training.oop.lesson4.interfaces;

/**
 * @author Alexander Tyshchenko.
 */
public class LetterExample implements Addressable {

    private String street;
    private String city;

    public LetterExample(String street, String city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getStreet() {
        return street;
    }

    public static void main(String[] args) {
        LetterExample letter = new LetterExample("123 AnyStreet", "AnyCity");
        System.out.println(letter.getFullAddress());
    }

}
