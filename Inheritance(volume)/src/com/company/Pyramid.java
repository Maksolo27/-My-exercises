package com.company;

public class Pyramid extends Shape {
    double s, h;

    public Pyramid(double s, double h) {
        super(s * h * 4 / 3);
        this.s = s;
        this.h = h;
    }
}
