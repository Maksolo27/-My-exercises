package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrom("yeyey"));
        System.out.print(isPalindrom("maksym"));
    }
    static boolean isPalindrom(String word){
        int len = word.length();
        for (int i = 0; i < len; i++){
            if (word.charAt(i) != word.charAt(len - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
