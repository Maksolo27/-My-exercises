package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        double temp = -37.3;
        double calvin = new ToCalvin().convert(temp);
        double celsium = new ToCelsius().convert(temp);
        double fahrenheite = new ToFarangate().convert(temp);
        ArrayList<Double> temepatur = new ArrayList<>();
        temepatur.add(calvin);
        temepatur.add(fahrenheite);
        temepatur.add(celsium);
        System.out.println(temepatur.toString());
    }
}
