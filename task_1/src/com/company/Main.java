package com.company;

public class Main {

    private final static int MULTIPLIER_A = 1103515245;
    private final static int INCREMENT_C = 12345;
    private final static int MODULUS = 100;

    private static int seed = (int) (System.currentTimeMillis());

    public static void main(String[] args) {
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = randomPositiveInt();
            }
        }

        int min = array[0][0];
        int max = array[array.length - 1][array.length - 1];

        for (int[] nums : array) {
            for (int num : nums) {

                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
        }
        int sum = 0;
        int count = 0;
        for (int[] ints : array) {
            for (int j = 0; j < array.length; j++) {
                sum += ints[j];
                count++;
            }
        }

        System.out.println("Массив: " + printArray(array));
        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Максимальный элемент массива: " + max);
        System.out.print("Среднее значение: " + sum / count);
    }

    private static int randomInt() {
        seed = (seed * MULTIPLIER_A + INCREMENT_C) % MODULUS;
        return seed;
    }

    private static int randomPositiveInt() {
        int tmp = randomInt();
        if (tmp < 0) {
            seed = tmp * -1;
        }
        return seed;
    }

    private static String printArray(int[][] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < array.length; i++) {
            sb.append("[");
            for (int j = 0; j < array.length; j++) {
                if (j > 0) {
                    sb.append(", ");
                }
                sb.append(array[i][j]);
            }
            if (i < array.length - 1) {
                sb.append("], ");
            } else {
                sb.append("] ");
            }
        }
        sb.append("]");
        return sb.toString();

    }
}


