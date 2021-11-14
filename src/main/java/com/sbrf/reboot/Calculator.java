package com.sbrf.reboot;

public class Calculator {
    public static int getAddition(int i, int j) {
        return i + j;
    }

    public static int getSubtraction(int i, int j) {
        return i - j;
    }

    public static double getMultiplication(double i, double j) {
        return i * j;
    }

    public static double getDivision(double i, double j) {
        return i / j;
    }

    public static double getPower(double i, double j) {
        return Math.pow(i, j);
    }

    public static double getMin(double i, double j) {
        return Math.min(i, j);
    }

    public static double getMax(double i, double j) {
        return Math.max(i, j);
    }

}
