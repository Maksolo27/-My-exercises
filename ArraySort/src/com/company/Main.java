package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] ints = new int[]{5,7,10,-23,51,4,2};
        System.out.println(Arrays.toString(ints));
	    Sort.cocktailSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
