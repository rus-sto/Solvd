package hw002.company;


import hw002.company.constructions.Flat;
import hw002.company.constructions.House;
import hw002.company.constructions.Room;
import hw002.company.materials.Wall;
import hw002.company.materials.Window;

public class HW002 {

    public static void main(String[] args) {


        Wall wallOne = new Wall(5.4, 5.2);
        Wall wallTwo = new Wall(3.4, 4);
//        Wall wallThree = new Wall(4.3, 4.5);
        Window window = new Window(2, 1.2);

        double areaWallOne = wallOne.wallArea(5.4, 5.2);
        double costWallOne = wallOne.costWall(areaWallOne);
        double areaWallTwo = wallTwo.wallArea(3.4, 4);
        double costWallTwo = wallTwo.costWall(areaWallTwo);


        Room oneRoom = new Room(wallOne, wallTwo, window, 1);

        double roomArea = oneRoom.areaRoom(wallOne.getLength(), wallTwo.getLength());
        double roomAreaCost = oneRoom.costRoomArea(roomArea);

        double roomCost = oneRoom.costRoom((roomAreaCost), costWallOne, costWallTwo);
        double costOfRoomTotal = oneRoom.TotalRoomCost(roomCost, window.costWindow(2, 1.2));

        Flat oneFlat = new Flat(1, oneRoom);
        Flat twoFlat = new Flat(2, oneRoom);
        Flat threeFlat = new Flat(2, oneRoom);

        double flatArea = twoFlat.areaFlat(2, roomArea);
        double flatCost = twoFlat.costFlat(costOfRoomTotal, 2);

        House threeHouse = new House(oneFlat, 0, twoFlat, 3, threeFlat, 0);
        threeHouse.totalHouseArea(flatArea, 3);
        threeHouse.totalHouseCost(flatCost, 3, flatArea);

        long roomTime = oneRoom.produceTimeOfRoom(roomArea);
        long flatTime = twoFlat.produceTimeOfFlat(roomTime, 2);
        threeHouse.produceTimeOfHouse(flatTime, 3);


    }
}