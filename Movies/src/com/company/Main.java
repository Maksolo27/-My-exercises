package com.company;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Hall> redHall = new ArrayList<>();
        ArrayList<Hall> blueHall = new ArrayList<>();
        ArrayList<Hall> lightBlueHall = new ArrayList<>();
        //
        redHall.add(new Hall("12:00", 50));
        redHall.add(new Hall("16:00", 65));
        redHall.add(new Hall("20:00", 145));
        //
        blueHall.add(new Hall("10:00", 55));
        blueHall.add(new Hall("13:00", 75));
        blueHall.add(new Hall("16:00",135 ));
        //
        lightBlueHall.add(new Hall("10:00", 75));
        lightBlueHall.add(new Hall("14:00", 85));
        lightBlueHall.add(new Hall("18:00", 125));
        //
        ArrayList<ArrayList> halls = new ArrayList<>();
        halls.add(redHall);
        halls.add(blueHall);
        halls.add(lightBlueHall);
        int amount = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            amount = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Введен неправильный формат");
        }
        if(amount > 3){
            for (int i = 0; i < halls.size(); i++) {
                ArrayList value = halls.get(i);
                for (int j = 0; j < value.size(); j++) {
                    Hall time = (Hall) value.get(j);
                    time.price -= (time.price * 5) / 100;
                    System.out.println(time.price);
                }
            }
        }
        if(amount > 5){
            for (int i = 0; i < halls.size(); i++) {
                ArrayList value = halls.get(i);
                for (int j = 0; j < value.size(); j++) {
                    Hall time = (Hall) value.get(j);
                    time.price -= (time.price * 10) / 100;
                    System.out.println(time.price);
                }
            }
        }
        Map<Integer, String> hallsNames = new Hashtable<>();
        hallsNames.put(0,"Красный зал: ");
        hallsNames.put(1,"Синий зал: ");
        hallsNames.put(2,"Голубой зал: ");
        for (int i = 0; i < halls.size(); i++) {
            ArrayList value = halls.get(i);
            System.out.println(hallsNames.get(i));
            for (int j = 0; j < value.size(); j++) {
                Hall time = (Hall) value.get(j);
                System.out.println(time.toString());
            }
        }
    }
}
