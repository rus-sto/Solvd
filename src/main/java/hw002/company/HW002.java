package hw002.company;


import hw002.company.constructions.*;
import hw002.company.materials.Wall;
import hw002.company.materials.Window;

import java.util.Arrays;
import java.util.Scanner;

public class HW002 {
    /**
     * number of 1-room flats, number of 2-room flats, number of 3-room flats,
     *
     * @param args
     */

    public static void main(String[] args) {

        System.out.println("Input quantity of oneRoomFlats per stage");
        Scanner scanner1 = new Scanner(System.in);
        int oneRoomFlatsQuantity = scanner1.nextInt();
        System.out.println("Input quantity of twoRoomFlats per stage");
        Scanner scanner2 = new Scanner(System.in);
        int twoRoomFlatsQuantity = scanner2.nextInt();
        System.out.println("Input quantity of threeRoomFlats per stage ");
        Scanner scanner3 = new Scanner(System.in);
        int threeRoomFlatsQuantity = scanner3.nextInt();

        int[] flatsQuantityArray = new int[]{oneRoomFlatsQuantity, twoRoomFlatsQuantity, threeRoomFlatsQuantity};
        System.out.println(Arrays.toString(flatsQuantityArray));

        System.out.println("Input High of walls of flats ");

        Scanner scanner4 = new Scanner(System.in);
        double wallHigh = scanner4.nextDouble();

        System.out.println("Input wallOne Length of flats ");

        Scanner scanner5 = new Scanner(System.in);
        double wallOneLength = scanner5.nextDouble();

        System.out.println("Input wallTwo Length of flats ");

        Scanner scanner6 = new Scanner(System.in);
        double wallTwoLength = scanner6.nextDouble();

        Wall wallOne = new Wall(wallOneLength, wallHigh);
        Wall wallTwo = new Wall(wallTwoLength, wallHigh);

        System.out.println("Input number of stages in the house ");

        Scanner scanner7 = new Scanner(System.in);
        int stagesQuantity = scanner7.nextInt();

        System.out.println("Input sizes of the window in the rooms  Width (enter) and  High");

        Scanner scanner8 = new Scanner(System.in);
        double windowWidth = scanner8.nextDouble();
        Scanner scanner9 = new Scanner(System.in);
        double windowHigh = scanner9.nextDouble();

        System.out.println("Input number of windows in each room ");

        Scanner scanner10 = new Scanner(System.in);
        int countWindows = scanner10.nextInt();

        Window window = new Window(windowWidth, windowHigh);

        double areaWallOne = wallOne.wallAreaCalc(wallOneLength, wallHigh);
        double costWallOne = wallOne.costWallCalc(areaWallOne);
        double areaWallTwo = wallTwo.wallAreaCalc(wallTwoLength, wallHigh);
        double costWallTwo = wallTwo.costWallCalc(areaWallTwo);

        Room oneRoom = new Room(wallOne, wallTwo, window, 2);

        double roomArea = oneRoom.areaRoomCalc(wallOne.getLength(), wallTwo.getLength());
        double roomAreaCost = oneRoom.costRoomAreaCalc(roomArea);
        long roomProduceTime = oneRoom.produceTimeOfRoom(roomArea);

        double roomCost = oneRoom.costRoom((roomAreaCost), costWallOne, costWallTwo);
        double costOfRoomTotal = oneRoom.TotalRoomCost(roomCost, window.costWindowCalc(2, 1.2));
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
        long fundamentProduceTime = fundament.produceTimeOfFundament(fundamentArea);
        fundament.printInfo();

        Roof roof = new Roof(stage);
        double roofArea = roof.roofAreaCalc(oneStageArea);
        double roofCoat = roof.roofCostCalc(roofArea);
        long roofProduceTime = roof.produceTimeOfRoof(roofArea);
        roof.printInfo();

        House firstHouse = new House(stage, stagesQuantity,fundament,roof);

        firstHouse.totalHouseAreaCalc(oneStageArea, stagesQuantity);
        firstHouse.totalHouseCostCalc(oneStageCost, stagesQuantity,fundamentCost,roomCost);
        firstHouse.produceTimeOfHouse(oneStageProduceTime, stagesQuantity, fundamentProduceTime, roofProduceTime);

        firstHouse.setAddress(" Minsk, Voronina 6");
        firstHouse.printInfo();


    }
}