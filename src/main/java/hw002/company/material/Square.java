package hw002.company.material;

import hw002.company.exception.InvalidSizeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Square extends Material implements SquareCountable {

    private static final Logger LOGGER = LogManager.getLogger(Square.class);

    private double sizeOne;
    private double sizeTwo;

    public Square(String type) {
        super(type);
    }

    public Square(double sizeOne, double sizeTwo, String type) {
        super(type);
        this.sizeOne = sizeOne;
        this.sizeTwo = sizeTwo;
    }

    @Override
    public double countSquare(double a, double b) {
        double rez1 = a * b;
        return rez1;
    }

    public double getSizeOne() {
        return sizeOne;
    }

    public void setSizeOne(double sizeOne) throws InvalidSizeException {
        if (sizeOne <= 0) {
            throw new InvalidSizeException("Only natural size is possible");
        }
        this.sizeOne = sizeOne;
    }

    public double getSizeTwo() {
        return sizeTwo;
    }

    public void setSizeTwo(double sizeTwo) throws InvalidSizeException {
        if (sizeTwo <= 0) {
            throw new InvalidSizeException("Only natural size is possible");
        }
        this.sizeTwo = sizeTwo;
    }

    @Override
    public String toString() {
        return super.toString() + " SizeOne = " + sizeOne + " SizeTwo = " + sizeTwo;
    }
}
