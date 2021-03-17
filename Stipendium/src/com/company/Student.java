package com.company;

public class Student {
    String name;
    int notes;
    boolean budged;

    Student(){

    }
    public Student(String name, int notes, boolean budged) {
        this.name = name;
        this.notes = notes;
        this.budged = budged;
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
