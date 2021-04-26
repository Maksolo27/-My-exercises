package com.company;

public class Sort {

    public static void cocktailSort(int[] a) {
        int size = a.length;
        boolean swapped = false;
        for (int k = size - 1; k > 0; k--) {
            swapped = false;
            for (int i = k; i > size - 1 - k; i--)
                if (a[i] < a[i-1]) {
                    int temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                    swapped = true;
                }

            for (int i = size - k; i < k; i++)
                if (a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapped = true;
                }

            if (!swapped)
                break;
        }
    }
}
