package hw002.company;


import hw002.company.constructions.*;
import hw002.company.materials.Wall;
import hw002.company.materials.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

public class HW002 {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(HW002.class);

    public static void main(String[] args) {

        LOGGER.debug("Input quantity of oneRoomFlats per stage");
        Scanner scanner1 = new Scanner(System.in);
        int oneRoomFlatsQuantity = scanner1.nextInt();
        LOGGER.debug("Input quantity of twoRoomFlats per stage");
        Scanner scanner2 = new Scanner(System.in);
        int twoRoomFlatsQuantity = scanner2.nextInt();
        LOGGER.debug("Input quantity of threeRoomFlats per stage ");
        Scanner scanner3 = new Scanner(System.in);
        int threeRoomFlatsQuantity = scanner3.nextInt();

        int[] flatsQuantityArray = new int[]{oneRoomFlatsQuantity, twoRoomFlatsQuantity, threeRoomFlatsQuantity};
        LOGGER.debug(Arrays.toString(flatsQuantityArray));

        LOGGER.debug("Input High of walls of flats ");

        Scanner scanner4 = new Scanner(System.in);
        double wallHigh = scanner4.nextDouble();

        LOGGER.debug("Input wallOne Length of flats ");

        Scanner scanner5 = new Scanner(System.in);
        double wallOneLength = scanner5.nextDouble();

        LOGGER.debug("Input wallTwo Length of flats ");

        Scanner scanner6 = new Scanner(System.in);
        double wallTwoLength = scanner6.nextDouble();

        Wall wallOne = new Wall(wallOneLength, wallHigh);
        Wall wallTwo = new Wall(wallTwoLength, wallHigh);

        LOGGER.debug("Input number of stages in the house ");

        Scanner scanner7 = new Scanner(System.in);
        int stagesQuantity = scanner7.nextInt();

        LOGGER.debug("Input sizes of the window in the rooms  Width (enter) and  High");

        Scanner scanner8 = new Scanner(System.in);
        double windowWidth = scanner8.nextDouble();
        Scanner scanner9 = new Scanner(System.in);
        double windowHigh = scanner9.nextDouble();

        Window window = new Window(windowWidth, windowHigh);
        double windowCost = window.costWindowCalc(windowWidth, windowHigh);

        double areaWallOne = wallOne.wallAreaCalc(wallOneLength, wallHigh);
        double costWallOne = wallOne.costWallCalc(areaWallOne);
        double areaWallTwo = wallTwo.wallAreaCalc(wallTwoLength, wallHigh);
        double costWallTwo = wallTwo.costWallCalc(areaWallTwo);

        Room oneRoom = new Room(wallOne, wallTwo, window);

        double roomArea = oneRoom.areaRoomCalc(wallOne.getLength(), wallTwo.getLength());
        int countWindow = oneRoom.countWindowCalc(roomArea);
        double roomAreaCost = oneRoom.costRoomAreaCalc(roomArea);
        long roomProduceTime = oneRoom.produceTimeOfRoom(roomArea);

        double roomCost = oneRoom.costRoom((roomAreaCost), costWallOne, costWallTwo);
        double costOfRoomTotal = oneRoom.TotalRoomCost(roomCost,windowCost,countWindow);
        oneRoom.printInfo();

        Flat oneRoomFlat = new Flat(1, oneRoom);
        Flat twoRoomFlat = new Flat(2, oneRoom);
        Flat threeRoomFlat = new Flat(3, oneRoom);

        double oneRoomFlatArea = oneRoomFlat.areaFlat(1, roomArea);
        double oneRoomFlatCost = oneRoomFlat.costFlat(costOfRoomTotal, 1);
        long oneRoomFlatProduceTime = oneRoomFlat.produceTimeOfFlat(roomProduceTime, 1);
        double twoRoomFlatArea = twoRoomFlat.areaFlat(2, roomArea);
        double twoRoomFlatCost = twoRoomFlat.costFlat(costOfRoomTotal, 2);
        long twoRoomFlatProduceTime = twoRoomFlat.produceTimeOfFlat(roomProduceTime, 2);
        double threeRoomFlatArea = threeRoomFlat.areaFlat(3, roomArea);
        double threeRoomFlatCost = threeRoomFlat.costFlat(costOfRoomTotal, 3);
        long threeRoomFlatProduceTime = threeRoomFlat.produceTimeOfFlat(roomProduceTime, 3);
        oneRoom.printInfo();

        Stage stage = new Stage(oneRoomFlat, oneRoomFlatsQuantity, twoRoomFlat, twoRoomFlatsQuantity, threeRoomFlat, threeRoomFlatsQuantity);
        stage.getCountOneRoomFlat();
        stage.getCountTwoRoomFlat();
        stage.getCountThreeRoomFlat();
        double oneStageArea = stage.oneStageAreaCalc(oneRoomFlatArea, oneRoomFlatsQuantity, twoRoomFlatArea,
                twoRoomFlatsQuantity, threeRoomFlatArea, threeRoomFlatsQuantity);
        double oneStageCost = stage.totalStageCost(oneRoomFlatCost, oneRoomFlatsQuantity, twoRoomFlatCost,
                twoRoomFlatsQuantity, threeRoomFlatCost, threeRoomFlatsQuantity);
        long oneStageProduceTime = stage.produceTimeOfStage(oneRoomFlatProduceTime, oneRoomFlatsQuantity,
                twoRoomFlatProduceTime, twoRoomFlatsQuantity, threeRoomFlatProduceTime, threeRoomFlatsQuantity);
        stage.printInfo();

        Fundament fundament = new Fundament(stage);
        double fundamentArea = fundament.fundamentAreaCalc(oneStageArea);
        double fundamentCost = fundament.fundamentCostCalc(fundamentArea);
        fundament.setFundamentCostRez(fundamentCost);
        long fundamentProduceTime = fundament.produceTimeOfFundament(fundamentArea);
        fundament.printInfo();

        Roof roof = new Roof(stage);
        double roofArea = roof.roofAreaCalc(oneStageArea);
        double roofCost = roof.roofCostCalc(roofArea);
        roof.setRoofCostRez(roofCost);
        long roofProduceTime = roof.produceTimeOfRoof(roofArea);
        roof.printInfo();

        House firstHouse = new House(stage, stagesQuantity,fundament,roof);

        firstHouse.totalHouseAreaCalc(oneStageArea, stagesQuantity);
        firstHouse.totalHouseCostCalc(oneStageCost, stagesQuantity,fundamentCost,roomCost);
        firstHouse.produceTimeOfHouse(oneStageProduceTime, stagesQuantity, fundamentProduceTime, roofProduceTime);

        LOGGER.debug("Input house address ");

        Scanner scanner10 = new Scanner(System.in);
        java.lang.String HouseAddress = scanner10.nextLine();

        firstHouse.setAddress(HouseAddress);
        firstHouse.printInfo();
    }
}