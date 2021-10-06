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
        Wall wallThree = new Wall(4.3, 4.5);
        Window window = new Window(2, 1.2);

//        wallOne.wallArea(5.4,5.2);
//        wallOne.costWall(wallOne.wallArea(5.4, 5.2));
//        wallTwo.wallArea(3.4,4);
//        wallTwo.costWall(wallTwo.wallArea(3.4, 4));


        Room oneRoom = new Room(wallOne, wallTwo, window, 1);
//        double areaOneRoom = oneRoom.areaRoom(oneRoom.getFirstWall().getLength(), oneRoom.getSecondWall().getLength());
//        oneRoom.produceTimeOfRoom(areaOneRoom);
        double roomArea = oneRoom.areaRoom(wallOne.getLength(), wallTwo.getLength());
//        oneRoom.costRoomArea(oneRoom.areaRoom(wallOne.getLength(), wallTwo.getLength()));
//        oneRoom.costRoom(oneRoom.costRoomArea( oneRoom.areaRoom(wallOne.getLength(), wallTwo.getLength())),
//                wallOne.costWall(wallOne.wallArea(5.4, 5.2)),
//                wallTwo.costWall(wallTwo.wallArea(3.4, 4)));
//        oneRoom.TotalRoomCost( oneRoom.costRoom(oneRoom.costRoomArea( oneRoom.areaRoom(wallOne.getLength(), wallTwo.getLength())),
//                wallOne.costWall(wallOne.wallArea(5.4, 5.2)),
//                wallTwo.costWall(wallTwo.wallArea(3.4, 4))),window.costWindow(2,1.2));

        Flat oneFlat = new Flat(1, oneRoom);
        Flat twoFlat = new Flat(2, oneRoom);
        Flat threeFlat = new Flat(2, oneRoom);
        double flatArea = twoFlat.areaFlat(2,oneRoom.areaRoom(wallOne.getLength(), wallTwo.getLength()));
        double flatCost = twoFlat.costFlat(oneRoom.TotalRoomCost( oneRoom.costRoom(oneRoom.costRoomArea( oneRoom.areaRoom(wallOne.getLength(), wallTwo.getLength())),
                wallOne.costWall(wallOne.wallArea(5.4, 5.2)),
                wallTwo.costWall(wallTwo.wallArea(3.4, 4))),window.costWindow(2,1.2)), 2);

        House threeHouse = new House(oneFlat,0,twoFlat,3, threeFlat, 0);
        threeHouse.totalHouseArea(twoFlat.areaFlat(2,oneRoom.areaRoom(wallOne.getLength(), wallTwo.getLength())),3);
        threeHouse.totalHouseCost(flatCost,3, flatArea);

        long roomTime = oneRoom.produceTimeOfRoom(roomArea);
        long flatTime = twoFlat.produceTimeOfFlat(roomTime, 2);
        threeHouse.produceTimeOfHouse(flatTime, 3);


//        Room twoRoom = new Room(wallOne, wallThree, window, 1);
//        double areaTwoRoom = oneRoom.areaRoom(twoRoom.getFirstWall().getLength(), twoRoom.getSecondWall().getLength());
//
//        Room threeRoom = new Room(wallTwo, wallThree, window, 1);
//        double areaThreeRoom = oneRoom.areaRoom(threeRoom.getFirstWall().getLength(), threeRoom.getSecondWall().getLength());
//
//        Flat oneRoomFlat = new Flat(1, oneRoom);
//        double areaOneRoomFlat = oneRoomFlat.areaFlat(1, areaOneRoom);
//
//        Flat twoRoomFlat = new Flat(2, twoRoom);
//        double areaTwoRoomFlat = twoRoomFlat.areaFlat(2, areaTwoRoom);
//
//        Flat threeRoomFlat = new Flat(3, threeRoom);
//        double areaThreeRoomFlat = threeRoomFlat.areaFlat(3, areaThreeRoom);
//
//        House newHouse = new House(oneRoomFlat, 20, twoRoomFlat, 15, threeRoomFlat, 10);

    }
}