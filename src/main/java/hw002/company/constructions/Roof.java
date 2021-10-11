package hw002.company.constructions;

import hw002.company.PrintBlock;
import hw002.company.materials.CostImpl;

import java.time.LocalTime;

public class Roof extends PrintBlock {
    private static final LocalTime TIME_PRODUCE_FOR_METER_ROOF = LocalTime.of(1,10,00);
    private static final double COST_ROOF_COEFFICIENT = 1.3;

    private Stage stage;
    private double roofCostRez;

    public Roof(Stage stage) {
        this.stage = stage;
    }

    public double roofAreaCalc (double oneStageArea) {
        double roofSquare = oneStageArea ;
        //        System.out.println("Total Fundament AREA is " + String.format("%.2f", roofSquare));
        return roofSquare;
    }

    public double roofCostCalc(double roofSquare) {
        CostImpl roofCost = new CostImpl(roofSquare);
        double roofCostRez = roofCost.costSquareCount(roofSquare) * COST_ROOF_COEFFICIENT;
//        System.out.println("Total COST of THE roof  is " + String.format("%.2f", roofCostRez));
        return roofCostRez;
    }

    public long produceTimeOfRoof(double roofSquare) {
        long roofSeconds = (long) ((TIME_PRODUCE_FOR_METER_ROOF.getHour() * 3600
                + TIME_PRODUCE_FOR_METER_ROOF.getMinute() * 60
                + TIME_PRODUCE_FOR_METER_ROOF.getSecond()));
        long rez = roofSeconds * (long)roofSquare;
        System.out.println("We need " + rez + " seconds to build the roof");
        int days = (int) (rez / 3600 / 24);
        int hour = (int) (rez / 3600 % 24);
        int min = (int) (rez / 60 % 60);
        int sec = (int) (rez / 1 % 60);
        System.out.println(String.format("%s days %s:%s:%s", days, hour, min, sec));
        return rez;
    }

    public double getRoofCostRez() {
        return roofCostRez;
    }

    public void setRoofCostRez(double roofCostRez) {
        this.roofCostRez = roofCostRez;
    }

    @Override
    public void printInfo() {
        System.out.println("Our Roof cost is XX special units");
    }
}