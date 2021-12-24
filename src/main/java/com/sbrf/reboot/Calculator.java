package com.sbrf.reboot;

public class Calculator {

    public int getAddition(int a, int b) {
        return a + b;
    }

    public int getSubtraction(int a, int b) {
        return a - b;
    }

    public int getMultiplication(int a, int b) {
        return a * b;
    }

    public int getDivision(int a, int b) {
        return a / b;
    }

    public double getDegree(int a, int b) {
        return Math.pow(a, b);
    }

    public int getModule(int a) {
        return Math.abs(a);
    }

    public double getSquareRoot(int a) {
        return Math.sqrt(a);
    }
}
