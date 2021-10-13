package hw002.company.construction;

import hw002.company.PrintBlock;
import hw002.company.exception.StageException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class House implements PrintBlock {

    private static final int COST_HOUSE_EXTRA_AREA = 50;
    private static final int EXTRA_HOUSE_AREA = 15;
    private static final LocalTime EXTRA_TIME_PRODUCE_FOR_HOUSE = LocalTime.of(20, 00, 00);
    private static final Logger LOGGER = LogManager.getLogger(House.class);

    private Flat oneRoomFlat;
    private int countOneRoomFlat;
    private Flat twoRoomFlat;
    private int countTwoRoomFlat;
    private Flat threeRoomFlat;
    private int countThreeRoomFlat;
    private String address;
    private Stage stage;
    private int stageQuantity;
    private double houseArea;
    private double houseCost;
    private String timeToBuild;
    private Fundament fundament;
    private Roof roof;
    private Flat[] flats;

    private LocalDateTime startBuild;
    private LocalDateTime finishBuild;

    public House(Stage stage, int stageQuantity, Fundament fundament, Roof roof) {
        this.stage = stage;
        this.stageQuantity = stageQuantity;
        this.fundament = fundament;
        this.roof = roof;
    }
    //    public House(Stage stage, int stageQuantity) {
//        this.stage = stage;
//        this.stageQuantity = stageQuantity;
//    }

    public double totalHouseAreaCalc(double oneStageArea, int stageQuantity) {
        houseArea = oneStageArea * stageQuantity + EXTRA_HOUSE_AREA;
//        System.out.println("Total House AREA is " + String.format("%.2f", houseArea));
        return houseArea;
    }

    public double totalHouseCostCalc(double oneStageCost, int stageQuantity, double fundamentCost, double roofCost) {
        houseCost = oneStageCost * stageQuantity + COST_HOUSE_EXTRA_AREA +
                fundamentCost + roofCost;
//        System.out.println("Total COST of THE House  is " + String.format("%.2f", houseCost));
        return houseCost;
    }

    public long produceTimeOfHouseCalc(long produceTimeOfStage, int stageQuantity, long produceTimeOfFundament, long produceTimeOfRoof) {
        startBuild = LocalDateTime.now();
        System.out.println("If we start building - " + startBuild);
        long totalHouseExtraSeconds = (long) ((EXTRA_TIME_PRODUCE_FOR_HOUSE.getHour() * 3600
                + EXTRA_TIME_PRODUCE_FOR_HOUSE.getMinute() * 60
                + EXTRA_TIME_PRODUCE_FOR_HOUSE.getSecond()));
        long rez = produceTimeOfStage * stageQuantity + totalHouseExtraSeconds + produceTimeOfFundament + produceTimeOfRoof;
        System.out.println("We need " + rez + " seconds to build this house!");
        int days = (int) (rez / 3600 / 24);
        int hour = (int) (rez / 3600 % 24);
        int min = (int) (rez / 60 % 60);
        int sec = (int) (rez / 1 % 60);
        timeToBuild = String.format("%s days %s:%s:%s", days, hour, min, sec);
        System.out.println(timeToBuild);
        finishBuild = LocalDateTime.now().plusSeconds(rez);
        System.out.println("The building will be finished at " + finishBuild);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getStageQuantity() {
        return stageQuantity;
    }

    public void setStageQuantity(int stageQuantity) throws StageException {
        if (stageQuantity <= 0) {
            throw new StageException("Number of stages must be natural");
        }
        this.stageQuantity = stageQuantity;
    }

    public LocalDateTime getStartBuild() {
        return startBuild;
    }

    public void setStartBuild(LocalDateTime startBuild) {
        this.startBuild = startBuild;
    }

    public LocalDateTime getFinishBuild() {
        return finishBuild;
    }

    public void setFinishBuild(LocalDateTime finishBuild) {
        this.finishBuild = finishBuild;
    }

    public Fundament getFundament() {
        return fundament;
    }

    public void setFundament(Fundament fundament) {
        this.fundament = fundament;
    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House{" +
                "oneRoomFlat=" + oneRoomFlat +
                ", countOneRoomFlat=" + countOneRoomFlat +
                ", twoRoomFlat=" + twoRoomFlat +
                ", countTwoRoomFlat=" + countTwoRoomFlat +
                ", threeRoomFlat=" + threeRoomFlat +
                ", countThreeRoomFlat=" + countThreeRoomFlat +
                ", address='" + address + '\'' +
                ", stage=" + stage +
                ", stageQuantity=" + stageQuantity +
                ", startBuild=" + startBuild +
                ", finishBuild=" + finishBuild +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return countOneRoomFlat == house.countOneRoomFlat && countTwoRoomFlat == house.countTwoRoomFlat &&
                countThreeRoomFlat == house.countThreeRoomFlat && stageQuantity == house.stageQuantity &&
                Objects.equals(oneRoomFlat, house.oneRoomFlat) && Objects.equals(twoRoomFlat, house.twoRoomFlat) &&
                Objects.equals(threeRoomFlat, house.threeRoomFlat) && Objects.equals(address, house.address) &&
                Objects.equals(stage, house.stage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oneRoomFlat, countOneRoomFlat, twoRoomFlat,
                countTwoRoomFlat, threeRoomFlat, countThreeRoomFlat,
                address, stage, stageQuantity);
    }

    @Override
    public void printInfo() {
        LOGGER.debug(" \n This house situated in " + getAddress() + ". \n Has - " +
                stageQuantity + " stages; \n- " + stage.getCountOneRoomFlat() * stageQuantity + " OneRoomFlats; \n- " +
                stage.getCountTwoRoomFlat() * stageQuantity + " TwoRoomFlats; \n- " + stage.getCountThreeRoomFlat() * stageQuantity + " ThreeRoomFlats; " +
                "\nTotal Area of thr House is - " + houseArea + " m2! ; \nTotal House cost is - " + houseCost +
                " special units; \nAnd we need - " + timeToBuild + " to build it!");

    }
}