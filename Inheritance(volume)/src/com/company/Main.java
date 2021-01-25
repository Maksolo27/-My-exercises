package com.company;

public class Main {

    public static void main(String[] args) {
        Shape ball = new Ball(4);
        Shape cylinder = new Cylinder(3,20);
        Shape piramid = new Pyramid(3,2);
        Box box = new Box(200);
        System.out.println(box.add(ball));
        System.out.println(box.add(cylinder));
        System.out.println(box.add(piramid));


    }
}
