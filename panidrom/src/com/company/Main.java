package com.company;


import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    String str = "abcba";
	    String str2 = "sdadwe";
        System.out.println(isPalindrom(str));
        System.out.println(isPalindrom(str2));
        System.out.println("----------");
        System.out.println(getBeginIndexQueryStr(str2, "e"));
        System.out.println("-----------");
        int[] array = new int[]{2,4,8,-2,1,0,-14,2,19};
        System.out.println(Arrays.toString(bubbleSort(array)));
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(2);
        integers.add(7);
        integers.add(-1);
        System.out.println("-------------");
        System.out.println(removeIterative(integers));
        System.out.println("-------------");
        System.out.println(sumOfDigitsOfNumber(5624));
    }
    private static boolean isPalindrom(String str){
        if(new StringBuilder(str).reverse().toString().equals(str)){
            return true;
        }
        return false;
    }

    private static int getBeginIndexQueryStr(String str, String qStr){
        int length = qStr.length();
        for (int i = 0; i < str.length(); i++) {
            if (i + length <= str.length() && str.substring(i, i + length).equals(qStr)){
                    return i;
                }
            }
        return -1;
    }

    private static int[] bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    private static List removeIterative(List list){
        return (List) list.stream().distinct().collect(Collectors.toList());
    }

    private static int sumOfDigitsOfNumber(int number){
        String stringNumber = String.valueOf(number);
        int sum = 0;
        for (int i = 0; i < stringNumber.length(); i++) {
            sum += Character.getNumericValue(stringNumber.charAt(i));
        }
        return sum;
    }
}
