package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("dasjd");
        names.add("asaasdsjd");
        names.add("jsdfj");

        System.out.println(names.toString());
        System.out.println(removeChar(names));


        }
        public static List<String> removeChar(List<String> names) {
            for (int i = 0; i < names.size(); i++) {
                String val = names.get(i);
                String val1 = val.substring(1);
                names.set(i, val1);

            }
            return names;
        }

    }

