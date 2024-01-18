package org.example.utils;

public class Utils {
    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double roundOf(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
