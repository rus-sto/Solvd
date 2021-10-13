package hw002.house.room;

import hw002.house.sostav.Wall;

import java.util.Arrays;

public class Room {

    private Wall[] walls;
    private Floor floor;
    private Ceiling ceiling;
    private String roomType;

    public Room(Wall[] walls, Floor floor, Ceiling ceiling, String roomType) {
        this.walls = walls;
        this.floor = floor;
        this.ceiling = ceiling;
        this.roomType = roomType;
    }

    public double roomWallsAreaCalc() {
        double roomWallsArea = 0;
        for (Wall wall : walls) {
            roomWallsArea += wall.wallAreaCalc();
        }
        return roomWallsArea;
    }

    public void printRoomInfo() {
        System.out.println("This room " + roomType + " walls area is " + roomWallsAreaCalc()
                + " \n It's Floor is " + floor.getMaterial() + " and it's ceiling " + ceiling.getColor());
    }

    public Wall[] getWalls() {
        return walls;
    }

    public void setWalls(Wall[] walls) {
        this.walls = walls;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Ceiling getCeiling() {
        return ceiling;
    }

    public void setCeiling(Ceiling ceiling) {
        this.ceiling = ceiling;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "\nRoom{" +
                ", This roomType='" + roomType +
                ", this room walls area =" + roomWallsAreaCalc() +
                ", floor=" + floor +
                ", ceiling=" + ceiling +
                ", \nwalls=" + Arrays.toString(walls) +
                '\'' +
                '}';
    }
}
