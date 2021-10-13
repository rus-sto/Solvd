package hw002.company;

import hw002.company.construction.*;
import hw002.company.exception.InvalidHighException;
import hw002.company.exception.InvalidLengthException;
import hw002.company.material.Wall;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class HW002 {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
// Посчитать площадь всех стен в доме, Массивы, Несколько вложенных циклов

    private static final Logger LOGGER = LogManager.getLogger(HW002.class);

    public static void main(String[] args) {

        /**
         * Example with file


        File file = new File("myFile1.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read();
        } catch (FileNotFoundException e) {
            LOGGER.debug("This file cannot be found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
         */

        Wall wallOne = new Wall(2, 3, "Beton");
        Wall wallTwo = new Wall(3, 3, "Plastic");
        Wall wallThree = new Wall(4, 3, "Wood");
        Wall wallFour = new Wall(2, 3, "Paper");
        Wall wallFive = new Wall(3, 3, "Metal");
        Wall wallSix = new Wall(4, 3, "Sand");

        Wall wall0 = new Wall("Capet");
        try {
            wall0.setLength(5);
            wall0.setHigh(3);
        } catch (InvalidLengthException | InvalidHighException e) {
            LOGGER.debug("Invalid wall data");
//        } catch (InvalidHighException e) {
//            LOGGER.debug("Invalid High");
        } catch (Exception e) {
            LOGGER.debug("Other Exceptions");
        } finally {
            LOGGER.debug("After operation");
        }
        try(PaintResource resource = new PaintResource()) {
            LOGGER.debug("We can do smth in try block");
        }


//        wall0.setType("Capet");

        Wall[] wallsOne = {wallThree};
        Wall[] wallsTwo = {wallTwo, wallSix};
        Wall[] wallsThree = {wallFive, wallFour, wallOne};
//        Wall[] wallsFour = {wallOne, wallThree,wallTwo, wallThree};

        Room roomOne = new Room(wallsOne);
//        roomOne.setWalls(null);
        roomOne.setWalls(wallsOne);
        Room roomTwo = new Room(wallsTwo);
        roomTwo.setWalls(wallsTwo);
        Room roomThree = new Room(wallsThree);
        roomTwo.setWalls(wallsThree);
//        Room roomFour = new Room(wallsFour);
//        roomTwo.setWalls(wallsFour);
        Room[] roomsOneA = {roomThree};
        Room[] roomsTwoA = {roomTwo, roomOne};
//        Room[] roomsThreeA = {roomOne, roomTwo, roomThree};
//        Room[] roomsFourA = {roomOne, roomTwo, roomThree, roomFour};

        Flat flatOne = new Flat(roomsOneA);
        Flat flatTwo = new Flat(roomsTwoA);
//        Flat flatThree = new Flat(roomsThreeA);
//        Flat flatFour = new Flat(roomsFourA);
        Flat[] flatsOneA = {flatOne};
        Flat[] flatsTwoA = {flatTwo};
//        Flat[] flatsThreeA = {flatTwo, flatTwo,flatTwo};
//        Flat[] flatsFourA = {flatOne,flatThree,flatOne,flatFour};

        Stage stageOne = new Stage(flatsTwoA);
        stageOne.setFlats(flatsTwoA);
        LOGGER.debug(stageOne.toString());
  //      LOGGER.debug(Arrays.toString(flatsTwoA));


//        LOGGER.debug("Input quantity of oneRoomFlats per stage");
//        Scanner scanner1 = new Scanner(System.in);
//        int oneRoomFlatsQuantity = scanner1.nextInt();
//        LOGGER.debug("Input quantity of twoRoomFlats per stage");
//        Scanner scanner2 = new Scanner(System.in);
//        int twoRoomFlatsQuantity = scanner2.nextInt();
//        LOGGER.debug("Input quantity of threeRoomFlats per stage ");
//        Scanner scanner3 = new Scanner(System.in);
//        int threeRoomFlatsQuantity = scanner3.nextInt();
//
//        int[] flatsQuantityArray = new int[]{oneRoomFlatsQuantity, twoRoomFlatsQuantity, threeRoomFlatsQuantity};
//        LOGGER.debug(Arrays.toString(flatsQuantityArray));
//
//        LOGGER.debug("Input High of walls of flats ");
//
//        Scanner scanner4 = new Scanner(System.in);
//        double wallHigh = scanner4.nextDouble();
//
//        LOGGER.debug("Input wallOne Length of flats ");
//
//        Scanner scanner5 = new Scanner(System.in);
//        double wallOneLength = scanner5.nextDouble();
//
//        LOGGER.debug("Input wallTwo Length of flats ");
//
//        Scanner scanner6 = new Scanner(System.in);
//        double wallTwoLength = scanner6.nextDouble();
//
//        Square area1 = new Square(wallOneLength, wallHigh,"Beton");
//        try {
//            area1.setSizeOne(wallOneLength);
//        } catch (InvalidSizeException e) {
//            LOGGER.debug("Only natural size is possible");
//        } finally {
//            LOGGER.debug("After Operation");
//        }
//        try {
//            area1.setSizeTwo(wallHigh);
//        } catch (InvalidSizeException e) {
//            LOGGER.debug("Only natural size is possible");
//        } finally {
//            LOGGER.debug("After Operation");
//        }
//
//        Wall wallOne = new Wall(wallOneLength, wallHigh, "Beton");
//        Wall wallTwo = new Wall(wallTwoLength, wallHigh,"Beton");
//
//        LOGGER.debug("Input number of stages in the house ");
//
//        Scanner scanner7 = new Scanner(System.in);
//        int stagesQuantity = scanner7.nextInt();
//
//        LOGGER.debug("Input sizes of the window in the rooms  Width (enter) and  High");
//
//        Scanner scanner8 = new Scanner(System.in);
//        double windowWidth = scanner8.nextDouble();
//        Scanner scanner9 = new Scanner(System.in);
//        double windowHigh = scanner9.nextDouble();
//
//        Window window = new Window(windowWidth, windowHigh);
//        double windowCost = window.costWindowCalc(windowWidth, windowHigh);
//
//        double areaWallOne = wallOne.wallAreaCalc(wallOneLength, wallHigh);
//        double costWallOne = wallOne.costWallCalc(areaWallOne);
//        double areaWallTwo = wallTwo.wallAreaCalc(wallTwoLength, wallHigh);
//        double costWallTwo = wallTwo.costWallCalc(areaWallTwo);
//
//        Room oneRoom = new Room(wallOne, wallTwo, window);
//
//        double roomArea = oneRoom.areaRoomCalc(wallOne.getLength(), wallTwo.getLength());
//        int countWindow = oneRoom.countWindowCalc(roomArea);
//        double roomAreaCost = oneRoom.costRoomAreaCalc(roomArea);
//        long roomProduceTime = oneRoom.produceTimeOfRoomCalc(roomArea);
//
//        double roomCost = oneRoom.costRoomCalc((roomAreaCost), costWallOne, costWallTwo);
//        double costOfRoomTotal = oneRoom.TotalRoomCostCalc(roomCost, windowCost, countWindow);
//        oneRoom.printInfo();
//
//        Flat oneRoomFlat = new Flat(1, oneRoom);
//        Flat twoRoomFlat = new Flat(2, oneRoom);
//        Flat threeRoomFlat = new Flat(3, oneRoom);
//
//        double oneRoomFlatArea = oneRoomFlat.areaFlatCalc(1, roomArea);
//        double oneRoomFlatCost = oneRoomFlat.costFlatCalc(costOfRoomTotal, 1);
//        long oneRoomFlatProduceTime = oneRoomFlat.produceTimeOfFlatCalc(roomProduceTime, 1);
//        double twoRoomFlatArea = twoRoomFlat.areaFlatCalc(2, roomArea);
//        double twoRoomFlatCost = twoRoomFlat.costFlatCalc(costOfRoomTotal, 2);
//        long twoRoomFlatProduceTime = twoRoomFlat.produceTimeOfFlatCalc(roomProduceTime, 2);
//        double threeRoomFlatArea = threeRoomFlat.areaFlatCalc(3, roomArea);
//        double threeRoomFlatCost = threeRoomFlat.costFlatCalc(costOfRoomTotal, 3);
//        long threeRoomFlatProduceTime = threeRoomFlat.produceTimeOfFlatCalc(roomProduceTime, 3);
//        oneRoom.printInfo();
//
//        Stage stage = new Stage(oneRoomFlat, oneRoomFlatsQuantity, twoRoomFlat, twoRoomFlatsQuantity, threeRoomFlat, threeRoomFlatsQuantity);
//        stage.getCountOneRoomFlat();
//        stage.getCountTwoRoomFlat();
//        stage.getCountThreeRoomFlat();
//        double oneStageArea = stage.oneStageAreaCalc(oneRoomFlatArea, oneRoomFlatsQuantity, twoRoomFlatArea,
//                twoRoomFlatsQuantity, threeRoomFlatArea, threeRoomFlatsQuantity);
//        double oneStageCost = stage.totalStageCostCalc(oneRoomFlatCost, oneRoomFlatsQuantity, twoRoomFlatCost,
//                twoRoomFlatsQuantity, threeRoomFlatCost, threeRoomFlatsQuantity);
//        long oneStageProduceTime = stage.produceTimeOfStageCalc(oneRoomFlatProduceTime, oneRoomFlatsQuantity,
//                twoRoomFlatProduceTime, twoRoomFlatsQuantity, threeRoomFlatProduceTime, threeRoomFlatsQuantity);
//        stage.printInfo();
//
//        Fundament fundament = new Fundament(stage);
//        double fundamentArea = fundament.fundamentAreaCalc(oneStageArea);
//        double fundamentCost = fundament.fundamentCostCalc(fundamentArea);
//        fundament.setFundamentCostRez(fundamentCost);
//        long fundamentProduceTime = fundament.produceTimeOfFundamentCalc(fundamentArea);
//        fundament.printInfo();
//
//        Roof roof = new Roof(stage);
//        double roofArea = roof.roofAreaCalc(oneStageArea);
//        double roofCost = roof.roofCostCalc(roofArea);
//        roof.setRoofCostRez(roofCost);
//        long roofProduceTime = roof.produceTimeOfRoofCalc(roofArea);
//        roof.printInfo();
//
//        House firstHouse = new House(stage, stagesQuantity, fundament, roof);
//
//        firstHouse.totalHouseAreaCalc(oneStageArea, stagesQuantity);
//        firstHouse.totalHouseCostCalc(oneStageCost, stagesQuantity, fundamentCost, roomCost);
//        firstHouse.produceTimeOfHouseCalc(oneStageProduceTime, stagesQuantity, fundamentProduceTime, roofProduceTime);
//
//        LOGGER.debug("Input house address ");
//
//        Scanner scanner10 = new Scanner(System.in);
//        java.lang.String HouseAddress = scanner10.nextLine();
//
//        firstHouse.setAddress(HouseAddress);
//        firstHouse.printInfo();
    }
}