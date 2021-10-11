package hw002.company.constructions;

import hw002.company.PrintBlock;
import hw002.company.materials.CostImpl;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Fundament extends PrintBlock {

    private static final LocalTime TIME_PRODUCE_FOR_METER_FUNDAMENT = LocalTime.of(1,30,00);
    private static final double COST_FUNDAMENT_COEFFICIENT = 1.5;

    private Stage stage;
    private double fundamentCostRez;

    public Fundament(Stage stage) {
        this.stage = stage;
    }

    public Fundament(Stage stage, double fundamentCostRez) {
        this.stage = stage;
        this.fundamentCostRez = fundamentCostRez;
    }

    public double fundamentAreaCalc (double oneStageArea) {
        double fundamentSquare = oneStageArea ;
        //        System.out.println("Total Fundament AREA is " + String.format("%.2f", fundamentSquare));
        return fundamentSquare;
    }

    public double fundamentCostCalc(double fundamentSquare) {
        CostImpl fundamentCost = new CostImpl(fundamentSquare);
        double fundamentCostRez = fundamentCost.costSquareCount(fundamentSquare) * COST_FUNDAMENT_COEFFICIENT;
//        System.out.println("Total COST of THE fundament  is " + String.format("%.2f", fundamentCostRez));
        return fundamentCostRez;
    }

    public long produceTimeOfFundament(double fundamentSquare) {
        long fundamentSeconds = (long) ((TIME_PRODUCE_FOR_METER_FUNDAMENT.getHour() * 3600
                + TIME_PRODUCE_FOR_METER_FUNDAMENT.getMinute() * 60
                + TIME_PRODUCE_FOR_METER_FUNDAMENT.getSecond()));
        long rez = fundamentSeconds * (long)fundamentSquare;
        System.out.println("We need " + rez + " seconds to build fundament");
        int days = (int) (rez / 3600 / 24);
        int hour = (int) (rez / 3600 % 24);
        int min = (int) (rez / 60 % 60);
        int sec = (int) (rez / 1 % 60);
        System.out.println(String.format("%s days %s:%s:%s", days, hour, min, sec));
        return rez;
    }

    public double getFundamentCostRez() {
        return fundamentCostRez;
    }

    public void setFundamentCostRez(double fundamentCostRez) {
        this.fundamentCostRez = fundamentCostRez;
    }

    @Override
    public void printInfo() {
        System.out.println("The cost of fundament is X special units");
    }
}
