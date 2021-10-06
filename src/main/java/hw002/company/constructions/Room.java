package hw002.company.constructions;


import hw002.company.materials.Wall;
import hw002.company.materials.Window;

import java.time.LocalTime;
import java.util.Objects;

public class Room {

    private static final int COST_ONE_METER_AREA = 4;
    private static final LocalTime PRODUCE_TIME_FOR_ONE_SQUARE_METER = LocalTime.of(2, 15, 30);

    private Window window;
    private int countWindows;
    private Wall firstWall;
    private Wall secondWall;

    public Room(Wall firstWall, Wall secondWall, Window window, int countWindows) {
        this.firstWall = firstWall;
        this.secondWall = secondWall;
        this.window = window;
        this.countWindows = countWindows;
    }

    public double areaRoom(double firstWallLength, double secondWallLength) {
        String rez = String.format("%.2f",firstWallLength * secondWallLength);
        System.out.println("this room area is " + rez);
        return firstWallLength * secondWallLength;
    }

    public double costRoomArea(double areaRoom) {
        String rez = String.format("%.2f",areaRoom * COST_ONE_METER_AREA);
        System.out.println("this room area  COST is " + rez);
        return areaRoom * COST_ONE_METER_AREA;
    }

    public double costRoom(double costRoomArea, double costWallA, double costWallB) {
        String rez = String.format("%.2f",costRoomArea + costWallA + costWallB);
        System.out.println("this Room Cost is " + rez);
        return costRoomArea + costWallA + costWallB;
    }

    public double TotalRoomCost(double costRoom, double costWindow) {
        String rez = String.format("%.2f",costRoom + costWindow);
        System.out.println("this Room  Total Cost with window is " + rez);
        return costRoom + costWindow;
    }

    public long produceTimeOfRoom(double areaRoom) {
        long totalSeconds = (long) ((PRODUCE_TIME_FOR_ONE_SQUARE_METER.getHour() * 3600
                + PRODUCE_TIME_FOR_ONE_SQUARE_METER.getMinute() * 60
                + PRODUCE_TIME_FOR_ONE_SQUARE_METER.getSecond()) * areaRoom);
        int days = (int) (totalSeconds / 3600 / 24);
        int hour = (int) (totalSeconds / 3600 % 24);
        int min = (int) (totalSeconds / 60 % 60);
        int sec = (int) (totalSeconds / 1 % 60);
        System.out.println(String.format("%s days %s:%s:%s", days, hour, min, sec));
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

    @Override
    public String toString() {
        return "Room{" +
                "countWindows=" + countWindows +
                ", firstWall=" + firstWall +
                ", secondWall=" + secondWall +
                '}';
    }
}
