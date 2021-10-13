package hw002.company.construction;

import hw002.company.PrintBlock;
import hw002.company.exception.InvalidWallsException;
import hw002.company.material.Square;
import hw002.company.material.CostImpl;
import hw002.company.material.Wall;
import hw002.company.material.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class Room implements PrintBlock {

    private static final Logger LOGGER = LogManager.getLogger(Room.class);
    private static final LocalTime PRODUCE_TIME_FOR_ONE_SQUARE_METER = LocalTime.of(1, 0, 0);

    private Window window;
    private int countWindows;
    private Wall firstWall;
    private Wall secondWall;
    private double roomSquare;
    private Wall[] walls;

    public Room(Wall[] walls) {
        this.walls = walls;
    }

    //    public Room(Wall firstWall, Wall secondWall, Window window) {
//        this.firstWall = firstWall;
//        this.secondWall = secondWall;
//        this.window = window;
//    }

    public double areaRoomCalc(double firstWallLength, double secondWallLength) {
        Square roomArea = new Square(firstWallLength, secondWallLength, "Beton");
        double roomSquare = roomArea.countSquare(firstWallLength, secondWallLength);
        return roomSquare;
    }
    public int countWindowCalc(double roomSquare) {
        if (roomSquare <= 15){
            countWindows = 1;
        }else if(roomSquare <=22) {
            countWindows = 2;
        }else {
            countWindows = 3;
        }
        return countWindows;
    }

    public double costRoomAreaCalc(double areaRoom) {
        CostImpl roomCost = new CostImpl(areaRoom);
        double rez = roomCost.costSquareCount(areaRoom);
        return rez;
    }

    public double costRoomCalc(double costRoomAreaCalc, double costWallA, double costWallB) {
        return costRoomAreaCalc + 2 * costWallA + 2 * costWallB;
    }

    public double TotalRoomCostCalc(double costRoom, double costWindow, int countWindows) {
        String rez = String.format("%.2f", costRoom + costWindow * countWindows);
        System.out.println("this Room  Total Cost with window is " + rez + " special units");
        return costRoom + costWindow * countWindows;
    }

    public long produceTimeOfRoomCalc(double areaRoom) {
        long totalSeconds = (long) ((PRODUCE_TIME_FOR_ONE_SQUARE_METER.getHour() * 3600
                + PRODUCE_TIME_FOR_ONE_SQUARE_METER.getMinute() * 60
                + PRODUCE_TIME_FOR_ONE_SQUARE_METER.getSecond()) * areaRoom);
        int days = (int) (totalSeconds / 3600 / 24);
        int hour = (int) (totalSeconds / 3600 % 24);
        int min = (int) (totalSeconds / 60 % 60);
        int sec = (int) (totalSeconds / 1 % 60);
//        System.out.println(String.format("%s days %s:%s:%s", days, hour, min, sec));
        return totalSeconds;
    }

    public int getCountWindows() {
        return countWindows;
    }

    public void setCountWindows(int countWindows) {
        this.countWindows = countWindows;
    }

    public Wall getFirstWall() {
        return firstWall;
    }

    public void setFirstWall(Wall firstWall) {
        this.firstWall = firstWall;
    }

    public Wall getSecondWall() {
        return secondWall;
    }

    public void setSecondWall(Wall secondWall) {
        this.secondWall = secondWall;
    }

    public double getRoomSquare() {
        return roomSquare;
    }

    public void setRoomSquare(double roomSquare) {
        this.roomSquare = roomSquare;
    }

    public Wall[] getWalls() {
        return walls;
    }

    public void setWalls(Wall[] walls) {
        if (walls == null) {
            throw new InvalidWallsException("Walls cannot be null");
        }
        this.walls = walls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return countWindows == room.countWindows && Objects.equals(firstWall, room.firstWall) && Objects.equals(secondWall, room.secondWall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countWindows, firstWall, secondWall);
    }

//    @Override
//    public String toString() {
//        return "Room{" +
//                "countWindows=" + countWindows +
//                ", firstWall=" + firstWall +
//                ", secondWall=" + secondWall +
//                '}';
//    }


    @Override
    public String toString() {
        return "Room{" +
                "walls=" + Arrays.toString(walls) +
                '}';
    }

    @Override
    public void printInfo() {
        LOGGER.debug("Each room is made of walls  \n- " + firstWall.getLength() + "m length and \n-" + firstWall.getHigh() + " m high,\n and \n-" +
                secondWall.getLength() + "m length and \n-" + secondWall.getHigh() + " m high. \n And has " + countWindows + " windows");
    }
}