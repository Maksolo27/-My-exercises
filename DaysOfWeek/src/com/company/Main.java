package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long days = sc.nextInt();
        String days1 = Long.toString(days);
        final Map<Integer, String> weekend = new HashMap<>();
        weekend.put(1, "Monday");
        weekend.put(2, "Tuesday");
        weekend.put(3, "Wednesday");
        weekend.put(4, "Thursday");
        weekend.put(5, "Friday");
        weekend.put(6, "Saturday");
        weekend.put(7, "Sunday");

        HashSet<Integer> uniqestringSet = new HashSet<>();
        for (int i = 0; i < days1.length(); i++) {
            uniqestringSet.add(Character.getNumericValue(days1.charAt(i)));
        }

        Iterator<Integer> it = uniqestringSet.iterator();
        List<Integer> list = new ArrayList<>();
        while(it.hasNext()){
            list.add(it.next());
        }
        System.out.println(list);

        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result += weekend.get(list.get(i)) + ", ";
        }
        System.out.println(result);
    }
}
