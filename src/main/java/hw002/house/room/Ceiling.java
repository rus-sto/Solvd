package hw002.house.room;

import java.util.Locale;

public class Ceiling {

    private boolean isLighted;
    private String color;

    public Ceiling(boolean isLighted, String color) {
        this.isLighted = isLighted;
        this.color = color;
    }

    public void printCeilInfo() {
        System.out.println("This ceiling has " + color + " color");
    }

    public boolean isLighted() {
        return isLighted;
    }

    public void setLighted(boolean lighted) {
        isLighted = lighted;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ceiling{" +
                "isLighted=" + isLighted +
                ", color='" + color + '\'' +
                '}';
    }
}
