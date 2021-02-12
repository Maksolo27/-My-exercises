package com.company;

public class Hall {
    public String time;
    public int price;

    public Hall(String time, int price) {
        this.time = time;
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "time: '" + time + '\'' +
                ", price: " + price;
    }

}
