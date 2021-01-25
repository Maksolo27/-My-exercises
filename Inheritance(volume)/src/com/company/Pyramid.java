package com.company;

public class Pyramid extends Shape {
    double s, h;

    public Pyramid(double s, double h) {
        super(h * s * 4 / 3);
        this.s = s;
        this.h = h;
    }
}
