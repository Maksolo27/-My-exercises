package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ArrayList<Test> arrayList = new ArrayList<>();
        LinkedList<Test> linkedList = new LinkedList<>();
        Test[] array = new Test[1000000];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(new Test(i, "" + i,new Test()));
        }
        long lastTime = System.currentTimeMillis();
        long time = lastTime - startTime;
        System.out.println("Время наполнения в ArrayList: " + time);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(new Test(i, "" + i,new Test()));
        }
        lastTime = System.currentTimeMillis();
        time = lastTime - startTime;
        System.out.println("Время наполнения в LinkedList: " + time);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            array[i] = new Test(i, "" + i,new Test());
        }
        lastTime = System.currentTimeMillis();
        time = lastTime - startTime;
        System.out.println("Время наполнения в Array: " + time);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            arrayList.get((int) Math.random() * (1000 - 1));
        }
        lastTime = System.currentTimeMillis();
        time = lastTime - startTime;
        System.out.println("Время выбора из ArrayList " + time);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedList.get((int) Math.random() * (1000 - 1));
        }
        lastTime = System.currentTimeMillis();
        time = lastTime - startTime;
        System.out.println("Время выбора из LinkedList " + time);

    }
}
