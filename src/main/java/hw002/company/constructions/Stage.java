package hw002.company.constructions;

import hw002.company.PrintBlock;

import java.time.LocalTime;

public class Stage extends PrintBlock {

    private static final int EXTRA_STAGE_AREA = 15;
    private static final int COST_STAGE_EXTRA_AREA = 50;
    private static final LocalTime EXTRA_TIME_PRODUCE_FOR_STAGE = LocalTime.of(15, 00, 00);

    private Flat oneRoomFlat;
    private int countOneRoomFlat;
    private Flat twoRoomFlat;
    private int countTwoRoomFlat;
    private Flat threeRoomFlat;
    private int countThreeRoomFlat;

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

    public double totalStageCost(double oneRoomFlatCost, int countOneRoomFlat,
                                 double twoRoomFlatCost, int countTwoRoomFlat,
                                 double threeRoomFlatCost, int countThreeRoomFlat) {
        double rez = oneRoomFlatCost * countOneRoomFlat + twoRoomFlatCost * countTwoRoomFlat +
                threeRoomFlatCost * countThreeRoomFlat + COST_STAGE_EXTRA_AREA;
//        System.out.println("Total oneStage COST is " + String.format("%.2f", rez) + " special units");
        return rez;
    }

    public long produceTimeOfStage(long produceTimeOneRoomFlats, int countOneRoomFlat,
                                   long produceTimeTwoRoomFlats, int countTwoRoomFlat,
                                   long produceTimeThreeRoomFlats, int countThreeRoomFlat) {
        long totalFlatExtraSeconds = (long) ((EXTRA_TIME_PRODUCE_FOR_STAGE.getHour() * 3600
                + EXTRA_TIME_PRODUCE_FOR_STAGE.getMinute() * 60
                + EXTRA_TIME_PRODUCE_FOR_STAGE.getSecond()) );
        long rez = (produceTimeOneRoomFlats + totalFlatExtraSeconds) * countOneRoomFlat +
                (produceTimeTwoRoomFlats + totalFlatExtraSeconds) * countTwoRoomFlat +
                (produceTimeThreeRoomFlats + totalFlatExtraSeconds) * countThreeRoomFlat;
//        System.out.println("Stage produce time is  " + rez + " seconds");
        return  rez;
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

    @Override
    public void printInfo() {
        System.out.println("Each stage has: \n- " + getCountOneRoomFlat() + " oneRoomFlats; \n- " + getCountTwoRoomFlat() + " twoRoomFlats; \n- "
        + getCountThreeRoomFlat() + " threeRoomFlats.");
    }
}
