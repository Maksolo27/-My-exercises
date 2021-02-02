package com.company;

public class ToCalvin extends BaseConverter{
    private double calvin = 273.15;
    @Override
    public double convert(double grad) {
        return grad + calvin;
    }
}
