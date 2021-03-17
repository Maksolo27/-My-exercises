package com.company;

public class StipendiumStudent implements Comparable<StipendiumStudent>{
    double avgNote;
    String name;

    public StipendiumStudent(double avgNote, String name) {
        this.avgNote = avgNote;
        this.name = name;
    }
    
    @Override
    public int compareTo(StipendiumStudent s){

        return (int) (s.avgNote-avgNote);
    }

    @Override
    public String toString() {
        return name + " : \n" +
                "Середній бал : " + avgNote;
    }
}
