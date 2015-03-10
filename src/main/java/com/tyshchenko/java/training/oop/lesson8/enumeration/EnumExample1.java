package com.tyshchenko.java.training.oop.lesson8.enumeration;

/**
 * @author Alexander Tyshchenko.
 *
 * http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 */
public class EnumExample1 {

    private Day day;

    public EnumExample1(Day day) {
        this.day = day;
    }

    public static void main(String[] args) {
        EnumExample1 firstDay = new EnumExample1(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumExample1 thirdDay = new EnumExample1(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumExample1 fifthDay = new EnumExample1(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumExample1 sixthDay = new EnumExample1(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumExample1 seventhDay = new EnumExample1(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }

    public enum Day {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

}
