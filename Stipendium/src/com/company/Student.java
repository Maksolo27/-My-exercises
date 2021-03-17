package com.company;

public class Student {
    String name;
    int notes;
    boolean budged;

    Student(){

    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", notes=" + notes +
                ", budged=" + budged +
                '}';
    }
}
