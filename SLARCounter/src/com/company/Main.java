package com.company;

import com.company.gauss.Algorithm;
import com.company.gauss.Equation;

public class Main {
    private static final int DEFAULT_EQUATIONS_NUMBER = 2;
    private static final int DEFAULT_VARIABLES_NUMBER = 2;

    public static void main(String args[]){
        LinearSystem<Float, Equation> list = generateSystem();
        printSystem(list);
        int i, j;
        Algorithm<Float, Equation> alg = new Algorithm<Float, Equation>(list);
        try{
            alg.calculate();
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        Float [] x = new Float[DEFAULT_EQUATIONS_NUMBER];
        for(i = list.size() - 1; i >= 0; i--) {
            Float sum = 0.0f;
            for(j = list.size() - 1; j > i; j--) {
                sum += list.itemAt(i, j) * x[j];
            }
            x[i] = (list.itemAt(i, list.size()) - sum) / list.itemAt(i, j);
        }
        printSystem(list);
        printVector(x);
    }

    public static LinearSystem<Float, Equation> generateSystem(){
        LinearSystem<Float, Equation> list = new LinearSystem<Float, Equation>();
        int i;
        for (i = 0; i < DEFAULT_EQUATIONS_NUMBER; i++){
            Equation eq = new Equation();
            eq.generate(DEFAULT_VARIABLES_NUMBER + 1);
            list.push(eq);
        }
        return list;
    }

    public static void printSystem(LinearSystem<Float, Equation> system){
        for (int i = 0; i < system.size(); i++){
            Equation temp = system.get(i);
            String s = "";
            for (int j = 0; j < temp.size(); j++){
                s += String.format("%f; %s", system.itemAt(i, j), "\t");
            }
            System.out.println(s);
        }System.out.println("");
    }

    public static void printVector(Float [] x){
        String s = "";
        for (int i = 0; i < x.length; i++){
            s += String.format("x%d = %f; ", i, x[i]);
        }System.out.println(s);
    }
}