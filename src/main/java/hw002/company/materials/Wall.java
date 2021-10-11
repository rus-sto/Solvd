package hw002.company.materials;

import java.util.Objects;

public class Wall extends AreaImpl{

    private double length;
    private double high;

    public Wall(double length, double high) {
        super(length,high);
//        this.length = length;
//        this.high = high;
    }

    public double wallAreaCalc(double length, double high) {

        AreaImpl wallArea = new AreaImpl(length, high);
        double rez = wallArea.countSquare(length, high);
//        System.out.println("this wall area is " + String.format("%.2f", rez) + "m2!");

        return rez;
    }

    public double costWallCalc(double wallArea) {
        CostImpl wallCost = new CostImpl(wallArea);
        double rez1 = wallCost.costSquareCount(wallArea);
//        System.out.println("this wall COST is " + String.format("%.2f", rez1) + " special units");

        return rez1;
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
