package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (1 + Math.random()  * 10);
                System.out.println(matrix[i][j]);
            }
        }

        int sum1 = 0;
        int len = matrix.length - 1;
        for (int i = 0; i <= len; i++) {
            sum1 +=  matrix[i][i];
        }
        System.out.println(sum1);
        int sum2 = 0;
        for (int i = 0; i <= len; i++) {
            sum2 +=  matrix[len - i][i];
        }
        System.out.println(sum2);
        System.out.println(sum1 + sum2);

    }
}
