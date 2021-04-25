package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Prog prog = new Prog();
        int[] result = prog.twoSum(new int[]{2, 4, 3, 10, 15}, 7);
        System.out.println(Arrays.toString(result));
    }
}
