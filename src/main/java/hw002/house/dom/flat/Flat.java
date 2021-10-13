package hw002.house.dom.flat;

import hw002.house.room.Room;

import java.util.Arrays;

public class Flat {

    private Room[] rooms;
    private String color;

    public Flat(Room[] rooms, String color) {
        this.rooms = rooms;
        this.color = color;
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
                "It has " + rooms.length + " rooms " +
                ",rooms=" + Arrays.toString(rooms) +
                '}';
    }
}
