package hw002.architector;

import hw002.HW002;

public class Room {

    public double square;
    public int windows;

    public int numberOfWindows(double square) {
        if (square <= 10) {
            windows = 1;
        } else if (square < 20) {
            windows = 2;
        } else {
            windows = 3;
        }
        System.out.println("So as room square is " + square + "m2; then in this rooms will be " + windows + " window(s)");
        return windows;
    }
}
