package com.tyshchenko.java.training.oop.lesson8.clone;

/**
 * @author Alexander Tyshchenko.
 */
public class CloneExample3 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Department department = new Department(1, "Human Resource");
        Employee original = new Employee(1, "Admin", department);
        Employee cloned = (Employee) original.clone();

        //Let change the department name in cloned object and we will verify in original object
        cloned.getDepartment().setName("Finance");

        System.out.println(original.getDepartment().getName());
    }

    private static final class Department {
        private int id;
        private String name;

        public Department(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static final class Employee implements Cloneable {
        private int id;
        private String name;
        private Department department;

        public Employee(int id, String name, Department department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }



}
