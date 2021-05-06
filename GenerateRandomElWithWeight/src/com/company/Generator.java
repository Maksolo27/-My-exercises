package com.company;

public class Generator {

    private int[] values;
    private int[] weights;
    private int[] ranges;
    private int sum;

    public Generator(int[] values, int[] weights) {
        this.values = values;
        this.weights = weights;
        ranges = new int[values.length];

        sum = 0;
        for (int weight : weights) {
            sum += weight;
        }

        // Заполняем ranges, левыми границами
        int lastSum = 0;
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = lastSum;
            lastSum += weights[i];
        }
    }

    public int getRandom() {
        int random = (int) (Math.random() * (sum - 1));

        int ourRangeIndex = 0;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] > random) {
                break;
            }
            ourRangeIndex = i;
        }
        return values[ourRangeIndex];
    }
}
