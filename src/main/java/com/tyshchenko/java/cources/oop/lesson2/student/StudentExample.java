package com.tyshchenko.java.cources.oop.lesson2.student;

import java.time.LocalDate;

/**
 * @author Alexander Tyshchenko.
 */
public class StudentExample {

	public static void main(String[] args) {
		StudentList sl = new StudentList();
		
		sl.add(new Student("Dima", "Stepurenko", LocalDate.of(1986, 1,1 )));
		sl.add(new Student("Vasya", "Pupkin", LocalDate.of(1970, 3, 28)));
		
		int n = sl.find("Vasya");
		System.out.println(sl.get(n).getBirth().toString());
	}
}
