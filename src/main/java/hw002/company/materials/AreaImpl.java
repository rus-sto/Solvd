package hw002.company.materials;

public class AreaImpl implements SquareCountable{

    private double sizeOne;
    private double sizeTwo;

    public AreaImpl(double sizeOne, double sizeTwo) {
        this.sizeOne = sizeOne;
        this.sizeTwo = sizeTwo;
    }

    public double getSizeOne() {
        return sizeOne;
    }

    public void setSizeOne(double sizeOne) {
        this.sizeOne = sizeOne;
    }

    public double getSizeTwo() {
        return sizeTwo;
    }

    public void setSizeTwo(double sizeTwo) {
        this.sizeTwo = sizeTwo;
    }

    @Override
    public double countSquare(double a, double b) {
//        String rez = String.format("%.2f",a * b);
//        System.out.println("this area is " + rez + "m2");
        double rez1 = a * b;
        return rez1;
    }

}
