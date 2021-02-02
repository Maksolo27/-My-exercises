package com.company;

public class ToFarangate extends BaseConverter{
    private int farangate = 32;
    @Override
    public double convert(double grad) {
        return 1.8 * grad + farangate;
    }
}
