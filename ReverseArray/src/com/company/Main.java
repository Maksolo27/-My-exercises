package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] array = new int[5];
	    for (int i = 0; i < array.length; i++) {
	        array[i] = i;
	    }
	    System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        System.out.println(Arrays.toString(array));

    }
}
