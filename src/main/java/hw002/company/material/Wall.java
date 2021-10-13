package hw002.company.material;

import hw002.company.exception.InvalidHighException;
import hw002.company.exception.InvalidLengthException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Wall extends Square {

    private static final Logger LOGGER = LogManager.getLogger(Wall.class);

    private double length;
    private double high;

    public Wall(String type) {
        super(type);
    }

    public Wall(double length, double high, String type) {
        super(length, high, type);
        this.length = length;
        this.high = high;
    }

    public double wallAreaCalc(double length, double high) {

        Square wallArea = new Square(length, high, "Beton");
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

    public void setLength(double length) throws  InvalidLengthException{
        if (length < 1 || length > 50) {
            throw new InvalidLengthException("Length cannot be under 1  and above 50");
        }
        this.length = length;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) throws InvalidHighException{
        if (high < 2 || high > 10){
            throw new InvalidHighException("High is invalid");
        }
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
        return super.toString();
    }
}
