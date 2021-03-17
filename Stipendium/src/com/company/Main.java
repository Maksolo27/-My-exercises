package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try(FileReader reader = new FileReader("C:\\Users\\maxim\\IdeaProjects\\-My-exercises\\Stipendium\\Students.csv"))
        {
            StringBuilder text = new StringBuilder();
            int c;
            while((c =reader.read())!=-1){
                text.append((char) c);
            }
            String[] array = text.toString().split(",");
            int quantity = 0;
            for (int i = 0; i < array.length; i++) {
                if(i == 0){
                    quantity = Integer.parseInt(array[i]);
                }
            }
            List<String> students = new ArrayList<>();
            for (int i = 1; i < array.length; i++) {
                students.add(array[i]);
            }
            int i = 0;
            int j = 0;
            List<Student> studentList = new ArrayList<>();
            while (i < quantity) {
                Student student = new Student();
                int notes = 0;
                while (j < array.length){
                    Pattern pattern = Pattern.compile("[а-яА-Я]+");
                    Matcher matcher = pattern.matcher(students.get(j));
                    if (matcher.find() && !students.get(j).equals("TRUE") && !students.get(j).equals("FALSE")) {
                        student.name = students.get(j);
                    }
                    pattern = Pattern.compile("[0-9]+");
                    matcher = pattern.matcher(students.get(j));
                    if(matcher.find() && !students.get(j).equals("TRUE") && !students.get(j).equals("FALSE")){
                        notes += Integer.parseInt(students.get(j));
                    }
                    if(students.get(j).equals("FALSE") && students.get(j).equals("TRUE")){
                        student.budged = Boolean.getBoolean(students.get(j));
                    }
                    j++;
                    if(j % 7 == 0){
                        break;
                    }
                }
                student.notes = notes;
                studentList.add(student);
                i++;
            }
            List<StipendiumStudent> stipendiumStudentPriorityList  = new ArrayList<>();
            for (Student student : studentList) {
                double avgNote = student.notes / 5;
                StipendiumStudent stipendiumStudent = new StipendiumStudent(avgNote, student.name);
                stipendiumStudentPriorityList.add(stipendiumStudent);

            }
            double stipendiumQuantity = quantity * 40 / 100;
            stipendiumStudentPriorityList.sort(StipendiumStudent::compareTo);
            for (int k = 0; k < stipendiumStudentPriorityList.size(); k++) {
                if(k < stipendiumQuantity) {
                    FileWriter writer = new FileWriter("C:\\Users\\maxim\\IdeaProjects\\-My-exercises\\Stipendium\\Rating.csv", true);
                    System.out.println(stipendiumStudentPriorityList.get(k).toString());
                    writer.append(stipendiumStudentPriorityList.get(k).toString());
                    writer.flush();
                    if(k == stipendiumQuantity - 1){
                        System.out.println("------------------");
                        System.out.println("Прохідний балл на стипендію - " + stipendiumStudentPriorityList.get(k).avgNote);
                    }
                }
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
