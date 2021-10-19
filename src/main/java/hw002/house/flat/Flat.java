package hw002.house.flat;

import hw002.house.Electrisized;
import hw002.house.room.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

public class Flat implements Electrisized {

    private static final Logger LOGGER = LogManager.getLogger(Flat.class);

    private Room[] rooms;
    private String color;

    public Flat(Room[] rooms, String color) {
        this.rooms = rooms;
        this.color = color;
    }

    public double flatWallsAreaCalc() {
        double flatWallsArea = 0;
        for (Room room : rooms) {
            flatWallsArea += room.roomWallsAreaCalc();
        }
        return flatWallsArea;
    }

    public double flatTimeProduceCalc() {
        double flatTimeProduce = 0;
        for (Room room : rooms) {
            flatTimeProduce += room.roomTimeProduceCalc();
        }
        return flatTimeProduce;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\n\nFlat{" +
                "Flats color='" + color + '\'' +
                "\nThis flat walls area is - " + flatWallsAreaCalc() + "m2" +
                "\nAnd it can be produced for " + flatTimeProduceCalc() + "seconds" +
                "\nIt has " + rooms.length + " rooms " +
                "\n,rooms=" + Arrays.toString(rooms) +
                '}';
    }

    @Override
    public String toElectrisize() {
        String elecrto = "We have electricity in this flat";
        LOGGER.debug(elecrto);
        return elecrto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return Arrays.equals(rooms, flat.rooms) && Objects.equals(color, flat.color);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(color);
        result = 31 * result + Arrays.hashCode(rooms);
        return result;
    }
}
