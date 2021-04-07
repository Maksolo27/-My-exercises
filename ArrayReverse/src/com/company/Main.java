package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        int mid = array.length/2;
        int[] temArr = new int[mid];
        for (int i = 0; i < temArr.length; i++) {
            temArr[i] = array[i];
        }
        for (int i = 0; i < mid; i++) {
            array[i] = array[array.length - i - 1];
        }
        for (int i = 0 ; i < temArr.length; i++) {
            array[array.length - i - 1] = temArr[i];
        }
        System.out.println(Arrays.toString(array));
    }
}
