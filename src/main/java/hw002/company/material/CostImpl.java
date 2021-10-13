package hw002.company.material;

public class CostImpl implements CostCountable {

    private static final int COST_ONE_SQUARE_METER = 3;

    private double elementSquare;
    private String rez;

    public CostImpl(double elementSquare) {
        this.elementSquare = elementSquare;
    }

    @Override
    public double costSquareCount(double square) {
        double costCount = square * COST_ONE_SQUARE_METER;
        return costCount;
    }

    public double getElementSquare() {
        return elementSquare;
    }

    public void setElementSquare(double elementSquare) {
        this.elementSquare = elementSquare;
    }
}
