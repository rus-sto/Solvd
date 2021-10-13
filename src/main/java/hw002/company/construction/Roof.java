package hw002.company.construction;

import hw002.company.PrintBlock;
import hw002.company.material.CostImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;

public class Roof implements PrintBlock {

    private static final LocalTime TIME_PRODUCE_FOR_METER_ROOF = LocalTime.of(1,10,00);
    private static final double COST_ROOF_COEFFICIENT = 1.3;
    private static final Logger LOGGER = LogManager.getLogger(Roof.class);

    private Stage stage;
    private double roofCostRez;

    public Roof(Stage stage) {
        this.stage = stage;
    }

    public double roofAreaCalc (double oneStageArea) {
        double roofSquare = oneStageArea ;
        return roofSquare;
    }

    public double roofCostCalc(double roofSquare) {
        CostImpl roofCost = new CostImpl(roofSquare);
        double roofCostRez = roofCost.costSquareCount(roofSquare) * COST_ROOF_COEFFICIENT;
        return roofCostRez;
    }

    public long produceTimeOfRoofCalc(double roofSquare) {
        long roofSeconds = (long) ((TIME_PRODUCE_FOR_METER_ROOF.getHour() * 3600
                + TIME_PRODUCE_FOR_METER_ROOF.getMinute() * 60
                + TIME_PRODUCE_FOR_METER_ROOF.getSecond()));
        long rez = roofSeconds * (long)roofSquare;
        LOGGER.debug("We need " + rez + " seconds to build the roof");
        int days = (int) (rez / 3600 / 24);
        int hour = (int) (rez / 3600 % 24);
        int min = (int) (rez / 60 % 60);
        int sec = (int) (rez / 1 % 60);
        LOGGER.debug(String.format("%s days %s:%s:%s", days, hour, min, sec));
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
        LOGGER.debug("Our Roof cost is " + getRoofCostRez() + " special units");
    }
}
