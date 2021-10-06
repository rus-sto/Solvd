package hw002.company.materials;

import java.util.Objects;

public class Window {
    private static final int COST_ONE_METER_WINDOW = 5;


    private double wight;
    private double high;

    public Window(double wight, double high) {
        this.wight = wight;
        this.high = high;
    }

    public  double costWindow(double wight, double high){
        String rez = String.format("%.2f",wight * high * COST_ONE_METER_WINDOW);
        System.out.println("this Window Cost is " + rez);
        return wight * high * COST_ONE_METER_WINDOW;
    }
    public double getWight() {
        return wight;
    }

    public void setWight(double wight) {
        this.wight = wight;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return Double.compare(window.wight, wight) == 0 && Double.compare(window.high, high) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wight, high);
    }

    @Override
    public String toString() {
        return "Window{" +
                "wight=" + wight +
                ", high=" + high +
                '}';
    }
}
