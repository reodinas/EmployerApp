package com.reodinas2.employerapp.model;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private int age;
    private int salary;
//    String profileImage;


    public  Employee(){

    }

    public Employee(String name, int age, int salary) {
        id = -1;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
