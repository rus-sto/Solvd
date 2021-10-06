package hw002.company.materials;

import java.util.Objects;

public class Wall {

    private static final int COST_ONE_METER_WALL = 3;

    private double length;
    private double high;


    public Wall(double length, double high) {
        this.length = length;
        this.high = high;
    }

    public double wallArea (double length, double high) {
        String rez = String.format("%.2f",length * high);
        System.out.println("this wall area is " + rez);
        return length * high;
    }
    public double costWall(double wallArea){
        String rez1 = String.format("%.2f",wallArea * COST_ONE_METER_WALL);
        System.out.println("this wall COST   is " + rez1);
        return wallArea * COST_ONE_METER_WALL;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
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
        Wall wall = (Wall) o;
        return Double.compare(wall.length, length) == 0 && Double.compare(wall.high, high) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, high);
    }

    @Override
    public String toString() {
        return "Wall{" +
                "length=" + length +
                ", high=" + high +
                '}';
    }
}
