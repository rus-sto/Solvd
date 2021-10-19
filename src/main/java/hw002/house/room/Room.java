package hw002.house.room;

import hw002.house.Paintable;
import hw002.house.sostav.Wall;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class Room implements Paintable {

    private static final Logger LOGGER = LogManager.getLogger(Room.class);
    private static final LocalTime TIME_PRODUCE_ONE_SQUARE_METER = LocalTime.of(1, 0, 0);

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

    public long roomTimeProduceCalc() {
        long totalSeconds = (long) ((TIME_PRODUCE_ONE_SQUARE_METER.getHour() * 3600
                + TIME_PRODUCE_ONE_SQUARE_METER.getMinute() * 60
                + TIME_PRODUCE_ONE_SQUARE_METER.getSecond()) * roomWallsAreaCalc());
        int days = (int) (totalSeconds / 3600 / 24);
        int hour = (int) (totalSeconds / 3600 % 24);
        int min = (int) (totalSeconds / 60 % 60);
        int sec = (int) (totalSeconds / 1 % 60);
        LOGGER.debug(String.format("%s days %s:%s:%s", days, hour, min, sec));
        return totalSeconds;
    }

    public void printRoomInfo() {
        LOGGER.debug("This room " + roomType + " walls area is " + roomWallsAreaCalc()
                + " \n It's Floor is " + floor.getMaterial() + " and it's ceiling " + ceiling.getColor());
    }

    public void printRoomInfo(String wallMaterial) {
        LOGGER.debug("This room " + roomType + " walls area is " + roomWallsAreaCalc()
                + "It's walls material is " + wallMaterial
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
                ",\n this room walls area =" + roomWallsAreaCalc() +
                " \nAnd It can be produced for " + roomTimeProduceCalc() + "seconds" +
                ",\nfloor=" + floor +
                ", ceiling=" + ceiling +
                ", \nwalls=" + Arrays.toString(walls) +
                '\'' +
                '}';
    }

    @Override
    public String toPaint() {
        return "Room is nice colored";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Arrays.equals(walls, room.walls) && Objects.equals(floor, room.floor) && Objects.equals(ceiling, room.ceiling) && Objects.equals(roomType, room.roomType);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(floor, ceiling, roomType);
        result = 31 * result + Arrays.hashCode(walls);
        return result;
    }
}
