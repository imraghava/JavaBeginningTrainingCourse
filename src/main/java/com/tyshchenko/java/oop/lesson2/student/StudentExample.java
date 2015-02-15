package com.tyshchenko.java.oop.lesson2.student;

import java.util.Date;

/**
 * @author Alexander Tyshchenko.
 */
public class StudentExample {

	public static void main(String[] args) {
		StudentList sl = new StudentList();
		
		sl.add(new Student("Dima", "Stepurenko", new Date(1986 - 1900, 1, 1)));
		sl.add(new Student("Vasya", "Pupkin", new Date(1970 - 1900, 3, 28)));
		
		int n = sl.find("Vasya");
		System.out.println(sl.get(n).getBirth().toString());
	}
}
