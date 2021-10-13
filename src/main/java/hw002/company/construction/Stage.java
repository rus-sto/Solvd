package hw002.company.construction;

import hw002.company.PrintBlock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.Arrays;

public class Stage implements PrintBlock {

    private static final int EXTRA_STAGE_AREA = 15;
    private static final int COST_STAGE_EXTRA_AREA = 50;
    private static final LocalTime EXTRA_TIME_PRODUCE_FOR_STAGE = LocalTime.of(15, 00, 00);
    private static final Logger LOGGER = LogManager.getLogger(Stage.class);

    private Flat oneRoomFlat;
    private int countOneRoomFlat;
    private Flat twoRoomFlat;
    private int countTwoRoomFlat;
    private Flat threeRoomFlat;
    private int countThreeRoomFlat;
    private Flat[] flats;


    public Stage(Flat[] flats) {
        this.flats = flats;
    }

    public Stage(Flat oneRoomFlat, int countOneRoomFlat, Flat twoRoomFlat, int countTwoRoomFlat, Flat threeRoomFlat, int countThreeRoomFlat) {
        this.oneRoomFlat = oneRoomFlat;
        this.countOneRoomFlat = countOneRoomFlat;
        this.twoRoomFlat = twoRoomFlat;
        this.countTwoRoomFlat = countTwoRoomFlat;
        this.threeRoomFlat = threeRoomFlat;
        this.countThreeRoomFlat = countThreeRoomFlat;
    }

    public double oneStageAreaCalc(double oneRoomFlatArea, int countOneRoomFlat,
                                   double twoRoomFlatArea, int countTwoRoomFlat,
                                   double threeRoomFlatArea, int countThreeRoomFlat) {
        double rez = oneRoomFlatArea * countOneRoomFlat +
                twoRoomFlatArea * countTwoRoomFlat +
                threeRoomFlatArea * countThreeRoomFlat + EXTRA_STAGE_AREA;
        System.out.println("Total one stage AREA is " + String.format("%.2f", rez) + " m2");
        return rez;
    }

    public double totalStageCostCalc(double oneRoomFlatCost, int countOneRoomFlat,
                                     double twoRoomFlatCost, int countTwoRoomFlat,
                                     double threeRoomFlatCost, int countThreeRoomFlat) {
        double rez = oneRoomFlatCost * countOneRoomFlat + twoRoomFlatCost * countTwoRoomFlat +
                threeRoomFlatCost * countThreeRoomFlat + COST_STAGE_EXTRA_AREA;
        return rez;
    }

    public long produceTimeOfStageCalc(long produceTimeOneRoomFlats, int countOneRoomFlat,
                                       long produceTimeTwoRoomFlats, int countTwoRoomFlat,
                                       long produceTimeThreeRoomFlats, int countThreeRoomFlat) {
        long totalFlatExtraSeconds = (long) ((EXTRA_TIME_PRODUCE_FOR_STAGE.getHour() * 3600
                + EXTRA_TIME_PRODUCE_FOR_STAGE.getMinute() * 60
                + EXTRA_TIME_PRODUCE_FOR_STAGE.getSecond()));
        long rez = (produceTimeOneRoomFlats + totalFlatExtraSeconds) * countOneRoomFlat +
                (produceTimeTwoRoomFlats + totalFlatExtraSeconds) * countTwoRoomFlat +
                (produceTimeThreeRoomFlats + totalFlatExtraSeconds) * countThreeRoomFlat;
        return rez;
    }

    public Flat getOneRoomFlat() {
        return oneRoomFlat;
    }

    public void setOneRoomFlat(Flat oneRoomFlat) {
        this.oneRoomFlat = oneRoomFlat;
    }

    public int getCountOneRoomFlat() {
        return countOneRoomFlat;
    }

    public void setCountOneRoomFlat(int countOneRoomFlat) {
        this.countOneRoomFlat = countOneRoomFlat;
    }

    public Flat getTwoRoomFlat() {
        return twoRoomFlat;
    }

    public void setTwoRoomFlat(Flat twoRoomFlat) {
        this.twoRoomFlat = twoRoomFlat;
    }

    public int getCountTwoRoomFlat() {
        return countTwoRoomFlat;
    }

    public void setCountTwoRoomFlat(int countTwoRoomFlat) {
        this.countTwoRoomFlat = countTwoRoomFlat;
    }

    public Flat getThreeRoomFlat() {
        return threeRoomFlat;
    }

    public void setThreeRoomFlat(Flat threeRoomFlat) {
        this.threeRoomFlat = threeRoomFlat;
    }

    public int getCountThreeRoomFlat() {
        return countThreeRoomFlat;
    }

    public void setCountThreeRoomFlat(int countThreeRoomFlat) {
        this.countThreeRoomFlat = countThreeRoomFlat;
    }

    public Flat[] getFlats() {
        return flats;
    }

    public void setFlats(Flat[] flats) {
        this.flats = flats;
    }

    @Override
    public void printInfo() {
        LOGGER.debug("Each stage has: \n- " + getCountOneRoomFlat() + " oneRoomFlats; \n- " + getCountTwoRoomFlat() + " twoRoomFlats; \n- "
                + getCountThreeRoomFlat() + " threeRoomFlats.");
    }

    @Override
    public String toString() {
        return "Stage{" +
                "flats=" + Arrays.toString(flats) +
                '}';
    }
}
