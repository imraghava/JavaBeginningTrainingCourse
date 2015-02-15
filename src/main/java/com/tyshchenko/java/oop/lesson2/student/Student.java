package com.tyshchenko.java.oop.lesson2.student;

import java.util.Date;


/**
 * @author Alexander Tyshchenko.
 */
public class Student {
	private String name;
	private String surname;
	private Date birth;
	
	public Student(String name, String surname, Date birth) {
		this.name = name;
		this.surname = surname;
		this.birth = birth;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Date getBirth() {
		return birth;
	}
	
	public void setBirth(Date birth) {
		this.birth = birth;
	}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
