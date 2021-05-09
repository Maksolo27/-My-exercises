package com.company.gauss;

import java.util.*;

public class Equation implements Gauss<Float, Equation> {
    private List<Float> equation = new ArrayList<Float>();

    public List<Float> getEquation(){
        return equation;
    }

    public void generate(int size){
        if (size < 2) size = 2;
        this.equation.clear();
        for (int i = 0; i < size; i++){
            Random random = new Random();
            this.equation.add((float) (random.nextInt()%10) + 1);
        }
    }

    public void userGenerate(int size){
        if (size < 2) size = 2;
        this.equation.clear();
        for (int i = 0; i < size; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите x" + i);
            this.equation.add((float) scanner.nextDouble());
            scanner = new Scanner(System.in);
        }
    }

    public void set(double el){
        this.equation.add((float) el);
    }

    @Override
    public int size(){
        return equation.size();
    }
    @Override
    public void addEquation(Equation item){
        ListIterator<Float> i = equation.listIterator();
        ListIterator<Float> j = item.getEquation().listIterator();
        for(; i.hasNext() && j.hasNext();){
            Float a = i.next();
            Float b = j.next();
            i.set(a + b);
        }
    }
    @Override
    public void mul(Float coefficient){
        for(ListIterator<Float> i = equation.listIterator(); i.hasNext();){
            Float next = i.next();
            i.set(next * coefficient);
        }
    }
    @Override
    public Float findCoefficient(Float a, Float b){
        if (a == 0.0f) return 1.0f;
        return -b/a;
    }
    @Override
    public Float at(int index){
        return equation.get(index);
    }
}
