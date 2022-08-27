package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 3, 2, 5, 1, 4, 9};
        System.out.println("Не сортированный массив: " + printArray(array));
        sort(array);
        System.out.print("Отсортированный массив: " + deleteDuplicate(array));
    }

    private static String deleteDuplicate(int[] array) {
        int current = array[0];
        boolean found = false;

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int j : array) {
            if (current == j && !found) {
                found = true;
            } else if (current != j) {
                if (j != array[1]) {
                    sb.append(", ");
                }
                sb.append(current);
                current = j;
                found = false;
            }
        }
        sb.append(", ").append(current);
        sb.append("]");
        return sb.toString();
    }

    private static void sort(int[] array) {
        int index;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {

                if (array[i - 1] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    isSorted = false;

                }
            }
        }
    }

    private static String printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}